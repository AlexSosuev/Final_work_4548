package Controllers;

import java.util.List;

import Services.AnimalService;
import models.Animal;

public abstract class AnimalController<T extends Animal> {
    protected final AnimalService<T> animalService;

    public AnimalController(AnimalService<T> animalService) {
        this.animalService = animalService;
    }

    public List<T> getAll() {
        return animalService.getAll();
    }

    public void create(int id, String name, String birthday, String breed, List<String> commandList) {
        animalService.create(id, name, birthday, breed, commandList);
    }
}