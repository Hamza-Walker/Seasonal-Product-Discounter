package com.codecool.seasonalproductdiscounter.service.discounts;

import com.codecool.seasonalproductdiscounter.model.offers.Offer;
import com.codecool.seasonalproductdiscounter.model.products.Product;

import java.time.LocalDate;


public interface DiscountService {
    Offer getOffer(Product product, LocalDate date);

}

