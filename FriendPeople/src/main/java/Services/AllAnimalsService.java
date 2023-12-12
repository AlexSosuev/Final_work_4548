package Services;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import models.*;

@AllArgsConstructor
public class AllAnimalsService {
    private final AnimalService<Dog> dogService;
    private final AnimalService<Cat> catService;
    private final AnimalService<Hamster> hamsterService;
    private final AnimalService<Horse> horseService;
    private final AnimalService<Donkey> donkeyService;
    private final AnimalService<Camel> camelService;

    public List<Animal> getAll() {
        List<Animal> animals = new ArrayList<>(dogService.getAll());
        animals.addAll(new ArrayList<>(catService.getAll()));
        animals.addAll(new ArrayList<>(hamsterService.getAll()));
        animals.addAll(new ArrayList<>(horseService.getAll()));
        animals.addAll(new ArrayList<>(donkeyService.getAll()));
        animals.addAll(new ArrayList<>(camelService.getAll()));
        return animals;
    }

    public int getMaxId() {
        int maxID = -1;
        List<Animal> animals = getAll();
        for (Animal animal : animals) {
            if (animal.getId() > maxID) {
                maxID = animal.getId();
            }
        }
        return Math.max(maxID, 0);
    }

    public List<String> getCommands(int id) {
        List<Animal> animals = getAll();
        List<String> commands = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.getId() == id) {
                for (Dog dog : dogService.getAll()) {
                    if (dog.getId() == id) {
                        commands = dog.getCommands();
                    }
                }
                for (Cat cat : catService.getAll()) {
                    if (cat.getId() == id) {
                        commands = cat.getCommands();
                    }
                }
                for (Hamster hamster : hamsterService.getAll()) {
                    if (hamster.getId() == id) {
                        commands = hamster.getCommands();
                    }
                }
                for (Horse horse : horseService.getAll()) {
                    if (horse.getId() == id) {
                        commands = horse.getWorkPerformed();
                    }
                }
                for (Donkey donkey : donkeyService.getAll()) {
                    if (donkey.getId() == id) {
                        commands = donkey.getWorkPerformed();
                    }
                }
                for (Camel camel : camelService.getAll()) {
                    if (camel.getId() == id) {
                        commands = camel.getWorkPerformed();
                    }
                }
            }
        }
        return commands;
    }

    public void createNewCommand(int id, String command) {
        List<String> commands = getCommands(id);
        commands.add(command);
    }
}