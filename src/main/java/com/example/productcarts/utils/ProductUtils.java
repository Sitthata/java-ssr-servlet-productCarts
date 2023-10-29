package com.example.productcarts.utils;

import com.example.productcarts.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductUtils {
    public static List<Product> getSampleProducts() {
        List<Product> productList = new ArrayList<>();

        productList.add(new Product("1", "Laptop", 800.00));
        productList.add(new Product("2", "Phone", 400.00));
        productList.add(new Product("3", "TV", 1000.00));

        return productList;
    }
}
