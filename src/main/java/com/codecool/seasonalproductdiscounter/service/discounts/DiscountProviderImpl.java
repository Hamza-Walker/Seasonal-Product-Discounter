package com.codecool.seasonalproductdiscounter.service;

import com.codecool.seasonalproductdiscounter.model.discounts.*;
import com.codecool.seasonalproductdiscounter.model.enums.Color;
import com.codecool.seasonalproductdiscounter.model.enums.Season;
import com.codecool.seasonalproductdiscounter.service.discounts.DiscountProvider;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class DiscountProviderImpl implements DiscountProvider {
    private final List<Discount> discounts;

    public DiscountProviderImpl() {
        this.discounts = createDiscounts();
    }

    @Override
    public List<Discount> getDiscounts() {
        return discounts;
    }

    private List<Discount> createDiscounts() {
        List<Discount> discountList = new ArrayList<>();

        // Monthly Discounts
        MonthlyDiscount summerKickoffDiscount = new MonthlyDiscount("Summer Kick-off", 10,
                LocalDate.of(LocalDate.now().getYear(), 6, 1), LocalDate.of(LocalDate.now().getYear(), 7, 31));
        MonthlyDiscount winterSaleDiscount = new MonthlyDiscount("Winter Sale", 10,
                LocalDate.of(LocalDate.now().getYear(), 2, 1), LocalDate.of(LocalDate.now().getYear(), 2, 28));

        // Color Discounts
        int currentYear = LocalDate.now().getYear();
        LocalDate endDate = LocalDate.of(currentYear, 2, Month.FEBRUARY.length(Year.isLeap(currentYear)));
        ColorDiscount blueWinterDiscount = new ColorDiscount("Blue Winter", 5, Color.BLUE,
                LocalDate.of(currentYear, 12, 1), endDate);
        ColorDiscount greenSpringDiscount = new ColorDiscount("Green Spring", 5, Color.GREEN,
                LocalDate.of(LocalDate.now().getYear(), 3, 1), LocalDate.of(LocalDate.now().getYear(), 5, 31));
        ColorDiscount yellowSummerDiscount = new ColorDiscount("Yellow Summer", 5, Color.YELLOW,
                LocalDate.of(LocalDate.now().getYear(), 6, 1), LocalDate.of(LocalDate.now().getYear(), 8, 31));
        ColorDiscount brownAutumnDiscount = new ColorDiscount("Brown Autumn", 5, Color.BROWN,
                LocalDate.of(LocalDate.now().getYear(), 9, 1), LocalDate.of(LocalDate.now().getYear(), 11, 30));

        // Seasonal Discounts
        SeasonalDiscount saleDiscount = new SeasonalDiscount("Sale Discount", 10, Season.WINTER.ordinal(), 0);
        SeasonalDiscount outletDiscount = new SeasonalDiscount("Outlet Discount", 20, Season.WINTER.ordinal(), 2);

        // Add discounts to the list
        discountList.add(summerKickoffDiscount);
        discountList.add(winterSaleDiscount);
        discountList.add(blueWinterDiscount);
        discountList.add(greenSpringDiscount);
        discountList.add(yellowSummerDiscount);
        discountList.add(brownAutumnDiscount);
        discountList.add(saleDiscount);
        discountList.add(outletDiscount);

        return discountList;
    }
}
