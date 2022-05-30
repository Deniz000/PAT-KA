package com.company;

public class BusinessAddress implements Adress{
    private String adress;

    public BusinessAddress(String adress) {
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
