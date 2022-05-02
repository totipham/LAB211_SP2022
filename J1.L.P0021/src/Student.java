/*
 * Copyright 2022 DucPTMHE160517
 */

/**
 *
 * @author DucPTMHE160517
 */
public class Student{
    private String id, semester, studentName, courseName;

    public Student(String id, String studentName, String semester, String courseName) {
        this.id = id;
        this.semester = semester;
        this.studentName = studentName;
        this.courseName = courseName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return String.format("%5s%20s%10s%10s", id, studentName, semester, courseName);
        //return "Student{" + "id=" + id + ", semester=" + semester + ", studentName=" + studentName + ", courseName=" + courseName + '}';
    }
    
}
