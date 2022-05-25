package com.company;

public class Product extends CommonClass{
    private int id;
    private String nameOtProduct;
    private int price;
    private int discountRate;
    private int amountOfStock;
    private String brand;
    private String memory;
    private String ram;
    private String screenSize;


    static {
        System.out.println("Notebook Listesi!");
        Notebook.add();
        Notebook.print();
        System.out.println("\n");
        System.out.println("Cep Telefonu Listesi");
        Phone.add();
        Phone.print();
    }

    public Product() {
    }


    public Product(int id, String nameOtProduct, int price, String brand, String memory, String ram, String screenSize) {
        this.id = id;
        this.nameOtProduct = nameOtProduct;
        this.price = price;
        this.brand = brand;
        this.memory = memory;
        this.ram = ram;
        this.screenSize = screenSize;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOtProduct() {
        return nameOtProduct;
    }

    public void setNameOtProduct(String nameOtProduct) {
        this.nameOtProduct = nameOtProduct;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }

    public int getAmountOfStock() {
        return amountOfStock;
    }

    public void setAmountOfStock(int amountOfStock) {
        this.amountOfStock = amountOfStock;
    }

    public String getBrand(){
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }
}
