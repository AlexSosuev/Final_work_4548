package Services;

import java.util.List;
import java.util.Objects;

import models.Cat;
import Repositories.AnimalsRepository;

public class CatService implements AnimalService<Cat> {
    private final AnimalsRepository<Cat> catRepository;

    public CatService(AnimalsRepository<Cat> catRepository) {
        Objects.requireNonNull(catRepository, "catRepository cannot be null");
        this.catRepository = catRepository;
    }

    @Override
    public List<Cat> getAll() {
        return catRepository.getAll();
    }

    @Override
    public void create(int id, String name, String birthday, String breed, List<String> commandList) {
        catRepository.create(new Cat(id, name, birthday, breed, commandList));
    }
}