package com.store.services;

import com.store.implementations.Customer;

public interface CashierServices {
    void sell(Customer customer);
    boolean dispenseReceipt(Customer customer);
    boolean addProduct();
}
