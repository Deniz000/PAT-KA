package com.company;

import java.util.ArrayList;
import java.util.List;

public class FindNumber implements Runnable{
    private List<Integer> odd = new ArrayList<>();
    private List<Integer> even = new ArrayList<>();
    private List<Integer> number = new ArrayList<>();
    private final Object LOCK = new Object();
    List<Integer> full = new ArrayList<>();

    public FindNumber() {
    }

    public FindNumber(List<Integer> number) {
        this.number = number;
    }

    @Override
    public void run() {

        synchronized (LOCK){
            for (int i = 0; i < 2500; i++) {
                if (number.get(i) % 2 == 0) {
                    even.add(number.get(i));
                } else {
                    odd.add(number.get(i));
                }
            }
        }
        full = odd;
        print();
    }
    public void print(){
        System.out.println(Thread.currentThread().getName() + " tek " + " -- " + odd);
        System.out.println(Thread.currentThread().getName() + " çift " + " -- " + even);
        System.out.println(Thread.currentThread().getName() + " full " + " -- " + full);
    }

    public List<Integer> getOdd() {
        return odd;
    }

    public void setOdd(List<Integer> odd) {
        this.odd = odd;
    }

    public List<Integer> getEven() {
        return even;
    }

    public void setEven(List<Integer> even) {
        this.even = even;
    }
}
