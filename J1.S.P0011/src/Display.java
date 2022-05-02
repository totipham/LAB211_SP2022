
import java.util.ArrayList;

/*
 * Copyright 2022 DucPTMHE160517
 */
/**
 *
 * @author DucPTMHE160517
 */
class Display {

    public void displayMenu() {
        ArrayList<String> menuChoice = new ArrayList<>();
        menuChoice.add("1. Binary");
        menuChoice.add("2. Decimal");
        menuChoice.add("3. Hexadecimal");
        menuChoice.add("0. Exit the program");

        //Loop to get each choice in menu choice
        menuChoice.forEach(choice -> {
            System.out.println(choice);
        });

    }

    public void displayResult(String result) {

        //Check if result is not null
        if (result != null) {
            System.out.println("Output result: " + result);
        }
    }
}
