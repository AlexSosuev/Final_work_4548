package Controllers;

import models.Cat;
import Services.AnimalService;

public class CatController extends AnimalController<Cat> {
    public CatController(AnimalService<Cat> catService) {
        super(catService);
    }
}