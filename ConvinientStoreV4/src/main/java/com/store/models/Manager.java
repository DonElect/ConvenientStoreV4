package com.store.models;

import com.store.implementations.CashierImp;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Staff{


    public Manager(String firstName, String lastName, int age, String employerID, String email, String address) {
        super(firstName, lastName, age, employerID, email, address);
    }

    public Manager(){

    }

}
