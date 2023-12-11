package Controllers;

import models.Dog;
import Services.AnimalService;

public class DogController extends AnimalController<Dog>{
    public DogController(AnimalService<Dog> dogService) {
        super(dogService);
    }
}