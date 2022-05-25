package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class Brand extends CommonClass{
    private int id;
    private static int tempId = 0;
    private String name;
    private static List<String> names = new ArrayList<>();
    private static TreeSet<Brand> brands = new TreeSet<>(new ForBrandName());

    public Brand() {
    }

    public Brand(int id, String name) {
        this.id = id;
        this.name = name;
    }

    static {
        Brand.add("Samnsung");
        Brand.add("Lenovo");
        Brand.add("Apple");
        Brand.add("Huawei");
        Brand.add("Casper");
        Brand.add("Asus");
        Brand.add("HP");
        Brand.add("Xiaomi");
        Brand.add("Monster");
        Brand.sortByName();
    }
    public static void add(String name){
        names.add(name);
        brands.add(new Brand(tempId,names.get(tempId)));
        tempId++;
    }
    public static void sortByName(){
        for(Brand brand : brands){
            System.out.println(brand.getName());
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
