package com.example.WebWorks.DBoperations;

public class EmployeeDB {
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    private String Name;


    public int getCusid() {
        return cusid;
    }

    public void setCusid(int cusid) {
        this.cusid = cusid;
    }

    private int cusid;

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    private String Address;

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    private String Phone;
    private int Salary;

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    private String dob;
    @Override
    public String toString() {
        return "EmployeeDB{" +
                "Name='" + Name + '\'' +
                ", cusid=" + cusid +
                ", Address='" + Address + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Salary=" + Salary +
                '}';
    }
}
