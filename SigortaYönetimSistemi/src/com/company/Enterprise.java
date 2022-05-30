package com.company;

public class Enterprise extends Account{
    @Override
    public void insurancePolicy(Account account) {
        System.out.println("Girişim poliçesi");
    }
}
