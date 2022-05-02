/*
 * Copyright 2022 DucPTMHE160517
 */


import java.util.ArrayList;

/**
 *
 * @author DucPTMHE160517
 */
public class EmployeeList extends ArrayList<Employee> {

    EmployeeList() {
        super();
    }

    EmployeeList(Employee e) {
        
        //Check if ID is not a collided id
        if (!isCollidedID(e.getId())) {
            this.add(e);
        } else {
            System.out.println("ID is existed !");
        }
    }

    void addEmployee(Employee e) {
        
        //Check if ID is not a collided id
        if (!isCollidedID(e.getId())) {
            this.add(e);
            System.out.println("Adding successful !");
        } else {
            System.out.println("Adding unsuccessful! This employee's ID is collided.");
        }
    }

    private int searchEmployeeByID(int id) {
        
        //Check if employee list is empty
        if (this.isEmpty()) {
            return -1;
        }

        //Loop to get every employee in this list
        for (Employee employee : this) {

            //Compare employee's id with searching id
            if (employee.getId() == id) {
                return this.indexOf(employee);
            }
        }

        return -1;
    }

    private boolean isCollidedID(int id) {

        //Check if there had un employee has ID same with this ID
        if (searchEmployeeByID(id) >= 0) {
            return true;
        }

        return false;
    }
}
