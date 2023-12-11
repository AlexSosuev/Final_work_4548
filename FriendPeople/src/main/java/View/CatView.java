package View;

import Controllers.AnimalController;
import models.Cat;

public class CatView extends AnimalView<Cat> {
    public CatView(AnimalController<Cat> controller) {
        super(controller);
    }
}