package com.codecool.seasonalproductdiscounter.service.products;

import com.codecool.seasonalproductdiscounter.model.enums.Color;
import com.codecool.seasonalproductdiscounter.model.enums.Season;
import com.codecool.seasonalproductdiscounter.model.products.Product;

import java.util.List;

public class ProductProviderImpl implements ProductProvider {
    private final List<Product> products;

    public ProductProviderImpl() {
        products = List.of(
                new Product("Yellow skirt", Color.YELLOW, Season.SPRING, 15.00),
                new Product("Blue skirt", Color.BLUE, Season.SPRING, 15.00),
                new Product("Red T-Shirt", Color.RED, Season.SUMMER, 10.00),
                new Product("Brown T-Shirt", Color.BROWN, Season.SUMMER, 10.00),
                new Product("Brown jacket", Color.BROWN, Season.AUTUMN, 40.00),
                new Product("Violet shirt", Color.VIOLET, Season.AUTUMN, 30.00),
                new Product("Blue jacket", Color.BLUE, Season.AUTUMN, 40.00),
                new Product("Blue hat", Color.BLUE, Season.WINTER, 10.00),
                new Product("Pink hat", Color.PINK, Season.WINTER, 10.00),
                new Product("Red gloves", Color.RED, Season.WINTER, 8.00),
                new Product("Yellow gloves", Color.YELLOW, Season.WINTER, 8.00)
        );
    }

    public List<Product> getProducts() {
        return products;
    }
}

