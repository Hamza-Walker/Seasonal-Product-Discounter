package com.codecool.seasonalproductdiscounter.model.discounts;

import com.codecool.seasonalproductdiscounter.model.enums.Color;
import com.codecool.seasonalproductdiscounter.model.products.Product;

import java.time.LocalDate;

public record ColorDiscount(String name, int rate, Color color, LocalDate startMonth, LocalDate endMonth) implements Discount {
    @Override
    public boolean accepts(Product product, LocalDate date) {
        return product.color() == color
                && date.getMonthValue() >= startMonth.getMonthValue()
                && date.getMonthValue() <= endMonth.getMonthValue();
    }

    @Override
    public String toString() {
        return "ColorDiscount{" +
                "name='" + name + '\'' +
                ", rate=" + rate +
                ", color=" + color +
                ", startMonth=" + startMonth +
                ", endMonth=" + endMonth +
                '}';
    }
}
