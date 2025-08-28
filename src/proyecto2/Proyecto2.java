/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto2;

import ClientManagers.ClientManager;
import GUI.FrmClientes;
import GUI.FrmContrato;

/**
 *
 * @author Farid
 */
public class Proyecto2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ClientManager clientManager = new ClientManager();

        java.awt.EventQueue.invokeLater(() -> {
            new FrmClientes(clientManager).setVisible(true);
        });

       FrmContrato contratoForm = new FrmContrato(clientManager);
        contratoForm.setVisible(true);
    }
}
