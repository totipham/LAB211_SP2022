
import java.util.ArrayList;

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
        ArrayList <Student> studentList = new ArrayList<>();
        StudentManagement studentManagement = new StudentManagement();
        
        do {
            //Display menu
            display.displayMenu();

            //Get choice
            choice = input.getInt("", 1, 5);

            //Perform action
            switch (choice) {
                case 1:
                    studentManagement.createStudent(studentList);
                    break;
                case 2:
                    studentManagement.findAndSort(studentList);
                    break;
                case 3:
                    studentManagement.updateOrDelete(studentList);
                    break;
                case 4:
                    studentManagement.report(studentList);
                    break;
            }
        } while (choice < 5); //Loop while choice less than 5
    }

}
