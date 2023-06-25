package com.codecool.seasonalproductdiscounter.model.discounts;

import com.codecool.seasonalproductdiscounter.model.enums.Color;
import com.codecool.seasonalproductdiscounter.model.enums.Season;
import com.codecool.seasonalproductdiscounter.model.products.Product;

import java.time.LocalDate;

public class DiscountTest {
    public static void main(String[] args) {
        // Create some test products
        Product product1 = new Product("Product 1", Color.BLUE, Season.WINTER, 100.0);
        Product product2 = new Product("Product 2", Color.GREEN, Season.SPRING, 200.0);
        Product product3 = new Product("Product 3", Color.YELLOW, Season.SUMMER, 300.0);
        Product product4 = new Product("Product 4", Color.BROWN, Season.AUTUMN, 400.0);

        // Test MonthlyDiscount
        MonthlyDiscount summerKickoffDiscount = new MonthlyDiscount("Summer Kick-off", 10,
                LocalDate.of(2023, 6, 1), LocalDate.of(2023, 7, 31));
        System.out.println("Monthly Discount - Summer Kick-off");
        System.out.println(summerKickoffDiscount);
        System.out.println("Accepts product1 in June: " + summerKickoffDiscount.accepts(product1, LocalDate.of(2023, 6, 15)));
        System.out.println("Accepts product2 in August: " + summerKickoffDiscount.accepts(product2, LocalDate.of(2023, 8, 15)));

        MonthlyDiscount winterSaleDiscount = new MonthlyDiscount("Winter Sale", 10,
                LocalDate.of(2023, 2, 1), LocalDate.of(2023, 2, 28));
        System.out.println("\nMonthly Discount - Winter Sale");
        System.out.println(winterSaleDiscount);
        System.out.println("Accepts product1 in February: " + winterSaleDiscount.accepts(product1, LocalDate.of(2023, 2, 15)));
        System.out.println("Accepts product2 in March: " + winterSaleDiscount.accepts(product2, LocalDate.of(2023, 3, 15)));

        // Test ColorDiscount
        ColorDiscount blueWinterDiscount = new ColorDiscount("Blue Winter", 5,
                Color.BLUE, LocalDate.of(2023, 12, 1), LocalDate.of(2024, 2, 29));
        System.out.println("\nColor Discount - Blue Winter");
        System.out.println(blueWinterDiscount);
        System.out.println("Accepts product1 in December: " + blueWinterDiscount.accepts(product1, LocalDate.of(2023, 12, 15)));
        System.out.println("Accepts product2 in January: " + blueWinterDiscount.accepts(product2, LocalDate.of(2023, 1, 15)));

        ColorDiscount greenSpringDiscount = new ColorDiscount("Green Spring", 5,
                Color.GREEN, LocalDate.of(2023, 3, 1), LocalDate.of(2023, 5, 31));
        System.out.println("\nColor Discount - Green Spring");
        System.out.println(greenSpringDiscount);
        System.out.println("Accepts product2 in March: " + greenSpringDiscount.accepts(product2, LocalDate.of(2023, 3, 15)));
        System.out.println("Accepts product3 in June: " + greenSpringDiscount.accepts(product3, LocalDate.of(2023, 6, 15)));

        // Test SeasonalDiscount
        SeasonalDiscount saleDiscount = new SeasonalDiscount("Sale Discount", 10, Season.SPRING.ordinal(), 0);
        System.out.println("\nSeasonal Discount - Sale Discount");
        System.out.println(saleDiscount);
        System.out.println("Accepts product2 in Spring: " + saleDiscount.accepts(product2, LocalDate.of(2023, 4, 15)));
        System.out.println("Accepts product3 in Winter: " + saleDiscount.accepts(product3, LocalDate.of(2023, 12, 15)));

        SeasonalDiscount outletDiscount = new SeasonalDiscount("Outlet Discount", 20, Season.WINTER.ordinal(), 2);
        System.out.println("\nSeasonal Discount - Outlet Discount");
        System.out.println(outletDiscount);
        System.out.println("Accepts product1 in Spring: " + outletDiscount.accepts(product1, LocalDate.of(2023, 4, 15)));
        System.out.println("Accepts product3 in Summer: " + outletDiscount.accepts(product3, LocalDate.of(2023, 8, 15)));
    }
}
