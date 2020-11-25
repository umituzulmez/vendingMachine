package com.VendingMachine;

import java.util.*;

public class VendingMachine {

    public Scanner scanner = new Scanner(System.in);
    public HashMap<String, Product> products;
    public HashMap<String, Product> purchasedProducts;
    public Integer totalPurchaseAmount = 0;
    public Integer availableBalance = 0;

    public VendingMachine() {
        initialize();
    }

    private void initialize() {

        Product Coke = new Product("Coke", 100, 25);
        Product Pepsi = new Product("Pepsi", 100, 35);
        Product Soda = new Product("Soda", 100, 45);

        products = new HashMap();
        products.put("Coke", Coke);
        products.put("Pepsi", Pepsi);
        products.put("Soda", Soda);
        purchasedProducts = new HashMap();
    }


    public void select(String productName) {

            Product product = products.get(productName);

        if (product.getCount() < 1) {
            System.out.println("Sorry product is out of stock");
            return;
        }

        int price = product.getPrice();

        if (price + totalPurchaseAmount > availableBalance) {
            System.out.println("Sorry Not available balance");
            return;
        }

        totalPurchaseAmount += price;
        availableBalance -= price;

        product.reduceCount(1);

        updatePurchasedProducts(productName);

        System.out.println(productName + " is to the basket");
    }

    private void updatePurchasedProducts(String productName) {

        if (purchasedProducts.containsKey(productName)) {

            Product product = purchasedProducts.get(productName);
            product.increaseAmount();
            purchasedProducts.put(productName, product);

        } else {

            int price = products.get(productName).getPrice();
            Product product = new Product(productName, 1, price);
            purchasedProducts.put(productName, product);
        }
    }

    public void purchase () {

        for (String productName : purchasedProducts.keySet()) {
            Product product = purchasedProducts.get(productName);
            System.out.println(product.getName() + " " + product.getCount() + " amount " + "product total price: " + product.getCount() * product.getPrice());
        }

        int amount = availableBalance;

        changeMoney(amount);

        System.out.println(amount + " is remained");
    }

    public void addAvailableBalance(int money) {

        availableBalance += money;
    }

    private void changeMoney ( int amount) {

        int[] moneys = {0, 0, 0, 0};
        String[] sMoneys = {"Quarter", "Dime", "Nickel", "Penny"};

        while (amount > 0) {
            if (amount >= 25) {
                amount -= 25;
                moneys[0] += 1;
            } else if (amount >= 10) {
                amount -= 10;
                moneys[1] += 1;
            } else if (amount >= 5) {
                amount -= 5;
                moneys[2] += 1;
            } else if (amount < 5) {
                amount -= 1;
                moneys[3] += 1;
            }
        }


        for (int i = 0; i < 4; i++) {
            if (moneys[i] > 0) {
                System.out.println(moneys[i] + " " + sMoneys[i]);
            }

        }

    }

    public void refund () {

        System.out.println("\n!!! Thank you !!!");
        System.out.println("--- Here Your Coins Back ---");

        changeMoney(availableBalance);

        initialize();
    }



}
