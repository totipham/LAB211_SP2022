
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    Date getDate(String msg) {
        String input;
        Date date;
        Scanner sc = new Scanner(System.in);

        // \d{1,2}: number has 1 or 2 digit number
        //[-]: contains character -
        //\d{4}: the number must have 4 digit
        String dateRegex = "\\d{1,2}[-]\\d{1,2}[-]\\d{4}";

        do {
            System.out.print(msg);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            dateFormat.setLenient(false);
            input = sc.nextLine();
            try {
                //Check if input is empty
                if (input.isEmpty()) {
                    throw new Exception("Input value must not be empty!");
                }

                //Check if input not matches date format
                if (!input.matches(dateRegex)) {
                    throw new Exception("Input not matches date format requirement!");
                }

                date = dateFormat.parse(input);
                break;
            } catch (ParseException e) {
                System.out.println("Date not existed!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);  //Loop while true

        return date;
    }

    Double getPlan(String msg, double min, double max) {
        Double value = null;
        Scanner sc = new Scanner(System.in);

        //^[0-9] matches string start with digit from 0 - 9
        //* accepts any number of digits
        // \. must have character "."
        //[05]{1} must match one of digit 0 or 5
        //Matches double number end with .0 or .5
        String planPattern = "^[0-9]*\\.[05]{1}$";
        
        do {
            try {
                System.out.print(msg);
                String input = sc.nextLine();

                //Check if input is empty
                if (input.isEmpty()) {
                    throw new Exception("Input could not be empty!");
                }

                //Check if input does not match plan pattern
                if (!input.matches(planPattern)) {
                    throw new Exception("Just accept value in sequence 8.0, 8.5,"
                            + " 9.0, 9.5, ... , 16.5, 17.0, 17.5");
                }

                value = Double.parseDouble(input);

                //Check if value greater than max and also less than min
                if (value > max || value < min) {
                    throw new Exception("Value must be in range from " + min
                            + " to " + max);
                }

                break;
            } catch (NumberFormatException e) {
                System.out.println("Only accept valid choice!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true); //Loop while true

        return value;
    }

}
