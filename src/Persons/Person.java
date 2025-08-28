/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persons;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author mathy
 */
public abstract class Person {
    protected String id;
    protected String name;
    protected LocalDate birthDate;
    protected String phone;
    protected String email;

    public int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public Person(String id, String name, LocalDate birthDate, String phone, String email) {
            this.id = id;
            this.name = name;
            this.birthDate = birthDate;
            this.phone = phone;
            this.email = email;
    }
}
