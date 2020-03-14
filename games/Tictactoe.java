package games;

import java.util.Scanner;

public class Tictactoe {
    int dimension;
    char[][] gameBoard;

    public Tictactoe(int dimension) {
        this.dimension = dimension;
        this.gameBoard = new char[dimension][dimension];

        for (int row = 0; row < gameBoard.length; row ++) {

            for (int col = 0; col < gameBoard.length; col++) {

                gameBoard[row][col] = ' ';
            }
        }
    }

    public void move(int n) {

        if (n % 2 == 0) {
            System.out.println("Turn of player : X");
        } else {
            System.out.println("Turn of player : O");
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println();

            System.out.print("Enter the coordinates (top left -> 1,1, bottom right -> 3,3) : ");

            try {

                int row = scanner.nextInt();
                int col = scanner.nextInt();


                if (row > gameBoard.length || col > gameBoard.length) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }

                row--;
                col--;


                if (gameBoard[row][col] == ' ') {

                    if (n % 2 == 0) {
                        gameBoard[row][col] = 'X';
                        break;
                    } else {
                        gameBoard[row][col] = 'O';
                        break;
                    }

                } else {

                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }
            } catch (Exception e) {

                System.out.println("You should enter numbers!");
                move(n);
            }
        }


        System.out.println();
        getGameBoard();

        if (checkWinner()) {
            return;
        }

        if (checkGameProgress()) {
            move(++n); // Important, recursive call for the next player's turn.
        } else {
            System.out.println();
            System.out.println("Draw");
            return;
        }
    }

    public boolean checkWinner() {

        boolean hasWinner = false;

        StringBuilder winStringForX = new StringBuilder();
        StringBuilder winStringForO = new StringBuilder();

        for (int numberOfCharsInWinString = 0; numberOfCharsInWinString < gameBoard.length; numberOfCharsInWinString++) {
            winStringForX.append('X');
            winStringForO.append('O');
        }

        StringBuilder mainDiagonal = new StringBuilder();
        StringBuilder secondaryDiagonal = new StringBuilder();

        for (int row = 0; row < gameBoard.length; row++) {

            StringBuilder rowString = new StringBuilder();
            StringBuilder colString = new StringBuilder();

            for (int col = 0; col < gameBoard.length; col++) {

                if (row == col) {
                    mainDiagonal.append(Character.toUpperCase(gameBoard[row][col]));
                }

                if ((row + col) == (gameBoard.length - 1)) {
                    secondaryDiagonal.append(Character.toUpperCase(gameBoard[row][col]));
                }

                rowString.append(Character.toUpperCase(gameBoard[row][col]));
                colString.append(Character.toUpperCase(gameBoard[col][row]));


                if (rowString.toString().equals(winStringForX.toString()) || colString.toString().equals(winStringForX.toString())) {
                    System.out.println();
                    System.out.println("X wins");
                    hasWinner = true;
                    return hasWinner;
                }
                if (rowString.toString().equals(winStringForO.toString()) || colString.toString().equals(winStringForO.toString())) {
                    System.out.println();
                    System.out.println("O wins");
                    hasWinner = true;
                    return hasWinner;
                }
            }
        }


        if (mainDiagonal.toString().equals(winStringForX.toString()) || secondaryDiagonal.toString().equals(winStringForX)) {
            System.out.println();
            System.out.println("X wins");
            hasWinner = true;
            return hasWinner;
        }
        if (mainDiagonal.toString().equals(winStringForO.toString()) || secondaryDiagonal.toString().equals(winStringForO)) {
            System.out.println();
            System.out.println("O wins");
            hasWinner = true;
            return hasWinner;
        }


        return hasWinner;
    }

    public boolean checkGameProgress() {

        boolean gameInProgress = false;

        for (int row = 0; row < gameBoard.length; row++) {

            for (int col = 0; col < gameBoard.length; col++) {

                if (gameBoard[row][col] == ' ') {
                    gameInProgress = true;
                }
            }
        }
        return gameInProgress;
    }

    public void getGameBoard () {

        for (int numberOfDashes = 0; numberOfDashes < ((2 * gameBoard.length) + 3); numberOfDashes ++) {
            System.out.print("-");
        }

        System.out.println();

        for (int row = 0; row < gameBoard.length; row++) {
            System.out.print("| ");
            for (int col = 0; col < gameBoard.length; col++) {
                System.out.print(gameBoard[row][col] + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        for (int numberOfDashes = 0; numberOfDashes < ((2 * gameBoard.length) + 3); numberOfDashes ++) {
            System.out.print("-");
        }
    }
}

