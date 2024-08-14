package view;

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
                "4. Вывести список животных по дате рождения\n" +
                "5. Выход");
            String cmd = scanner.nextLine();
            switch (cmd) {
                case "1" -> addAnimal();
                case "2" -> showComandsAnimal();
                case "3" -> System.out.println("Обучение командам");
                case "4" -> System.out.println(controller.getAllAnimals());
                case "5" -> System.exit(0);
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
                "7. Вернуться в галвное меню\n");
        String cmd = scanner.nextLine();
            switch (cmd) {
                case "1" -> createCat();
                case "2" -> System.out.println("Собака");
                case "3" -> System.out.println("Хомяк");
                case "4" -> System.out.println("Верблюд");
                case "5" -> System.out.println("Лошадь");
                case "6" -> System.out.println("Осел");
                case "7" -> start();
                default -> System.out.println("Нет такого дейтсвия");
            }
        }
    }

    private Cat createCat(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя кошки: ");
        String name = scanner.nextLine();
        System.out.println("Введите дату рождения кошки: ");
        String dateOfBirth = scanner.nextLine();
        System.out.println("Введите через запятую команды, которые знает кошка: ");
        String commands = scanner.nextLine();
        String[] commandsArray = commands.split(",");
        Cat cat = controller.createCat(name, dateOfBirth, commandsArray);
        System.out.println(cat);
        return cat;
    }

    private Animal showComandsAnimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя животного, команды которого показать: ");
        String name = scanner.nextLine();
        Animal animal = controller.getByName(name);
        return animal;
    }
}
