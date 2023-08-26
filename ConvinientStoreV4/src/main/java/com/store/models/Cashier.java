package com.store.models;

import java.util.Map;

public class Cashier extends Staff{
    private String cashierStand;
    private boolean isHired;
    public Cashier(String firstName, String lastName, int age, String employerID, String email, String address, String cashierStand) {
        super(firstName, lastName, age, employerID, email, address);
        this.cashierStand = cashierStand;
    }

    public Cashier() {
    }

    public boolean isHired() {
        return isHired;
    }

    public void setHired(boolean hired) {
        isHired = hired;
    }
}
