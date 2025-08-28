/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Managments;

import Managments.excepciones.VehiculoEnUsoException;
import java.util.HashMap;

/**
 *
 * @author Jorge
 */
public class VehiculeManager {

    private HashMap<String, Vehicule> vehicules;

    public VehiculeManager() {
        vehicules = new HashMap<>();
    }

    public void AddVehicule(Vehicule v) {
        if (vehicules.containsKey(v.getPlate())) {
            throw new IllegalArgumentException("Ya existe un vehículo con la misma placa");
        }
        vehicules.put(v.getPlate(), v);
    }

    public Vehicule SearchVehicule(String plate) {
        return vehicules.get(plate); 
    }

    public void UpdateVehicule(String plate, String NewModel, Types NewTipe, Status NewState) {
        Vehicule v = vehicules.get(plate);
        if (v == null) {
            throw new IllegalArgumentException("No se encontró vehículo con placa " + plate);
        }
        if (NewModel != null && !NewModel.isBlank()) {
            v.setModel(NewModel);
        }
        if (NewTipe != null) {
            v.setType(NewTipe);
        }
        if (NewState != null) {
            v.setStatus(NewState);
        }
    }

    public void DeleteVehicule(String placa) throws VehiculoEnUsoException{
        Vehicule v = vehicules.get(placa);
        if (v == null) {
            throw new IllegalArgumentException("No se encontró vehículo con placa " + placa);
        }
        if (v.getStatus().equals("En alquiler")) {
            throw new IllegalStateException("No se puede eliminar un vehículo que está en alquiler");
        }
        vehicules.remove(placa);
    }

}
