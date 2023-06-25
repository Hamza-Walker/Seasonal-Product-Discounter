package com.codecool.seasonalproductdiscounter.model.discounts;

import com.codecool.seasonalproductdiscounter.model.products.Product;

import java.time.LocalDate;

public record SeasonalDiscount(String name, int rate, int favoredSeason, int discountOffset) implements Discount {
    @Override
    public boolean accepts(Product product, LocalDate date) {
        int productSeason = (product.season().ordinal() + discountOffset) % 4;
        return productSeason == favoredSeason;
    }

    @Override
    public String toString() {
        return "SeasonalDiscount{" +
                "name='" + name + '\'' +
                ", rate=" + rate +
                ", favoredSeason=" + favoredSeason +
                ", discountOffset=" + discountOffset +
                '}';
    }
}
