/*
 * Copyright 2022 DucPTMHE160517
 */

import java.util.Scanner;

/**
 *
 * @author DucPTMHE160517
 */
class Input {

    int getInt(String msg, int min, int max) {
        int choice;
        String errorMessage = "Only accept integer number from "
                            + min + " to " + max + "!";

        do {
            System.out.print(msg);
            try {
                Scanner sc = new Scanner(System.in);
                String input = sc.nextLine();

                //Check if input is empty
                if (input.isEmpty()) {
                    throw new Exception(errorMessage);
                }

                choice = Integer.parseInt(input);

                //Check if choice greater than max or choice less than min
                if (choice > max || choice < min) {
                    throw new Exception(errorMessage);
                }

                break;
            } catch (NumberFormatException e) {
                System.out.println(errorMessage);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } while (true); //Loop while true

        return choice;
    }

    String getString(String msg, String type, String warningMessage) {
        String regexPattern, input;
        Scanner sc = new Scanner(System.in);

        switch (type) {
            case "account":

                // \d matches digit from 0 - 9 (like [0-9])
                // {10} contains 10 characters
                //Match string contains 10 character and digits from 0-9
                regexPattern = "^\\d{10}";
                break;
            case "password":

                //{8,31} matches the previous token between 8 and 31 times, as many times as possible, giving back as needed
                //$ asserts position at the end of a line
                //Positive Lookahead (?=.*[0-9])
                //Assert that the Regex below matches
                //. matches any character (except for line terminators)
                //* matches the previous token between zero and unlimited times, as many times as possible, giving back as needed
                //Match a single character present in the list below [0-9]
                //0-9 matches a single character in the range between 0 and 9
                //. matches any character
                //* matches the previous token between zero and unlimited times, as many times as possible, giving back as needed
                //Match a single character present in the list below [a-zA-Z]
                //a-z matches a single character in the range between a and z
                //A-Z matches a single character in the range between A and Z
                //1st Capturing Group ([a-zA-Z0-9]+)
                //Match a single character present in the list below [a-zA-Z0-9]
                //+ matches the previous token between one and unlimited times, as many times as possible, giving back as needed
                //a-z matches a single character in the range between a and z
                //A-Z matches a single character in the range between A and Z
                //0-9 matches a single character in the range between 0 and 9
                //$ asserts position at the end of a line
                //Match string contains both uppercase, lowercase character, digit
                //from 0-9 and has length from 8 to 31
                regexPattern = "^(?=.{8,31}$)(?=.*[0-9])(?=.*[a-zA-Z])([a-zA-Z0-9]+)$";
                break;
            case "captcha":

                //{5} matches 5 character
                //$ asserts position at the end of a line
                //Positive Lookahead (?=.*[0-9])
                //Assert that the Regex below matches
                //. matches any character (except for line terminators)
                //* matches the previous token between zero and unlimited times, as many times as possible, giving back as needed
                //Match a single character present in the list below [0-9]
                //0-9 matches a single character in the range between 0 and 9
                //. matches any character
                //* matches the previous token between zero and unlimited times, as many times as possible, giving back as needed
                //Match a single character present in the list below [a-zA-Z]
                //a-z matches a single character in the range between a and z
                //A-Z matches a single character in the range between A and Z
                //1st Capturing Group ([a-zA-Z0-9]+)
                //Match a single character present in the list below [a-zA-Z0-9]
                //+ matches the previous token between one and unlimited times, as many times as possible, giving back as needed
                //a-z matches a single character in the range between a and z
                //A-Z matches a single character in the range between A and Z
                //0-9 matches a single character in the range between 0 and 9
                //$ asserts position at the end of a line
                //Match string contains both uppercase, lowercase character, digit
                //from 0-9 and has length of 5
                regexPattern = "^(?=.{5}$)(?=.*[0-9])(?=.*[a-zA-Z])([a-zA-Z0-9]+)$";
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
                    throw new Exception();
                } else {
                    
                    //Check if regex patern type is empty
                    if (regexPattern.isEmpty()) {
                        break;
                    }

                    //Check if input string maches regex pattern type
                    if (input.matches(regexPattern)) {
                        break;
                    } else {
                        throw new Exception();
                    }
                }
            } catch (Exception e) {
                System.out.println(warningMessage);
            }
        } while (true); //Loop while true

        return input;
    }
}
