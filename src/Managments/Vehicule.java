/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Managments;

import java.time.Year;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Jorge
 */
public class Vehicule {
    private String plate;
    private String brand;
    private String model;
    private int year;
    private String tipe;
    private String state;

    
    private static final List<String> VALID_TYPES = Arrays.asList("Sedán", "SUV", "Pick-up");
    
    private static final List<String> VALID_STATES = Arrays.asList("Disponible", "En alquiler", "En mantenimiento");
    
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

    public String getTipe() {
        return tipe;
    }

    public String getState() {
        return state;
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

    public void setTipe(String tipe) {
       if (!VALID_TYPES.contains(tipe))
            throw new IllegalArgumentException("Tipo inválido. Solo se permiten: " + VALID_TYPES);
        this.tipe = tipe;
    }

    public void setState(String state) {
        if (!VALID_STATES.contains(state))
            throw new IllegalArgumentException("Estado inválido. Solo se permiten: " + VALID_STATES);
        this.state = state;
    }

    public Vehicule(String plate, String brand, String model, int year, String tipe, String state) {
        this.plate = plate;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.tipe = tipe;
        this.state = state;
    }
    
    
    
}
