package controller;

import model.Cat;
import service.PetRegistryService;

public class PetRegistryController {
    private PetRegistryService service = new PetRegistryService();

    public Cat createCat(String animalName, String dateOfBirth, String[] commands) {
        return service.createCat(animalName, dateOfBirth, commands);
    }
}
