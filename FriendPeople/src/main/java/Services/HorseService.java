package Services;

import java.util.List;
import java.util.Objects;

import models.Horse;
import Repositories.AnimalsRepository;

public class HorseService implements AnimalService<Horse> {
    private final AnimalsRepository<Horse> horseRepository;

    public HorseService(AnimalsRepository<Horse> horseRepository) {
        Objects.requireNonNull(horseRepository, "horseRepository cannot be null");
        this.horseRepository = horseRepository;
    }

    @Override
    public List<Horse> getAll() {
        return horseRepository.getAll();
    }

    @Override
    public void create(int id, String name, String birthday, String breed, List<String> commandList) {
        horseRepository.create(new Horse(id, name, birthday, breed, commandList, 0));
    }
}