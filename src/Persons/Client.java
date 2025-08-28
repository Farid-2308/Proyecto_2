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
public class Client extends Person{
    private String license;

    public Client(String id, String name, LocalDate birthDate, String phone, String email, String license) {
        super(id, name, birthDate, phone, email);
        this.license = license;
    }

    public String getLicense() { return license; }
    public void setLicense(String license) { this.license = license; }

    @Override
    public String toString() {
        return "Client: " + name + " (" + id + ") Age: " + getAge();
    }

}
