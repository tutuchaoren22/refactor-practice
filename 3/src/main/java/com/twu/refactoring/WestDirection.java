package com.twu.refactoring;

public class WestDirection extends Direction {

    public WestDirection() {
        super('W');
    }

    @Override
    public Direction turnLeft() {
        return new SouthDirection();
    }

    @Override
    public Direction turnRight() {
        return new NorthDirection();
    }
}