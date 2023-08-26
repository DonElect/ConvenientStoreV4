package com.store.models;

import com.store.services.CATEGORY;

public class ProductDetails {
    private String nameOfProduct;
    private CATEGORY CAT;
    private int price;
    private int quantity;

    public ProductDetails(String nameOfProduct, CATEGORY CAT, int price, int quantity) {
        this.nameOfProduct = nameOfProduct;
        this.CAT = CAT;
        this.price = price;
        this.quantity = quantity;
    }

    public ProductDetails(){

    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public CATEGORY getCAT() {
        return CAT;
    }

    public void setCAT(CATEGORY CAT) {
        this.CAT = CAT;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
