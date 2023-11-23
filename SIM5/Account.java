package com.company;

public class Account {

    protected double amount = 0;

    public void put(double amount) {
        if (amount >= 0) {
            this.amount += amount;
        } else {
            throw new IllegalArgumentException("Сумма должна быть положительным числом");
        }
    }

    public void take(double amount) {
        if (amount >= 0) {
            if (this.amount - amount > 0) {
                this.amount -= amount;
            } else {
                throw new IllegalArgumentException("Нельзя снять сумму больше текущей");
            }
        } else {
            throw new IllegalArgumentException("Сумма должна быть положительным числом");
        }
    }

    public double getAmount(){
        return amount;
    }
}
