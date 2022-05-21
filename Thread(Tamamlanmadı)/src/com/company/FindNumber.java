package com.company;

import java.util.ArrayList;
import java.util.List;

public class FindNumber extends Thread {
    private static List<Integer> tekSayi = new ArrayList<>();
    private static List<Integer> ciftSayi = new ArrayList<>();
    private List<Integer> liste;

    public FindNumber(List<Integer> liste){
        this.liste = liste;
    }
    @Override
    public void run() {
        bulTekCift(this.liste);
        printValue(Thread.currentThread().getName());
    }

    public synchronized void bulTekCift(List<Integer> liste){
        for(int i = 0; i<liste.size(); i++){
            int sayi = liste.get(i);
            if(sayi%2 == 0){
                ciftSayi.add(i);
            }
            else{
                tekSayi.add(i);
            }
        }
    }

    public void printValue(String threadAdi){
        System.out.println(threadAdi + " -- " + tekSayi);
        System.out.println(threadAdi + " -- " + ciftSayi);
    }
}
