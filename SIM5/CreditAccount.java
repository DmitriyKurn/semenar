package com.company;

public class CreditAccount extends Account {

    @Override
    public void take(double amount) {
        if (amount >= 0) {
            if (this.amount - amount * 1.01 > 0) {
                this.amount -= amount * 1.01;
            } else {
                throw new IllegalArgumentException("С учётом комиссии нельзя снять сумму большую текущей");
            }
        } else {
            throw new IllegalArgumentException("Сумма должна быть положительным числом");
        }
    }
}
