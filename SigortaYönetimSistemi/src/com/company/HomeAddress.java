package com.company;

import java.util.ArrayList;
import java.util.List;

public class HomeAddress implements Adress{
    private String adress;
    private User user = new User();


    public HomeAddress(String adress) {
        this.adress = adress;
    }

    @Override
    public String getAdress() {
        return adress;
    }

    @Override
    public void setAdress(String adress) {
        this.adress = adress;
    }
}
