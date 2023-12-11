package Controllers;

import models.Donkey;
import Services.AnimalService;

public class DonkeyController extends AnimalController<Donkey> {
    public DonkeyController(AnimalService<Donkey> donkeyService) {
        super(donkeyService);
    }
}