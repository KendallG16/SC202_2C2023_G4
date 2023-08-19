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
    private String[][][] calendario;
    
    
    public Medicos(String nombreMedico, String especialidad, String horaAlmuerzo, String[][][] calendario) {
        this.NombreMedico = nombreMedico;
        this.Especialidad = especialidad;
        this.HoraAlmuerzo = horaAlmuerzo;
        inicializarCalendario(calendario);

    }

    public Medicos() {
    } 

    public void hacerCita(Cita cita, int mes, String dia, int horas) {
    int numeroMes = obtenerNumeroMes(mes);
    int numeroDia = obtenerNumeroDia(dia);

    for (int hora = 0; hora < calendario[numeroMes][numeroDia].length; hora++) {
        if (calendario[numeroMes][numeroDia][hora] == null) {
            if (horas == 0) {
                break;
            }
            calendario[numeroMes][numeroDia][hora] = cita.getCliente();
            horas--;
        }
    }
    if (horas > 0) {
        JOptionPane.showMessageDialog(null, "No hay espacio disponible para la cita.");
    }
}

    private int obtenerNumeroMes(int mes) {
        return 0;
    }
    
    private int obtenerNumeroDia(String dia) {
        return 0;
    }
    
    public void inicializarCalendario(String[][][] calendario) {
    String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    
    for (int mes = 0; mes < calendario.length; mes++) {
        for (int dia = 0; dia < calendario[mes].length; dia++) {
            for (int hora = 0; hora < calendario[mes][dia].length; hora++) {
                if (hora == 0 && dia == 0) {
                    calendario[mes][dia][hora] = meses[mes];
                    } 
                else {
                    calendario[mes][dia][hora] = null;
                    }
                }
            }
        }
    }
    
    public static void IngresarDetalles(Medicos[] medicosArray, String[][][] calendario){
        String[] especialidades = {"Cirugía General", "Medicina General", "Cirugía Especializada"};

        for (int i = 0; i < 5; i++) {
            Medicos medico = new Medicos();
            medico.setNombreMedico(JOptionPane.showInputDialog(null, "Ingrese el nombre del médico " + (i + 1) + ":"));
            medico.setHoraAlmuerzo(JOptionPane.showInputDialog(null, "Ingrese la hora de almuerzo para el médico " + medico.getNombreMedico() + ":"));
            medico.setCalendario(calendario, medico); // Asignar el calendario después de haber creado la instancia
            medicosArray[i] = medico;
         }
    
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
    
    public static void setCalendario(String[][][] calendario, Medicos medico) {
    medico.calendario = calendario; 
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
    
    public static void consultarAgenda(Medicos[] medicosArray) {
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
                            agenda += "Mes: " + (mes + 1) + ", Día: " + (dia + 1) + ", Hora: " + hora + ":00 - Cliente: " + medicoCalendario[mes][dia][hora] + "\n";
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
    public String[] getHorasDisponibles(int mes, String dia) {
    int mesIndex = obtenerNumeroMes(mes);
    int diaIndex = obtenerNumeroDia(dia);

    String[] horasDisponibles = new String[calendario[mesIndex][diaIndex].length];
    int contadorHoras = 0;

    for (int hora = 0; hora < calendario[mesIndex][diaIndex].length; hora++) {
        int horaReal = hora + 8;
        if (horaReal <= 18 && calendario[mesIndex][diaIndex][hora] == null) {
            horasDisponibles[contadorHoras] = String.valueOf(horaReal);
            contadorHoras++;
        }
    }

    String[] horasFinales = new String[contadorHoras];
    for (int i = 0; i < contadorHoras; i++) {
        horasFinales[i] = horasDisponibles[i];
    }

    return horasFinales;
}
}
