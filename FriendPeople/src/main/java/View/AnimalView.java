package View;

import Controllers.AnimalController;
import models.Animal;

import java.util.List;

public class AnimalView<T extends Animal> {
    private final AnimalController<T> controller;

    public AnimalView(AnimalController<T> controller) {
        this.controller = controller;
    }

    public void create(int id, String name, String birthday, String breed, List<String> commandList) {
        controller.create(id, name, birthday, breed, commandList);
    }
}