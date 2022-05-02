/*
 * Copyright 2022 DucPTMHE160517
 */


/**
 *
 * @author DucPTMHE160517
 */
class MatrixCalculation {

    int[][] additionMatrix(int[][] matrix1, int[][] matrix2) {
        int matrix1Row = matrix1.length;
        int matrix1Column = matrix1[0].length;
        int[][] result = new int[matrix1Row][matrix1Column];

        //Loop through row from starting to ending
        for (int i = 0; i < matrix1Row; i++) {
            
            //Loop through column from top to bottom
            for (int j = 0; j < matrix1Column; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return result;
    }

    int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2) {
        int matrix1Row = matrix1.length;
        int matrix1Column = matrix1[0].length;
        int[][] result = new int[matrix1Row][matrix1Column];

        //Loop through row from starting to ending
        for (int i = 0; i < matrix1Row; i++) {
            
            //Loop through column from top to bottom
            for (int j = 0; j < matrix1Column; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }

        return result;
    }

    int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        int matrix1Row = matrix1.length;
        int matrix1Column = matrix1[0].length;
        int matrix2Column = matrix2[0].length;
        int[][] result = new int[matrix1Row][matrix2Column];

        //Loop through row from starting to ending
        for (int i = 0; i < matrix1Row; i++) {
            
            //Loop through matrix 2 column from top to bottom
            for (int j = 0; j < matrix2Column; j++) {
                
                //Loop through matrix 2 row from starting to ending
                for (int k = 0; k < matrix1Column; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;
    }

}
