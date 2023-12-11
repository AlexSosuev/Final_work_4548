package Services;

import java.util.List;
import java.util.Objects;

import models.Dog;
import Repositories.AnimalsRepository;

public class DogService implements AnimalService<Dog> {
    private final AnimalsRepository<Dog> dogRepository;

    public DogService(AnimalsRepository<Dog> dogRepository) {
        Objects.requireNonNull(dogRepository, "dogRepository cannot be null");
        this.dogRepository = dogRepository;
    }

    @Override
    public List<Dog> getAll() {
        return dogRepository.getAll();
    }

    @Override
    public void create(int id, String name, String birthday, String breed, List<String> commandList) {
        dogRepository.create(new Dog(id, name, birthday, breed, commandList));
    }
}