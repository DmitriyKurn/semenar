package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {

    public static void save(Men men) {
        File fileWriter = new File(men.getLastName() + ".txt");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileWriter, true))) {
            String write = String.format("<%s><%s><%s><%s><%d><%c>", men.getLastName(),
                    men.getFirstName(),
                    men.getMiddleName(),
                    men.getBirthDate(),
                    men.getPhoneNumber(),
                    men.getGender());
            bufferedWriter.write(write);
            bufferedWriter.newLine();
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл.");
            e.printStackTrace();
        }
    }
}
