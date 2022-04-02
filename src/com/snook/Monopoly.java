package com.snook;

import java.util.*;
import java.util.function.Predicate;

public class Monopoly {

    public static void main(String[] args) {
        Statistic statistic = new Statistic();

        int maxNumberOfGames = 5;
        for (int i = 0; i < maxNumberOfGames; i++){
            simulationGame(setProperties(), registerPlayers(), statistic);
        }
        System.out.println("Average number of rolls(turns): " + statistic.getAverageTurns() / statistic.getTotalGames());
        System.out.println("Average number of properties purchased in all games: " + statistic.getTotalPurchasedProperties() / statistic.getTotalGames());

        double percentageOfTotalIndianaAvenuePurchased = (statistic.getTotalIndianaAvenuePurchased() * 100) / statistic.getTotalGames();
        System.out.println("Percent of how many times Indiana Avenue was purchased in all games: " + percentageOfTotalIndianaAvenuePurchased + "%");
    }

    private static ArrayList<Player> registerPlayers() {
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("first player",  0, 1500, 0));
        players.add(new Player("second player", 0, 1000, 0));
        return players;
    }

    public static void simulationGame(Map<Integer, Property> properties, ArrayList<Player> players, Statistic statistic) {
        Dice dice = new Dice();
        boolean endGame;
        int actualPlayer = 1;

        statistic.addTotalGames();
        do {
            endGame = playTurn(players.get(actualPlayer - 1), dice, properties);
            actualPlayer = nextPlayer(actualPlayer);
        }
        while(!endGame);
        //Average of dice rolled per game
        statistic.addAverageTurns(sumDiceRolledPerGame(players) / players.size());
        statistic.addAverageProperties(countPropertiesPurchasedPerGame(properties));
        if (isIndianaAvenuePurchasedInGame(properties)) {
            statistic.addTotalIndianaAvenuePurchased();
        }
    }

    public static double sumDiceRolledPerGame(ArrayList<Player> players) {
        return players.stream().mapToDouble(Player::getDiceRolled).sum();
    }

    public static int countPropertiesPurchasedPerGame(Map<Integer, Property> properties) {
        return (int) properties.entrySet()
                .stream()
                .filter(property -> property.getValue().getType() == Property.PROPERTY)
                .filter(property -> !property.getValue().getOwner().isBlank())
                .count();
    }

    public static boolean isIndianaAvenuePurchasedInGame(Map<Integer, Property> properties) {
        Predicate<Map.Entry<Integer, Property>> indianaAvenue = property -> property.getValue().getName().equals("Indiana Avenue");
        Predicate<Map.Entry<Integer, Property>> owned = property -> !property.getValue().getOwner().isBlank();
        Predicate<Map.Entry<Integer, Property>> combinadeCondition = indianaAvenue.and(owned);
        return properties.entrySet()
                .stream()
                .anyMatch(combinadeCondition);
    }

    private static int nextPlayer(int actualPlayer) {
        if (actualPlayer == 1){
            actualPlayer = 2;
        } else {
            actualPlayer = 1;
        }
        return actualPlayer;
    }

    public static boolean playTurn(Player player, Dice dice, Map<Integer, Property> properties) {
        boolean endGame;
        int diceOne, diceTwo, sumDices;
        Property property;
        System.out.println("---------------------------------------");
        System.out.println("New turn of player: " + player.getName());
        System.out.println("Turn number: " + player.getDiceRolled());
        
        diceOne = dice.diceRoll();
        System.out.println("First dice: " + diceOne);

        diceTwo = dice.diceRoll();
        System.out.println("Second dice: " + diceTwo);

        sumDices = diceOne + diceTwo;

        //Increase dice rolled per turn.
        player.diceRolled();

        reachOrPassesGoPosition(player, sumDices);

        //Take last position in game.
        property = properties.get(player.getPosition());

        purchasePropertyOrPayPenalty(player, sumDices, property);

        endGame = verifiyMaxDiceRolledOrCashBalance(player);
        return endGame;
    }

    private static boolean verifiyMaxDiceRolledOrCashBalance(Player player) {
        return player.getDiceRolled() > 1000 || player.getBalance() <= 0;
    }

    private static void purchasePropertyOrPayPenalty(Player player, int sumDices, Property property) {
        if (property != null) {
            if (property.getType() == Property.PROPERTY) {
                if (player.getBalance() >= property.getCost() && property.getOwner().equals("")) {
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
    }

    private static void reachOrPassesGoPosition(Player player, int sumDices) {
        player.setPosition(player.getPosition() + sumDices);

        if (player.getPosition() > 39) {
            int calculatedPosition = player.getPosition() - 40;
            if (calculatedPosition == 0) {
                player.setPosition(1);
            } else {
                player.setPosition(calculatedPosition);
            }

            //Only for know with passed or landed on GO.
            if (player.getPosition() != 0) {
                System.out.println("You passed property GO. Collect $200");
            } else {
                System.out.println("You landed on property GO. Collect $200");
            }
            player.collectMoney(200);
        }
    }

    public static Map<Integer, Property> setProperties() {
        Map<Integer, Property> properties = new HashMap<>();

        properties.put(1,  new Property("Mediterranean Avenue",  "", Property.PROPERTY, 60));
        properties.put(2,  new Property("Community Chest",       "", Property.PENALTY,  0));
        properties.put(3,  new Property("Baltic Avenue",         "", Property.PROPERTY, 60));
        properties.put(4,  new Property("Income Tax",            "", Property.PENALTY,  200));
        properties.put(5,  new Property("Reading Railroad",      "", Property.PROPERTY, 200));
        properties.put(6,  new Property("Oriental Avenue",       "", Property.PROPERTY, 100));
        properties.put(7,  new Property("Chance",                "", Property.PROPERTY, 0));
        properties.put(8,  new Property("Vermont Avenue",        "", Property.PROPERTY, 100));
        properties.put(9,  new Property("Connecticut Avenue",    "", Property.PROPERTY, 120));
        properties.put(10, new Property("Jail Visit",            "", Property.PENALTY,  50));
        properties.put(11, new Property("St. Charles Place",     "", Property.PROPERTY, 140));
        properties.put(12, new Property("Electric Company",      "", Property.PROPERTY, 150));
        properties.put(13, new Property("States Avenue",         "", Property.PROPERTY, 140));
        properties.put(14, new Property("Virginia Avenue",       "", Property.PROPERTY, 160));
        properties.put(15, new Property("Pennsylvania Railroad", "", Property.PROPERTY, 200));
        properties.put(16, new Property("St. James Place",       "", Property.PROPERTY, 180));
        properties.put(17, new Property("Community Chest",       "", Property.PENALTY,  0));
        properties.put(18, new Property("Tennessee Avenue",      "", Property.PROPERTY, 180));
        properties.put(19, new Property("New York Avenue",       "", Property.PROPERTY, 200));
        properties.put(20, new Property("Free Parking",          "", Property.PENALTY,  0));
        properties.put(21, new Property("Kentucky Avenue",       "", Property.PROPERTY, 220));
        properties.put(22, new Property("Chance",                "", Property.PENALTY,  0));
        properties.put(23, new Property("Indiana Avenue",        "", Property.PROPERTY, 220));
        properties.put(24, new Property("Illinois Avenue",       "", Property.PROPERTY, 240));
        properties.put(25, new Property("B&O Railroad",          "", Property.PROPERTY, 200));
        properties.put(26, new Property("Atlantic Avenue",       "", Property.PROPERTY, 260));
        properties.put(27, new Property("Ventnor Avenue",        "", Property.PROPERTY, 260));
        properties.put(28, new Property("Water Works",           "", Property.PROPERTY, 150));
        properties.put(29, new Property("Marvin Gardens",        "", Property.PROPERTY, 280));
        properties.put(30, new Property("Police Bribe",          "", Property.PENALTY,  50));
        properties.put(31, new Property("Pacific Avenue",        "", Property.PROPERTY, 300));
        properties.put(32, new Property("North Carolina Avenue", "", Property.PROPERTY, 300));
        properties.put(33, new Property("Community Chest",       "", Property.PENALTY,  0));
        properties.put(34, new Property("Pennsylvania Avenue",   "", Property.PROPERTY, 320));
        properties.put(35, new Property("Short Line Railroad",   "", Property.PROPERTY, 200));
        properties.put(36, new Property("Chance",                "", Property.PENALTY,  0));
        properties.put(37, new Property("Park Place",            "", Property.PROPERTY, 350));
        properties.put(38, new Property("Luxury Tax",            "", Property.PENALTY,  0));
        properties.put(39, new Property("Boardwalk",             "", Property.PROPERTY, 400));
        properties.put(40, new Property("GO",                    "", Property.PENALTY,  0));

        return properties;
    }
}
