/*
 * Copyright 2022 DucPTMHE160517
 */


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author DucPTMHE160517
 */
class Employee {

    private int Id;
    private String FirstName, LastName, Phone, Email, Address, Sex, Agency;
    private Date DOB;
    private double Salary;

    public Employee(int Id, String FirstName, String LastName, String Phone,
            String Email, String Address, String Sex, String Agency, Date DOB, double Salary) {
        this.Id = Id;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Phone = Phone;
        this.Email = Email;
        this.Address = Address;
        this.Sex = Sex;
        this.Agency = Agency;
        this.DOB = DOB;
        this.Salary = Salary;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    public String getAgency() {
        return Agency;
    }

    public void setAgency(String Agency) {
        this.Agency = Agency;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double Salary) {
        this.Salary = Salary;
    }

    @Override
    public String toString() {
        String birthday = new SimpleDateFormat("dd/MM/yyyy").format(DOB);
        String gender = (Sex.equals("F")) ? "Female" : "Male";
        return String.format("%3s%10s%15s%15s%20s%25s%15s%10s%10s%10s\n", Id, FirstName, LastName, Phone, Email, Address, birthday, gender, Salary, Agency);
    }

}
