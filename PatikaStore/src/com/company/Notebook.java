package com.company;

import java.util.ArrayList;
import java.util.List;

public class Notebook extends Product{
    private static List<Notebook> notebooks = new ArrayList<>();

    public Notebook(int id, String nameOtProduct, int price, String brand, String memory, String ram, String screenSize) {
        super(id, nameOtProduct, price, brand, memory, ram, screenSize);
    }

    public static void add(){
     notebooks.add(new Notebook(1,"HUAWEI Matebook 14",7000,"Huawei    ","512        ","14.0      ","16          "));
     notebooks.add(new Notebook(2,"LENOVO V14 IGL    ",3699,"Lenovo    ","1024       ","14.0      ","8          "));
     notebooks.add(new Notebook(3,"ASUS Tuf Gaming   ",8019,"Asus      ","2048       ","15.6      ","32          "));
    }
    public static void print(){
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------\n" +
                "| ID | Ürün Adı                      | Fiyat     | Marka     | Depolama  | Ekran     | Kamera    | Pil       | RAM       | Renk      | \n" +
                "--------------------------------------------------------------------------------------------------------------------------------------");
        for(Notebook notebook: notebooks){
            System.out.println("| " + notebook.getId()+" | " + notebook.getNameOtProduct() +"\t\t\t" + " | " + notebook.getPrice() + "\t\t" + " | " + notebook.getBrand() + "\t\t"+ " | "  + notebook.getMemory() + "\t\t" + " | "  +
                    notebook.getScreenSize() + "\t\t" + " | ");
        }
    }
}
