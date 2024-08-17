package controller;

import DB.DataBase;
import model.*;
import service.PetRegistryService;

import java.util.List;

public class PetRegistryController {
    private PetRegistryService service = new PetRegistryService();

    public Cat createCat(String animalName, String dateOfBirth, String[] commands) {
        return service.createCat(animalName, dateOfBirth, commands);
    }

    public Dog createDog(String animalName, String dateOfBirth, String[] commands) {
        return service.createDog(animalName, dateOfBirth, commands);
    }

    public Hamster createHamster(String animalName, String dateOfBirth, String[] commands) {
        return service.createHamster(animalName, dateOfBirth, commands);
    }

    public Camel createCamel(String animalName, String dateOfBirth, String[] commands) {
        return service.createCamel(animalName, dateOfBirth, commands);
    }

    public Horse createHorse(String animalName, String dateOfBirth, String[] commands) {
        return service.createHorse(animalName, dateOfBirth, commands);
    }

    public Donkey createDonkey(String animalName, String dateOfBirth, String[] commands) {
        return service.createDonkey(animalName, dateOfBirth, commands);
    }

    public List<Animal> getAllAnimals(){
        return service.getAllAnimals();
    }

    public Animal getById (int id){
        Animal animal = null;
        try {
            animal = service.getById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return animal;
    }

    public Animal getDateOfBirth (String dateOfBirth){
        Animal animal = null;
        try {
            animal = service.getDateOfBirth(dateOfBirth);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return animal;
    }
}
