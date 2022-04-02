package com.snook;

public class Player {

    private String name;
    private int position;
    private int balance;
    private int diceRolled;

    public Player(String name, int space, int balance, int diceRolled) {
        this.name = name;
        this.position = space;
        this.balance = balance;
        this.diceRolled = diceRolled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {return position;}

    public void setPosition(int space) {
        this.position = space;
    }

    public int getBalance() {
        return balance;
    }

    public  void movePiece(int spaceMove) { position += spaceMove; }

    public void collectMoney(int money) { this.balance += money;}

    public void removeMoney(int money) { this.balance -= money;}

    public int getDiceRolled() {return diceRolled;}

    public void diceRolled() { diceRolled += 1;}
}
