package Controllers;

import models.Hamster;
import Services.AnimalService;

public class HamsterController extends AnimalController<Hamster>{
    public HamsterController(AnimalService<Hamster> hamsterService) {
        super(hamsterService);
    }
}