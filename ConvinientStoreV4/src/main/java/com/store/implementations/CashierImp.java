package com.store.implementations;

import com.store.models.Cashier;
import com.store.models.ProductDetails;
import com.store.services.CashierServices;

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class CashierImp implements CashierServices {

    public Cashier cashier;

    public CashierImp(Cashier cashier){
        this.cashier = cashier;
    }

    public CashierImp(){

    }


    @Override
    public void sell(Customer customer) {
        if(cashier.isHired()) {
            if(!customer.getCart().isEmpty())
                System.out.println("The following item in your store are been bought.");
        }else System.out.println("You are no longer a staff here. And cannot sell");
    }

    @Override
    public boolean dispenseReceipt(Customer customer) {
        if(cashier.isHired()) {
            if(!customer.getCart().isEmpty()) {
                int sum = 0;
                System.out.println("****************************************************************");
                System.out.println("Purchase receipt");
                System.out.println("Products                  Price(₦\u200E)              Quantity");
                for (Map.Entry<String, ProductDetails> items : customer.getCart().entrySet()) {
                    System.out.println(items.getKey() + "         :             " + items.getValue().getPrice() + "        :         " + items.getValue().getQuantity());
                    sum += items.getValue().getPrice() * (items.getValue().getQuantity());
                }
                System.out.println("Total price: " + sum + "\nThank you for patronizing us, have a great day!");
                System.out.println();
                //If receipt was successfully dispensed
                return true;
            }else {
                System.out.println("Your Cart is Empty");
                System.out.println();
                return false;
            }
        }
        else {
            System.out.println("You are no longer a staff here. And so cannot dispense receipt");
            return false;
        }
    }

    @Override
    public boolean addProduct() {
        if(cashier.isHired()) {
            if (new Products().addProductsToShelve())
            // If products were successfully added
                return true;
            else {
                System.out.println("Products not successfully added.");
                return false;
            }
        }
        else {
            System.out.println("You are no longer a staff here. And so cannot add products to store");
            return false;
        }
    }

}
