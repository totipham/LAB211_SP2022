
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/*
 * Copyright 2022 DucPTMHE160517
 */
/**
 *
 * @author DucPTMHE160517
 */
class StudentManagement {

    private Input input = new Input();
    private Display display = new Display();

    private boolean isCollided(String checkingID, String checkingSemester,
            String checkingCourseName, ArrayList<Student> studentList) {

        boolean isSameID = false, isSameSemester = false, isSameCourse = false;

        //Loop to get each student in student list
        for (Student student : studentList) {

            isSameID = checkingID.equals(student.getId());
            isSameSemester = checkingSemester.equals(student.getSemester());
            isSameCourse = checkingCourseName.equals(student.getCourseName());

            //Check if same ID, same semester and same course are true
            if (isSameID && isSameSemester && isSameCourse) {
                return true;
            }
        }

        return false;
    }

    private int getFirstIndex(String searchingID, ArrayList<Student> studentList) {

        //Loop to get each student in student list
        for (Student student : studentList) {

            //Check if student's id equals searching id
            if (student.getId().equals(searchingID)) {
                return studentList.indexOf(student);
            }
        }

        return -1;
    }

    private ArrayList<Student> findStudentByID(String searchingID,
            ArrayList<Student> studentList) {

        ArrayList<Student> studentResultList = new ArrayList<>();

        //Loop to get each student in student list
        for (Student student : studentList) {

            //Check if student's id equals searching id
            if (student.getId().equals(searchingID)) {
                studentResultList.add(student);
            }
        }

        return studentResultList;
    }

    void createStudent(ArrayList<Student> studentList) {
        String id, semester, studentName, courseName;
        boolean isUsingStudent;
        String userChoice;

        do {
            
            //Check if size of student list equals 10
            if (studentList.size() >= 10) {
                
                System.out.println("Number of student is greater than 10.\n"
                        + "Do you want to continue (Y/N)?");
                
                userChoice = input.getString("Choose Y to continue, N to "
                        + "return main screen. ", "yes or no");

                //Check if user answer is equals "Y"
                if (!userChoice.equals("Y")) {
                    break;
                }
            }
            
            isUsingStudent = false;
            
            try {
                id = input.getString("Enter ID: ", "");

                int studentIndex = getFirstIndex(id, studentList);

                //Check if student index is greater than 0
                if (studentIndex >= 0) {

                    System.out.println("This ID has already been using by student "
                            + studentList.get(studentIndex).getStudentName()
                            + " (ID: " + id + ") ");

                    userChoice = input.getString("Do you want to use it "
                            + "(Y - Yes/N - No): ", "yes or no");

                    //Check if user answer is equals "Y"
                    if (userChoice.equals("Y")) {
                        isUsingStudent = true;
                    } else {
                        continue;
                    }
                }

                //Check if using student is false
                if (!isUsingStudent) {
                    studentName = input.getString("Enter name: ", "name");
                } else {
                    studentName = studentList.get(studentIndex).getStudentName();
                }

                semester = input.getString("Enter semester: ", "");
                courseName = input.getCourse("Your choice: ");

                //Check if this id, semester, course name is collided in student list
                if (isCollided(id, semester, courseName, studentList)) {
                    throw new Exception(studentName + " (ID: " + id + ") "
                            + "already registed " + courseName
                            + " for semester " + semester + "\nCreate unsuccessfully!");

                } else {
                    studentList.add(new Student(id, studentName, semester, courseName));
                    System.out.println("Create new student successfully !");
                    display.displayList(studentList, "student_list");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true); //Loop while true
    }

    void findAndSort(ArrayList<Student> studentList) {
        String searchingString;
        ArrayList<Student> searchingResult = new ArrayList<>();

        //Check if student list is empty
        if (studentList.isEmpty()) {
            System.out.println("Student list is empty!");
            return;
        }

        searchingString = input.getString("Enter whole/part of searching student name: ", "");

        //Loop to get each student in student list
        studentList.forEach((student) -> {
            String lowerCaseName = student.getStudentName().toLowerCase();
            //Check if lowercase name contains lowercase searching string
            if (lowerCaseName.contains(searchingString.toLowerCase())) {
                searchingResult.add(student);
            }
        });

        if (searchingResult.isEmpty()) {
            System.out.println("No student be found!");
            return;
        }

        Collections.sort(searchingResult, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getStudentName().compareToIgnoreCase(o2.getStudentName());
            }
        });
        display.displayList(searchingResult, "student_list");
    }

