
import java.util.ArrayList;

/*
 * Copyright 2022 DucPTMHE160517
 */

/**
 *
 * @author DucPTMHE160517
 */
class TaskList extends ArrayList <Task>{
    TaskList() {
        super();
    }
    
    void addTask(Task task) {
        this.add(task);
    }
    
    int searchTaskByID(int searchingID) {
        
        //Loop to get each task in this task list
        for (Task task : this) {
            
            //Check if searching id equals task's id
            if (searchingID == task.getId()) {
                return this.indexOf(task);
            }
        }
        
        return -1;
    }

    void removeTaskByID(int removingID) {
        this.remove(removingID);
    }
}
