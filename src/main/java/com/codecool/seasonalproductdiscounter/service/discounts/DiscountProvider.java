package com.codecool.seasonalproductdiscounter.service.discounts;

import com.codecool.seasonalproductdiscounter.model.discounts.Discount;

import java.util.List;

public interface DiscountProvider {
    List<Discount> getDiscounts();
}
