package model;

import java.util.Arrays;

public class Animal {
    private int id;
    private String type;
    private String animalName;
    private String dateOfBirth;
    private String[] commands;

    public Animal(int id, String type, String animalName, String dateOfBirth, String[] commands) {
        this.id = id;
        this.type = type;
        this.animalName = animalName;
        this.dateOfBirth = dateOfBirth;
        this.commands = commands;
    }

    public int getId() {
        return id;
    }

    public String getAnimalName() {
        return animalName;
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
                + animalName + ' '
                + "дата рождения " + dateOfBirth
                + " знает команды " + Arrays.toString(commands);
    }

}
