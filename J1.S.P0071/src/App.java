/*
 * Copyright 2022 DucPTMHE160517
 */

/**
 *
 * @author DucPTMHE160517
 */
public class App {

    public static void main(String[] args) {
        int choice, currentID = 0;
        Display display = new Display();
        Input input = new Input();
        TaskList taskList = new TaskList();
        TaskManagement taskManagement = new TaskManagement();

        do {
            //Display menu
            display.displayMenu();

            //Get choice
            choice = input.getInt("", 1, 4);

            //Perform action
            switch (choice) {
                case 1:
                    currentID = taskManagement.addTask(currentID, taskList);
                    break;
                case 2:
                    taskManagement.deleteTask(taskList);
                    break;
                case 3:
                    taskManagement.displayTasks(taskList);
                    break;
            }
            
        } while (choice < 4); //Loop while choice less than 4
    }
}
