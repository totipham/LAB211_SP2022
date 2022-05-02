/*
 * Copyright 2022 DucPTMHE160517
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author DucPTMHE160517
 */
class EmployeeManagement {
    private Display display = new Display();
    private Input input = new Input();

    private int searchEmployeeByID(int id, EmployeeList employeeList) {
        
        //Check if employee list is empty
        if (employeeList.isEmpty()) {
            return -1;
        }

        for (Employee employee : employeeList) {

            //Check if employee's id equals searching id
            if (employee.getId() == id) {
                return employeeList.indexOf(employee);
            }
        }

        return -1;
    }

    private boolean isCollidedID(int id, EmployeeList employeeList) {

        //Check if this ID already existed in employee list
        if (searchEmployeeByID(id, employeeList) >= 0) {
            return true;
        }

        return false;
    }

    void addEmployee(EmployeeList employeeList) {
        int Id;
        String FirstName, LastName, Phone, Email, Address, Sex, Agency;
        Date DOB;
        double Salary;
        boolean flagCheck;
        Date currentDate = new Date();

        //Check if employee list is not empty
        if (!employeeList.isEmpty()) {
            display.displayList(employeeList);
        }
        
        do {
            flagCheck = false;
            Id = input.getInt("Enter employee's ID: ", 1, Integer.MAX_VALUE);
            flagCheck = isCollidedID(Id, employeeList);

            //Check if flag is true
            if (flagCheck) {
                System.out.println("ID must not be collided!");
            }
        } while (flagCheck); //Loop while flag check is true
        
        FirstName = input.getString("Enter employee's first name: ", "name");
        LastName = input.getString("Enter employee's last name: ", "name");
        Phone = input.getString("Enter employee's phone: ", "phone");
        Email = input.getString("Enter employee's email: ", "email");
        Address = input.getString("Enter employee's address: ", "");
        DOB = input.getDate("Enter employee's DOB: ", currentDate);
        Sex = input.getString("Enter employee's sex (F-Female/M-Male): ", "sex");
        Salary = input.getDouble("Enter employee's salary: ", 0, Double.MAX_VALUE);
        Agency = input.getString("Enter employee's agency: ", "");

        employeeList.addEmployee(new Employee(Id, FirstName, LastName, Phone, Email,
                Address, Sex, Agency, DOB, Salary));
    }

    void updateEmployee(EmployeeList employeeList) {
        int searchingID, employeePosition, choice;
        Date currentDate = new Date();
        
        do {
            //Check if employee list is empty
            if (employeeList.isEmpty()) {
                System.out.println("Employee list is empty!");
                return;
            } else {
                display.displayList(employeeList);
            }
            
            searchingID = input.getInt("Enter employee's ID: ", 0, Integer.MAX_VALUE);
            try {
                employeePosition = searchEmployeeByID(searchingID, employeeList);

                //Check if employee's position equals -1
                if (employeePosition == -1) {
                    throw new Exception("Employee not existed!");
                }

                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true); //Loop while true

        do {
            display.displayUpdateMenu(employeeList.get(employeePosition));

            choice = input.getInt("Your choice: ", 1, 11);

            switch (choice) {
                case 1:
                    int Id = input.getInt("Enter employee's ID: ", 1, Integer.MAX_VALUE);

                    //Check if this Id is not equal searchingID
                    if (Id != searchingID) {
                        //Check if ID is collided id in the list
                        if (isCollidedID(Id, employeeList)) {
                            System.out.println("ID must not be collided!");
                        } else {
                            employeeList.get(employeePosition).setId(Id);
                        }
                    }
                    break;
                case 2:
                    String FirstName = input.getString("Enter employee's firstname: ", "name");
                    employeeList.get(employeePosition).setFirstName(FirstName);
                    break;
                case 3:
                    String LastName = input.getString("Enter employee's last name: ", "name");
                    employeeList.get(employeePosition).setLastName(LastName);
                    break;
                case 4:
                    String Phone = input.getString("Enter employee's phone: ", "phone");
                    employeeList.get(employeePosition).setPhone(Phone);
                    break;
                case 5:
                    String Email = input.getString("Enter employee's email: ", "email");
                    employeeList.get(employeePosition).setEmail(Email);
                    break;
                case 6:
                    String Address = input.getString("Enter employee's address: ", "");
                    employeeList.get(employeePosition).setAddress(Address);
                    break;
                case 7:
                    Date DOB = input.getDate("Enter employee's DOB: ", currentDate);
                    employeeList.get(employeePosition).setDOB(DOB);
                    break;
                case 8:
                    String Sex = input.getString("Enter employee's sex (F-Female/M-Male): ", "sex");
                    employeeList.get(employeePosition).setSex(Sex);
                    break;
                case 9:
                    double Salary = input.getDouble("Enter employee's salary: ", 0, Double.MAX_VALUE);
                    employeeList.get(employeePosition).setSalary(Salary);
                    break;
                case 10:
                    String Agency = input.getString("Enter employee's agency: ", "");
                    employeeList.get(employeePosition).setAgency(Agency);
                    break;

            }
        } while (choice < 11); //Loop while choice less than 11

    }

    void removeEmployee(EmployeeList employeeList) {
        int id, employeePosition;

        //Check if employee list is empty
        if (employeeList.isEmpty()) {
            System.out.println("Employee list is empty!");
            return;
        }
        
        do {
            display.displayList(employeeList);
            id = input.getInt("Enter employee's id: ", 0, Integer.MAX_VALUE);
            try {
                employeePosition = searchEmployeeByID(id, employeeList);

                //Check if employee position equals -1
                if (employeePosition == -1) {
                    throw new Exception("Employee not existed!");
                }

                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true); //Loop while true
        
        employeeList.remove(employeePosition);
        System.out.println("Removing employee successful!");
    }

    void searchEmployeeByName(EmployeeList employeeList) {
        ArrayList<Integer> positionList = new ArrayList<>();

        //Check if employee list is empty
        if (employeeList.isEmpty()) {
            System.out.println("Employee list is empty!");
            return;
        }

        String employeeSearchingName = input.getString("Enter employee's name: ", "");

        //Loop to get each employee index from starting to ending
        for (int i = 0; i < employeeList.size(); i++) {
            String employeeFullname = employeeList.get(i).getFirstName().concat(employeeList.get(i).getLastName());

            //Check if employee full name contains employee searching name
            if (employeeFullname.contains(employeeSearchingName)) {
                positionList.add(i);
            }
        }

        //Check if posisition list is empty
        if (positionList.isEmpty()) {
            System.out.println("Employee not existed !");
        } else {
            System.out.format("%3s%10s%15s%15s%20s%25s%15s%10s%10s%10s\n", "ID",
                    "Firstname", "Lastname", "Phone", "Email", "Address", "DOB",
                    "Sex", "Salary", "Agency");
        }

        //Get each position in position list
        positionList.forEach(position -> {
            System.out.println(employeeList.get(position));
        });
    }

    void sortBySalary(EmployeeList employeeList) {

        //Check if employee list is empty
        if (employeeList.isEmpty()) {
            System.out.println("Employee list is empty!");
            return;
        }
                
        Collections.sort(employeeList, new Comparator<Employee>() {

            @Override
            public int compare(Employee e1, Employee e2) {
                double deviant = e1.getSalary() - e2.getSalary();

                //Check if deviant equals 0
                if (deviant == 0) {
                    return e1.getId() - e2.getId();
                } else if (deviant > 0) { //Check if deviant greater than 0
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        display.displayList(employeeList);
    }

}
