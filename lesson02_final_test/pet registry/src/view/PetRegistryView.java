package view;

import DB.DataBase;
import controller.PetRegistryController;
import model.Animal;
import model.Cat;

import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class PetRegistryView {
    private PetRegistryController controller = new PetRegistryController();
    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Программа-реестр домашних животных");
            System.out.println("Выберете, что хотите сделать: \n1. Добавить новое животное\n" +
                "2. Показать список команд животного\n" +
                "3. Обучение новым командам\n" +
                "4. Вывести список всех животных в реестре\n" +
                "5. Вывести количество животных в реестре\n" +
                "6. Удалить животное\n" +
                "7. Выход");
            switch (scanner.nextInt()) {
                case 1 -> addAnimal();
                case 2 -> showComandsAnimal();
                case 3 -> addCommandAnimal();
                case 4 -> System.out.println(controller.getAllAnimals());
                case 5 -> showRegistrySize();
                case 6 -> delAnimal();
                case 7 -> System.exit(0);
                default -> System.out.println("Нет такого дейтсвия");
            }
        }
    }
    private void addAnimal(){
        Scanner scanner = new Scanner(System.in);
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
                case 2 -> System.out.println("Собака"); //--
                case 3 -> System.out.println("Хомяк"); //--
                case 4 -> System.out.println("Верблюд"); //--
                case 5 -> System.out.println("Лошадь"); //--
                case 6 -> System.out.println("Осел"); //--
                case 7 -> start();
                default -> System.out.println("Нет такого дейтсвия");
            }
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
        System.out.println(Arrays.toString(animal.getCommands()));
        System.out.println("Введите новые через запятую команды для животного: ");
        String commands = scanner.nextLine();
        String[] commandsArray = commands.split(",");
        animal.setCommands(commandsArray);
        System.out.println(animal);
    }

    private void showRegistrySize(){
        System.out.println("В реестре " + DataBase.animals.size() + " животных");
    }

    private void delAnimal(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер животного, которого необходимо удалить: ");
        Animal animal = controller.getById(scanner.nextInt());
        DataBase.animals.remove(animal);
        System.out.println("Животное: " + animal + " удалено");
    }
}
