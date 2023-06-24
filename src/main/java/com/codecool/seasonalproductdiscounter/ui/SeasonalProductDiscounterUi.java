package com.codecool.seasonalproductdiscounter.ui;

import com.codecool.seasonalproductdiscounter.model.offers.Offer;
import com.codecool.seasonalproductdiscounter.model.products.Product;
import com.codecool.seasonalproductdiscounter.service.discounts.DiscountProvider;
import com.codecool.seasonalproductdiscounter.service.discounts.DiscountService;
import com.codecool.seasonalproductdiscounter.service.products.ProductProvider;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SeasonalProductDiscounterUi {
    private final ProductProvider productProvider;
    private final DiscountProvider discountProvider;
    private final DiscountService discountService;
    private final Scanner scanner;

    public SeasonalProductDiscounterUi(
            ProductProvider productProvider,
            DiscountProvider discountProvider,
            DiscountService discounterService) {
        this.productProvider = productProvider;
        this.discountProvider = discountProvider;
        this.discountService = discounterService;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("Welcome to Seasonal Product Discounter!\n");

        printCatalog();
        printPromotions();

        System.out.println("Enter a date to see which products are discounted on that date:");
        LocalDate date = getDate();
        System.out.println();

        printOffers(date);
    }

    private LocalDate getDate() {
        return null;
    }

    private void printCatalog() {
    }

    private void printPromotions() {
    }

    private void printOffers(LocalDate date) {
    }

    private List<Offer> getOffers(LocalDate date) {
        List<Offer> discounted = new ArrayList<>();

        for (Product product : productProvider.getProducts()) {
            Offer offer = discountService.getOffer(product, date);
            if (!offer.discounts().isEmpty()) {
                discounted.add(offer);
            }
        }

        return discounted;
    }
}

