package com.snook;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

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
}
