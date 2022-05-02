
import java.util.Date;

/*
 * Copyright 2022 DucPTMHE160517
 */
/**
 *
 * @author DucPTMHE160517
 */
class TaskManagement {

    private Display display = new Display();
    private Input input = new Input();

    private boolean isCollided(String searchingAssignee, Date searchingDate,
            double checkingPlanFrom, double checkingPlanTo, TaskList taskList) {

        //Loop to get each task in task list
        for (Task task : taskList) {
            String taskAssignee = task.getAssignee();
            Date taskDate = task.getDate();

            //Check if task assignee equals searching assignee & recent 
            //task date equals searching date
            if (taskAssignee.equals(searchingAssignee)
                    && taskDate.equals(searchingDate)) {

                double planTo = task.getPlanTo();
                double planFrom = task.getPlanFrom();

                //Check if [checking plan from] greater than [plan to] or 
                //[checking plan to] less than [plan from]
                if (checkingPlanFrom > planTo || checkingPlanTo < planFrom) {
                    continue;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    int addTask(int currentID, TaskList taskList) {
        String requirementName, assignee, reviewer;
        int taskTypeId;
        double planFrom, planTo;
        Date date;

        display.displayMethodInterface("add_task");

        requirementName = input.getString("Requirement Name: ", "");
        taskTypeId = input.getInt("Task Type: ", 1, 4);
        date = input.getDate("Date: ");

        do {
            try {
                planFrom = input.getPlan("From: ", 8.0, 17.5);
                planTo = input.getPlan("To: ", 8.0, 17.5);

                //Check if plan from greater than plan to
                if (planFrom > planTo) {
                    throw new Exception("Plan from must less than or equals "
                            + "plan to !");
                }

                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } while (true); //Loop while true

        assignee = input.getString("Assignee: ", "name");
        reviewer = input.getString("Reviewer: ", "name");

        //Check if date, plan from, plan to are collided with existed task
        if (isCollided(assignee, date, planFrom, planTo, taskList)) {

            System.out.println(assignee + " already has task collided with "
                    + "above input time!");

        } else {
            taskList.add(new Task(++currentID, requirementName, taskTypeId, date,
                    planFrom, planTo, assignee, reviewer));
        }

        return currentID;
    }

    void deleteTask(TaskList taskList) {
        int removingID, taskIndex;

        //Check if task list is empty
        if (taskList.isEmpty()) {
            System.out.println("Task list is empty !");
            return;
        }

        display.displayMethodInterface("delete_task");

        do {
            try {
                removingID = input.getInt("ID: ", 1, Integer.MAX_VALUE);
                taskIndex = taskList.searchTaskByID(removingID);

                //Check if task index less than 0
                if (taskIndex < 0) {
                    throw new Exception("Task is not existed!");
                }

                taskList.removeTaskByID(taskIndex);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } while (true); //Loop while true
    }

    void displayTasks(TaskList taskList) {

        //Check if task list is empty
        if (taskList.isEmpty()) {
            System.out.println("Task list is empty !");
            return;
        }

        display.displayMethodInterface("display_task");
        display.displayList(taskList);
    }

}
