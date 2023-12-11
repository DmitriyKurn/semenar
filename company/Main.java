package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите данные (Фамилия Имя Отчество дата рождения номер телефона пол)");
            String userInput = scanner.nextLine().trim();

            // Проверяем количество введенных данных
            String[] userData = userInput.split("\\s+");
            if (userData.length != 6) {
                throw new IllegalArgumentException("Ошибка: Введите все 6 требуемых данных.");
            }
            String lastName = userData[0];
            String firstName = userData[1];
            String middleName = userData[2];
            String birthDate = userData[3];
            String phoneNumber = userData[4];
            String gender = userData[5];
            try {
                Men men = new Men(lastName, firstName, middleName, birthDate, Long.parseLong(phoneNumber), gender.charAt(0));
                FileUtil.save(men);
            } catch (IllegalArgumentException e) {
                //Обрабатывает исключения из класса Men
                System.out.println("Ошибка: " + e.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
