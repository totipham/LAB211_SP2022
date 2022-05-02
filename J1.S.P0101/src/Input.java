/*
 * Copyright 2022 DucPTMHE160517
 */


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

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
                //Match string made from one of character A-Z, a-z and starts
                //with first uppercase character, and the left is lowercase character
                regexPattern = "\\b([A-Z][-,a-z. ']+[ ]*)+";
                break;
            case "phone":

                //^0: matches 0 at the begining
                //[139]{1}: matches one of (1, 3, 9) at the next
                //[0-9]{8}$: matches 8 elements as number digit at the last
                //Accept 10 digit phone number start with 0, next is one of 1, 3, 9
                regexPattern = "^0[139]{1}[0-9]{8}$";
                break;
            case "email":

                //^[a-zA-Z0-9]: matches a-z, A-Z, 0-9 from beginning
                //+@: matches  @ at the next
                //[a-z]{2,6}: matches 2 to 6 characters from a - z
                //[a-z]{2,6}\\.[a-z]{2,6}|[a-z]{2,6}\\.[a-z]{2,6}\\.[a-z]{2,6})*$
                // matches 0 or more of the preceding token
                //Accept email format which start with string username, character @
                //and domain
                regexPattern = "^[a-zA-Z0-9]+@([a-z]{2,6}\\.[a-z]{2,6}|[a-z]{2,6}\\.[a-z]{2,6}\\.[a-z]{2,6})*$";
                break;
            case "sex":
                
                //[FM]{1} matches F or M
                //Accept F or M only
                regexPattern = "[FM]{1}";
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

    Date getDate(String msg, Date currentDate) {
        String input;
        Date date;
        Scanner sc = new Scanner(System.in);

        // \d{1,2}: number has 1 or 2 digit number
        //[/]: contains character /
        //\d{4}: the number must have 4 digit
        String dateRegex = "\\d{1,2}[/]\\d{1,2}[/]\\d{4}";

        do {
            System.out.print(msg);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
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

                //Check if this date is after current date
                if (date.after(currentDate)) {
                    throw new Exception("Date must be before " + 
                            dateFormat.format(currentDate));
                }
                
                break;
            } catch (ParseException e) {
                System.out.println("Date not existed!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);  //Loop while true

        return date;
    }

    Double getDouble(String msg, double min, double max) {
        Double value = null;
        Scanner sc = new Scanner(System.in);

        do {
            try {
                System.out.print(msg);
                String input = sc.nextLine();

                //Check if input is empty
                if (input.isEmpty()) {
                    throw new Exception("Input could not be empty!");
                }

                value = Double.parseDouble(input);
                
                //Check if value is greater than max or less than min
                if (value > max || value < min) {
                    throw new Exception("Value must be in range from " + min +
                            " to " + max );
                }
                
                break;
            } catch (NumberFormatException e) {
                System.out.println("Only accept valid double number!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true); //Loop while true

        return value;
    }

}
