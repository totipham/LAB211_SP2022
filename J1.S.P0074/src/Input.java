/*
 * Copyright 2022 DucPTMHE160517
 */


import java.util.Scanner;

/**
 *
 * @author DucPTMHE160517
 */
class Input {

    int getInt(String msg, String type, int min, int max) {
        int choice;
        
        do {
            System.out.print(msg);
            try {
                Scanner sc = new Scanner(System.in);
                String input = sc.nextLine();

                //Check if input is empty
                if (input.isEmpty()) {
                    throw new NumberFormatException();
                }

                choice = Integer.parseInt(input);

                //Check if choice greater than max or choice less than min
                if (choice > max || choice < min) {
                    throw new Exception("Only accept valid number from "
                            + min + " to " + max + "!");
                }

                break;
            } catch (NumberFormatException e) {
                System.out.println("Values of " + type + " must be the number");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } while (true); //Loop while true

        return choice;
    }

    int[][] getMatrix(int[][] checkMatrix, int type) {
        int matrixOrder, row, column;
        int[][] matrix = null;

        //Check if matrix check is null
        if (checkMatrix == null) {
            matrixOrder = 1;
        } else {
            matrixOrder = 2;
        }

        do {
            try {
                row = getInt("Enter Row Matrix " + matrixOrder
                        + ":", "row", 1, Integer.MAX_VALUE);
                column = getInt("Enter Column Matrix " + matrixOrder
                        + ":", "column", 1, Integer.MAX_VALUE);

                //Check if matrix order equals 2
                if (matrixOrder == 2) {
                    int checkMatrixRow = checkMatrix.length;
                    int checkMatrixColumn = checkMatrix[0].length;
                    //Check if type equals 3
                    if (type == 3) {
                        
                        //Check if row differs check matrix column
                        if (row != checkMatrixColumn) {
                            throw new Exception("Row must be same as "
                                    + "the first matrix column !");
                        }
                    } else {
                        
                        //Check if row differs check matrix row or 
                        //column differs check matrix column
                        if (row != checkMatrixRow || column != checkMatrixColumn) {
                            throw new Exception("Both row & column must be same as "
                                    + "the first matrix !");
                        }
                    }
                }

                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } while (true); //Loop while true

        matrix = new int[row][column];

        //Loop through row from starting to ending
        for (int i = 0; i < row; i++) {
            
            //Loop through column from top to bottom
            for (int j = 0; j < column; j++) {
                matrix[i][j] = getInt("Enter Matrix" + matrixOrder
                        + "[" + (i + 1) + "]" + "[" + (j + 1) + "]:",
                        "matrix", Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        }

        return matrix;
    }

}
