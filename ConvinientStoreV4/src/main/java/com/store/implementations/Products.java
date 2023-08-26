package com.store.implementations;

import com.store.models.ProductDetails;
import com.store.services.CATEGORY;
import com.store.services.ProductsManagement;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Products implements ProductsManagement {
    private ProductDetails product;

    private static Map<String, ProductDetails> provisions = new HashMap<>();
    private static Map<String, ProductDetails> vegetables = new HashMap<>();
    private static Map<String, ProductDetails> tools = new HashMap<>();
    private static Map<String, ProductDetails> fruits = new HashMap<>();


    public Products(ProductDetails product){
        this.product = product;
    }
    public Products(){

    }

    @Override
    public boolean addProductsToShelve() {
        File file = new File("./src/main/resources/products.csv");
        String line = "";

        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            while ((line = reader.readLine()) != null){
                String[] row = line.split(",");
                product = new ProductDetails();
                if(!row[0].equalsIgnoreCase("name")){
                    product.setNameOfProduct(row[0]);

                    if(row[1].equalsIgnoreCase("fruits")){
                        product.setCAT(CATEGORY.FRUITS);
                    }
                    else if(row[1].equalsIgnoreCase("vegetables")){
                        product.setCAT(CATEGORY.VEGETABLES);
                    }
                    else if(row[1].equalsIgnoreCase("tools")){
                        product.setCAT(CATEGORY.TOOLS);
                    }
                    else if(row[1].equalsIgnoreCase("provisions")){
                        product.setCAT(CATEGORY.PROVISIONS);
                    }

                    product.setPrice(Integer.parseInt(row[2]));
                    product.setQuantity(Integer.parseInt(row[3]));

                    if(product.getCAT() == CATEGORY.FRUITS){
                        fruits.put(product.getNameOfProduct(), product);
                    }
                    if(product.getCAT() == CATEGORY.VEGETABLES){
                        vegetables.put(product.getNameOfProduct(), product);
                    }
                    if(product.getCAT() == CATEGORY.PROVISIONS){
                        provisions.put(product.getNameOfProduct(), product);
                    }
                    if(product.getCAT() == CATEGORY.TOOLS){
                        tools.put(product.getNameOfProduct(), product);
                    }
                }
            }

            System.out.println("Done adding Products to Shelve");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void updateStock() {

    }

    public Map<String, ProductDetails> getProvisions() {
        return provisions;
    }

    public Map<String, ProductDetails> getVegetables() {
        return vegetables;
    }

    public Map<String, ProductDetails> getTools() {
        return tools;
    }

    public Map<String, ProductDetails> getFruits() {
        return fruits;
    }

    public void viewProducts(Map<String, ProductDetails> productMap){
        System.out.println("****************************************************************");
        System.out.println("Products                  Price(₦\u200E)              Quantity");
        for (Map.Entry<String, ProductDetails> items : productMap.entrySet()) {
            System.out.println(items.getKey() + "         :             " + items.getValue().getPrice() + "        :         " + items.getValue().getQuantity());
        }
    }
}
