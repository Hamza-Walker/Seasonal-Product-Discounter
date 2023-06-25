package com.codecool.seasonalproductdiscounter.service.discounts;

import com.codecool.seasonalproductdiscounter.model.discounts.Discount;
import com.codecool.seasonalproductdiscounter.model.offers.Offer;
import com.codecool.seasonalproductdiscounter.model.products.Product;

import java.time.LocalDate;
import java.util.List;

public class DiscountServiceImpl implements DiscountService {

    private final DiscountProvider discountProvider;

    public DiscountServiceImpl(DiscountProvider discountProvider) {
        this.discountProvider = discountProvider;
    }

    @Override
    public Offer getOffer(Product product, LocalDate date) {
        List<Discount> applicableDiscounts = findApplicableDiscounts(product, date);
        double discountedPrice = calculateDiscountedPrice(product, applicableDiscounts);
        return new Offer(product, date, applicableDiscounts, discountedPrice);
    }


    private List<Discount> findApplicableDiscounts(Product product, LocalDate date) {
        List<Discount> discounts = discountProvider.getDiscounts();
        return discounts.stream()
                .filter(discount -> discount.accepts(product, date))
                .toList();
    }

    private double calculateDiscountedPrice(Product product, List<Discount> discounts) {
        double price = product.price();
        for (Discount discount : discounts) {
            double discountRate = discount.rate() / 100.0;
            double discountAmount = price * discountRate;
            price -= discountAmount;
        }
        return price;
    }

}
