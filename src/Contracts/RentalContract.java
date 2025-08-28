/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Contracts;

import java.time.LocalDate;

/**
 *
 * @author Farid
 */
public class RentalContract {
    private String contractId;
    private String clientId;
    private String vehiclePlate;
    private LocalDate startDate;
    private LocalDate endDate;
    private double dailyRate;
    private double totalAmount;
    private EstadoContrato status;

    public String getContractId() {
        return contractId;
    }

    public String getClientId() {
        return clientId;
    }

    public String getVehiclePlate() {
        return vehiclePlate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public EstadoContrato getStatus() {
        return status;
    }
    
    public RentalContract(String contractId, String clientId, String vehiclePlate,LocalDate startDate, LocalDate endDate, double dailyRate) {
        this.contractId = contractId;
        this.clientId = clientId;
        this.vehiclePlate = vehiclePlate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dailyRate = dailyRate;

        int days = calculateDays(startDate, endDate);
        this.totalAmount = days * dailyRate;
        this.status = EstadoContrato.ACTIVO;
    }

    public void finalizeContract(){
        if (status != EstadoContrato.ACTIVO) throw new IllegalStateException("Solo contratos activos pueden ser finalizados");
        this.status = EstadoContrato.FINALIZADO;
    }


    public void cancelContract(){
        if (status == EstadoContrato.FINALIZADO) throw new IllegalStateException("No se puede cancelar un contrato ya finalizado");
        this.status = EstadoContrato.CANCELADO;
    }


    private int calculateDays(LocalDate start, LocalDate end) {
        int startDays = start.getYear() * 365 + start.getMonthValue() * 30 + start.getDayOfMonth();
        int endDays = end.getYear() * 365 + end.getMonthValue() * 30 + end.getDayOfMonth();
        

        int days = endDays - startDays;
        if (days <= 0) {
            return 1;
        } else {
            return days;
        }
    }

    @Override
    public String toString(){
        return "Contract #"+contractId+" Client:"+clientId+" Vehicle:"+vehiclePlate+" Status:"+status+" Amount:"+totalAmount;
    }
}
