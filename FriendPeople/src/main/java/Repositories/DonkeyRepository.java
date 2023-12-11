package Repositories;

import java.util.ArrayList;
import java.util.List;

import models.Donkey;

public class DonkeyRepository implements AnimalsRepository<Donkey>{
    private final List<Donkey> donkeys;

    public DonkeyRepository() {
        this.donkeys = new ArrayList<>();
    }

    @Override
    public void create(Donkey animal) {
        donkeys.add(animal);
    }

    @Override
    public List<Donkey> getAll() {
        return donkeys;
    }
    
}
