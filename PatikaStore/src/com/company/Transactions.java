package com.company;

public class Transactions {
    private String transactions;

    public Transactions(String transactions) {
        this.transactions = transactions;
        System.out.println(transactions + "açılıyor");
    }

    public String getTransactions() {
        return transactions;
    }

    public void setTransactions(String transactions) {
        this.transactions = transactions;
    }
}
