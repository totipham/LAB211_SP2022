
import java.util.Scanner;

/*
 * Copyright 2022 DucPTMHE160517
 */
/**
 *
 * @author DucPTMHE160517
 */
class Input {

    public int getBase(String typeInput, int maxChoiceNum, int minChoiceNum, int fromBase) {
        int baseType = 0;
        String message = "";

        switch (typeInput) {
            case "from_base":
                message = "From base: ";
                break;
            case "to_base":
                message = "To base: ";
                break;
        }

        do {
            System.out.print(message);
            try {
                Scanner sc = new Scanner(System.in);
                String baseChoice = sc.nextLine();

                //Check if base choice input is empty
                if (baseChoice.isEmpty()) {
                    throw new NumberFormatException();
                }

                //Check if base choice length greater than 1
                if (baseChoice.length() > 1) {
                    throw new Exception("Only accept valid choice number from "
                            + minChoiceNum + " to " + maxChoiceNum + "!");
                }

                baseType = Integer.parseInt(baseChoice);

                //Check if base type equals 0
                if (baseType == 0) {
                    System.exit(0);
                }

                //Check if base type is greater than max choice or 
                //base type is less than min choice
                if (baseType > maxChoiceNum || baseType < minChoiceNum) {
                    throw new Exception("Only accept valid choice number from "
                            + minChoiceNum + " to " + maxChoiceNum + "!");
                }

                //Check if recent base type equals from base
                if (baseType == fromBase) {
                    throw new Exception("Base converting output must not be same"
                            + " as base coverting input!");
                }

                break;
            } catch (NumberFormatException e) {
                System.out.println("Only accept valid choice number!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } while (true); //Loop while true

        return baseType;
    }

    public String inputValue(int fromBase) {
        String basePatern = "", baseType = "", value = "";
        String inputMessage = "Input value: ";

        switch (fromBase) {
            case 1:
                //Match set of character which in the range 0 to 1 (Binary)
                basePatern = "^[0-1]+$";
                baseType = "Binary";
                break;
            case 2:
                //Match set of character which in the range 0 to 9 (Decimal)
                basePatern = "^[0-9]+$";
                baseType = "Decimal";
                break;
            case 3:
                /*Match set of character which in the range 0 to 9 and 
                from A to F (Hexadecimal) */
                basePatern = "^[A-F0-9]+$";
                baseType = "Hexadecimal";
                break;
        }

        do {
            System.out.print(inputMessage);
            try {
                Scanner sc = new Scanner(System.in);
                value = sc.nextLine();

                //Check if base is empty
                if (value.isEmpty()) {
                    throw new Exception("Input value must not be empty!");
                }

                //Check if uppercased input value matches output base pattern validation
                if (!value.toUpperCase().matches(basePatern)) {
                    throw new Exception("Invalid " + baseType.toLowerCase()
                            + " base format!");
                }

                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } while (true); //Loop while true

        return value.toUpperCase();
    }
}
