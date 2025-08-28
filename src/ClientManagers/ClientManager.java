/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClientManagers;

import Persons.Client;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 *
 * @author mathy
 */
public class ClientManager {
    private ArrayList<Client> clients = new ArrayList<>();

    private boolean isValidEmail(String email) {
        return Pattern.matches("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,6}$", email);
    }

    private boolean isValidPhone(String phone) {
        return phone.matches("^[2678][0-9]{7}$");
    }

    public void addClient(Client c) throws Exception {
        for (Client existing : clients) {
            if (existing.getId().equals(c.getId())) {
                throw new Exception("Ya existe un cliente con la misma cedula");
            }
        }
        if (c.getAge() < 18) throw new Exception("El cliente debe ser mayor de edad");
        if (!isValidEmail(c.getEmail())) throw new Exception("formato de correo invalido");
        if (!isValidPhone(c.getPhone())) throw new Exception("El telefono debe ser de 8 digitos");
        if (!isValidLicense(c.getLicense())) {
            throw new Exception("La licencia debe tener 9 dígitos numéricos");
        }

        clients.add(c);
    }

    public Client searchClient(String id) {
        for (Client c : clients) {
            if (c.getId().equals(id)) 
                return c;
        }
        return null;
    }

    public void updateClient(String id, String phone, String email, String license) {
        Client c = searchClient(id);
        if (c != null) {
            c.setPhone(phone);
            c.setEmail(email);
            c.setLicense(license);
        }
    }
    
    private boolean isValidLicense(String license) {
    return license != null && license.matches("\\d{9}");
}

    public void removeClient(String id) {
        clients.removeIf(c -> c.getId().equals(id));
    }

    public ArrayList<Client> getClients() { 
        return clients;
    }
}
