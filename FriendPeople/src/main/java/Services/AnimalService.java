package Services;

import java.util.List;

import models.Animal;

public interface AnimalService <T extends Animal>{
    List<T> getAll();
    void create(int id, String name, String birthday,String breed,List<String> commandList);
    

}
