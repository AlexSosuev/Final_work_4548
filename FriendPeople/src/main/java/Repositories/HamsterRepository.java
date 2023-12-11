package Repositories;

import java.util.ArrayList;
import java.util.List;

import models.Hamster;

public class HamsterRepository implements AnimalsRepository<Hamster>{
    private final List<Hamster> hamsters;
    public HamsterRepository() {
        this.hamsters = new ArrayList<>();
    }

    @Override
    public void create(Hamster animal) {
        hamsters.add(animal);
    }

    @Override
    public List<Hamster> getAll() {
        return hamsters;
    }
    
}
