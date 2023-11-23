package com.company;

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
