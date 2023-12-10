package view;

import java.util.List;

import controllers.AnimalController;
import models.Dog;

public class DogView implements AnimalView{
    private final AnimalController<Dog> controller;

    public DogView(AnimalController<Dog> controller) {
        this.controller = controller;
    }
    @Override
    public void create(int id, String name, String birthday, String breed,List<String> commandList) {
        controller.create(id, name,birthday,breed,commandList);
    }

}
