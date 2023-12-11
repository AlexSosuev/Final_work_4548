package View;

import Controllers.AnimalController;
import models.Hamster;

public class HamsterView extends AnimalView<Hamster>{
    public HamsterView(AnimalController<Hamster> controller) {
        super(controller);
    }
}