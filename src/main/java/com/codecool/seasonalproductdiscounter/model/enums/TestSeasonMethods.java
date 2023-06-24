package com.codecool.seasonalproductdiscounter.model.enums;



import java.time.Month;

public class TestSeasonMethods {
        public static void main(String[] args) {
            Season currentSeason = Season.SUMMER;
            Season shiftedSeason = currentSeason.shift(1);
            System.out.println(shiftedSeason); // Output: Autumn

            Month january = Month.JANUARY;
            boolean isJanuaryInSeason = shiftedSeason.contains(january);
            System.out.println(isJanuaryInSeason); // Output: false
        }
}
