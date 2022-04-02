package com.snook;

import java.util.Random;

public class Dice {
    private final Random generate;

    public Dice() {
        generate = new Random();
    }

    public int diceRoll() {
        return generate.nextInt(6) + 1;
    }
}
