package com.codecool.seasonalproductdiscounter.ui;

import com.codecool.seasonalproductdiscounter.model.offers.Offer;
import com.codecool.seasonalproductdiscounter.model.products.Product;
import com.codecool.seasonalproductdiscounter.service.discounts.DiscountProvider;
import com.codecool.seasonalproductdiscounter.service.discounts.DiscountService;
import com.codecool.seasonalproductdiscounter.service.products.ProductProvider;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
            DiscountService discountService) {
        this.productProvider = productProvider;
        this.discountProvider = discountProvider;
        this.discountService = discountService;
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
        LocalDate date = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        while (date == null) {
            System.out.print("Enter a date (yyyy-MM-dd): ");
            String input = scanner.nextLine();

            try {
                date = LocalDate.parse(input, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter a valid date.");
            }
        }

        return date;
    }

    private void printCatalog() {
        System.out.println("Product Catalog:");
        productProvider.getProducts().forEach(System.out::println);
        System.out.println();
    }

    private void printPromotions() {
        System.out.println("Available Promotions:");
        discountProvider.getDiscounts().forEach(System.out::println);
        System.out.println();
    }

    private void printOffers(LocalDate date) {
        System.out.println("Offers for " + date + ":");
        List<Offer> offers = getOffers(date);

        if (offers.isEmpty()) {
            System.out.println("No offers available for the specified date.");
        } else {
            offers.forEach(System.out::println);
        }
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
