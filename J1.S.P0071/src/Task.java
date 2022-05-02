
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Copyright 2022 DucPTMHE160517
 */
/**
 *
 * @author DucPTMHE160517
 */
public class Task {
    private int id, taskTypeId;
    private String requirementName, assignee, reviewer;
    private double planFrom, planTo;
    private Date date;
    
    Task (int id, String requirementName, int taskTypeId, Date date,
            double planFrom, double planTo, String assignee, String reviewer) {
        this.id = id;
        this.requirementName = requirementName;
        this.taskTypeId = taskTypeId;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public double getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(double planFrom) {
        this.planFrom = planFrom;
    }

    public double getPlanTo() {
        return planTo;
    }

    public void setPlanTo(double planTo) {
        this.planTo = planTo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    

    @Override
    public String toString() {
        String taskType = "";
        Double time = planTo - planFrom;
        String dateString = new SimpleDateFormat("dd-MM-yyyy").format(date);
        switch (taskTypeId) {
            case 1:
                taskType = "Code";
                break;
            case 2:
                taskType = "Test";
                break;
            case 3:
                taskType = "Design";
                break;
            case 4:
                taskType = "Review";
                break;
        }
        return String.format("%-5s%-17s%-15s%-15s%-10s%-15s%-15s\n", id, requirementName, 
                taskType, dateString, time, assignee, reviewer);
    }
    
    
    
}
