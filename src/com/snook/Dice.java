package com.snook;

import java.util.Random;

public class Dice {
    private int sides;
    private Random generate;

    public Dice() {
        sides = 6;
        generate = new Random();
    }

    public int getSides() {
        return sides;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }
}
