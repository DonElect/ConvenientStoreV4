package com.store.implementations;

import com.store.models.ProductDetails;

import java.util.HashMap;
import java.util.Map;

public class Customer {
    public Customer(){

    }
    private Map<String, ProductDetails> cart = new HashMap<>();

    public Map<String, ProductDetails> getCart() {
        return cart;
    }

    public String addToCart(String item, int quantity) {
        item = item.toLowerCase();
        String result = productCheck(item);
        Map<String, ProductDetails> products = (result.equalsIgnoreCase("vegetables"))? new Products().getVegetables():
                (result.equalsIgnoreCase("provisions"))? new Products().getProvisions():
                        (result.equalsIgnoreCase("fruits"))? new Products().getFruits():
                                (result.equalsIgnoreCase("tools"))? new Products().getFruits(): null;
        if(products != null) {
            if(adjustQuantity(result, item, quantity)) {
                if (cart.containsKey(item)) {
                    int currentQuantity = cart.get(item).getQuantity() + quantity;
                    cart.get(item).setQuantity(currentQuantity);
                } else {
                    ProductDetails newProducts = new ProductDetails();
                    newProducts.setNameOfProduct(item);
                    newProducts.setCAT(products.get(item).getCAT());
                    newProducts.setPrice(products.get(item).getPrice());
                    newProducts.setQuantity(quantity);
                    cart.put(item, newProducts);
                }
                return "done";
            }
            else {
                System.out.println("OUT OF STOCK");
                return "out-of-stock";
            }
        }
        else
            System.out.println("We dont have "+item.toUpperCase()+" in our store for now.");
        return "not-in-store";
    }

    public String removeFromCart(String item, int quantity) {
        item = item.toLowerCase();
        if(cart.containsKey(item)){
            if(cart.get(item).getQuantity()-quantity >= 0) {
                cart.get(item).setQuantity(cart.get(item).getQuantity()-quantity);
                System.out.println(quantity + " " + item + " removed to your cart!");
                System.out.println();
            }else{
                cart.remove(item);
            }
            return "done";
        }
        else {
            System.out.println("You dont have " + item.toUpperCase() + " in our cart.");
            return "not-in-cart";
        }
    }


    public boolean buy(){
        int sum = 0;
        System.out.println("You about to pay for the following items in your list");
        System.out.println("********************************************");
        System.out.println("Products                  Price(₦\u200E)              Quantity");
        for(Map.Entry<String, ProductDetails> item : cart.entrySet()){
            System.out.println(item.getKey()+"         :             "+item.getValue().getPrice()+"        :        "+item.getValue().getQuantity());
            sum += item.getValue().getPrice() * item.getValue().getQuantity();
        }
        System.out.println("Total price: "+sum);
        System.out.println("Go over the counter and make payment. Cash or card payment is acceptable");
        System.out.println();
        return true;
    }

    private String productCheck(String productName){
        return new Products().getProvisions().containsKey(productName)? "provisions":
                new Products().getVegetables().containsKey(productName)? "vegetables":
                        new Products().getFruits().containsKey(productName)? "fruits":
                                new Products().getTools().containsKey(productName)? "tools":"";
    }

    private boolean adjustQuantity(String result, String item, int quantity){
        if(result.equalsIgnoreCase("fruits")) {
            if((new Products().getFruits().get(item).getQuantity() - quantity) >= 0) {
                new Products().getFruits().get(item).setQuantity(new Products().getFruits().get(item).getQuantity() - quantity);
                return true;
            }
            else{
                System.out.println(item.toUpperCase()+"s remaining "+ new Products().getFruits().get(item).getQuantity());
                return false;
            }
        }
        else if(result.equalsIgnoreCase("provisions")){
            if((new Products().getProvisions().get(item).getQuantity() - quantity) >= 0) {
                new Products().getProvisions().get(item).setQuantity(new Products().getProvisions().get(item).getQuantity() - quantity);
                return true;
            }
            else {
                System.out.println(item.toUpperCase()+"s remaining "+ new Products().getProvisions().get(item).getQuantity());
                return false;
            }
        }
        else if(result.equalsIgnoreCase("tools")){
            if((new Products().getTools().get(item).getQuantity() - quantity) >= 0) {
                new Products().getTools().get(item).setQuantity(new Products().getTools().get(item).getQuantity() - quantity);
                return true;
            }
            else {
                System.out.println(item.toUpperCase()+"s remaining "+ new Products().getTools().get(item).getQuantity());
                return false;
            }
        }
        else if(result.equalsIgnoreCase("vegetables")){
            if((new Products().getVegetables().get(item).getQuantity() - quantity) >= 0) {
                new Products().getVegetables().get(item).setQuantity(new Products().getVegetables().get(item).getQuantity() - quantity);
                return true;
            }
            else {
                System.out.println(item.toUpperCase()+"s remaining "+ new Products().getVegetables().get(item).getQuantity());
                return false;
            }
        }
        else return false;
    }
}
