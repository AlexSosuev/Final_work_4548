package repositories;

import java.util.List;

import models.Animal;

public interface AnimalsRepository <T extends Animal>{
    void create(T animal);
    List<T> getAll();
} 
