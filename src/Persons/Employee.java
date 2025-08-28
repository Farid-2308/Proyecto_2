/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persons;

import java.time.LocalDate;

/**
 *
 * @author mathy
 */
public class Employee extends Person{
    private String position;
    private double salary;

    public Employee(String id, String name, LocalDate birthDate, String phone, String email, String position, double salary) {
        super(id, name, birthDate, phone, email);
        this.position = position;
        this.salary = salary;
    }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    @Override
    public String toString() {
        return "Employee: " + name + " (" + id + ") Position: " + position;
    }

}
