package com.company;

public class Main {

    public static void main(String[] args) {

        Account testAccount = new Account();
        testAccount.put(75);
        System.out.println("На счету " + testAccount.getAmount());
        testAccount.take(15);
        System.out.println("На счету " + testAccount.getAmount());

        CreditAccount testCreditAccount = new CreditAccount();
        testCreditAccount.put(100);
        System.out.println("На счету " + testCreditAccount.getAmount());
        testCreditAccount.take(15);
        System.out.println("На счету " + testCreditAccount.getAmount());

        DepositAccount testDepositAccount = new DepositAccount();
        testDepositAccount.put(750);
        System.out.println("На счету " + testDepositAccount.getAmount());
        testDepositAccount.take(300);
        System.out.println("На счету " + testDepositAccount.getAmount());
        testDepositAccount.take(50);//выведется ошибка
        System.out.println("На счету " + testDepositAccount.getAmount());
    }
}
