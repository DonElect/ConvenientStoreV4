package com.store;

import com.store.implementations.CashierImp;
import com.store.implementations.Customer;
import com.store.implementations.ManagerImp;
import com.store.implementations.Products;
import com.store.models.Cashier;
import com.store.models.Manager;
import com.store.services.CashierServices;
import com.store.services.ManagerServices;


public class Store {

    public static void main(String[] args) {
        //Creating the manager and customer instances and hiring two new cashiers
        Manager manager = new Manager("Donatus", "Okpala", 29,
                "D55B78", "donatus.okpala@decagon.dev", "Decagon Institute, Ohen");
        ManagerServices managerImp = new ManagerImp(manager);

        Cashier cashier1 = new Cashier("Stella", "Louis",
                25, "D0001B2", "stellalouis@gmail.com", "Ikorrodu, Lagos", "Stand 1");
        Cashier cashier2 = new Cashier("Marry", "John",
                25, "D0002B2", "maryjohn@gmail.com", "Makurdi, Benue", "Stand 2");
        CashierServices cashierImp1 = new CashierImp(cashier1);
        CashierServices cashierImp2 = new CashierImp(cashier2);

        managerImp.hire(cashier1);
        managerImp.hire(cashier2);
        //manager.fire(cashier2);

        Customer customer1 = new Customer();
        Customer customer2 = new Customer();

        // Add items to store
        cashierImp1.addProduct();
        new Products().viewProducts(new Products().getFruits());
//        new Products().viewProducts(new Products().getVegetables());
//        new Products().viewProducts(new Products().getTools());
//        new Products().viewProducts(new Products().getProvisions());

        // Customer1 Buying items from store
        customer1.addToCart("Mango", 24);
        customer1.addToCart("Orange", 5);
        customer1.addToCart("Banana", 2);
        customer1.addToCart("miksi", 3);

//        //customer1.removeFromCart("Mango", 1);
//
        // Customer2 buying items
        customer2.addToCart("Mango", 22);
        customer2.addToCart("Orange", 15);
        customer2.addToCart("Banana", 20);

        customer1.buy();
        customer2.buy();

        cashierImp2.sell(customer1);
        cashierImp2.dispenseReceipt(customer1);

        cashierImp2.sell(customer2);
        cashierImp2.dispenseReceipt(customer2);
        new Products().viewProducts(new Products().getFruits());
    }
}
