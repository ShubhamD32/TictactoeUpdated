package tictactoe.run;

import game.builder.TictactoeBuilder;
import games.Tictactoe;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the dimension of the TicTacToe board : ");
        int dimensionOfGameBoard;
        Tictactoe ticTacToe = null;
        while (true) {
            try {
                dimensionOfGameBoard = scanner.nextInt();
                if (dimensionOfGameBoard < 3) {
                    System.out.println("Invalid input, resorting to defaults.");
                    ticTacToe = new TictactoeBuilder().buildGameBoard();
                    break;
                } else {
                    System.out.println("Setting up the board!");
                    ticTacToe = new TictactoeBuilder().setDimension(dimensionOfGameBoard).buildGameBoard();
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Enter a number");
                scanner.next();
                System.out.println("Enter the dimension of the TicTacToe board : ");
            }
        }
        ticTacToe.getGameBoard();
        System.out.println();
        ticTacToe.move(0); // 0 is used to provide an initial seed to determine which player starting the game.
    }
}
