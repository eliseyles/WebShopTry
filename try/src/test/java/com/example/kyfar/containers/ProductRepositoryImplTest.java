package com.example.kyfar.containers;

import com.example.kyfar.entity.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProductRepositoryImplTest {
    private Product product;
    private ProductRepositoryImpl productRepositoryImpl;

    @Test
    public void indexOfCheckNullThenReturnMinusOne() {
        ProductRepositoryImpl productRepositoryImpl = new ProductRepositoryImpl();
        int actual = productRepositoryImpl.indexOf(null);
        int expected = -1;
        assertEquals(actual, expected);
    }

    @Test
    public void indexOfCheckSearchInEmptyProductListThenReturnMinusOne() {
        ProductRepositoryImpl productRepositoryImpl = new ProductRepositoryImpl(new Product[]{});
        int actual = productRepositoryImpl.indexOf(new Product("10.00"));
        int expected = -1;
        assertEquals(actual, expected);
    }

    @Test
    public void indexOfCheckSearchInListWithoutSeachingObjectExpectedMinusOne() {
        ProductRepositoryImpl productRepositoryImpl = new ProductRepositoryImpl(new Product[]{new Product("4.00"), new Product("5.00")});
        int actual = productRepositoryImpl.indexOf(new Product("10.00"));
        int expected = -1;
        assertEquals(actual, expected);
    }
     
    @Test
    public void indexOfCheckSearchInListWithSeachingObjectExpectedPosition() {
        Product product = new Product("10.00");
        ProductRepositoryImpl productRepositoryImpl = new ProductRepositoryImpl(new Product[]{new Product("4.00"), new Product("5.00"), product});
        int actual = productRepositoryImpl.indexOf(product);
        int expected = 2;
        assertEquals(actual, expected);
    }
     
    @Test
    public void addCheckNullObjectExpectFalse() {
        ProductRepositoryImpl productRepositoryImpl = new ProductRepositoryImpl();
        boolean actual = productRepositoryImpl.add(null);
        boolean expected = false;
        assertEquals(actual, expected);
    }
     
    @Test
    public void addCheckNormalObjectExpectTrue() {
        ProductRepositoryImpl productRepositoryImpl = new ProductRepositoryImpl();
        boolean actual = productRepositoryImpl.add(new Product("10.00"));
        boolean expected = true;
        assertEquals(actual, expected);
    }
     
    @Test
    public void getAllPriceNullListExpectMinusOne() {
        ProductRepositoryImpl productRepositoryImpl = new ProductRepositoryImpl();
        double actual = productRepositoryImpl.getAllPrice(null);
        double expected = -1;
        assertEquals(actual, expected, 0.0001);
    }
     
    @Test
    public void getAllPriceEmptyProductListExpectZero() {
        ProductRepositoryImpl productRepositoryImpl = new ProductRepositoryImpl();
        double actual = productRepositoryImpl.getAllPrice(new Product[]{});
        double expected = 0;
        assertEquals(actual, expected, 0.0001);
    }
     
    @Test
    public void getAllPriceNullProductInListExpectZero() {
        ProductRepositoryImpl productRepositoryImpl = new ProductRepositoryImpl();
        double actual = productRepositoryImpl.getAllPrice(new Product[]{null});
        double expected = 0;
        assertEquals(actual, expected, 0.0001);
    }
     
    @Test
    public void getAllPriceNormalProductExpectTheirSum() {
        ProductRepositoryImpl productRepositoryImpl = new ProductRepositoryImpl();
        double actual = productRepositoryImpl.getAllPrice(new Product[]{new Product("4.00"), new Product("5.00"), new Product("10.00")});
        double expected = 19;
        assertEquals(actual, expected, 0.0001);
    }
    
     
    @Test
    public void removeNullProductExpectFalse() {
        ProductRepositoryImpl productRepositoryImpl = new ProductRepositoryImpl();

        boolean actual = productRepositoryImpl.remove(null);
        boolean expected = false;
        assertEquals(expected, actual);
    }
     
    @Test
    public void removeProductFromEmptyProductListExpectFalse() {
        ProductRepositoryImpl productRepositoryImpl = new ProductRepositoryImpl();
        Product product1 = new Product("5.00");
        Product product2 = new Product("2.00");

        boolean actual = productRepositoryImpl.remove(product1);
        boolean expected = false;
        assertEquals(expected, actual);
    }
     
    @Test
    public void removeNotContaintedProductExpectFalse() {
        Product product1 = new Product("5.00");
        Product product2 = new Product("2.00");
        ProductRepositoryImpl productRepositoryImpl = new ProductRepositoryImpl(new Product[]{product2});

        boolean actual = productRepositoryImpl.remove(product1);
        boolean expected = false;
        assertEquals(expected, actual);
    }
     
    @Test
    public void removeContaintedProductExpectTrue() {
        Product product1 = new Product("5.00");
        Product product2 = new Product("2.00");
        ProductRepositoryImpl productRepositoryImpl = new ProductRepositoryImpl(new Product[]{product2, product1});

        boolean actual = productRepositoryImpl.remove(product1);
        boolean expected = true;
        assertEquals(expected, actual);
    }
     
    @Test
    public void removeContaintedProduct10ExpectTrue() {
        Product product1 = new Product("10.00");
        Product product2 = new Product("2.00");
        ProductRepositoryImpl productRepositoryImpl = new ProductRepositoryImpl(new Product[]{product2, product1});

        boolean actual = productRepositoryImpl.remove(product1);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Before
    public void init() {
        product = new Product("12.00", "normal");
        productRepositoryImpl = new ProductRepositoryImpl(new Product[]{product});
    }

    @Test
    public void replaceContaintedProductExpectTrue() {
        Product expectProduct = new Product("12.00", "replaced");

        productRepositoryImpl.replace(product, new Product("12.00", "replaced"));

        assertEquals(expectProduct, productRepositoryImpl.get(0));
    }

    @Test
    public void replaceNotContaintedProductExpectTrue() {
        Product expectProduct = new Product("12.00", "normal");

        productRepositoryImpl.replace(new Product(), new Product("12.00", "replaced"));

        assertEquals(expectProduct, productRepositoryImpl.get(0));
    }

    @Test
    public void replaceNullProductExpectTrue() {
        Product expectProduct = new Product("12.00", "normal");

        productRepositoryImpl.replace(new Product(), new Product("12.00", "replaced"));

        assertEquals(expectProduct, productRepositoryImpl.get(0));
    }

    @Test
    public void findByTitleTestNullTitleExpectEmptyList() {
        List expected = new ArrayList();
        List actual = productRepositoryImpl.findByTitle(null);
        assertTrue(expected.equals(actual));
    }

    @Test
    public void findByTitleTestEmptyListExpectEmptyList() {
        productRepositoryImpl = new ProductRepositoryImpl();
        List expected = new ArrayList();
        List actual = productRepositoryImpl.findByTitle("");
        assertTrue(expected.equals(actual));
    }

    @Test
    public void findByTitleTestNotContainedProductTitleExpectEmptyList() {
        Product product1 = new Product("5.00", "lol");
        Product product2 = new Product("2.00", "kek");
        ProductRepositoryImpl productRepositoryImpl = new ProductRepositoryImpl(new Product[]{product2, product1});

        List actual = productRepositoryImpl.findByTitle("lolkek");
        List expected = new ArrayList();
        assertTrue(expected.equals(actual));
    }

    @Test
    public void findByTitleTestContainedProductTitleExpectNonEmptyList() {
        Product product1 = new Product("5.00", "lol");
        Product product2 = new Product("2.00", "kek");
        ProductRepositoryImpl productRepositoryImpl = new ProductRepositoryImpl(new Product[]{product2, product1});

        List actual = productRepositoryImpl.findByTitle("lol");
        List expected = new ArrayList();
        expected.add(product1);
        assertTrue(expected.equals(actual));
    }


    @Test
    public void findById() {
    }

    @Test
    public void findByIdTestNullTitleExpectNull() {
        Product expected = null;
        Product actual = productRepositoryImpl.findById(null);
        assertEquals(expected, actual);
    }

    @Test
    public void findByIdTestEmptyListExpectNull() {
        productRepositoryImpl = new ProductRepositoryImpl();
        Product expected = null;
        Product actual = productRepositoryImpl.findById(new Product());
        assertEquals(expected, actual);
    }

    @Test
    public void findByIdTestNotContainedProductExpectNull() {
        Product product1 = new Product("5.00", "lol");
        Product product2 = new Product("2.00", "kek");
        ProductRepositoryImpl productRepositoryImpl = new ProductRepositoryImpl(new Product[]{product2});

        Product expected = null;
        Product actual = productRepositoryImpl.findById(product1);
        assertEquals(expected, actual);
    }

    @Test
    public void findByIdTestContainedProductExpectedNormalProduct() {
        Product product1 = new Product("5.00", "lol");
        Product product2 = new Product("2.00", "kek");
        ProductRepositoryImpl productRepositoryImpl = new ProductRepositoryImpl(new Product[]{product2, product1});

        Product expected = product1;
        Product actual = productRepositoryImpl.findById(product1);
        assertEquals(expected, actual);
    }

    @After
    public void tearDown() throws Exception {
        product = null;
        productRepositoryImpl = null;
    }
}