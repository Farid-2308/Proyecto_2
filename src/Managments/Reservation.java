/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Managments;

import java.time.LocalDate;

/**
 *
 * @author Jorge
 */
public class Reservation {
    private Client client;
    private Vehicule vehicule;
    private LocalDate StartDate;
    private LocalDate EndDate;
    private boolean confirm;

    public Client getClient() {
        return client;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public LocalDate getStartDate() {
        return StartDate;
    }

    public LocalDate getEndDate() {
        return EndDate;
    }

    public boolean isConfirm() {
        return confirm;
    }

    public void setClient(Client client) {
        if (client == null) throw new IllegalArgumentException("El cliente no puede ser nulo");
        this.client = client;
    }

    public void setVehicule(Vehicule vehicule) {
        if (vehicule == null) throw new IllegalArgumentException("El vehículo no puede ser nulo");
        if (!vehicule.getState().equals("Disponible"))
            throw new IllegalArgumentException("El vehículo no está disponible para reservar");
        this.vehicule = vehicule;
    }

    public void setStartDate(LocalDate StartDate) {
         if (StartDate.isBefore(LocalDate.now()))
            throw new IllegalArgumentException("La fecha de inicio no puede ser anterior a hoy");
        this.StartDate = StartDate;
    }

    public void setEndDate(LocalDate EndDate) {
        if (EndDate.isBefore(StartDate))
            throw new IllegalArgumentException("La fecha de fin debe ser posterior a la de inicio");
        this.EndDate = EndDate;
    }

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }

    public Reservation(Client client, Vehicule vehicule, LocalDate StartDate, LocalDate EndDate, boolean confirm) {
        this.client = client;
        this.vehicule = vehicule;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
        this.confirm = confirm;
    }
    
    
    
}
