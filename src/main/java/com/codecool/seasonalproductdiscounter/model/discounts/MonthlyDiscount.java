package com.codecool.seasonalproductdiscounter.model.discounts;

import com.codecool.seasonalproductdiscounter.model.products.Product;

import java.time.LocalDate;

public record MonthlyDiscount(String name, int rate, LocalDate startMonth, LocalDate endMonth) implements Discount {
    @Override
    public boolean accepts(Product product, LocalDate date) {
        return date.getMonthValue() >= startMonth.getMonthValue()
                && date.getMonthValue() <= endMonth.getMonthValue();
    }

    @Override
    public String toString() {
        return "MonthlyDiscount{" +
                "name='" + name + '\'' +
                ", rate=" + rate +
                ", startMonth=" + startMonth +
                ", endMonth=" + endMonth +
                '}';
    }
}
