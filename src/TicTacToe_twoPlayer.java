import java.awt.*;
import java.util.Scanner;
/** This program will have two users play Tic Tac Toe against each other. The game is won by three X's or O's
 in a row either vertically, horizontally, or diagonally.

 @ Ethan Salazar

 Due October 6th 2022

 */

public class TicTacToe_twoPlayer {
    public static void main(String[] args) {
        final int OH = 1;
        final int X = 2;
        final int EMPTY = 0;
        double x, y;
        int answer = 1;
        int[][] board = new int[3][3];
        // Use variable player to change turns between O and X
        int player = OH;
        int nx, ny;
        int moves = 0;

        StdDraw.setCanvasSize(800, 800);
        StdDraw.setScale(-0.1, 3.1);

        while (true) {

            // Draw the board in [0, 3] x [0, 3]
            // Assume the canvas' scale is set to -0.1 to 3.1
            drawBoard(board);

            // Capture coordinates of mouse click on the board (x, y)
            if (StdDraw.isMousePressed()) {
                x = StdDraw.mouseX();
                y = StdDraw.mouseY();
                System.out.printf("Mouse click @ %.2f, %.2f\n", x, y);

                // Is (x,y) within the board?
                if (x >= 0 && x <= 3 && y >= 0 && y <= 3) {
                    // Is board element corresponding to (x, y) EMPTY?
                    nx = (int) x;
                    ny = (int) y;
                    // Set board element corresponding to (x, y) = player
                    if (board[nx][ny] == EMPTY) {
                        board[nx][ny] = player;
                        if (player == OH) {
                            StdDraw.setPenColor(Color.red);
                            StdDraw.circle(nx + .5, ny + .5, .3);
                        }
                        if (player == X) {
                            drawX(nx + .5, ny + .5);
                        }
                    } else {
                        continue;
                    }
                    StdDraw.setPenColor();

                    // Has player won?
                    if (player == OH && ifWinner(board, OH)) {
                        if(playAgain(0,0) == true){
                            //reset board
                        }
                        if(!playAgain(0,0) == true){
                            System.exit(0);
                        }
                    }


                    if (player == X && ifWinner(board, X)) {
                        if(playAgain(0,0) == true){
                            //reset board
                        }
                        if(!playAgain(0,0) == true){
                            System.exit(0);
                        }
                    }

                    // Change player
                    if (player == OH) {
                        player = X;

                    } else {
                        player = OH;
                    }
                }
            }
            StdDraw.pause(20);
        }



    }



    public static void drawBoard(int[][] table) {
        StdDraw.setPenColor(Color.black);

        for (int j = 0; j < 4; j++) {
            StdDraw.line(0, j, 3, j);
            StdDraw.line(j, 0, j, 3);
        }
    }

    public static void drawX(double nx, double ny) {
        StdDraw.setPenColor(Color.blue);
        StdDraw.line(nx, ny, nx + .3, ny + .3);
        StdDraw.line(nx, ny, nx + .3, ny - .3);
        StdDraw.line(nx, ny, nx - .3, ny - .3);
        StdDraw.line(nx, ny, nx - .3, ny + .3);
    }


    public static boolean ifWinner(int[][] board, int player) {
        if ((board[0][0] == player && board[1][0] == player && board[2][0] == player) ||
                (board[1][0] == player && board[1][1] == player && board[1][2] == player) ||
                (board[0][0] == player && board[0][1] == player && board[0][2] == player) ||
                (board[0][1] == player && board[1][1] == player && board[1][2] == player) ||
                (board[2][0] == player && board[2][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][2] == player && board[2][2] == player) ||
                (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {

            StdDraw.setFont(new Font("Arial", Font.BOLD, 40));
            StdDraw.text(1.5, 1.5, "You Win");



            return true;
        } else {

            return false;
        }
    }



    public static boolean playAgain(double x, double y) {
        StdDraw.text(1.5, 1, "Enter y for new game or n to stop.");
        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                char d = StdDraw.nextKeyTyped();
                if (d == 'y') {

                    return true;
                } else if (d == 'n') {
                    return false;

                }
            }
        }

    }
}
