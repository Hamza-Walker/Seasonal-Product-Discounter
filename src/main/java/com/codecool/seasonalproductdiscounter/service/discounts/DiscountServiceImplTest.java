package com.codecool.seasonalproductdiscounter.service.discounts;

import com.codecool.seasonalproductdiscounter.model.discounts.ColorDiscount;
import com.codecool.seasonalproductdiscounter.model.discounts.Discount;
import com.codecool.seasonalproductdiscounter.model.discounts.MonthlyDiscount;
import com.codecool.seasonalproductdiscounter.model.discounts.SeasonalDiscount;
import com.codecool.seasonalproductdiscounter.model.offers.Offer;
import com.codecool.seasonalproductdiscounter.model.products.Product;
import com.codecool.seasonalproductdiscounter.model.enums.Color;
import com.codecool.seasonalproductdiscounter.model.enums.Season;
import com.codecool.seasonalproductdiscounter.service.discounts.DiscountProvider;
import com.codecool.seasonalproductdiscounter.service.discounts.DiscountService;
import com.codecool.seasonalproductdiscounter.service.discounts.DiscountServiceImpl;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class DiscountServiceImplTest {

    @Test
    void testGetOffer_WithApplicableDiscounts_ShouldReturnOfferWithDiscountedPrice() {
        // Arrange
        Product product = new Product("Shirt", Color.BLUE, Season.WINTER, 50.0);
        LocalDate date = LocalDate.of(2022, 12, 15);

        DiscountProvider discountProvider = createMockDiscountProvider();
        DiscountService discountService = new DiscountServiceImpl(discountProvider);

        // Act
        Offer offer = discountService.getOffer(product, date);

        // Log the offer details
        System.out.println("Offer: " + offer);

        // Assert
        // ...
    }

    @Test
    void testGetOffer_WithNoApplicableDiscounts_ShouldReturnOfferWithOriginalPrice() {
        // Arrange
        Product product = new Product("Shirt", Color.RED, Season.SUMMER, 30.0);
        LocalDate date = LocalDate.of(2022, 7, 10);

        DiscountProvider discountProvider = createMockDiscountProvider();
        DiscountService discountService = new DiscountServiceImpl(discountProvider);

        // Act
        Offer offer = discountService.getOffer(product, date);

        // Log the offer details
        System.out.println("Offer: " + offer);

        // Assert
        // ...
    }

    private DiscountProvider createMockDiscountProvider() {
        return new DiscountProvider() {
            @Override
            public List<Discount> getDiscounts() {
                return Arrays.asList(
                        new MonthlyDiscount("Summer Kick-off", 10, LocalDate.of(2022, 6, 1), LocalDate.of(2022, 7, 31)),
                        new ColorDiscount("Blue Winter", 5, Color.BLUE, LocalDate.of(2022, 12, 1), LocalDate.of(2023, 2, 28)),
                        new SeasonalDiscount("Sale Discount", 10, Season.WINTER.ordinal(), 0)
                );
            }
        };
    }
}
