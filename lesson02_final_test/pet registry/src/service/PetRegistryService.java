package service;

import DB.DataBase;
import model.Animal;
import model.Cat;

import java.util.List;

public class PetRegistryService {
    public Cat createCat (String animalNAme, String dateOfBirth, String[] commands){
        int id;
        int size = DataBase.animals.size();
        if (size == 0) {
            id = 1;
        } else id = size + 1;
        Cat cat = new Cat(id, "кошка", animalNAme, dateOfBirth, commands);
        DataBase.animals.add(cat);
        System.out.println();
        return cat;
    }

    public List<Animal> getAllAnimals(){
        return DataBase.animals;
    }

    public Animal getByName (String animalName) throws Exception {
        Animal animal = DataBase.animals
                .stream()
                .filter(s -> s.getAnimalName() == animalName)
                .findFirst()
                .orElse(null);
        if (animal == null) {
            throw new Exception("Животное не найдено");
        }
        return animal;
    }
}
