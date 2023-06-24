package com.codecool.seasonalproductdiscounter.model.products;

import com.codecool.seasonalproductdiscounter.model.enums.Color;
import com.codecool.seasonalproductdiscounter.model.enums.Season;


public record Product(String name, Color color, Season season, double price) {

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", color=" + color +
                ", season=" + season +
                ", price=" + price +
                '}';
    }
}

