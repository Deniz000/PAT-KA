package com.company;

import java.util.ArrayList;
import java.util.List;

public class AdressManager {
    private static User user;
    private static List<Adress> adresses = new ArrayList<>();

    public AdressManager(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addAdress(Adress adress){
        System.out.println("Adres ekleme bölümü");
        Helper.addressTransactions();
    }
    public void deleteAdress(String adress){
        System.out.println("Adres silme bölümü");
        for (int i = 0; i < Account.getUser().getAdresListesi().size(); i++) {
            if (Account.getUser().getAdresListesi().get(i).getAdress().contains(adress)) {
                Account.getUser().getAdresListesi().remove(i);
            }
        }
        System.out.println("Silme işlemi başarılı");
        System.out.println("Yeni adres listesi: ");
        int i = 0;
        while (i<Account.getUser().getAdresListesi().size()){
            System.out.println(Account.getUser().getAdresListesi().get(i).getAdress());
            i++;
        }
    }

}
