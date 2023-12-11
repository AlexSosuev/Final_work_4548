package Controllers;

import java.util.List;

import models.Horse;
import Services.AnimalService;

public class HorseController implements AnimalController<Horse>{
    private final AnimalService<Horse> horseService;

    public HorseController(AnimalService<Horse> horseService) {
        this.horseService = horseService;
    }

    @Override
    public List<Horse> getAll() {
        return horseService.getAll();
    }

    @Override
    public void create(int id, String name, String birthday, String breed,List<String> commandList) {
        horseService.create(id, name, birthday, breed,commandList);
    }
    
}
