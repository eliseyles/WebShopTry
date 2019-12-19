package com.example.kyfar.entity;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTest {

    private Product product;

    @Before
    public void init() {
        product = new Product("12.00", "normal");
    }

    @Test
    public void setTitleTestInvalidTitle1() {
        Product expectedProduct = new Product("12.00", "normal");
        product.setTitle("1");
        Assert.assertEquals(expectedProduct, product);
    }

    @Test
    public void setTitleTestInvalidTitle() {
        Product expectedProduct = new Product("12.00", "normal");
        product.setTitle("123456789000123458909876khjghftdghfjslighkihgfsjdhgksjhgkjfhkghdfkjhg54321345678909876543");
        Assert.assertEquals(expectedProduct, product);
    }

    @Test
    public void setTitleTestValidTitle() {
        Product expectedProduct = new Product("12.00", "hello");
        product.setTitle("hello");
        Assert.assertEquals(expectedProduct, product);
    }

    @After
    public void tearDown() throws Exception {
        product = null;
    }


}