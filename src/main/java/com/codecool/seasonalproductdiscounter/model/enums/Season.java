package com.codecool.seasonalproductdiscounter.model.enums;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Set;

public enum Season {
    SPRING(Set.of(Month.MARCH, Month.APRIL, Month.MAY)),
    SUMMER(Set.of(Month.JUNE, Month.JULY, Month.AUGUST)),
    AUTUMN(Set.of(Month.SEPTEMBER, Month.OCTOBER, Month.NOVEMBER)),
    WINTER(Set.of(Month.DECEMBER, Month.JANUARY, Month.FEBRUARY));

    private final Set<Month> months;

    Season(Set<Month> months) {
        this.months = months;
    }

    public Set<Month> getMonths() {
        return months;
    }
    public boolean contains(Month month) {
        for (Season season: Season.values()){
            if(season.containsMonth(month)) {
                return true;
            }
        }
        return false;
    }
    private boolean containsMonth (Month month){
        return months.contains(month);
    }

    public Season shift(int shiftValue) {
        Season[] seasons = Season.values();
        int currentIndex = this.ordinal();
        int newIndex = (currentIndex + shiftValue) % seasons.length;
        return seasons[newIndex];
    }

}
