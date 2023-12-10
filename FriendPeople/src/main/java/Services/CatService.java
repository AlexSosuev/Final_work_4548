package services;

import java.util.List;

import models.Cat;
import repositories.AnimalsRepository;
import repositories.CatRepository;

public class CatService implements AnimalService<Cat>{
    private final AnimalsRepository<Cat> catRepository;

    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    @Override
    public List<Cat> getAll() {
        return catRepository.getAll();
    }

    @Override
    public void create(int id, String name, String birthday, String breed,List<String> commandList) {
        catRepository.create(new Cat(id, name, birthday, breed, commandList));
    }
}
