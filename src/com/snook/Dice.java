package com.snook;

import java.util.Random;

public class Dice {
    private Random generate;

    public Dice() {
        generate = new Random();
    }

    public int secondRoll() {
        return generate.nextInt(6) + 1;
    }
}
