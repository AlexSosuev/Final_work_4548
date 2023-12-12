
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import Controllers.*;
import Repositories.*;
import Services.*;
import View.*;


public class App {
    private static DogRepository dogRepository;
    private static DogService dogService;
    private static DogController dogController;
    private static DogView dogView = getDogView();
    private static CatRepository catRepository;
    private static CatService catService;
    private static CatController catController;
    private static CatView catView = getCatView();
    private static HamsterRepository hamsterRepository;
    private static HamsterService hamsterService;
    private static HamsterController hamsterController;
    private static HamsterView hamsterView = getHamsterView();
    private static HorseRepository horseRepository;
    private static HorseService horseService;
    private static HorseController horseController;
    private static HorseView horseView = getHorseView();
    private static DonkeyRepository donkeyRepository;
    private static DonkeyService donkeyService;
    private static DonkeyController donkeyController;
    private static DonkeyView donkeyView = getDonkeyView();
    private static CamelRepository camelRepository;
    private static CamelService camelService;
    private static CamelController camelController;
    private static CamelView camelView = getCamelView();
    private static AllAnimalsView allAnimalsView = getAllAnimalsView();
    private static Scanner scan = new Scanner(System.in);
    private static CounterService counterService;
    private static CounterController counterController;
    private static CounterView counterView = getCounterView();
    private static final String WARNING = "Введен не существующий пункт!";
    private static final String WARNING_INFO = "Введите целое число!";

    public static void run() {
        boolean flag = true;
        while (flag) {
            System.out.println("""
                    Список команд:
                    1 - Показать список животных
                    2 - Добавить новое животное
                    3 - Показать список команд/выполняемых работ животного
                    4 - Научить животное новым командам
                    5 - Узнать количество животных
                    6 - Закрыть приложение
                    """);

            switch (scan.nextLine()) {
                case "1" -> allAnimalsView.printAllAnimals();
                case "2" -> {
                    counterView.add();
                    createAnimal();
                }
                case "3" -> {
                    System.out.println("Введите ID животного, список действий которого хотите увидеть: ");
                    try {
                        int id = Integer.parseInt(scan.nextLine());
                        allAnimalsView.printCommands(id);
                    } catch (Exception e) {
                        System.out.println(WARNING_INFO);
                    }
                }
                case "4" -> {
                    try {
                        System.out.println("Введите ID животного");
                        int id = Integer.parseInt(scan.nextLine());
                        String commandString = scan.nextLine();
                        allAnimalsView.createNewCommand(id, commandString);
                    } catch (Exception e) {
                        System.out.println(WARNING_INFO);
                    }
                }
                case "5" -> counterView.printCount();
                case "6" -> {
                    try {
                        System.out.print("Закрываем приложение: ");
                        for (int i = 0; i < 3; i++) {
                            Thread.sleep(500);
                            System.out.print(" bye ");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    flag = false;
                }
                default -> System.out.println(WARNING);
            }
        }
    }

    private static DogView getDogView() {
        dogRepository = new DogRepository();
        dogService = new DogService(dogRepository);
        dogController = new DogController(dogService);
        return new DogView(dogController);
    }

    private static CatView getCatView() {
        catRepository = new CatRepository();
        catService = new CatService(catRepository);
        catController = new CatController(catService);
        return new CatView(catController);
    }

    private static HamsterView getHamsterView() {
        hamsterRepository = new HamsterRepository();
        hamsterService = new HamsterService(hamsterRepository);
        hamsterController = new HamsterController(hamsterService);
        return new HamsterView(hamsterController);
    }

    private static HorseView getHorseView() {
        horseRepository = new HorseRepository();
        horseService = new HorseService(horseRepository);
        horseController = new HorseController(horseService);
        return new HorseView(horseController);
    }

    private static DonkeyView getDonkeyView() {
        donkeyRepository = new DonkeyRepository();
        donkeyService = new DonkeyService(donkeyRepository);
        donkeyController = new DonkeyController(donkeyService);
        return new DonkeyView(donkeyController);
    }

    private static CamelView getCamelView() {
        camelRepository = new CamelRepository();
        camelService = new CamelService(camelRepository);
        camelController = new CamelController(camelService);
        return new CamelView(camelController);
    }

    private static AllAnimalsView getAllAnimalsView() {
        AllAnimalsService allAnimalsService = new AllAnimalsService(dogService, catService, hamsterService, horseService, donkeyService, camelService);
        AllAnimalController animalController = new AllAnimalController(allAnimalsService);
        return new AllAnimalsView(animalController);
    }

    private static CounterView getCounterView() {
        counterService = new CounterService();
        counterController = new CounterController(counterService);
        return new CounterView(counterController);
    }

    private static void createAnimal() {
        System.out.println("""
                Выберите вид животного:
                1 - Собака
                2 - Кошка
                3 - Хомяк
                4 - Лошадь
                5 - Осёл
                6 - Верблюд
                """);
        switch (scan.nextLine()) {
            case "1" -> choice(dogView);
            case "2" -> choice(catView);
            case "3" -> choice(hamsterView);
            case "4" -> choice(horseView);
            case "5" -> choice(donkeyView);
            case "6" -> choice(camelView);
            default -> System.out.println(WARNING);
        }
    }

    private static void choice(AnimalView animalView) {
        System.out.println("Введите имя, дату рождения(дд.мм.гггг) и породу животного через запятую");
        String[] animal = scan.nextLine().split(",");
        System.out.println("Введите команды через запятую (если их нет, напишите \"НЕТ\")");
        List<String> commands = new ArrayList<>(Arrays.asList(scan.nextLine().split(",")));
        try {
            animalView.create(allAnimalsView.getMaxId() + 1, animal[0], animal[1], animal[2], commands);
            System.out.println("Животное добавлено!\n");
        } catch (Exception e) {
            System.out.println("Не верно введенные данные!");
        }
    }
}