/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Managments;

import java.time.Year;


/**
 *
 * @author Jorge
 */
public class Vehicule {
    private String plate;
    private String brand;
    private String model;
    private int year;
    private Types type;
    private Status status;

    
    public String getPlate() {
        return plate;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public Types getType() {
        return type;
    }

    public Status getStatus() {
        return status;
    }

    public void setType(Types type) {
        this.type = type;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
    public void setPlate(String plate) {
         if (plate == null || plate.isBlank())
            throw new IllegalArgumentException("La placa no puede estar vacía");
        this.plate = plate;
    }

    public void setBrand(String brand) {
        if (brand == null || brand.isBlank())
            throw new IllegalArgumentException("La marca no puede estar vacía");
        this.brand = brand;
    }

    public void setModel(String model) {
         if (model == null || model.isBlank())
            throw new IllegalArgumentException("El modelo no puede estar vacío");
        this.model = model;
    }

    public void setYear(int year) {
        int actual = Year.now().getValue();
        if (year > actual) 
            throw new IllegalArgumentException("El año no puede ser mayor al actual");
        if (actual - year > 20) 
            throw new IllegalArgumentException("El vehículo no puede tener más de 20 años");
        this.year = year;
    }

 
    
    public Vehicule(String plate, String brand, String model, int year, Types type, Status status) {
        this.plate = plate;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.type = type;
        this.status = status;
    }
    
    
    
}
