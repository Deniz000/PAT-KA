package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.jar.JarOutputStream;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<Integer> liste = new ArrayList<>();
        for (int i = 0; i<10000;i++){
            liste.add(i);
        }
        System.out.println(liste);

        List<Integer> liste1 = liste.subList(0,2500);
        List<Integer> liste2 = liste.subList(2500,5000);
        List<Integer> liste3 = liste.subList(5000,7500);
        List<Integer> liste4 = liste.subList(7500,10000);

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        FindNumber findNumber1 = new FindNumber(liste1);


        for (int i = 0; i <4; i++){
            executorService.execute(findNumber1);
        }
    }
}
