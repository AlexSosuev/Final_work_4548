package Controllers;

import java.util.List;

import models.Dog;
import Services.AnimalService;

public class DogController implements AnimalController<Dog>{
    private final AnimalService<Dog> dogService;

    public DogController(AnimalService<Dog> dogService) {
        this.dogService = dogService;
    }

    @Override
    public List<Dog> getAll() {
        return dogService.getAll();
    }

    @Override
    public void create(int id, String name, String birthday, String breed, List<String> commandList) {
        dogService.create(id, name, birthday, breed,commandList);
    }
    
}
