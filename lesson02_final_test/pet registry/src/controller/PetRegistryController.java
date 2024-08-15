package controller;

import DB.DataBase;
import model.Animal;
import model.Cat;
import service.PetRegistryService;

import java.util.List;

public class PetRegistryController {
    private PetRegistryService service = new PetRegistryService();

    public Cat createCat(String animalName, String dateOfBirth, String[] commands) {
        return service.createCat(animalName, dateOfBirth, commands);
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
}
