package com.twu.refactoring;

public class RegularMovie extends  Movie {
    public RegularMovie(String title) {
        super(title);
    }

    @Override
    double getCharge(int daysRented) {
        double charge = 2;
        if (daysRented> 2)
            charge += (daysRented - 2) * 1.5;
        return charge;
    }

    @Override
    int getFrequentRenterPoints(int daysRented) {
        return 1;
    }

}
