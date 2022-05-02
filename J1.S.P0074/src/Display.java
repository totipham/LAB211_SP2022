/*
 * Copyright 2022 DucPTMHE160517
 */


import java.util.ArrayList;

/**
 *
 * @author DucPTMHE160517
 */
class Display {

    void displayMenu() {
        ArrayList<String> menuChoice = new ArrayList<>();

        System.out.println("=======Calculator program======");

        menuChoice.add("1. Addition Matrix");
        menuChoice.add("2. Subtraction Matrix");
        menuChoice.add("3. Multiplication Matrix");
        menuChoice.add("4. Quit");

        //Get each choice in menu choices
        menuChoice.forEach(choice -> {
            System.out.println(choice);
        });
    }

    void displayInterface(int type) {
        String msg = null;
        switch (type) {
            case 1:
                msg = "-------- Addition --------";
                break;
            case 2:
                msg = "----- Subtraction ------";
                break;
            case 3:
                msg = "-------- Multiplication -------";
                break;
        }
        System.out.println(msg);
    }

    void displayResult(int[][] matrix1, int[][] matrix2, int type, int[][] result) {
        String expression = null;
        switch (type) {
            case 1:
                expression = "+";
                break;
            case 2:
                expression = "-";
                break;
            case 3:
                expression = "*";
                break;
        }

        System.out.println("--------- Result --------");
        displayMatrix(matrix1);
        System.out.println(expression);
        displayMatrix(matrix2);
        System.out.println("=");
        displayMatrix(result);
    }

    private void displayMatrix(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;

        //Loop through row from starting to ending
        for (int i = 0; i < row; i++) {
            //Loop through column from top to bottom
            for (int j = 0; j < column; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.print("\n");
        }
    }

}
