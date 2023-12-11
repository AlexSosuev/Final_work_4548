package View;

import Controllers.AnimalController;
import models.Donkey;

public class DonkeyView extends AnimalView<Donkey>{
    public DonkeyView(AnimalController<Donkey> controller) {
        super(controller);
    }
}