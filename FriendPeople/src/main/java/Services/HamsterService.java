package Services;

import java.util.List;
import java.util.Objects;

import models.Hamster;
import Repositories.AnimalsRepository;

public class HamsterService implements AnimalService<Hamster>{
    private final AnimalsRepository<Hamster> humsterRepository;

    public HamsterService(AnimalsRepository<Hamster> humsterRepository) {
        Objects.requireNonNull(humsterRepository, "humsterRepository cannot be null");
        this.humsterRepository = humsterRepository;
    }

    @Override
    public List<Hamster> getAll() {
        return humsterRepository.getAll();
    }

    @Override
    public void create(int id, String name, String birthday, String breed,List<String> commandList) {
        humsterRepository.create(new Hamster(id, name, birthday, breed, commandList));
    }
}