package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Account {
    private static User user = new User();
    private boolean AuthenticationStatus = true;
    private Scanner scanner = new Scanner(System.in);
    private int id,yas;
    private String isim,soyisim,email,sifre, meslek;

    public boolean register(){
        System.out.println("KULLANICI KAYIT EKRANI");
        System.out.print(" Adınız: ");
        isim = scanner.next();
        user.setIsim(isim);
        System.out.print(" Soyadınız: ");
        soyisim = scanner.next();
        user.setSoyisim(soyisim);
        System.out.print(" E-Mail adresinniz: ");
        email = scanner.next();
        user.setEmail(email);
        System.out.print(" Şifreniz: ");
        sifre = scanner.next();
        user.setSifre(sifre);
        System.out.print(" Mesleğiniz: ");
        meslek = scanner.next();
        user.setMeslek(meslek);
        System.out.print(" Yaşınız: ");
        yas = scanner.nextInt();
        user.setYas(yas);
        System.out.println(" Adresiniz: ");
        addressTransactions();
        return AuthenticationStatus;
    }
    private void addressTransactions(){
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
        user.setAdresListesi(adresListesi);

    }

    public boolean isAuthenticationStatus() {
        return AuthenticationStatus;
    }

    public void setAuthenticationStatus(boolean authenticationStatus) {
        AuthenticationStatus = authenticationStatus;
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        Account.user = user;
    }

    public final static void showUserInfo(){
        System.out.println(user.getId());
        System.out.println(user.getIsim());
        System.out.println(user.getSoyisim());
        System.out.println(user.getEmail());
        System.out.println(user.getSifre());
        System.out.println(user.getMeslek());
        System.out.println(user.getYas());
        System.out.println(user.getSonGiristarihi());

        for (int i = 0; i < user.getAdresListesi().size();i++){
            System.out.println(user.getAdresListesi().get(i).getAdress());
        }
    }
}
