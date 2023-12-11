package Controllers;

import models.Horse;
import Services.AnimalService;

public class HorseController extends AnimalController<Horse>{
    public HorseController(AnimalService<Horse> horseService) {
        super(horseService);
    }
}