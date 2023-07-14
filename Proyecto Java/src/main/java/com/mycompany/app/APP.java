/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.app;
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
            medicosArray[i] = medico;
        }

        String[] especialidades = {"Cirugía General", "Ginecología", "Neurología", "Dermatología", "Pediatría"};

        for (int i = 0; i < especialidades.length; i++) {
            Medicos medico = medicosArray[i];
            medico.setEspecialidad(especialidades[i]);
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
                case 0:
                    String personal = "";
                    for (int i = 0; i < 5; i++) {
                        personal += "Medico: " + medicosArray[i].getNombreMedico() + "\n";
                        personal += "Especialidad: " + medicosArray[i].getEspecialidad() + "\n";
                    }
                    JOptionPane.showMessageDialog(null, "Nuestro personal es:\n" + personal);
                    break;
                case 1:
                    String cliente = JOptionPane.showInputDialog(null, "Ingrese el nombre del cliente:");
                    String telefono = JOptionPane.showInputDialog(null, "Ingrese el teléfono del cliente:");

                    String[] diasSemana = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
                    String dia = (String) JOptionPane.showInputDialog(null, "Seleccione el día de la cita:",
                        "Seleccionar Día", JOptionPane.QUESTION_MESSAGE, null, diasSemana, diasSemana[0]);

                    String[] serviciosMedicos = {"Cirugía General", "Ginecología", "Neurología", "Dermatología", "Pediatría"};
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
                    break;
                case 2:
                        boolean reservaEliminada = false;       
                        String nombreClienteEliminar = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
                        String medicoEliminar = JOptionPane.showInputDialog("Ingrese el médico que lo iba a atender:");
                        String FechaClienteEliminar = JOptionPane.showInputDialog("Ingrese el día de atención:");
                        if (nombreClienteEliminar.equals(cliente.getNombrecliente()) && medicoEliminar.equals(medico.getNombreMedico())
                                && FechaClienteEliminar.equals(cliente.getFechacliente())) {
                          cliente.setBorrarCliente();
                                
                            reservaEliminada = true;
                                
                            JOptionPane.showMessageDialog(null, "Reserva eliminada exitosamente.");
                        } else {
                            JOptionPane.showMessageDialog(null, "No se encontró ninguna reserva con esos datos.");
                        }

                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Has seleccionado la Opción 4");
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    salir = true;
                    break;
        }
    }
    }       
}
