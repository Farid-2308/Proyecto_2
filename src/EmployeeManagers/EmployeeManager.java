/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EmployeeManagers;

import Persons.Employee;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 *
 * @author mathy
 */
public class EmployeeManager {
    private ArrayList<Employee> employees = new ArrayList<>();

    private boolean isValidEmail(String email) {
        return Pattern.matches("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,6}$", email);
    }

    private boolean isValidPhone(String phone) {
        return phone.matches("^[2678][0-9]{7}$");
    }

    public void addEmployee(Employee e) throws Exception {
        for (Employee existing : employees) {
            if (existing.getId().equals(e.getId())) {
                throw new Exception("Employee with same ID already exists");
            }
        }
        if (e.getAge() < 18) throw new Exception("Employee must be at least 18 years old");
        if (!isValidEmail(e.getEmail())) throw new Exception("Invalid email format");
        if (!isValidPhone(e.getPhone())) throw new Exception("Phone must have 8 digits");

        employees.add(e);
    }

    public Employee searchEmployee(String id) {
        for (Employee e : employees) {
            if (e.getId().equals(id)) return e;
        }
        return null;
    }

    public void updateEmployee(String id, String phone, String email, String position) {
        Employee e = searchEmployee(id);
        if (e != null) {
            e.setPhone(phone);
            e.setEmail(email);
            e.setPosition(position);
        }
    }

    public void removeEmployee(String id) {
        employees.removeIf(e -> e.getId().equals(id));
    }

    public ArrayList<Employee> getEmployees() { 
        return employees;
    }
}
