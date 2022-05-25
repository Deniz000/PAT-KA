package com.company;

public class ListOf {
    private Brand brand;
    private Product product;

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void listOfBrand(){
        Brand.sortByName();
    }
}
