package View;

import Controllers.AnimalController;
import models.Camel;

public class CamelView extends AnimalView<Camel> {
    public CamelView(AnimalController<Camel> controller) {
        super(controller);
    }
}