package com.snook;

public class Property {
    public static final int PROPERTY =  1;
    public static final int PENALTY =  2;

    private String name;
    private String owner;
    private int type;
    private int cost;

    public Property(String name, String owner, int type, int cost) {
        this.name = name;
        this.owner = owner;
        this.type = type;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getType() {
        return type;
    }

    public int getCost() {
        return cost;
    }

}
