package com.snook;

import java.util.*;

public class Monopoly {

    public static void main(String[] args) {
        int numberGames = 1000;

        for (int i = 0; i < numberGames; i++){
            simulationGame(setProperties(), registerPlayers());
        }
    }

    private static ArrayList<Player> registerPlayers() {
        ArrayList<Player> players;
        players = new ArrayList<>();
        Player playerOne = new Player("first player",  0, 1500, 0, 0);
        Player playerTwo = new Player("second player", 0, 1000, 0, 0);
        players.add(playerOne);
        players.add(playerTwo);
        return players;
    }

    public static void simulationGame(Map<Integer, Property> properties, ArrayList<Player> players) {
        Dice dice = new Dice();
        boolean endGame = false;
        int actualPlayer = 1;

        do {
            endGame = takeTurn(players.get(actualPlayer - 1), dice, properties);
            actualPlayer = nextPlayer(actualPlayer);
        }
        while(!endGame);
    }

    private static int nextPlayer(int actualPlayer) {
        if (actualPlayer == 1){
            actualPlayer = 2;
        } else {
            actualPlayer = 1;
        }
        return actualPlayer;
    }

    public static boolean takeTurn(Player player, Dice dice, Map<Integer, Property> properties) {
        boolean endGame = false;
        int diceOne, diceTwo, sumDices;

        System.out.print("+-------------------+\n" +
                         "|     NEXT TURN     |\n" +
                         "+-------------------+\n" +
                         player.getRolled()  +"\n" +
                         "_____________________\n");

        //TODO arrumar nome secondroll
        diceOne = dice.secondRoll();
        System.out.println("First dice: " + diceOne);

        diceTwo = dice.secondRoll();
        System.out.println("Second dice: " + diceTwo);

        sumDices = diceOne + diceTwo;

        player.diceRolled();

        player.setPosition(player.getPosition() + sumDices);

        Property property = null;
        if (player.getPosition() > 39) {
            int calculatedPosition = player.getPosition() - 40;
            if (calculatedPosition == 0) {
                player.setPosition(1);
            } else {
                player.setPosition(calculatedPosition);
            }

            if (player.getPosition() != 0) {
                System.out.println("You passed property GO. Collect $200");
            } else {
                System.out.println("You landed on property GO. Collect $200");
            }
            player.addMoney(200);
        }

        property = properties.get(player.getPosition());

        if (property != null) {
            if (property.getType() == Property.PROPERTY) {
                if (player.getMoney() >= property.getCost() && property.getOwner() == "") {
                    player.removeMoney(property.getCost());
                    property.setOwner(player.getName());
                    System.out.println("You bought the property");
                } else {
                    System.out.println("Dont have money or property has already owned");
                }
                player.movePiece(sumDices);
            } else if (property.getType() == Property.PENALTY) {
                player.removeMoney(property.getCost());
                player.movePiece(sumDices);
            }
        }

        if (player.getRolled() > 999 || player.getMoney() <= 0) {
            endGame = true;
        } else {
            endGame = false;
        }
        return endGame;
    }

    public static Map<Integer, Property> setProperties() {
        Map<Integer, Property> properties = new LinkedHashMap<>();

        properties.put(1,  new Property("Mediterranean Avenue",  "", Property.PROPERTY, 60, 1));
        properties.put(2,  new Property("Community Chest",       "", Property.PENALTY,  0,  2));
        properties.put(3,  new Property("Baltic Avenue",         "", Property.PROPERTY, 60, 3));
        properties.put(4,  new Property("Income Tax",            "", Property.PENALTY,  200,4));
        properties.put(5,  new Property("Reading Railroad",      "", Property.PROPERTY, 200,5));
        properties.put(6,  new Property("Oriental Avenue",       "", Property.PROPERTY, 100,6));
        properties.put(7,  new Property("Chance",                "", Property.PROPERTY, 0,  7));
        properties.put(8,  new Property("Vermont Avenue",        "", Property.PROPERTY, 100,8));
        properties.put(9,  new Property("Connecticut Avenue",    "", Property.PROPERTY, 120,9));
        properties.put(10, new Property("Jail Visit",            "", Property.PENALTY,  50, 10));
        properties.put(11, new Property("St. Charles Place",     "", Property.PROPERTY, 140,11));
        properties.put(12, new Property("Electric Company",      "", Property.PROPERTY, 150,12));
        properties.put(13, new Property("States Avenue",         "", Property.PROPERTY, 140,13));
        properties.put(14, new Property("Virginia Avenue",       "", Property.PROPERTY, 160,14));
        properties.put(15, new Property("Pennsylvania Railroad", "", Property.PROPERTY, 200,15));
        properties.put(16, new Property("St. James Place",       "", Property.PROPERTY, 180,16));
        properties.put(17, new Property("Community Chest",       "", Property.PENALTY,  0,  17));
        properties.put(18, new Property("Tennessee Avenue",      "", Property.PROPERTY, 180,18));
        properties.put(19, new Property("New York Avenue",       "", Property.PROPERTY, 200,19));
        properties.put(20, new Property("Free Parking",          "", Property.PENALTY,  0,  20));
        properties.put(21, new Property("Kentucky Avenue",       "", Property.PROPERTY, 220,21));
        properties.put(22, new Property("Chance",                "", Property.PENALTY,  0,  22));
        properties.put(23, new Property("Indiana Avenue",        "", Property.PROPERTY, 220,23));
        properties.put(24, new Property("Illinois Avenue",       "", Property.PROPERTY, 240,24));
        properties.put(25, new Property("B&O Railroad",          "", Property.PROPERTY, 200,25));
        properties.put(26, new Property("Atlantic Avenue",       "", Property.PROPERTY, 260,26));
        properties.put(27, new Property("Ventnor Avenue",        "", Property.PROPERTY, 260,27));
        properties.put(28, new Property("Water Works",           "", Property.PROPERTY, 150,28));
        properties.put(29, new Property("Marvin Gardens",        "", Property.PROPERTY, 280,29));
        properties.put(30, new Property("Police Bribe",          "", Property.PENALTY,  50, 30));
        properties.put(31, new Property("Pacific Avenue",        "", Property.PROPERTY, 300,31));
        properties.put(32, new Property("North Carolina Avenue", "", Property.PROPERTY, 300,32));
        properties.put(33, new Property("Community Chest",       "", Property.PENALTY,  0,  33));
        properties.put(34, new Property("Pennsylvania Avenue",   "", Property.PROPERTY, 320,34));
        properties.put(35, new Property("Short Line Railroad",   "", Property.PROPERTY, 200,35));
        properties.put(36, new Property("Chance",                "", Property.PENALTY,  0,  36));
        properties.put(37, new Property("Park Place",            "", Property.PROPERTY, 350,37));
        properties.put(38, new Property("Luxury Tax",            "", Property.PENALTY,  0,  38));
        properties.put(39, new Property("Boardwalk",             "", Property.PROPERTY, 400,39));
        properties.put(40, new Property("GO",                    "", Property.PENALTY,  0,  40));

        return properties;
    }
}
