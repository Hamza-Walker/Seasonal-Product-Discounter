package com.codecool.seasonalproductdiscounter.service.products;

import com.codecool.seasonalproductdiscounter.model.products.Product;

import java.util.List;

public interface ProductProvider {
    List<Product> getProducts();
}

