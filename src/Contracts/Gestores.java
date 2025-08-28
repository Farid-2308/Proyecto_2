/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Contracts;

import java.util.ArrayList;

/**
 *
 * @author Farid
 */
public class Gestores {
     private ArrayList<RentalContract> contracts = new ArrayList<>();

    public void add(RentalContract contract) {
        contracts.add(contract);
    }

    public RentalContract search(String id) {
        for (RentalContract c : contracts) {
            if (c.getContractId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    public void remove(String id) {
        RentalContract c = search(id);
        if (c != null) {
            contracts.remove(c);
        }
    }

    public ArrayList<RentalContract> list() {
        return contracts;
    }
}
