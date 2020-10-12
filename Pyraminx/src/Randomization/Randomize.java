package Randomization;

import Layout.Side;
import Moving.Movements;

import java.util.Scanner;


public class Randomize {
    // Starting the process of randomization
    public void start(Side index, Movements moving) {
        // Creating Sides - Accessing them
        //                                      side[0][0]
        //                          side[1][0]  side[1][1]  side[1][2]
        //              side[2][0]  side[2][1]  side[2][2]  side[2][3]  side[2][4]
        // side[3][0]   side[3][1]  side[3][2]  side[3][3]  side[3][4]  side[3][5]  side[3][6]
        String[][] red = index.createSide("red");
        String[][] green = index.createSide("green");
        String[][] blue = index.createSide("blue");
        String[][] yellow = index.createSide("yellow");



        //Initial Display
        System.out.println("Layout:");
        displayOutput(yellow, red, blue, green);

        randomLoop(index, moving, yellow, red, blue, green);

    }

    // Displaying sides of Pyraminx in Terminal
    public void displayOutput(String[][] yellow, String[][] red, String[][] blue, String[][] green) {
        //Outputting Everything At the Start
        System.out.println("   " + yellow[0][0] + "              " + red[0][0] + "              " + blue[0][0]);
        System.out.println("  " + yellow[1][0] + yellow[1][1] + yellow[1][2] + "            " + red[1][0] + red[1][1] + red[1][2] + "            " + blue[1][0] + blue[1][1] + blue[1][2]);
        System.out.println(" " + yellow[2][0] + yellow[2][1] + yellow[2][2] + yellow[2][3] + yellow[2][4] + "          " + red[2][0] + red[2][1] + red[2][2] + red[2][3] + red[2][4] + "          " + blue[2][0]+ blue[2][1] + blue[2][2] + blue[2][3] + blue[2][4]);
        System.out.println(yellow[3][0] + yellow[3][1] + yellow[3][2] + yellow[3][3] + yellow[3][4] + yellow[3][5] + yellow[3][6] + "        " + red[3][0] + red[3][1] + red[3][2] + red[3][3] + red[3][4] + red[3][5] + red[3][6] + "        " + blue[3][0] + blue[3][1] + blue[3][2] + blue[3][3] + blue[3][4] + blue[3][5] + blue[3][6]);
        System.out.println("                  " + green[0][0]);
        System.out.println("                 " + green[1][0] + green[1][1] + green[1][2]);
        System.out.println("                " + green[2][0] + green[2][1] + green[2][2] + green[2][3] + green[2][4]);
        System.out.println("               " + green[3][0] + green[3][1] + green[3][2] + green[3][3] + green[3][4] + green[3][5] + green[3][6]);
        System.out.println("");
    }

    // Gets user input for random movement
    public void randomLoop(Side index, Movements moving, String[][] yellow, String[][] red, String[][] blue, String[][] green) {

        String input = "";

        Scanner in = new Scanner(System.in);

        while (!input.equals("q") && !input.equals("Q")) {
            // Getting User Input
            System.out.println("Enter number of moves to randomize: ");
            System.out.println("(Enter 'R' to reset)");
            System.out.println("(Enter 'Q' to quit)");
            input = in.nextLine();

            // Resetting Pyraminx upon user request
            if (input.equals("r") || input.equals("R")) {
                red = index.createSide("red");
                green = index.createSide("green");
                blue = index.createSide("blue");
                yellow = index.createSide("yellow");
                displayOutput(yellow,red,blue,green);
            }
            else if (input.equals("q") || input.equals("Q")) {
                break;
            }
            // Randomizing Based on number user inputted
            else{
                if(input.equals("")) {
                    input = "0";
                }
                for (int i = 0; i < Integer.parseInt(input); i++) {
                    randomizeMovement(moving, yellow, red, blue, green);
                }
            }

        }
    }

    // Performs random movement on Pyraminx
    public void randomizeMovement(Movements moving, String[][] yellow, String[][] red, String[][] blue, String[][] green) {
        System.out.println("MOVE:");
        String[][] center = {};
        String[][] left = {};
        String[][] right = {};
        String[][] down = {};
        String currentDirection = "";

        // Randomizing Face Index
        int faceIndex = (int)(4.0 * Math.random());
        switch(faceIndex) {
            case 0:
                System.out.println("Face: Center");
                center = red;
                left = yellow;
                right = blue;
                down = green;
                break;
            case 1:
                System.out.println("Face: Bottom");
                center = green;
                left = red;
                right = blue;
                down = yellow;
                break;
            case 2:
                System.out.println("Face: Right");
                center = blue;
                left = red;
                right = yellow;
                down = green;
                break;
            case 3:
                System.out.println("Face: Left");
                center = yellow;
                left = blue;
                right = red;
                down = green;
                break;
            default:
                break;
        }
        // Randomizing Direction of Turn
        int turnIndex = (int)(2.0 * Math.random());
        switch(turnIndex) {
            case 0:
                System.out.println("Direction: Left");
                currentDirection = "left";
                break;
            case 1:
                System.out.println("Direction: Right");
                currentDirection = "right";
                break;
            default:
                break;
        }
        // Randomizing which part of the face is going to be moved
        int movingFunction = (int)(12.0 * Math.random());
        switch (movingFunction) {
            case 0:
                System.out.println("Affected: Top Row");
                moving.rowFirst(currentDirection, center, left, right, down);
                break;
            case 1:
                System.out.println("Affected: Second Row");
                moving.rowSecond(currentDirection, center, left, right, down);
                break;
            case 2:
                System.out.println("Affected: Third Row");
                moving.rowThird(currentDirection, center, left, right, down);
                break;
            case 3:
                System.out.println("Affected: Bottom Row");
                moving.rowFourth(currentDirection, center, left, right, down);
                break;
            case 4:
                System.out.println("Affected: First Left Diagonal");
                moving.leftDiagonalFirst(currentDirection, center, left, right, down);
                break;
            case 5:
                System.out.println("Affected: Second Left Diagonal");
                moving.leftDiagonalSecond(currentDirection, center, left, right, down);
                break;
            case 6:
                System.out.println("Affected: Third Left Diagonal");
                moving.leftDiagonalThird(currentDirection, center, left, right, down);
                break;
            case 7:
                System.out.println("Affected: Fourth Left Diagonal");
                moving.leftDiagonalFourth(currentDirection, center, left, right, down);
                break;
            case 8:
                System.out.println("Affected: First Right Diagonal");
                moving.rightDiagonalFirst(currentDirection, center, left, right, down);
                break;
            case 9:
                System.out.println("Affected: Second Right Diagonal");
                moving.rightDiagonalSecond(currentDirection, center, left, right, down);
                break;
            case 10:
                System.out.println("Affected: Third Right Diagonal");
                moving.rightDiagonalThird(currentDirection, center, left, right, down);
                break;
            case 11:
                System.out.println("Affected: Fourth Right Diagonal");
                moving.rightDiagonalFourth(currentDirection, center, left, right, down);
                break;
            default:
                break;
        }
        // Displaying Output after each move
        displayOutput(yellow,red,blue,green);
    }

}
