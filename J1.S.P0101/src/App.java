/*
 * Copyright 2022 DucPTMHE160517
 */



/**
 *
 * @author DucPTMHE160517
 */
public class App {

    public static void main(String[] args) {
        int choice;
        Display display = new Display();
        Input input = new Input();
        EmployeeList employeeList = new EmployeeList();
        EmployeeManagement employeeManagement = new EmployeeManagement();
         
        do {
            //Display menu
            display.displayMenu();
            
            //Get  choice
            choice = input.getInt("Your choice: ", 1, 6);
            
            //Do choice
            switch (choice) {
                case 1:
                    employeeManagement.addEmployee(employeeList);
                    break;
                case 2:
                    employeeManagement.updateEmployee(employeeList);
                    break;
                case 3:
                    employeeManagement.removeEmployee(employeeList);
                    break;
                case 4:
                    employeeManagement.searchEmployeeByName(employeeList);
                    break;
                case 5:
                    employeeManagement.sortBySalary(employeeList);
                    break;
            }
        } while (choice < 6); //Loop while choice less than 6
    }

}
