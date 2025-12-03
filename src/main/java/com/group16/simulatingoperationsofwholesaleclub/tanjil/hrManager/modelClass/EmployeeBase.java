package com.group16.simulatingoperationsofwholesaleclub.tanjil.hrManager.modelClass;

import java.io.Serializable;

public class EmployeeBase implements Serializable {
    private String id;
    private String name;
    private String department;
    private String position;

    public EmployeeBase() {
        this.id = "";
        this.name = "";
        this.department = "";
        this.position = "";
    }

    public EmployeeBase(String id, String name, String department, String position) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.position = position;
    }


    public String getId() {
        return id; }
    public void setId(String id) {
        this.id = id; }

    public String getName() {
        return name; }
    public void setName(String name) {
        this.name = name; }

    public String getDepartment() {
        return department; }
    public void setDepartment(String department) {
        this.department = department; }

    public String getPosition() {
        return position; }
    public void setPosition(String position) {
        this.position = position; }

    @Override
    public String toString() {
        return "EmployeeBase{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
