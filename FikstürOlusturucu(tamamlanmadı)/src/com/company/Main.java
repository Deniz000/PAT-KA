package com.company;

import java.awt.image.ImageProducer;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws InterruptedException {

       // Ordermatik ordermatik = new Ordermatik();
       // Thread thread = new Thread(ordermatik);
        //thread.join();
      //  thread.start();

       // Thread thread1 = new Thread(ordermatik);
       // thread1.start();
       // thread1.join();
       // System.out.println(ordermatik.getOrderNo());

        //Ordermatik ordermatik1 = new Ordermatik();
       // List<Thread> istemler = new ArrayList<>();
       // for(int i = 0; i <100;i++){
       //     Thread t = new Thread(ordermatik1);
       //     istemler.add(t);
       //     t.start();
       // }


        List<Integer> a = new ArrayList<>();
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(6);

        List<Integer> b = new ArrayList<>();
         b = a;
        System.out.println(b );
       // ExecutorService pool = Executors.newFixedThreadPool(50);
       // for(int i = 0; i <100;i++){
       //     pool.execute(new Ordermatik());
       // }

      //  ThreadExtends threadExtends = new ThreadExtends();

    //    ThreadExtends threadExtends1 = new ThreadExtends();

     //   RunnableImplements anImplements = new RunnableImplements("ilk");
     //   RunnableImplements anImplements1 = new RunnableImplements("ikinci");
     //   Thread thread = new Thread(anImplements);
     //   Thread thread1 = new Thread(anImplements1);
     //   thread1.start();
     //   thread.start();
      //  try {
      //      Thread.sleep(1000);
      //  } catch (InterruptedException e) {
      //      e.printStackTrace();
      //  }
       // anImplements.dur();

    }
}
