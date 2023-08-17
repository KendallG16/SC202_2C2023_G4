/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

import java.util.Random;

/**
 *
 * @author kenda
 */

import javax.swing.JOptionPane;

public class Medicos {


    private String NombreMedico = "";
    private String Especialidad = "";
    private String HoraAlmuerzo = "";
    private String[][][] calendario = new String[12][30][8]; // Calendario para cada médico

    public Medicos(String nombreMedico, String especialidad, String horaAlmuerzo) {
        this.NombreMedico = nombreMedico;
        this.Especialidad = especialidad;
        this.HoraAlmuerzo = horaAlmuerzo;
        inicializarCalendario();
    }

    public Medicos() {
    } 

    public void hacerCita(Cita cita) {
        int mes = obtenerNumeroMes(cita.getDia()); // Implementa obtenerNumeroMes según tu necesidad
        int dia = obtenerNumeroMes(cita.getDia()); // Implementa obtenerNumeroDia según tu necesidad
        int horas = cita.getHoras();

        for (int hora = 0; hora < calendario[mes][dia].length; hora++) {
            if (calendario[mes][dia][hora] == null) {
                if (horas == 0) {
                    break;
                }
                calendario[mes][dia][hora] = cita.getCliente();
                horas--;
            }
        }
        if (horas > 0) {
            JOptionPane.showMessageDialog(null, "No hay espacio disponible para la cita.");
        }
    }

    private int obtenerNumeroMes(String dia) {
        return 0;
    }
    

    public void inicializarCalendario() {
        for (int mes = 0; mes < calendario.length; mes++) {
            for (int dia = 0; dia < calendario[mes].length; dia++) {
                for (int hora = 0; hora < calendario[mes][dia].length; hora++) {
                    calendario[mes][dia][hora] = null;
                }
            }
        }
    }

    public static void IngresarDetalles(Medicos[] medicosArray) {
        for (int i = 0; i < 5; i++) {
            Medicos medico = new Medicos();
            medico.setNombreMedico(JOptionPane.showInputDialog(null, "Ingrese el nombre del médico " + (i + 1) + ":"));
            medico.setHoraAlmuerzo(JOptionPane.showInputDialog(null, "Ingrese la hora de almuerzo para el médico " + medico.getNombreMedico() + ":"));
            medicosArray[i] = medico;
        }
    
        String[] especialidades = {"Cirugía General", "Dermatología", "Pediatría"};

        for (int i = 0; i < especialidades.length; i++) {
            medicosArray[i].setEspecialidad(especialidades[i]);
        }
    
        Random random = new Random();
        for (int i = especialidades.length; i < medicosArray.length; i++) {
            int randomIndex = random.nextInt(especialidades.length);
            medicosArray[i].setEspecialidad(especialidades[randomIndex]);
        }
    }
    public static void Consulta(Medicos[] medicosArray){
        String personal = "";
        for (int i = 0; i < 5; i++) {
            personal += "Medico: " + medicosArray[i].getNombreMedico() + "\n";
            personal += "Especialidad: " + medicosArray[i].getEspecialidad() + "\n";
            }
        JOptionPane.showMessageDialog(null, "Nuestro personal es:\n" + personal);
    }
    
    public void setNombreMedico(String NombreMedico){
        this.NombreMedico = NombreMedico;
    }       

    public String getNombreMedico(){
        return NombreMedico;
    }
    public void setEspecialidad(String Especialidad){
        this.Especialidad = Especialidad;
    }       

    public String getEspecialidad(){
        return Especialidad;
    }

    public String[][][] getCalendario(){
        return calendario;
    }
    
    public void setHoraAlmuerzo(String HoraAlmuerzo){
        this.HoraAlmuerzo = HoraAlmuerzo;
    }       

    public String getHoraAlmuerzo(){
        return HoraAlmuerzo;
    }

    public static String asignarMedico(Medicos[] medicosArray) {
        return null;
    }
public void consultarAgenda(Medicos[] medicosArray) {
    String nombreMedicoConsulta = JOptionPane.showInputDialog(null, "Ingrese el nombre del médico para consultar su agenda:");
    boolean encontrado = false;

    for (int i = 0; i < medicosArray.length; i++) {
        Medicos medico = medicosArray[i];
        if (medico.getNombreMedico().equalsIgnoreCase(nombreMedicoConsulta)) {
            encontrado = true;
            String[][][] medicoCalendario = medico.getCalendario();
            String agenda = "Agenda de " + medico.getNombreMedico() + ":\n";

            for (int mes = 0; mes < medicoCalendario.length; mes++) {
                for (int dia = 0; dia < medicoCalendario[mes].length; dia++) {
                    for (int hora = 0; hora < medicoCalendario[mes][dia].length; hora++) {
                        if (medicoCalendario[mes][dia][hora] != null) {
                            agenda += "Mes: " + mes + ", Día: " + dia + ", Hora: " + hora + ":00 - Cliente: " + medicoCalendario[mes][dia][hora] + "\n";
                        }
                    }
                }
            }

            if (agenda.equals("Agenda de " + medico.getNombreMedico() + ":\n")) {
                agenda += "No hay citas en la agenda.";
            }

            JOptionPane.showMessageDialog(null, agenda);
            break;
        }
    }

    if (!encontrado) {
        JOptionPane.showMessageDialog(null, "Médico no encontrado.");
    }
}
   
}
