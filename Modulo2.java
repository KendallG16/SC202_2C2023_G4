/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.modulo2;

import javax.swing.JOptionPane;

/**
 *
 * @author joss2
 */
public class Modulo2 {

    public static void main(String[] args) {
        String cliente = JOptionPane.showInputDialog(null, "Ingrese el nombre del cliente:");
        String telefono = JOptionPane.showInputDialog(null, "Ingrese el teléfono del cliente:");

        String[] diasSemana = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        String dia = (String) JOptionPane.showInputDialog(null, "Seleccione el día de la cita:",
                "Seleccionar Día", JOptionPane.QUESTION_MESSAGE, null, diasSemana, diasSemana[0]);

        String[] serviciosMedicos = {"Cirugía General", "Ginecología y Obstetricia", "Neurología", "Dermatología", "Pediatría"};
        String servicio = (String) JOptionPane.showInputDialog(null, "Seleccione el servicio médico:",
                "Seleccionar Servicio", JOptionPane.QUESTION_MESSAGE, null, serviciosMedicos, serviciosMedicos[0]);

        int horas = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de horas necesarias:"));

        Cita cita = new Cita(cliente, telefono, dia, servicio, horas);
        String medico = cita.asignarMedico();
        float precio = cita.calcularPrecio();

        String mensaje = "Reservación de la cita:\n";
        mensaje += "Cliente: " + cita.getCliente() + "\n";
        mensaje += "Teléfono: " + cita.getTelefono() + "\n";
        mensaje += "Día: " + cita.getDia() + "\n";
        mensaje += "Servicio: " + cita.getServicio() + "\n";
        mensaje += "Horas: " + cita.getHoras() + "\n";
        mensaje += "Médico asignado: " + medico + "\n";
        mensaje += "Precio total: " + precio + " colones";

        JOptionPane.showMessageDialog(null, mensaje);
    }
}