package com.jyc.crud;

import java.util.List;

public class Supervisor extends Employee {

    private List<Employee> staff;

    public List<Employee> getStaff() {
        return staff;
    }

    public void setStaff(List<Employee> staff) {
        this.staff = staff;
    }
}
