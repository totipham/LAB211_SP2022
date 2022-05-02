/*
 * Copyright 2022 DucPTMHE160517
 */

/**
 *
 * @author DucPTMHE160517
 */
public class App {

    public static void main(String[] args) {
        Display display = new Display();
        Input input = new Input();
        Convert convert = new Convert();

        //Loop while true
        while (true) {
            //Display menu
            display.displayMenu();

            //Get input base type
            int fromBase = input.getBase("from_base", 3, 0, -1);

            //Get output base type
            int toBase = input.getBase("to_base", 3, 0, fromBase);

            //Receive input value
            String value = input.inputValue(fromBase);

            //Covert
            String result = convert.convertBase(fromBase, toBase, value);

            //Display result
            display.displayResult(result);
        }
    }
}
