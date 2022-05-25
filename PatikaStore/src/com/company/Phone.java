package com.company;

import java.util.ArrayList;
import java.util.List;

public class Phone extends Product{
    private String batteryPower;
    private String color;
    private String camera;
    private static List<Phone> phones = new ArrayList<>();


    public Phone(int id, String nameOtProduct, int price, String brand, String memory, String ram, String screenSize, String camera, String batteryPower, String color) {
        super(id, nameOtProduct, price, brand, memory, ram, screenSize);
        this.camera = camera;
        this.batteryPower = batteryPower;
        this.color = color;
    }


    public static void add(){
        phones.add(new Phone(1, "SAMSUNG GALAXY A51   ", 3199, "Samsung", "128", "6", "6.5", "32", "4000.0", "siyah"));
        phones.add(new Phone(2, "iPhone 11 64 GB      ", 7379, "Apple", "64", "6", "6.1", "5", "3046", "Mavi"));
        phones.add(new Phone(3, "Redmi Note 10 Pro 8GB", 4012, "Xiaomi", "128", "6", "6.5", "35", "4000.0", "Beyaz"));
        }

        public static void print(){
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("| ID | Ürün Adı                      | Fiyat     | Marka     | Depolama  | Ekran     | Kamera    | Pil       | RAM       | Renk      | ");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        for(Phone phone : phones){
            System.out.println("| " + phone.getId()+" | " + phone.getNameOtProduct() +"\t\t\t" + " | " + phone.getPrice() + "\t\t" + " | " + phone.getBrand() + "\t\t"+ " | "  + phone.getMemory() + "\t\t" + " | "  +
                    phone.getScreenSize() + "\t\t" + " | " + phone.getCamera() + "\t\t" + " | " + phone.getBatteryPower() + "\t\t" + " | " + phone.getRam() + "\t\t" + " | " + phone.getColor());
        }
        }


    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(String batteryPower) {
        this.batteryPower = batteryPower;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
