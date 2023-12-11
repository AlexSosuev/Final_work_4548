package Controllers;

import models.Camel;
import Services.AnimalService;

public class CamelController extends AnimalController<Camel> {
    public CamelController(AnimalService<Camel> camelService) {
        super(camelService);
    }
}