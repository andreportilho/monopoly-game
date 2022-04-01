package com.snook;

public class Player {

    private String name;
    private int position;
    private int money;
    private int games;
    private int rolled;

    public Player(String name, int space, int money, int games, int rolled) {
        this.name = name;
        this.position = space;
        this.money = money;
        this.games = games;
        this.rolled = rolled;
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

    public int getMoney() {
        return money;
    }

    public  void movePiece(int spaceMove) { position += spaceMove; }

    public int getGames() { return games;}

    public void setGames(int games) { this.games = games;}

    public void addMoney(int money) { this.money += money;}

    public void removeMoney(int money) { this.money -= money;}

    public void setMoney(int money) { this.money = money;}

    public int getRolled() {return rolled;}

    public void setRolled(int rolled) {this.rolled = rolled;}

    public void diceRolled() { rolled += 1;}
}
