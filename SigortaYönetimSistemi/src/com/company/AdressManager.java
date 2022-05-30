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

    public static void addAdress(Adress adress){

    }
    public static void deleteAdress(List<Adress> adress){}

}
