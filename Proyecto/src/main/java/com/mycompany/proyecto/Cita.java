/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

import javax.swing.JOptionPane;

/**
 *
 * @author kenda
 */
public class Cita {

    private String cliente;
    private String telefono;
    private String dia;
    private String servicio;
    private int horas;

    public Cita(String cliente, String telefono, String dia, String servicio, int horas) {
        this.cliente = cliente;
        this.telefono = telefono;
        this.dia = dia;
        this.servicio = servicio;
        this.horas = horas;
    }

    
    
    public static void hacerCita(Medicos[] medicosArray) {
        String cliente = JOptionPane.showInputDialog(null, "Ingrese el nombre del cliente:");
        String telefono = JOptionPane.showInputDialog(null, "Ingrese el teléfono del cliente:");
    
        String[] diasSemana = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        String dia = (String) JOptionPane.showInputDialog(null, "Seleccione el día de la cita:",
            "Seleccionar Día", JOptionPane.QUESTION_MESSAGE, null, diasSemana, diasSemana[0]);
    
        String[] serviciosMedicos = {"Cirugía General", "Dermatología", "Pediatría"};
        String servicio = (String) JOptionPane.showInputDialog(null, "Seleccione el servicio médico:",
            "Seleccionar Servicio", JOptionPane.QUESTION_MESSAGE, null, serviciosMedicos, serviciosMedicos[0]);

        int horas = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de horas necesarias:"));

        Cita cita = new Cita(cliente, telefono, dia, servicio, horas);
        String medicoAsignado = cita.asignarMedico(medicosArray, servicio);
        float precioTotal = cita.calcularPrecio();

        for (Medicos medico : medicosArray) {
            if (medico.getNombreMedico().equalsIgnoreCase(medicoAsignado)) {
                medico.hacerCita(cita); // Agregar la cita al calendario del médico
                break;
            }
        }

        String mensaje = "Reservación de la cita:\n";
        mensaje += "Cliente: " + cita.getCliente() + "\n";
        mensaje += "Teléfono: " + cita.getTelefono() + "\n";
        mensaje += "Día: " + cita.getDia() + "\n";
        mensaje += "Servicio: " + cita.getServicio() + "\n";
        mensaje += "Horas: " + cita.getHoras() + "\n";
        mensaje += "Médico asignado: " + medicoAsignado + "\n";
        mensaje += "Precio total: " + precioTotal + " colones";
    
        JOptionPane.showMessageDialog(null, mensaje);
    }
    private static String obtenerDiaSemana(int indice) {
        String[] diasSemana = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        return diasSemana[indice];
    }
    public static void hacerConsulta(Medicos[] medicosArray) {
    String nombreCliente = JOptionPane.showInputDialog(null, "Ingrese el nombre del cliente:");
    
    String mensajeConsulta = "";
    boolean seEncontroCita = false;

    for (Medicos medico : medicosArray) {
        String[][][] calendario = medico.getCalendario();
        
        for (int mes = 0; mes < calendario.length; mes++) {
            for (int dia = 0; dia < calendario[mes].length; dia++) {
                for (int hora = 0; hora < calendario[mes][dia].length; hora++) {
                    if (calendario[mes][dia][hora] != null && calendario[mes][dia][hora].equals(nombreCliente)) {
                        seEncontroCita = true;

                        mensajeConsulta += "Médico: " + medico.getNombreMedico() + "\n";
                        mensajeConsulta += "Día: " + obtenerDiaSemana(dia) + "\n";
                        mensajeConsulta += "Hora: " + hora + ":00\n";

                        break;
                    }
                }
                if (seEncontroCita) {
                    break;
                }
            }
            if (seEncontroCita) {
                break;
            }
        }
    }

    if (seEncontroCita) {
        JOptionPane.showMessageDialog(null, "Consulta:\n" + mensajeConsulta);
    } else {
        JOptionPane.showMessageDialog(null, "No se encontró una cita para el cliente.");
    }
}

    public static void cancelarCita(Medicos[] medicosArray) {
        String nombreCliente = JOptionPane.showInputDialog(null, "Ingrese el nombre del cliente cuya cita desea cancelar:");
        boolean seCanceloCita = false;

        for (Medicos medico : medicosArray) {
            String[][][] calendario = medico.getCalendario();
            
            for (int mes = 0; mes < calendario.length; mes++) {
                for (int dia = 0; dia < calendario[mes].length; dia++) {
                    for (int hora = 0; hora < calendario[mes][dia].length; hora++) {
                        if (calendario[mes][dia][hora] != null && calendario[mes][dia][hora].equals(nombreCliente)) {
                            calendario[mes][dia][hora] = null;
                            seCanceloCita = true;
                            break;
                        }
                    }
                    if (seCanceloCita) {
                        break;
                    }
                }
                if (seCanceloCita) {
                    break;
                }
            }
            if (seCanceloCita) {
                break;
            }
        }

        if (seCanceloCita) {
            JOptionPane.showMessageDialog(null, "La cita para el cliente " + nombreCliente + " ha sido cancelada.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró una cita para el cliente " + nombreCliente + ".");
        }
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public String asignarMedico(Medicos[] medicosArray, String especialidad) {
        for (int i = 0; i < medicosArray.length; i++) {
            if (medicosArray[i].getEspecialidad().equalsIgnoreCase(especialidad)) {
                return medicosArray[i].getNombreMedico();
            }
        }
        return "Médico no disponible para esta especialidad";
    }


    public float calcularPrecio() {
        float precio = 0;
        if (dia.equalsIgnoreCase("Sábado") || dia.equalsIgnoreCase("Domingo")) {
            precio = horas * 40000;
        } else {
            precio = horas * 25000;
        }
        float iva = precio * 0.13f;
        return precio + iva;
    }
}

