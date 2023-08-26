package com.store.implementations;

import com.store.models.Cashier;
import com.store.models.Manager;
import com.store.services.ManagerServices;

import java.util.ArrayList;
import java.util.List;

public class ManagerImp implements ManagerServices {
    private static List<Cashier> cashierList = new ArrayList<>();
    private Manager manager;
    public ManagerImp(Manager manager) {
        this.manager = manager;
    }

    public ManagerImp(){

    }

    @Override
    public boolean hire(Cashier cashier) {
        if (!cashier.isHired()) {
            cashier.setHired(true);
            cashierList.add(cashier);
            System.out.println("Welcome to Roban Store Miss "+cashier.getFirstName()+
                    ". \nMy name is "+manager.getFirstName()+" i am the manager.");
            System.out.println();
            return true;
        }
        else {
            System.out.println("This cashier is already hired");
            System.out.println();
            return false;
        }
    }

    @Override
    public boolean fire(Cashier cashier) {
        if(cashierList.contains(cashier)){
            cashier.setHired(false);
            cashierList.remove(cashier);
            System.out.println(cashier.getFirstName()+" has been fired.");
            System.out.println();
            return true;
        }
        else {
            System.out.println("Cashier already fired.");
            System.out.println();
            return false;
        }
    }
    public List<Cashier> getCashierList() {
        return cashierList;
    }
}
