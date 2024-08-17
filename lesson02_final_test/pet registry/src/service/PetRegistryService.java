package service;

import DB.DataBase;
import model.*;

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

    public Dog createDog (String animalName, String dateOfBirth, String[] commands){
        int id;
        int size = DataBase.animals.size();
        if (size == 0) {
            id = 1;
        } else id = size + 1;
        Dog dog = new Dog(id, "собака", animalName, dateOfBirth, commands);
        DataBase.animals.add(dog);
        return dog;
    }

    public Hamster createHamster (String animalName, String dateOfBirth, String[] commands){
        int id;
        int size = DataBase.animals.size();
        if (size == 0) {
            id = 1;
        } else id = size + 1;
        Hamster hamster = new Hamster(id, "хомяк", animalName, dateOfBirth, commands);
        DataBase.animals.add(hamster);
        return hamster;
    }

    public Camel createCamel (String animalName, String dateOfBirth, String[] commands){
        int id;
        int size = DataBase.animals.size();
        if (size == 0) {
            id = 1;
        } else id = size + 1;
        Camel camel = new Camel(id, "верблюд", animalName, dateOfBirth, commands);
        DataBase.animals.add(camel);
        return camel;
    }

    public Horse createHorse (String animalName, String dateOfBirth, String[] commands){
        int id;
        int size = DataBase.animals.size();
        if (size == 0) {
            id = 1;
        } else id = size + 1;
        Horse horse = new Horse(id, "верблюд", animalName, dateOfBirth, commands);
        DataBase.animals.add(horse);
        return horse;
    }

    public Donkey createDonkey (String animalName, String dateOfBirth, String[] commands){
        int id;
        int size = DataBase.animals.size();
        if (size == 0) {
            id = 1;
        } else id = size + 1;
        Donkey donkey = new Donkey(id, "верблюд", animalName, dateOfBirth, commands);
        DataBase.animals.add(donkey);
        return donkey;
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
