package com.VendingMachine;

import org.junit.Assert;
import org.junit.Test;

public class ProductUnitTest {

    @Test
    public void increaseTest() {

        Product product = new Product("Coke", 1, 25);

        int initialAmount = product.getCount();
        product.increaseAmount();

        int expectedAmount = product.getCount();
        int actualAmount = initialAmount+1;

        Assert.assertEquals(expectedAmount,actualAmount);
    }
}
