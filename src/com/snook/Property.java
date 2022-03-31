package com.snook;

public class Property {
    public static final int PROPERTY =  1;
    public static final int PENALTY =  2;

    private String name;
    private int owner;
    private int type;
    private int cost;
    private int space;

    public Property(String name, int owner, int type, int cost, int space) {
        this.name = name;
        this.owner = owner;
        this.type = type;
        this.cost = cost;
        this.space = space;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }
}
