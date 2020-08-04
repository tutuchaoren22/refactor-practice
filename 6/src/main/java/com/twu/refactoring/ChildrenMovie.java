package com.twu.refactoring;

public class ChildrenMovie extends Movie {
    public ChildrenMovie(String title) {
        super(title);
    }

    @Override
    double getCharge(int daysRented) {
        double charge= 1.5;
        if (daysRented > 3)
            charge += (daysRented - 3) * 1.5;
        return charge;
    }

    @Override
    int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
