package com.company;

import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Account {
    private static User user = new User();
    private boolean AuthenticationStatus = true;
    private Scanner scanner = new Scanner(System.in);
    private int id,yas;
    private String isim,soyisim,email,sifre, meslek;

    public abstract void insurancePolicy(Account account);

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
        Helper.addressTransactions();
        return AuthenticationStatus;
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


    public void login() throws InvalidAuthenticationException {
        System.out.println("KULLANICI GİRİŞ EKRANI");
        System.out.print(" email: ");
        String mail = scanner.next();
        System.out.print(" şifreniz :");
        String sifre = scanner.next();

        if (user.getEmail().contains(mail) && user.getSifre().contains(sifre)){
            System.out.println("Tekrar hoşgeldin " + user.getIsim());
            EAuthenticationStatus status = EAuthenticationStatus.SUCCESS;
        }
        else{
            throw new InvalidAuthenticationException("Giriş yapılamadı");
        }
    }
    enum EAuthenticationStatus{
        SUCCESS,
        FAIL
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
