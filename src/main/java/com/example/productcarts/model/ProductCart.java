package com.example.productcarts.model;

import com.example.productcarts.utils.ProductUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ProductCart {
    public List<Product> productCart;

    public ProductCart() {
        this.productCart = ProductUtils.getSampleProducts();
    }

    public Product findById(String id) {
        return productCart.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public boolean removeById(String id) {
        Product productToRemove = productCart.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (productToRemove == null) return false;
        productCart.remove(productToRemove);
        return true;
    }
}
