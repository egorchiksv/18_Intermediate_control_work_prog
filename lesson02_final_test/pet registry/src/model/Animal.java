package model;

import java.sql.Array;
import java.util.Arrays;

public class Animal {
    private int id;
    private String animalNAme;
    private String dateOfBirth;
    private String[] commands;

    public Animal(int id, String animalNAme, String dateOfBirth, String[] commands) {
        this.id = id;
        this.animalNAme = animalNAme;
        this.dateOfBirth = dateOfBirth;
        this.commands = commands;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnimalNAme() {
        return animalNAme;
    }

    public void setAnimalNAme(String animalNAme) {
        this.animalNAme = animalNAme;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String[] getCommands() {
        return commands;
    }

    public void setCommands(String[] commands) {
        this.commands = commands;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", animalNAme='" + animalNAme + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", commands=" + Arrays.toString(commands) +
                '}';
    }
}
