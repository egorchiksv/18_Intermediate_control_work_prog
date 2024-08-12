package view;

import java.util.Scanner;

public class PetRegistryView {
    public static void start(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Программа-реестр домашних животных");
        System.out.println("Выберете, что хотите сделать: \n1. Добавить новое животное\n" +
                "2. Показать список команд животного\n" +
                "3. Обучение новым командам\n" +
                "4. Вывести список животных по дате рождения\n" +
                "5. Выход");
        try {
            int cmd = scanner.nextInt();
            while (true) {
                switch (cmd) {
                    case 1 -> System.out.println("Добавление животного");
                    case 2 -> System.out.println("Показать команды");
                    case 3 -> System.out.println("Обучение командам");
                    case 4 -> System.out.println("Список по дате рождения");
                    case 5 -> System.exit(0);
                    default -> System.out.println("Нет такого дейтсвия");
                }
            }
        } catch (Exception e) {
            System.out.println("Выбрано не верное действие");
        }

    }
}
