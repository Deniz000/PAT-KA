package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Account newAccount = new Account();
        newAccount.register();


        if (newAccount.isAuthenticationStatus()) {
            System.out.println("Kayıt başarılı sayın " + Account.getUser().getIsim());
        } else {
            System.out.println("Malesef bir sourn oluştu!");
        }

        AdressManager adressManager = new AdressManager(Account.getUser());
        adressManager.deleteAdress("asdf");
    }}
