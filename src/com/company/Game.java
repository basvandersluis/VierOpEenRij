package com.company;
import java.util.Scanner;
public class Game {
    Gamerack speelrek;
    String[] players = {"Geel", "Rood"};
    boolean winner = false;

    public Game() {
        System.out.println(
                "\n" +
                "\n" +
                "====================" +
                "\n" +
                "Welkom bij 4 op een rij!" +
                "\n" +
                "====================" +
                "\n" +
                "\n"
            );
            speelrek = new Gamerack();
        }


    public void playGame() {
        while (!winner) {
            for (String player : players) {
                turn(player);
                winnerCheck(player);
                if (winner) {
                    System.out.println("Speler " + player + " heeft gewonnen!");
                    break;
                }
            }
        }
    }

    private void turn(String player) {
        Scanner input = new Scanner(System.in);
        System.out.println("Speler " + player + " in welke kolom wil je je steen gooien?");
        char column = input.nextLine().toLowerCase().charAt(0);
        System.out.println("Je hebt gekozen voor " + column);
        if (column >= 'a' && column <= 'g') {
            if (speelrek.checkColumnFull(column)) {
                System.out.println("Deze kolom is vol, gooi je steen in een andere kolom.");
                turn(player);
            } else {
                System.out.println("Je hebt gekozen voor " + column);
                speelrek.dropPiece(column, player);
                speelrek.printRack();
            }
        } else {
            System.out.println("De kolom bestaat niet, probeer opnieuw.");
            turn(player);
        }
    }
    private void winnerCheck(String player){
        if (speelrek.verticalCheck(player)) {
            winner = true;
        }
        if (speelrek.horizontalCheck(player)) {
            winner = true;
        }
        if (speelrek.diagonaleCheck(player)) {
            winner = true;
        }
    }


}
