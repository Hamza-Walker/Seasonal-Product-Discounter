package com.codecool.seasonalproductdiscounter.model.discounts;

import com.codecool.seasonalproductdiscounter.model.products.Product;

import java.time.LocalDate;

public interface Discount {
    boolean accepts(Product product, LocalDate date);

    String name();

    int rate();
}

