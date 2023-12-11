package View;

import Controllers.AnimalController;
import models.Dog;

public class DogView extends AnimalView<Dog> {
    public DogView(AnimalController<Dog> controller) {
        super(controller);
    }
}