package com.VendingMachine;

public class Product {

    String mName;
    int mCount;
    int mPrice;

    public Product(String name, int count, int price){
        this.mName = name;
        this.mCount = count;
        this.mPrice = price;
    }
    public String getName(){
        return mName;
    }

    public int getPrice(){
        return mPrice;
    }

    public int getCount(){
        return mCount;
    }

    public void reduceCount(int amount){
        mCount-=amount;
    }

    public void increaseAmount(){
        mCount+=1;
    }




}
