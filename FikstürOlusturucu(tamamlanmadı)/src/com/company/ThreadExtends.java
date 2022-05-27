package com.company;

public class ThreadExtends extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());

        for (int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName() + "-> " + i);
        }

    }
}
