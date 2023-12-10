package view;

import java.util.List;

import controllers.AnimalController;
import models.Cat;

public class CatView implements AnimalView{
    private final AnimalController<Cat> controller;
    public CatView(AnimalController<Cat> controller) {
        this.controller = controller;
    }

    @Override
    public void create(int id, String name, String birthday, String breed,List<String> commandList) {
        controller.create(id, name, birthday, breed,commandList);
    }
    
}
