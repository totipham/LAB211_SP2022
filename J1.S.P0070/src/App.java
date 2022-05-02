
import java.util.Locale;

/*
 * Copyright 2022 DucPTMHE160517
 */


/**
 *
 * @author DucPTMHE160517
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int choice;
        Display display = new Display();
        Input input = new Input();
        Ebank bankSystem = new Ebank();
        
        do {
            //Display menu
            display.displayMenu();
            
            //Get selection
            choice = input.getInt("Please choice one option:", 1, 3);
            
            //Perform action
            switch (choice) {
                case 1:
                    bankSystem.checkLogin(new Locale("Vi"));
                    break;
                case 2:
                    bankSystem.checkLogin(new Locale("En"));
                    break;
            }
        } while (choice < 3); //Loop while choice less than 3
    }
    
}
