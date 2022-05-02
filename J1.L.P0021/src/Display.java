
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

        System.out.println("WELCOME TO STUDENT MANAGEMENT");

        menuChoice.add("\t1. Create");
        menuChoice.add("\t2. Find and Sort");
        menuChoice.add("\t3. Update/Delete");
        menuChoice.add("\t4. Report");
        menuChoice.add("\t5. Exit");

        //Get each choice in menu choices
        menuChoice.forEach(choice -> {
            System.out.println("  " + choice);
        });

        System.out.println("(Please choose 1 to Create, 2 to Find and Sort, "
                + "3 to Update/Delete, 4 to Report and 5 to Exit program).");

    }

    void displayCourseMenu() {
        ArrayList<String> courseList = new ArrayList<>();

        System.out.println("Choose course: ");

        courseList.add("\t1. Java");
        courseList.add("\t2. .Net");
        courseList.add("\t3. C/C++");

        courseList.forEach(course -> {
            System.out.println(course);
        });
    }

    void displayList(ArrayList<Student> list, String displayType) {
        switch (displayType) {
            case "student_list":
                System.out.format("%5s%20s%10s%10s\n", "ID", "Name", "Semester", "Course");

                //Loop to get each student in student list
                for (Student student : list) {
                    System.out.println(student);
                }

                break;
            case "update_or_delete_list":
                int rowNumber = 0;
                System.out.format("%10s%5s%20s%10s%10s\n", "Row Number", "ID", 
                        "Name", "Semester", "Course");
                
                //Loop to get each student in student list
                for (Student student : list) {
                    System.out.format("%10s", ++rowNumber);
                    System.out.println(student);
                }
                
                break;
        }

    }
}
