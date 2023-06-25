package com.codecool.seasonalproductdiscounter;

import com.codecool.seasonalproductdiscounter.service.DiscountProviderImpl;
import com.codecool.seasonalproductdiscounter.service.discounts.DiscountProvider;
import com.codecool.seasonalproductdiscounter.service.discounts.DiscountService;
import com.codecool.seasonalproductdiscounter.service.discounts.DiscountServiceImpl;
import com.codecool.seasonalproductdiscounter.service.products.ProductProvider;
import com.codecool.seasonalproductdiscounter.service.products.ProductProviderImpl;
import com.codecool.seasonalproductdiscounter.ui.SeasonalProductDiscounterUi;

public class Application {

    public static void main(String[] args) {
        // Create the required components
        ProductProvider productProvider = new ProductProviderImpl();
        DiscountProvider discountProvider = new DiscountProviderImpl();
        DiscountService discountService = new DiscountServiceImpl(discountProvider);

        // Create an instance of SeasonalProductDiscounterUi
        SeasonalProductDiscounterUi ui = new SeasonalProductDiscounterUi(productProvider, discountProvider, discountService);

        // Call the run() method of SeasonalProductDiscounterUi
        ui.run();
    }
}
