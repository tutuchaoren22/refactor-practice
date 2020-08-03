package com.twu.refactoring;

public class NumberCruncher {
    private final int[] numbers;

    public NumberCruncher(int... numbers) {
        this.numbers = numbers;
    }

    public int countEven() {
        return countOfGivenModDividByTwo(0);
    }

    public int countOdd() {
        return countOfGivenModDividByTwo(1);
    }

    public int countPositive() {
        return countOfPositiveAndNegative()[0];
    }

    public int countNegative() {
        return countOfPositiveAndNegative()[1];
    }
    public int countOfGivenModDividByTwo(int mod){
        int count = 0;
        for (int number : numbers) {
            if (number % 2 == mod){
                count++;
            }
        }
        return count;
    }

    public int[] countOfPositiveAndNegative(){
        int[] countOfPositiveAndNegative=new int[2];
        for (int number : numbers) {
            if (number < 0) {
                countOfPositiveAndNegative[1]++;
            } else{
                countOfPositiveAndNegative[0]++;
            }
        }
        return countOfPositiveAndNegative;
    }
}
