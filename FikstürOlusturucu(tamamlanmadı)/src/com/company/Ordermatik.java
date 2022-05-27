package com.company;

public class Ordermatik implements Runnable{
    private int orderNo;
    private final Object LOCK = new Object();

    public Ordermatik() {
        this.orderNo = 0;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        increaseOrder();

        //synchronized (LOCK) {
        //    this.orderNo++;
        //    System.out.println(Thread.currentThread().getName() +
        //            " orden no " + this.orderNo);
        //}
    }
    public synchronized void increaseOrder(){
        this.orderNo++;
        System.out.println(Thread.currentThread().getName() +
                          " orden no " + this.orderNo);
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }
}
