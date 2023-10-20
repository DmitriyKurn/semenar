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

import java.time.LocalDate;
import java.time.Period;

public class DepositAccount extends Account {
    private LocalDate withdrawalDate = null;

    @Override
    public void take(double amount) {
        if(withdrawalDate == null){
            super.take(amount);
            withdrawalDate = LocalDate.now();
            return;
        }
        LocalDate nowDate = LocalDate.now();
        if (isTake(nowDate)) {
            super.take(amount);
            withdrawalDate = nowDate;
        } else {
            throw new IllegalArgumentException("Нельзя снимать средства чаще, чем раз в месяц");
        }
    }

    private boolean isTake(LocalDate nowDate) {
        Period period = Period.between(withdrawalDate, nowDate);
        int delMouth = period.getMonths();
        return delMouth >= 1;
    }
}
