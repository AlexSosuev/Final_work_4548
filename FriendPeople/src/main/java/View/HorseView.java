package View;

import Controllers.AnimalController;
import models.Horse;

public class HorseView extends AnimalView<Horse>{
    public HorseView(AnimalController<Horse> controller) {
        super(controller);
    }
}