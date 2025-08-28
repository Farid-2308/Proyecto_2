/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Managments;
import ClientManagers.ClientManager;
import Managments.excepciones.ReservaEnUsoException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Queue;

public class ReservationManager {

    private Queue<Reservation> reservationQueue;
    private ClientManager clientManager;
    private VehiculeManager vehiculeManager;
    private static int reservationCounter = 0;

    public ReservationManager(ClientManager clientManager, VehiculeManager vehiculeManager) {
        this.reservationQueue = new LinkedList<>();
        this.clientManager = clientManager;
        this.vehiculeManager = vehiculeManager;
        
    }

    public void addReservation(Reservation reservation) throws Exception {
        validateReservation(reservation);
        reservationQueue.add(reservation);
    }
    
    public Reservation searchReservation(String id) {
        for (Reservation reservation : reservationQueue) {
            if (reservation.getId().equals(id)) {
                return reservation;
            }
        }
        return null;
    }

    public void cancelReservation(String id) throws ReservaEnUsoException {
        Reservation reservation = searchReservation(id);
        if (reservation != null) {
            if (reservation.getStartDate().isBefore(LocalDate.now())) {
                throw new ReservaEnUsoException("No se puede cancelar una reserva que ya ha iniciado.");
            }
            reservationQueue.remove(reservation);
        }
    }
    
    public Reservation confirmReservation(String id) {
        Reservation reservation = searchReservation(id);
        if (reservation != null) {
            reservationQueue.remove(reservation); 
            return reservation;
        }
        return null;
    }

    private void validateReservation(Reservation reservation) throws Exception {
        if (clientManager.searchClient(reservation.getClientId()) == null) {
            throw new Exception("El cliente no está registrado.");
        }
        if (vehiculeManager.SearchVehicule(reservation.getVehiclePlate()) == null) {
            throw new Exception("El vehículo no está registrado.");
        }
        if (reservation.getStartDate().isBefore(LocalDate.now())) {
            throw new Exception("La fecha de inicio no puede ser menor a la fecha actual.");
        }
        if (reservation.getEndDate().isBefore(reservation.getStartDate())) {
            throw new Exception("La fecha de finalización debe ser posterior a la de inicio.");
        }
        long duration = java.time.temporal.ChronoUnit.DAYS.between(reservation.getStartDate(), reservation.getEndDate());
        if (duration > 30) {
            throw new Exception("La duración de la reserva no puede ser mayor a 30 días.");
        }
        if (!isVehiculeAvailable(reservation.getVehiclePlate(), reservation.getStartDate(), reservation.getEndDate())) {
            throw new Exception("El vehículo ya tiene una reserva activa en ese rango de fechas.");
        }
    }
    
    private boolean isVehiculeAvailable(String plate, LocalDate startDate, LocalDate endDate) {
        for (Reservation reservation : reservationQueue) {
            if (reservation.getVehiclePlate().equals(plate)) {
                if (!(endDate.isBefore(reservation.getStartDate()) || startDate.isAfter(reservation.getEndDate()))) {
                    return false;
                }
            }
        }
        return true;
    }
    public Reservation crear(String clientId, Types vehicleType, LocalDate startDate, LocalDate endDate) throws Exception {
    Vehicule availableVehicle = vehiculeManager.findAvailableVehiculeByType(vehicleType);
    if (availableVehicle == null) {
        throw new Exception("No hay vehículos disponibles del tipo solicitado.");
    }
     reservationCounter++;
    String reservationId = "RES-" + reservationCounter; 
    
    Reservation reservation = new Reservation(reservationId, clientId, availableVehicle.getPlate(), startDate, endDate);
    
    
    addReservation(reservation);
    availableVehicle.setStatus(Status.EN_ALQUILER);
    return reservation;
}

public void cancelar(String id) throws ReservaEnUsoException {
    cancelReservation(id);
    
    Reservation reservation = searchReservation(id);
    if (reservation != null) {
        Vehicule vehicule = vehiculeManager.SearchVehicule(reservation.getVehiclePlate());
        if (vehicule != null) {
            vehicule.setStatus(Status.DISPONIBLE);
        }
    }
}

public void modificarVehiculo(String idReserva, Types nuevoTipo) throws Exception {
    Reservation r = searchReservation(idReserva);
    if (r == null) {
        throw new Exception("Reserva no encontrada.");
    }
    
    Vehicule oldVehicle = vehiculeManager.SearchVehicule(r.getVehiclePlate());
    if (oldVehicle != null) {
        oldVehicle.setStatus(Status.DISPONIBLE);
    }

    Vehicule newVehicle = vehiculeManager.findAvailableVehiculeByType(nuevoTipo);
    if (newVehicle == null) {
        throw new Exception("No hay vehículos disponibles del nuevo tipo solicitado.");
    }
    r.setVehiclePlate(newVehicle.getPlate());
    newVehicle.setStatus(Status.EN_ALQUILER);
}
}
