package org.example.behavioral.ChainOfResponsibility;

public class Money {
    private int amount;

    public Money(int amount){
        this.amount = amount;
    }

    public int getAmount(){
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
