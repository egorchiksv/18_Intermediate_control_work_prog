package DB;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    public static final List<Animal> animals = new ArrayList<>();

    public static void DB() {
        String[] commands;
        commands = new String[]{"sit", "stay", "fetch"};
        Dog dog1 = new Dog(1, "собака", "Fido", "2020-01-01", commands);
        animals.add(dog1);
        commands = new String[]{"sit", "pounce"};
        Cat cat1 = new Cat(2, "кошка", "Whiskers", "2019-05-15", commands);
        animals.add(cat1);
        commands = new String[]{"roll", "hide"};
        Hamster hamster1 = new Hamster(3, "хомяк", "Hammy", "2021-03-10", commands);
        animals.add(hamster1);
        commands = new String[]{"sit", "paw", "bark"};
        Dog dog2 = new Dog(4, "собака", "Buddy", "2018-12-10", commands);
        animals.add(dog2);
        commands = new String[]{"sit", "pounce", "scratch"};
        Cat cat2 = new Cat(5, "кошка", "Smudge", "2020-02-20", commands);
        animals.add(cat2);
        commands = new String[]{"roll", "spin"};
        Hamster hamster2 = new Hamster(6, "хомяк", "Peanut", "2021-08-01", commands);
        animals.add(hamster2);
        commands = new String[]{"sit", "stay", "roll"};
        Dog dog3 = new Dog(7, "собака", "Bella", "2019-11-11", commands);
        animals.add(dog3);
        commands = new String[]{"meow", "scratch", "jump"};
        Cat cat3 = new Cat(8, "кошка", "Oliver", "2020-06-30", commands);
        animals.add(cat3);
        commands = new String[]{"trot", "canter", "gallop"};
        Horse horse1 = new Horse(9, "лошадь", "Thunder", "2015-07-21", commands);
        animals.add(horse1);
        commands = new String[]{"walk", "carry", "load"};
        Camel camel1 = new Camel(10, "верблюд", "Sandy", "2016-11-03", commands);
        animals.add(camel1);
        commands = new String[]{"carry", "load", "bray"};
        Donkey donkey1 = new Donkey(11, "осел", "Eeyore", "2017-09-18", commands);
        animals.add(donkey1);
        commands = new String[]{"canter"};
        Horse horse2 = new Horse(12, "лошадь", "Storm", "2014-05-05", commands);
        animals.add(horse2);
        commands = new String[]{"walk", "sit"};
        Camel camel2 = new Camel(13, "верблюд", "Dune", "2018-12-12", commands);
        animals.add(camel2);
        commands = new String[]{"walk", "bray", "kick"};
        Donkey donkey2 = new Donkey(14, "осел", "Burro", "2019-01-23", commands);
        animals.add(donkey2);
        commands = new String[]{"trot", "jump", "gallop"};
        Horse horse3 = new Horse(15, "лошадь", "Blaze", "2016-02-29", commands);
        animals.add(horse3);
        commands = new String[]{"walk", "run"};
        Camel camel3 = new Camel(16, "верблюд", "Sahara", "2015-08-14", commands);
        animals.add(camel3);
    }
}