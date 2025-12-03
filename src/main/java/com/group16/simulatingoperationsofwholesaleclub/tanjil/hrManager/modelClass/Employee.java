package com.group16.simulatingoperationsofwholesaleclub.tanjil.hrManager.modelClass;

import java.io.Serializable;

public class Employee implements Serializable {
    private String id;
    private String name;
    private String department;
    private String position;
    private double salary;

    // Default constructor
    public Employee() {
        this.id = "";
        this.name = "";
        this.department = "";
        this.position = "";
        this.salary = 0.0;
    }

    // Full constructor
    public Employee(String id, String name, String department, String position, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.position = position;
        this.salary = salary;
    }

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
