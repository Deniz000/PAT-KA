package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
    private int id;
    private String isim;
    private String soyisim;
    private String email;
    public String sifre;
    private String meslek;
    private int yas;
    private ArrayList<Adress> adresListesi = new ArrayList<>();
    private Date sonGiristarihi;

    public User() {

    }

    public User(int id, String isim, String soyisim, String email, String sifre, String meslek, int yaş, ArrayList<Adress> adresListesi, Date sonGiristarihi) {
        this.id = id;
        this.isim = isim;
        this.soyisim = soyisim;
        this.email = email;
        this.sifre = sifre;
        this.meslek = meslek;
        this.yas = yaş;
        this.adresListesi = adresListesi;
        this.sonGiristarihi = sonGiristarihi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getMeslek() {
        return meslek;
    }

    public void setMeslek(String meslek) {
        this.meslek = meslek;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public List<Adress> getAdresListesi() {
        return adresListesi;
    }

    public void setAdresListesi(ArrayList<Adress> adresListesi) {
        this.adresListesi = adresListesi;
    }

    public Date getSonGiristarihi() {
        return sonGiristarihi;
    }

    public void setSonGiristarihi(Date sonGiristarihi) {
        this.sonGiristarihi = sonGiristarihi;
    }
}
