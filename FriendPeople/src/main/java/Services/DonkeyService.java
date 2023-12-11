package Services;

import java.util.List;
import java.util.Objects;

import models.Donkey;
import Repositories.AnimalsRepository;

public class DonkeyService implements AnimalService<Donkey> {
    private final AnimalsRepository<Donkey> donkeyRepository;

    public DonkeyService(AnimalsRepository<Donkey> donkeyRepository) {
        Objects.requireNonNull(donkeyRepository, "donkeyRepository cannot be null");
        this.donkeyRepository = donkeyRepository;
    }

    @Override
    public List<Donkey> getAll() {
        return donkeyRepository.getAll();
    }

    @Override
    public void create(int id, String name, String birthday, String breed, List<String> commandList) {
        donkeyRepository.create(new Donkey(id, name, birthday, breed, commandList, 0));
    }


}
