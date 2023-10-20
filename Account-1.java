package com.company;

public interface Account {

    double getAmount();

    void put(double amount);

    void take(double amount);
}

public abstract class AbstractAccount implements Account{

    protected double amount = 0;

    public AbstractAccount(double amount){
        this.amount = amount;
    }

    @Override
    public void put(double amount) {
        if (amount >= 0) {
            doPut(amount);
        } else {
            throw new IllegalArgumentException("Сумма должна быть положительным числом");
        }
    }

    protected void doPut(double amount){
        this.amount += amount;
    }

    @Override
    public final void take(double amount) {
        if (amount >= 0) {
            if (this.amount - amount > 0) {
                doTake(amount);
            } else {
                throw new IllegalArgumentException("Нельзя снять сумму больше текущей");
            }
        } else {
            throw new IllegalArgumentException("Сумма должна быть положительным числом");
        }
    }

    protected void doTake(double amount){
        this.amount -= amount;
    }

    @Override
    public double getAmount(){
        return amount;
    }
}
public class FixedAmountAccount extends AbstractAccount{

    public FixedAmountAccount(double amount) {
        super(amount);
    }

    @Override
    protected void doPut(double amount){

    }

    @Override
    protected void doTake(double amount){

    }
}