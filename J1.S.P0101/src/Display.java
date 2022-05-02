/*
 * Copyright 2022 DucPTMHE160517
 */


import java.util.ArrayList;

/**
 *
 * @author DucPTMHE160517
 */
class Display {

    public void displayMenu() {
        ArrayList<String> menuChoice = new ArrayList<>();

        System.out.println("Main menu:");

        menuChoice.add("1. Add employees");
        menuChoice.add("2. Update employees");
        menuChoice.add("3. Remove employees");
        menuChoice.add("4. Search employees");
        menuChoice.add("5. Sort employees by salary");
        menuChoice.add("6. Exit");

        //Get each choice in menu choices
        menuChoice.forEach(choice -> {
            System.out.println("\t" + choice);
        });

    }

    void displayList(EmployeeList employeeList) {
        System.out.format("%3s%10s%15s%15s%20s%25s%15s%10s%10s%10s\n", "ID",
                    "Firstname", "Lastname", "Phone", "Email", "Address", "DOB",
                    "Sex", "Salary", "Agency");
        
        //Get each employee in employee list
        employeeList.forEach(employee -> {
            System.out.println(employee);
        });

    }

    void displayUpdateMenu(Employee employee) {
        ArrayList<String> updateChoice = new ArrayList<>();

        System.out.println("Updating menu for:");
        System.out.println("(+) " + employee + "\n");
        updateChoice.add(" 1. Update employee's ID");
        updateChoice.add(" 2. Update employee's firstname");
        updateChoice.add(" 3. Update employee's lastname");
        updateChoice.add(" 4. Update employee's phone");
        updateChoice.add(" 5. Update employee's email");
        updateChoice.add(" 6. Update employee's address");
        updateChoice.add(" 7. Update employee's DOB");
        updateChoice.add(" 8. Update employee's sex");
        updateChoice.add(" 9. Update employee's salary");
        updateChoice.add("10. Update employee's agency");
        updateChoice.add("11. Cancel");

        //Get each choice in update choice
        updateChoice.forEach(choice -> {
            System.out.println("\t" + choice);
        });
    }
}
