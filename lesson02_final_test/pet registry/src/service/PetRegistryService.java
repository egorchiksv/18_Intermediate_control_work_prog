package service;

import DB.DataBase;
import model.Animal;
import model.Cat;

import java.util.List;

public class PetRegistryService {
    public Cat createCat (String animalName, String dateOfBirth, String[] commands){
        int id;
        int size = DataBase.animals.size();
        if (size == 0) {
            id = 1;
        } else id = size + 1;
        Cat cat = new Cat(id, "кошка", animalName, dateOfBirth, commands);
        DataBase.animals.add(cat);
        return cat;
    }

    public List<Animal> getAllAnimals(){
        return DataBase.animals;
    }

    public Animal getById (int id) throws Exception {
        Animal animal = DataBase.animals
                .stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
        if (animal == null) {
            throw new Exception("Животное не найдено");
        }
        return animal;
    }
}
