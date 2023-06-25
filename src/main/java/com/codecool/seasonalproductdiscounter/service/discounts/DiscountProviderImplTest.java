package com.codecool.seasonalproductdiscounter.service.discounts;

import com.codecool.seasonalproductdiscounter.model.discounts.Discount;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DiscountProviderImplTest {

    @Test
    void testGetDiscounts() {
        DiscountProvider discountProvider = new com.codecool.seasonalproductdiscounter.service.DiscountProviderImpl();
        List<Discount> discounts = discountProvider.getDiscounts();

        assertEquals(8, discounts.size());

        // Check if all discounts are present
        assertTrue(discounts.stream().anyMatch(d -> d.name().equals("Summer Kick-off")));
        assertTrue(discounts.stream().anyMatch(d -> d.name().equals("Winter Sale")));
        assertTrue(discounts.stream().anyMatch(d -> d.name().equals("Blue Winter")));
        assertTrue(discounts.stream().anyMatch(d -> d.name().equals("Green Spring")));
        assertTrue(discounts.stream().anyMatch(d -> d.name().equals("Yellow Summer")));
        assertTrue(discounts.stream().anyMatch(d -> d.name().equals("Brown Autumn")));
        assertTrue(discounts.stream().anyMatch(d -> d.name().equals("Sale Discount")));
        assertTrue(discounts.stream().anyMatch(d -> d.name().equals("Outlet Discount")));

        // Test acceptance of discounts
        LocalDate currentDate = LocalDate.now();

        // Summer Kick-off discount should be accepted in June and July
        assertTrue(discounts.stream().anyMatch(d -> d.name().equals("Summer Kick-off")
                && d.accepts(null, LocalDate.of(currentDate.getYear(), 6, 1))));
        assertTrue(discounts.stream().anyMatch(d -> d.name().equals("Summer Kick-off")
                && d.accepts(null, LocalDate.of(currentDate.getYear(), 7, 31))));
        // Winter Sale discount should be accepted in February
        assertTrue(discounts.stream().anyMatch(d -> d.name().equals("Winter Sale")
                && d.accepts(null, LocalDate.of(currentDate.getYear(), 2, 1))));
        assertTrue(discounts.stream().anyMatch(d -> d.name().equals("Winter Sale")
                && d.accepts(null, LocalDate.of(currentDate.getYear(), 2, 28))));
        // ... Add more acceptance tests for other discounts
    }
}
