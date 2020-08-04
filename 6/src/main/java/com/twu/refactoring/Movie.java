package com.twu.refactoring;

public  abstract  class Movie {

	private String title;

	public Movie(String title) {
		this.title = title;
	}
	abstract double getCharge(int daysRented);

	abstract int getFrequentRenterPoints(int daysRented);

	public String getTitle () {
		return title;
	}
}

