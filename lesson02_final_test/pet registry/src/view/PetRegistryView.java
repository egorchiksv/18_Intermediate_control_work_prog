package view;

import DB.DataBase;
import controller.PetRegistryController;
import model.*;
import java.util.Arrays;
import java.util.Scanner;

public class PetRegistryView {
    private PetRegistryController controller = new PetRegistryController();
    public void start() {
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("Программа-реестр домашних животных");
                System.out.println("Выберете, что хотите сделать: \n1. Добавить новое животное\n" +
                        "2. Показать список команд животного\n" +
                        "3. Обучение новым командам\n" +
                        "4. Вывести список всех животных в реестре\n" +
                        "5. Вывести количество животных в реестре\n" +
                        "6. Вывсти животных по дате рождения\n" +
                        "7. Удалить животное\n" +
                        "8. Выход");
                switch (scanner.nextInt()) {
                    case 1 -> addAnimal();
                    case 2 -> showComandsAnimal();
                    case 3 -> addCommandAnimal();
                    case 4 -> System.out.println(controller.getAllAnimals());
                    case 5 -> showRegistrySize();
                    case 6 -> showByDateOfBirth();
                    case 7 -> delAnimal();
                    case 8 -> System.exit(0);
                    default -> System.out.println("Нет такого дейтсвия");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private void addAnimal(){
        Scanner scanner = new Scanner(System.in);
            try {
                while (true) {
                    System.out.println("Выберете, какое животное будете добавлять: \n1. Кошку\n" +
                            "2. Собаку\n" +
                            "3. Хомяка\n" +
                            "4. Верблюда\n" +
                            "5. Лошадь\n" +
                            "6. Осла\n" +
                            "7. Вернуться в галвное меню");
                    switch (scanner.nextInt()) {
                        case 1 -> createCat();
                        case 2 -> createDog();
                        case 3 -> createHamster();
                        case 4 -> createCamel();
                        case 5 -> createHorse();
                        case 6 -> createDonkey();
                        case 7 -> start();
                        default -> System.out.println("Нет такого дейтсвия");
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
    }

    private Cat createCat(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя кошки: ");
        String name = scanner.nextLine();
        System.out.println("Введите дату рождения кошки в формате 'yyyy-mm-dd': ");
        String dateOfBirth = scanner.nextLine();
        System.out.println("Введите через запятую команды, которые знает кошка: ");
        String commands = scanner.nextLine();
        String[] commandsArray = commands.split(",");
        Cat cat = controller.createCat(name, dateOfBirth, commandsArray);
        System.out.println(cat);
        return cat;
    }

    private Dog createDog(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя собаки: ");
        String name = scanner.nextLine();
        System.out.println("Введите дату рождения собаки в формате 'yyyy-mm-dd': ");
        String dateOfBirth = scanner.nextLine();
        System.out.println("Введите через запятую команды, которые знает собака: ");
        String commands = scanner.nextLine();
        String[] commandsArray = commands.split(",");
        Dog dog = controller.createDog(name, dateOfBirth, commandsArray);
        System.out.println(dog);
        return dog;
    }

    private Hamster createHamster(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя хомяка: ");
        String name = scanner.nextLine();
        System.out.println("Введите дату рождения хомяка в формате 'yyyy-mm-dd': ");
        String dateOfBirth = scanner.nextLine();
        System.out.println("Введите через запятую команды, которые знает хомяк: ");
        String commands = scanner.nextLine();
        String[] commandsArray = commands.split(",");
        Hamster hamster = controller.createHamster(name, dateOfBirth, commandsArray);
        System.out.println(hamster);
        return hamster;
    }

    private Camel createCamel(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя верблюда: ");
        String name = scanner.nextLine();
        System.out.println("Введите дату рождения верблюда в формате 'yyyy-mm-dd': ");
        String dateOfBirth = scanner.nextLine();
        System.out.println("Введите через запятую команды, которые знает верблюд: ");
        String commands = scanner.nextLine();
        String[] commandsArray = commands.split(",");
        Camel camel = controller.createCamel(name, dateOfBirth, commandsArray);
        System.out.println(camel);
        return camel;
    }

    private Horse createHorse(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя лошади: ");
        String name = scanner.nextLine();
        System.out.println("Введите дату рождения лошади в формате 'yyyy-mm-dd': ");
        String dateOfBirth = scanner.nextLine();
        System.out.println("Введите через запятую команды, которые знает лошадь: ");
        String commands = scanner.nextLine();
        String[] commandsArray = commands.split(",");
        Horse horse = controller.createHorse(name, dateOfBirth, commandsArray);
        System.out.println(horse);
        return horse;
    }

    private Donkey createDonkey(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя осла: ");
        String name = scanner.nextLine();
        System.out.println("Введите дату рождения осла в формате 'yyyy-mm-dd': ");
        String dateOfBirth = scanner.nextLine();
        System.out.println("Введите через запятую команды, которые знает осел: ");
        String commands = scanner.nextLine();
        String[] commandsArray = commands.split(",");
        Donkey donkey = controller.createDonkey(name, dateOfBirth, commandsArray);
        System.out.println(donkey);
        return donkey;
    }

    private void showComandsAnimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер животного, команды которого показать: ");
        Animal animal = controller.getById(scanner.nextInt());
        System.out.println(Arrays.toString(animal.getCommands()));
    }

    private void addCommandAnimal(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер животного, которого необходимо обучить новым командам: ");
        Animal animal = controller.getById(scanner.nextInt());
        System.out.println(animal);
        System.out.println();
        System.out.println("Введите через запятую без пробелов новые команды для животного: ");
        String commands = scanner.next();
        String[] commandsArray = commands.split(",");
        System.out.println(Arrays.toString(commandsArray));
        animal.setCommands(commandsArray);
        System.out.println(animal);
    }

    private void showRegistrySize(){
        System.out.println("В реестре " + DataBase.animals.size() + " животных");
    }

    private void showByDateOfBirth(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дату рождения: ");
        String dateOfBirth = scanner.next();
        int count = 0;
        for (Animal animal : DataBase.animals){
            if(animal.getDateOfBirth().equals(dateOfBirth)) {
                System.out.println(animal);
                count += 1;
            }
        }
        if (count == 0) {
            System.out.println("Животное не найдено");
        }
    }

    private void delAnimal(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер животного, которого необходимо удалить: ");
        Animal animal = controller.getById(scanner.nextInt());
        DataBase.animals.remove(animal);
        System.out.println("Животное: " + animal + " удалено");
    }
}
