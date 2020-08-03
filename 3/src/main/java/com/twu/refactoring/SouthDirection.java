package com.twu.refactoring;

public class SouthDirection extends Direction {
    public SouthDirection() {
        super('S');
    }

    @Override
    public Direction turnLeft() {
        return new EastDirection();
    }

    @Override
    public Direction turnRight() {
        return new WestDirection();
    }
}
