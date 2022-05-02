
import java.util.Scanner;

/*
 * Copyright 2022 DucPTMHE160517
 */
/**
 *
 * @author DucPTMHE160517
 */
class Input {

    int getInt(String msg, int min, int max) {
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
                    throw new Exception("Only accept valid choice number from "
                            + min + " to " + max + "!");
                }

                break;
            } catch (NumberFormatException e) {
                System.out.println("Only accept valid choice number!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } while (true); //Loop while true

        return choice;
    }

    String getString(String msg, String type) {
        String regexPattern, input;
        Scanner sc = new Scanner(System.in);

        switch (type) {
            case "name":

                //\b: matches a word boundary position between a word character 
                //and non-word character or position (start / end of string).
                //[A - Z]: ensures that the string starts with character from A - Z
                //[-,a-z. ']: matches uppercase followed by any number of lower cases, - , .
                //[ ]: space character
                //*: Match 0 or more of the preceding token.
                regexPattern = "\\b([A-Z][-,a-z. ']+[ ]*)+";
                break;
            case "yes or no":
                //[YN]{1} matches Y or N
                //Accept Y or N only
                regexPattern = "[YN]{1}";
                break;
            case "update or delete":
                //[UD]{1} matches U or D
                //Accept U or D only
                regexPattern = "[UD]{1}";
                break;
            default:
                regexPattern = "";
        }

        do {
            System.out.print(msg);
            try {
                input = sc.nextLine();

                //Check if input is empty
                if (input.isEmpty()) {
                    throw new Exception("Input value must not be empty!");
                } else {
                    //Check if regex patern type is empty
                    if (regexPattern.isEmpty()) {
                        break;
                    }

                    //Check if input string maches regex pattern type
                    if (input.matches(regexPattern)) {
                        break;
                    } else {
                        throw new Exception("Input not matches " + type + " format requirement!");
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true); //Loop while true

        return input;
    }

    String getCourse(String msg) {
        int courseChoice;
        String course = "";
        Display display = new Display();
        display.displayCourseMenu();
        courseChoice = getInt(msg, 1, 3);
        
        switch (courseChoice) {
            case 1:
                course = "Java";
                break;
            case 2:
                course = ".Net";
                break;
            case 3:
                course = "C/C++";
                break;
        }
        
        return course;
    }

}
