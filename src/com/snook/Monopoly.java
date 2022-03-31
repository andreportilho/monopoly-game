package com.snook;

import java.util.ArrayList;
import java.util.Scanner;

public class Monopoly {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Dice dice = new Dice();

        ArrayList<Player> players = new ArrayList<Player>();

        Player playerOne = new Player("first player");
        players.add(playerOne);

        setPlayersName(players, input);
    }

    public static void setPlayersName(ArrayList<Player> players, Scanner input){
        for (Player p : players) {
            System.out.println("Enter the name of the " + p.getName());
            p.setName(input.nextLine());
        }
    }

    public static void setProperties(ArrayList<Property> properties) {
        Property mediterraneanAvenue  = new Property("Mediterranean Avenue",  0, 1, 60, 0);

        Property balticAvenue         = new Property("Baltic Avenue",         0, 0, 60, 0);

        Property readingRailroad      = new Property("Reading Railroad",      0, 1, 200,0);
        Property orientalAvenue       = new Property("Oriental Avenue",       0, 1, 100,0);

        Property vermontAvenue        = new Property("Vermont Avenue",        0, 1, 100,0);
        Property ConnecticutAvenue    = new Property("Connecticut Avenue",    0, 1, 120,0);

        Property stCharlesPlace       = new Property("St. Charles Place",     0, 1, 140,0);
        Property electricCompany      = new Property("Electric Company",      0, 1, 150,0);
        Property statesAvenue         = new Property("States Avenue",         0, 1, 140,0);
        Property virginiaAvenue       = new Property("Virginia Avenue",       0, 1, 160,0);
        Property pennsylvaniaRailroad = new Property("Pennsylvania Railroad", 0, 1, 200,0);
        Property stJamesPlace         = new Property("St. James Place",       0, 1, 180,0);

        Property tennesseeAvenue      = new Property("Tennessee Avenue",      0, 1, 180,0);
        Property newYorkAvenue        = new Property("New York Avenue",       0, 1, 200,0);

        Property kentuckyAvenue       = new Property("Kentucky Avenue",       0, 1, 220,0);

        Property indianaAvenue        = new Property("Indiana Avenue",        0, 1, 220,0);
        Property illinoisAve          = new Property("Illinois Avenue",       0, 1, 240,0);
        Property bORailroad           = new Property("B&O Railroad",          0, 1, 200,0);

        Property atlanticAvenue       = new Property("Atlantic Avenue",       0, 1, 260,0);
        Property ventnorAvenue        = new Property("Ventnor Avenue",        0, 1, 260,0);
        Property waterWorks           = new Property("Water Works",           0, 1, 150,0);
        Property marvinGardens        = new Property("Marvin Gardens",        0, 1, 280,0);

        Property pacificAvenue        = new Property("Pacific Avenue",        0, 1, 300,0);
        Property northCarolinaAvenue  = new Property("North Carolina Avenue", 0, 1, 300,0);

        Property pennsylvaniaAvenue   = new Property("Pennsylvania Avenue",   0, 1, 320,0);
        Property shortLineRailroad    = new Property("Short Line Railroad",   0, 1, 200,0);

        Property parkPlace            = new Property("Park Place",            0, 1, 350,0);

        Property boardwalk            = new Property("Boardwalk",             0, 1, 400,0);

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
