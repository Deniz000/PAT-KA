package com.company;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        List<Integer> array = new ArrayList<>();

        for (int i = 1; i <= 10000; i++) {
            array.add(i);
        }

        List<Integer> subArray1 = array.subList(0, 2500);
        List<Integer> subArray2 = array.subList(2500, 5000);
        List<Integer> subArray3 = array.subList(5000, 7500);
        List<Integer> subArray4 = array.subList(7500, 10000);

        FindNumber helper1 = new FindNumber(subArray1);
        helper1.start();

        FindNumber helper2 = new FindNumber(subArray2);
        helper2.start();

        FindNumber helper3 = new FindNumber(subArray3);
        helper3.start();

        FindNumber helper4 = new FindNumber(subArray4);
        helper4.start();

    }
}
