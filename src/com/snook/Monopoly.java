package com.snook;

import java.util.ArrayList;
import java.util.Scanner;

public class Monopoly {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Dice dice = new Dice();
        ArrayList<Property> properties = new ArrayList<Property>();
        ArrayList<Player> players = new ArrayList<Player>();
        boolean endGame = false;
        int turn = 0;
        Player playerOne = new Player("first player");
        Player playerTwo = new Player("second player");
        players.add(playerOne);
        players.add(playerTwo);

        setPlayersName(players, input);
        setProperties(properties);

        do {
            input.nextLine();
            endGame = takeTurn(players.get(turn), dice, properties, input);
            input.nextLine();
            turn++;
            if(turn > players.size() - 1){
                turn = 0;
            }
        }
        while(!endGame);
    }

    public static boolean takeTurn(Player player, Dice dice, ArrayList<Property> properties, Scanner input) {
        boolean endGame = false;
        int diceOne, diceTwo, sumDices;

        System.out.print("+-------------------+\n" +
                         "|     NEXT TURN     |\n" +
                         "+-------------------+\n" +
                         player.getName()   + "\n" +
                         "_____________________\n" +
                player.getName() + "'s turn: What do you want to do?\n" +
                " 1 - Roll dice\n" +
                " 2 - End game\n>");

        switch (input.nextInt()) {
            case 1:
                diceOne = dice.secondRoll();
                System.out.println("First dice: " + diceOne);

                diceTwo = dice.secondRoll();
                System.out.println("Second dice: " + diceTwo);

                sumDices = diceOne + diceTwo;

                int move = player.getSpace() + sumDices;

                for (Property p : properties) {
                    if (move == p.getSpace() && p.getType() == 1 && p.getOwner() == "") {
                        System.out.print("+-------------------+\n" +
                                "|     DECISION      |\n" +
                                "+-------------------+\n" +
                                player.getName()   + "\n" +
                                "_____________________\n" +
                                player.getName() + "'s turn: What do you want to do?\n" +
                                " 1 - Buy\n" +
                                " 2 - End game\n>");

                        switch(input.nextInt()) {
                            case 1:
                                if (player.getMoney() >= 200) {
                                    p.setOwner(player.getName());
                                    System.out.println("You bought the property");
                                    player.movePiece(sumDices);
                                    break;
                                } else {
                                    System.out.println("Dont have the money, moving to next player");
                                    player.movePiece(sumDices);
                                    break;
                                }
                            case 2:
                                endGame = true;
                                break;
                        }
                        return endGame;
                    }
                }


                if (move > 39) {
                    player.setSpace(move - 40);
                    if (player.getSpace() != 0) {
                        System.out.println("You passed property GO. Collect $200");
                    } else {
                        System.out.println("You landed on property GO. Collect $200");
                    }
                    player.setMoney(200);
                }
                else {
                    player.movePiece(sumDices);
                }
                break;

            case 2:
                endGame = true;
                break;

            default:
                break;
        }


        return endGame;
    }

    public static void setPlayersName(ArrayList<Player> players, Scanner input){
        for (Player p : players) {
            System.out.println("Enter the name of the " + p.getName());
            p.setName(input.nextLine());
        }
    }

    public static void setProperties(ArrayList<Property> properties) {
        Property mediterraneanAvenue  = new Property("Mediterranean Avenue",  "", 1, 60, 1);

        Property balticAvenue         = new Property("Baltic Avenue",         "", 0, 60, 3);

        Property readingRailroad      = new Property("Reading Railroad",      "", 1, 200,5);
        Property orientalAvenue       = new Property("Oriental Avenue",       "", 1, 100,6);

        Property vermontAvenue        = new Property("Vermont Avenue",        "", 1, 100,7);
        Property ConnecticutAvenue    = new Property("Connecticut Avenue",    "", 1, 120,8);

        Property stCharlesPlace       = new Property("St. Charles Place",     "", 1, 140,10);
        Property electricCompany      = new Property("Electric Company",      "", 1, 150,11);
        Property statesAvenue         = new Property("States Avenue",         "", 1, 140,12);
        Property virginiaAvenue       = new Property("Virginia Avenue",       "", 1, 160,13);
        Property pennsylvaniaRailroad = new Property("Pennsylvania Railroad", "", 1, 200,14);
        Property stJamesPlace         = new Property("St. James Place",       "", 1, 180,15);

        Property tennesseeAvenue      = new Property("Tennessee Avenue",      "", 1, 180,17);
        Property newYorkAvenue        = new Property("New York Avenue",       "", 1, 200,18);

        Property kentuckyAvenue       = new Property("Kentucky Avenue",       "", 1, 220,20);

        Property indianaAvenue        = new Property("Indiana Avenue",        "", 1, 220,22);
        Property illinoisAve          = new Property("Illinois Avenue",       "", 1, 240,23);
        Property bORailroad           = new Property("B&O Railroad",          "", 1, 200,24);

        Property atlanticAvenue       = new Property("Atlantic Avenue",       "", 1, 260,26);
        Property ventnorAvenue        = new Property("Ventnor Avenue",        "", 1, 260,27);
        Property waterWorks           = new Property("Water Works",           "", 1, 150,28);
        Property marvinGardens        = new Property("Marvin Gardens",        "", 1, 280,29);

        Property pacificAvenue        = new Property("Pacific Avenue",        "", 1, 300,31);
        Property northCarolinaAvenue  = new Property("North Carolina Avenue", "", 1, 300,32);

        Property pennsylvaniaAvenue   = new Property("Pennsylvania Avenue",   "", 1, 320,34);
        Property shortLineRailroad    = new Property("Short Line Railroad",   "", 1, 200,35);

        Property parkPlace            = new Property("Park Place",            "", 1, 350,37);

        Property boardwalk            = new Property("Boardwalk",             "", 1, 400,39);

        properties.add(mediterraneanAvenue);
        properties.add(balticAvenue);
        properties.add(readingRailroad);
        properties.add(orientalAvenue);
        properties.add(vermontAvenue);
        properties.add(ConnecticutAvenue);
        properties.add(stCharlesPlace);
        properties.add(electricCompany);
        properties.add(statesAvenue);
        properties.add(virginiaAvenue);
        properties.add(pennsylvaniaRailroad);
        properties.add(stJamesPlace);
        properties.add(tennesseeAvenue);
        properties.add(newYorkAvenue);
        properties.add(kentuckyAvenue);
        properties.add(indianaAvenue);
        properties.add(illinoisAve);
        properties.add(bORailroad);
        properties.add(atlanticAvenue);
        properties.add(ventnorAvenue);
        properties.add(waterWorks);
        properties.add(marvinGardens);
        properties.add(pacificAvenue);
        properties.add(northCarolinaAvenue);
        properties.add(pennsylvaniaAvenue);
        properties.add(shortLineRailroad);
        properties.add(parkPlace);
        properties.add(boardwalk);
    }
}
