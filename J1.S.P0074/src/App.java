/*
 * Copyright 2022 DucPTMHE160517
 */


/**
 *
 * @author DucPTMHE160517
 */
public class App {

    public static void main(String[] args) {
        int choice;
        Display display = new Display();
        Input input = new Input();
        MatrixCalculation matrixCalculation = new MatrixCalculation();

        do {
            
            //Display menu
            display.displayMenu();

            //Get selection
            choice = input.getInt("Your choice:", "choice", 1, 4);

            switch (choice) {
                case 1:
                    //Display interface
                    display.displayInterface(choice);

                    //Get matrix 1
                    int[][] matrix1 = input.getMatrix(null, choice);

                    //Get matrix 2
                    int[][] matrix2 = input.getMatrix(matrix1, choice);

                    //Perform action
                    int[][] result = matrixCalculation.additionMatrix(matrix1, matrix2);

                    //Display result
                    display.displayResult(matrix1, matrix2, choice, result);
                    
                    break;
                case 2:
                    //Display interface
                    display.displayInterface(choice);

                    //Get matrix 1
                    matrix1 = input.getMatrix(null, choice);

                    //Get matrix 2
                    matrix2 = input.getMatrix(matrix1, choice);

                    //Perform action
                    result = matrixCalculation.subtractionMatrix(matrix1, matrix2);

                    //Display result
                    display.displayResult(matrix1, matrix2, choice, result);

                    break;
                case 3:
                    //Display interface
                    display.displayInterface(choice);

                    //Get matrix 1
                    matrix1 = input.getMatrix(null, choice);

                    //Get matrix 2
                    matrix2 = input.getMatrix(matrix1, choice);

                    //Perform action
                    result = matrixCalculation.multiplicationMatrix(matrix1, matrix2);

                    //Display result
                    display.displayResult(matrix1, matrix2, choice, result);

                    break;
            }
        } while (choice < 4); //Loop while choice less than 4
    }

}
