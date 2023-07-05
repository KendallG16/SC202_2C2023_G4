/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.modulo1;
import javax.swing.JOptionPane;

/**
 *
 * @author kenda
 */
public class APP {

    public static void main(String[] args) {
        
        Medicos[] medicosArray = new Medicos[5];

        for (int i = 0; i < 5; i++) {
            Medicos medico = new Medicos();
            medico.setNombreMedico(JOptionPane.showInputDialog(null, "Ingrese el nombre del médico " + (i + 1) + ":"));
            medico.setHoraAlmuerzo(JOptionPane.showInputDialog(null, "Ingrese la hora de almuerzo para el médico " + medico.getNombreMedico() + ":"));
            medico.setEspecialidad(JOptionPane.showInputDialog(null, "Ingrese la especialidad del médico " + medico.getNombreMedico() + ":"));
            medicosArray[i] = medico;
        }

        for (int i = 0; i < 5; i++) {
            Medicos medico = medicosArray[i];
            System.out.println("Detalles del médico " + (i + 1) + ":");
            System.out.println("Nombre: " + medico.getNombreMedico());
            System.out.println("Hora de almuerzo: " + medico.getHoraAlmuerzo());
            System.out.println("Especialidad: " + medico.getEspecialidad());
            System.out.println();
        }
            boolean salir = false;
        while (!salir) {
             String[] opciones = {"Administracion de personal", "Reservacion de espacios", "Devolucion de espacios", "Revision de agendas", "Salir"};
                int opcionSeleccionada = JOptionPane.showOptionDialog(
                null,
                "Seleccione una opción:",
                "Menú Principal",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                opciones,
                opciones[0]);

                switch (opcionSeleccionada) {
                    case 0 -> JOptionPane.showMessageDialog(null, "Has seleccionado la Opción 1");
                    case 1 -> JOptionPane.showMessageDialog(null, "Has seleccionado la Opción 2");
                    case 2 -> JOptionPane.showMessageDialog(null, "Has seleccionado la Opción 3");
                    case 3 -> JOptionPane.showMessageDialog(null, "Has seleccionado la Opción 4");
                    case 4 -> salir = true;
                    default -> salir = true;
        }
    }
    }       
}

