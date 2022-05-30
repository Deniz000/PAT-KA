package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Helper {
    public static void addressTransactions(){
        Adress myAdress;
        ArrayList<Adress> adresListesi = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kaç adres gireceksin");
        int adet = scanner.nextInt();
        int i = 0;
        String adres0 = "";
        int a0;
        while (i<adet) {
            System.out.println("Ev adresi girişi için 1 'e basınız. ");
            System.out.println("İş adresi girişi için 2 'ye basınız. ");
            a0 = scanner.nextInt();
            System.out.print("Adres : ");
            switch (a0) {
                case 1:
                    myAdress = new HomeAddress(scanner.next());
                    adresListesi.add(myAdress);
                    break;
                case 2:
                    myAdress = new BusinessAddress(scanner.next());
                    adresListesi.add(myAdress);
                    break;
                default:
                    System.out.println("Geçerli bir giriş yapınız.");
                    break;
            }
            i++;
        }
        Account.getUser().setAdresListesi(adresListesi);
    }

}
