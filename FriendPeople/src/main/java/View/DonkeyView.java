package view;

import java.util.List;

import controllers.AnimalController;
import models.Donkey;

public class DonkeyView implements AnimalView{
    private final AnimalController<Donkey> controller;

    public DonkeyView(AnimalController<Donkey> controller) {
        this.controller = controller;
    }

    @Override
    public void create(int id, String name, String birthday, String breed,List<String> commandList) {
        controller.create(id, name, birthday, breed,commandList);
    }

    
}
