package com.company;

public class RunnableImplements implements Runnable{
    private String name;
    private boolean isRun = true;
    public RunnableImplements(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(this.getName() + " sayacı başladı.");
        while (isRun) {
            for (int i = 0; i < 10; i++) {
                System.out.println(this.getName() + " ->" + i);
            }
        }
    }

    public void dur(){
        System.out.println(this.getName() + " durduruldu");
        this.isRun = false;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
