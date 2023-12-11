package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Men {

    public static final char GENDER_MALE = 'm';
    public static final char GENDER_FEMALE = 'f';

    private String lastName = "";
    private String firstName = "";
    private String middleName = "";
    private String birthDate = "00.00.0000";
    private long phoneNumber = 00000000000L;
    private char gender = '0';

    public Men(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    public Men(String lastName, String firstName, String middleName, String birthDate, long phoneNumber, char gender) {
        this(lastName, firstName, middleName);
        if (isCorrectDate(birthDate))
            this.birthDate = birthDate;
        if (isCorrectNumber(phoneNumber))
            this.phoneNumber = phoneNumber;
        if (isCorrectGender(gender))
            this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        if (isCorrectDate(birthDate)) this.birthDate = birthDate;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        if (isCorrectNumber(phoneNumber)) this.phoneNumber = phoneNumber;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {

        if (isCorrectGender(gender)) this.gender = gender;
    }

    public static boolean isCorrectDate(String birthDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        dateFormat.setLenient(false);
        try {
            Date date = dateFormat.parse(birthDate);
            return true;
        } catch (ParseException e) {
            throw new IllegalArgumentException("Неверный формат даты.\n" + e.getMessage() + "\nОжидается формат dd.MM.yyyy.");
        }
    }

    public static boolean isCorrectGender(char gender) {
        if (gender != GENDER_FEMALE && gender != GENDER_MALE) {
            throw new IllegalArgumentException("Некорректное значение пола. Допустимые значения: 'f' или 'm'.");
        }
        return true;
    }

    public static boolean isCorrectNumber(long phoneNumber) {
        if (String.valueOf(phoneNumber).matches("\\d{11}")) {
            return true;
        } else {
            throw new IllegalArgumentException("Некорректный формат номера телефона. Допустимо 11 цифр.");
        }
    }

}
