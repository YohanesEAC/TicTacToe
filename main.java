import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        // Create a 3x3 array that represents our tic tac toe board
        // can modify to 5x5 or 9x9 by maintain the code
        // for the next update code, we ask for the length of board

        // Scanner sc = new Scanner(System.in);
        // System.out.print("Draw The Board (ex Input 9 for 9x9 Board : ");

        // config the board size
        char[][] board = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }

        // Scanner player name
        Scanner in = new Scanner(System.in);
        System.out.println("Let's play Tic Tac Toe!");
        System.out.print("Player 1 Name : ");
        String p1 = in.nextLine();
        System.out.print("Player 2 Name : ");
        String p2 = in.nextLine();

        boolean player1 = true;

        boolean endGame = false;
        while (!endGame) {

            // call board tic tac toe
            tictactoeBoard(board);

            if (player1) {
                System.out.println(p1 + "'s Turn (X):");
            } else {
                System.out.println(p2 + "'s Turn (O):");
            }

            char c = '-';
            if (player1) {
                c = 'X';
            } else {
                c = 'O';
            }

            int row = 0;
            int col = 0;

            while (true) {

                System.out.print("Enter the row number (0, 1, or 2) : ");
                row = in.nextInt();
                System.out.print("Enter the column number (0, 1, or 2) : ");
                col = in.nextInt();
                if (row < 0 || col < 0 || row > 2 || col > 2) {
                    System.out.println("Fail Number (0 - 2) Only ! Try again.");
                } else if (board[row][col] != '-') {
                    System.out.println("Other Player Fill This Position ! Try again.");

                } else {
                    break;
                }

            }

            board[row][col] = c;

            // Check is there any winner
            if (gameWinner(board) == 'X') {
                System.out.println();
                System.out.println("===== Final Result =====");
                System.out.println(p1 + " is The Winner!");
                System.out.println("Final Board :");
                System.out.println();
                endGame = true;
            } else if (gameWinner(board) == 'O') {
                System.out.println();
                System.out.println("===== Final Result =====");
                System.out.println(p2 + " is The Winner!");
                System.out.println("Final Board :");
                System.out.println();
                endGame = true;
            } else {
                if (checkBoard(board)) {
                    System.out.println("Game Draw!");
                    endGame = true;
                } else {
                    player1 = !player1;
                }

            }

        }

        tictactoeBoard(board);

    }

    // Make a function to draw the tic tac toe board
    public static void tictactoeBoard(char[][] board) {
        System.out.println("===== TIC TAC TOE BOARD =====");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println("=============================");
    }

    // function check for the winner
    public static char gameWinner(char[][] board) {

        // row check
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
                return board[i][0];
            }
        }

        // column check
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != '-') {
                return board[0][j];
            }
        }

        // Check board diagonals
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
            return board[0][0];
        }
        if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] != '-') {
            return board[2][0];
        }

        return ' ';

    }

    // function if the board has been filled by other player
    public static boolean checkBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}