    private void updateStudent(Student updatingStudent, ArrayList<Student> studentList) {
        int studentIndex = -1;
        boolean isUsingStudent = false;
        String inputID, inputName = null, inputCourse, inputSemester;
        String studentCourse, studentSemester;

        System.out.println("(+) Updating for:");
        System.out.format("\t%5s%20s%10s%10s\n", "ID", "Name", "Semester", "Course");
        System.out.println("\t" + updatingStudent);

        inputID = input.getString("Enter ID: ", "");

        //Check if input ID equals updating student ID
        if (inputID.equals(updatingStudent.getId())) {
            isUsingStudent = true;
        } else {
            studentIndex = getFirstIndex(inputID, studentList);
        }

        //Check if using student is false
        if (isUsingStudent) {
            inputName = updatingStudent.getStudentName();
        } else {
            //Check if student index greater or equals 10
            if (studentIndex >= 0) {
                inputName = studentList.get(studentIndex).getStudentName();
            } else {
                inputName = input.getString("Enter name: ", "name");
            }
        }
        inputSemester = input.getString("Enter semester: ", "");
        inputCourse = input.getCourse("Your choice: ");

        studentCourse = updatingStudent.getCourseName();
        studentSemester = updatingStudent.getSemester();

        //Check if using student is true and input semester equals student semester
        //and input course equals student course
        if (isUsingStudent && inputSemester.equals(studentSemester)
                && inputCourse.equals(studentCourse)) {

            System.out.println("Update student successfully !");
        } else {

            //Check if input id, input semester, input course name is collided in student list
            if (!isCollided(inputID, inputSemester, inputCourse, studentList)) {
                updatingStudent.setId(inputID);
                updatingStudent.setStudentName(inputName);
                updatingStudent.setSemester(inputSemester);
                updatingStudent.setCourseName(inputCourse);
                System.out.println("Update student successfully !");

            } else {
                System.out.println("These input information above is collided "
                        + "with another record !");
            }
        }
    }

    private void deleteStudent(Student deletingStudent, ArrayList<Student> studentList) {
        studentList.remove(deletingStudent);
        System.out.println("Remove student successfully !");
    }

    void updateOrDelete(ArrayList<Student> studentList) {
        String searchingID, userChoice;
        Student studentChoice;
        ArrayList<Student> studentResultList = new ArrayList<>();

        //Check if student list is empty
        if (studentList.isEmpty()) {
            System.out.println("Student list is empty!");
            return;
        }

        do {
            try {
                display.displayList(studentList, "student_list");
                searchingID = input.getString("Enter ID: ", "");

                //Check if there is no student in student list has searching ID
                if (!(getFirstIndex(searchingID, studentList) >= 0)) {
                    throw new Exception("There is no student has this ID !");
                }

                studentResultList = findStudentByID(searchingID, studentList);
                display.displayList(studentResultList, "update_or_delete_list");

                //Check if student result list size greater than 1
                if (studentResultList.size() > 1) {

                    int userRowChoice = input.getInt("Enter student row number: ",
                            1, studentResultList.size());

                    studentChoice = studentResultList.get(userRowChoice - 1);
                } else {
                    studentChoice = studentResultList.get(0);
                }

                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true); //Loop while true

        userChoice = input.getString("Do you want to update (U) or delete (D) "
                + "student: ", "update or delete");

        //Check if user choice equals "U"
        if (userChoice.equals("U")) {
            updateStudent(studentChoice, studentList);
        } else {
            deleteStudent(studentChoice, studentList);
        }

        display.displayList(studentList, "student_list");
    }

    void report(ArrayList<Student> studentList) {
        ArrayList<String> list = new ArrayList<>();
        Set<String> set = null;

        //Check if student list is empty
        if (studentList.isEmpty()) {
            System.out.println("Student list is empty!");
            return;
        }

        //Loop to get each student in student list
        studentList.forEach(student -> {
            list.add(String.format("%10s - %15s | %10s", student.getId(), student.getStudentName(),
                    student.getCourseName()));
        });

        set = new HashSet<>(list);

        //Loop to get each row in set
        set.forEach((row) -> {
            System.out.println(row.split("-")[1] + " | " + Collections.frequency(list, row));
        });
    }
}
