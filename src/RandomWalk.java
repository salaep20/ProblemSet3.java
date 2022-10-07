/**********************************************************************
 * @file RandomWalk.java
 * @brief We are going to simulate the behavior of an insect-like robot seeking for a way out of a maze. In our
 * case, the maze is a N ×N grid.
 * @author Ethan Salazar
 * @date: October 6th 2022
 * @acknowledgement: Tim Hultman
 ***********************************************************************/
    import java.awt.*;
import java.util.Scanner;
import java.util.Random;
    public class RandomWalk {
        public static void main(String[] args) {
            Scanner kb = new Scanner(System.in);
            int n;                 // Grid size [0 n] x [0 n]

            int r1_currX, r1_currY;           // (currX, currY) is the current robot position
            int r1_prevX, r1_prevY;           // (prevX, prevY) is the previous robot position
            int r1_steps = 0;              // Counter for the number of moves
            boolean r1_didMove = true;
            Color r1_color = Color.red;

            int r2_currX, r2_currY;           // (currX, currY) is the current robot position
            int r2_prevX, r2_prevY;           // (prevX, prevY) is the previous robot position
            int r2_steps = 0;              // Counter for the number of moves
            boolean r2_didMove = true;
            Color r2_color = Color.green;

            int r3_currX, r3_currY;           // (currX, currY) is the current robot position
            int r3_prevX, r3_prevY;           // (prevX, prevY) is the previous robot position
            int r3_steps = 0;              // Counter for the number of moves
            boolean r3_didMove = true;
            Color r3_color = Color.orange;

            System.out.print("Desired grid size? ");
            n = kb.nextInt();

            // Set up the size of the canvas to be 600 pixels in width and
            // adjust the height so that the grid appears square and not
            // rectangular.
            StdDraw.setCanvasSize(600, (int)(600*(n+21)/(double)n));
            StdDraw.setXscale(-1, n+1); // x goes from -1 to n+1
            StdDraw.setYscale(-1, n+21); // y goes from -1 to n+10

            drawGrid(n);    // Draw the grid at the bottom of the canvas

            // Draw the robots' paths with a slightly thicker pen
            StdDraw.setPenRadius(0.007);



            Random rand = new Random();
            r1_currX=n/2;
            r1_currY=n/2;
            r1_prevY=n/2;
            r1_prevX=n/2;
            r2_currX=n/2;
            r2_currY=n/2;
            r2_prevY=n/2;
            r2_prevX=n/2;
            r3_currX=n/2;
            r3_currY=n/2;
            r3_prevY=n/2;
            r3_prevX=n/2;
            boolean canMove1=true;
            boolean canMove2=true;
            boolean canMove3=true;
            while(((r1_currX>=0&&r1_currX<=n)&&(r1_currY>=0&&r1_currY<=n))||((r2_currX>=0&&r2_currX<=n)&&(r2_currY>=0&&r2_currY<=n))||((r3_currX>=0&&r3_currX<=n)&&(r3_currY>=0&&r3_currY<=n))) {
                if (canMove1 == true) {
                    int decider = rand.nextInt(4);
                    if (decider == 0) {
                        r1_currX++;
                        r1_steps++;
                        drawStep(r1_prevX, r1_prevY, r1_currX, r1_currY, r1_color);
                    } else if (decider == 1) {
                        r1_currY--;
                        r1_steps++;
                        drawStep(r1_prevX, r1_prevY, r1_currX, r1_currY, r1_color);
                    } else if (decider == 2) {
                        r1_currX--;
                        r1_steps++;
                        drawStep(r1_prevX, r1_prevY, r1_currX, r1_currY, r1_color);
                    } else if (decider == 3) {
                        r1_currY++;
                        r1_steps++;
                        drawStep(r1_prevX, r1_prevY, r1_currX, r1_currY, r1_color);
                    }
                    r1_prevY = r1_currY;
                    r1_prevX = r1_currX;
                    if((r1_currX<0||r1_currX>n)||(r1_currY<0||r1_currY>n))
                        canMove1=false;

                }
                if(canMove2==true){
                    int decider=rand.nextInt(4);
                    if(decider==0){
                        r2_currX++;
                        r2_steps++;
                        drawStep(r2_prevX, r2_prevY,r2_currX, r2_currY, r2_color);
                    }
                    else if(decider==1){
                        r2_currY--;
                        r2_steps++;
                        drawStep(r2_prevX, r2_prevY,r2_currX, r2_currY, r2_color);
                    }
                    else if(decider==2){
                        r2_currX--;
                        r2_steps++;
                        drawStep(r2_prevX, r2_prevY,r2_currX, r2_currY, r2_color);
                    }
                    else if(decider==3){
                        r2_currY++;
                        r2_steps++;
                        drawStep(r2_prevX, r2_prevY,r2_currX, r2_currY, r2_color);
                    }
                    r2_prevY=r2_currY;
                    r2_prevX=r2_currX;
                    if((r2_currX<0||r2_currX>n)||(r2_currY<0||r2_currY>n))
                        canMove2=false;

                }
                if(canMove3==true){
                    int decider=rand.nextInt(4);
                    if(decider==0){
                        r3_currX++;
                        r3_steps++;
                        drawStep(r3_prevX, r3_prevY,r3_currX, r3_currY, r3_color);
                    }
                    else if(decider==1){
                        r3_currY--;
                        r3_steps++;
                        drawStep(r3_prevX, r3_prevY,r3_currX, r3_currY, r3_color);
                    }
                    else if(decider==2){
                        r3_currX--;
                        r3_steps++;
                        drawStep(r3_prevX, r3_prevY,r3_currX, r3_currY, r3_color);
                    }
                    else if(decider==3){
                        r3_currY++;
                        r3_steps++;
                        drawStep(r3_prevX, r3_prevY,r3_currX, r3_currY, r3_color);
                    }
                    r3_prevY=r3_currY;
                    r3_prevX=r3_currX;
                    if((r3_currX<0||r3_currX>n)||(r3_currY<0||r3_currY>n))
                        canMove3=false;

                }
            }





            // Print final results
            StdDraw.setPenColor(r1_color);
            StdDraw.text(n/2, n+18, "Robot 1: steps = " + r1_steps);
            StdDraw.setPenColor(r2_color);
            StdDraw.text(n/2, n+14, "Robot 2: steps = "+r2_steps);
            StdDraw.setPenColor(r3_color);
            StdDraw.text(n/2, n+10, "Robot 3: steps = "+r3_steps);
            StdDraw.setPenColor(Color.black);
            StdDraw.text(n/2, n+6, "average: " +
                    String.format("%.2f", (r1_steps + r2_steps + r3_steps) / 3.0));

        }

        /*
         * drawStep(x0, y0, x1, y1, c) draws a line between points (x0, y0)
         * and (x1, y1) using color c. Note that the actual locations of
         * points (x0, y0) and (x1, y1) in the canvas depend on the X and
         * Y scales previously set up.
         */
        private static void drawStep(int prevX, int prevY, int currX, int currY, Color color) {
            StdDraw.setPenColor(color);
            StdDraw.line(prevX, prevY, currX, currY);
        }

        /**
         * Draw a grid using red lines and methods in the StdDraw class.
         * @param n size of the grid
         */
        private static void drawGrid(int n) {
            StdDraw.setPenColor(Color.red);
            for (int i = 0; i <= n; i++) {
                StdDraw.line(i, 0, i, n);
                StdDraw.line(0, i, n, i);
            }
        }
    }

