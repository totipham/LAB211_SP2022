
import java.util.ArrayList;

/*
 * Copyright 2022 DucPTMHE160517
 */

/**
 *
 * @author DucPTMHE160517
 */
class Display {

    void displayMenu() {
        ArrayList<String> menuChoice = new ArrayList<>();

        System.out.println("========== Task program ==========");

        menuChoice.add("•\tAdd Task");
        menuChoice.add("•\tDelete task");
        menuChoice.add("•\tDisplay Task");
        menuChoice.add("•\texit");

        //Get each choice in menu choices
        menuChoice.forEach(choice -> {
            System.out.println("  " + choice);
        });

    }
    
    void displayMethodInterface(String type) {
        String msg = "";
        
        switch (type) {
            case "add_task":
                msg = "------------ Add Task ------------";
                break;
            case "delete_task":
                msg = "------------ Del Task ------------";
                break;
            case "display_task":
                msg = "---------------------------------------- Task -------"
                        + "---------------------------------";
                break;
        }
        
        System.out.println(msg);
    }
    
    void displayList(TaskList taskList) {
        System.out.format("%-5s%-17s%-15s%-15s%-10s%-15s%-15s\n", "ID",
                    "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
        
        //Get each task in task list
        taskList.forEach(task -> {
            System.out.println(task);
        });
    }
}
