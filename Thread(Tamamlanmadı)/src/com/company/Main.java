package com.company;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> fullNumber = new ArrayList<>();
        for(int i = 0; i <10000; i++){
            fullNumber.add(i);
        }
        FindNumber findNumber1 = new FindNumber(fullNumber.subList(0,2500));
        Thread t1 = new Thread(findNumber1);
        t1.start();

        FindNumber findNumber2 = new FindNumber(fullNumber.subList(2500,5000));
        Thread t2 = new Thread(findNumber2);
        t2.start();

        FindNumber findNumber3 = new FindNumber(fullNumber.subList(5000,7500));
        Thread t3 = new Thread(findNumber3);
        t3.start();

        FindNumber findNumber4 = new FindNumber(fullNumber.subList(7500,10000));
        Thread t4 = new Thread(findNumber4);
        t4.start();


    }
}
