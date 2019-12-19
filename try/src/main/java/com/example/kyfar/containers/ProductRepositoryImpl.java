package com.example.kyfar.containers;

import com.example.kyfar.entity.Product;
import com.example.kyfar.entity.User;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl {
    private static final int BASIC_SIZE = 0;
    private static final int BEGIN_VALUE = 0;
    private static final int OFFSET = 1;
    private static final int DEFAULT_INDEX = -1;
    private static final int DEFAULT_SUM = 0;
    private static final int WRONG_VALUE = -1;


    private Product[] productList;
    private int size;
    private static int id = 0;

    public ProductRepositoryImpl() {
        this.productList = new Product[BASIC_SIZE];
        this.size = BASIC_SIZE;
    }


    public ProductRepositoryImpl(Product[] list) {
        this.productList = list;
        this.size = list.length;
    }

    //    first method

    public int indexOf(Product product) {
        if (product != null) {
            int indexElement = DEFAULT_INDEX;
            for (int i = 0; i < size; i++) {
                if (this.productList[i] == product) {
                    indexElement = i;
                }
            }
            return indexElement;
        }
        return DEFAULT_INDEX;
    }

    //    second method
    public boolean add(Product product) {
        if (product != null) {
            Product[] newProductList = new Product[size + OFFSET];
            System.arraycopy(this.productList, BEGIN_VALUE, newProductList, BEGIN_VALUE, size);
            product.setId(ProductRepositoryImpl.id);
            id++;
            newProductList[size] = product;
            this.productList = newProductList;
            size = newProductList.length;
            return true;
        }
        return false;
    }

    public void addAll(Product... products) {
        for (Product product : products) {
            add(product);
        }
    }

    private void delete(int indexProduct) {
        Product[] newProductList = new Product[size - OFFSET];
        System.arraycopy(this.productList, BEGIN_VALUE, newProductList, BEGIN_VALUE, indexProduct);
        System.arraycopy(this.productList, indexProduct + OFFSET, newProductList, indexProduct,
                size - indexProduct - OFFSET);
        this.productList = newProductList;
        size = newProductList.length;
    }

    //    fifth method
    public boolean remove(Product product) {
        boolean result = false;
        if (product != null) {
            for (int i = 0; i < this.size(); i++) {
                if (product.equals(get(i))) {
                    delete(i);
                    result = true;
                }
            }
        }
        return result;
    }


    public void removeAll(Product... products) {
        for (Product product : products) {
            remove(product);
        }
    }

    public Product get(int index) {
        if (0 <= index && index < this.size()) {
            return productList[index];
        }
        return null;
    }

    public int size() {
        return size;
    }

    //    third method
    public double getAllPrice(Product[] products) {
        double sum = WRONG_VALUE;
        if (products != null) {
            sum = DEFAULT_SUM;
            for (Product product : products) {
                if (product != null) sum += Double.parseDouble(product.getPrice());
            }
        }
        return sum;
    }

    public boolean replace(Product product, Product newProduct) {
        boolean result = false;
        if (product != null && indexOf(product) != -1) {
            productList[indexOf(product)] = newProduct;
            result = true;
        }
        return result;
    }

    private static boolean isCorrect(double[] arr) {
        return arr != null;
    }

    public List<Product> findByTitle(String title) {
        if (title != null) {
            List<Product> findTitle = new ArrayList<>();
            for (Product i : productList) {
                if (i.getTitle().equals(title)) {
                    findTitle.add(i);
                }
            }
            return findTitle;
        }
        return new ArrayList<>();
    }

    public List<Product> findByOwner(User user) {
        if (user != null) {
            List<Product> findOwner = new ArrayList<>();
            for (Product i : productList) {
                if (i.getOwner() == user) {
                    findOwner.add(i);
                }
            }
            return findOwner;
        }
        return new ArrayList<>();
    }

    public Product findById(Product product) {
        if (product != null) {
            for (int i = 0; i < productList.length; i++) {
                if (productList[i].equals(product)) {
                    return productList[i];
                }
            }
            return null;
        }
        return null;
    }
}
