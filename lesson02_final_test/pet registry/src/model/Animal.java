package model;

import java.util.Arrays;

public class Animal {
    private int id;
    private String type;
    private String animalNAme;
    private String dateOfBirth;
    private String[] commands;

    public Animal(int id, String type, String animalNAme, String dateOfBirth, String[] commands) {
        this.id = id;
        this.type = type;
        this.animalNAme = animalNAme;
        this.dateOfBirth = dateOfBirth;
        this.commands = commands;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getAnimalName() {
        return animalNAme;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String[] getCommands() {
        return commands;
    }

    @Override
    public String toString() {
        return "Животное №" + id
                + ' ' + type + ' '
                + animalNAme + ' '
                + "дата рождения " + dateOfBirth
                + " знает команды " + Arrays.toString(commands);
    }
}
