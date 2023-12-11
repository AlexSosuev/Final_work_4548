package Repositories;

import java.util.ArrayList;
import java.util.List;

import models.Camel;

public class CamelRepository implements AnimalsRepository<Camel>{
    private final List<Camel> camels;

    public CamelRepository() {
        this.camels = new ArrayList<>();
    }

    @Override
    public void create(Camel animal) {
        camels.add(animal);
    }

    @Override
    public List<Camel> getAll() {
        return camels;
    }
}
