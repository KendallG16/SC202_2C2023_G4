/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author JAZ
 */
public class App {

    public static void main(String[] args) {
        
        Medicos[] medicosArray = new Medicos[5];
        String[] diasSemana = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        String[] especialidades = {"Cirugía General", "Ginecología", "Neurología", "Dermatología", "Pediatría"};
        String[][] clientes = new String[4][198];
        List<Cita> citasList = new ArrayList<>();

        
        for (int i = 0; i < 5; i++) {
            Medicos medico = new Medicos();
            medico.setNombreMedico(JOptionPane.showInputDialog(null, "Ingrese el nombre del médico " + (i + 1) + ":"));
            medico.setHoraAlmuerzo(JOptionPane.showInputDialog(null, "Ingrese la hora de almuerzo para el médico " + medico.getNombreMedico() + ":"));
            medicosArray[i] = medico;
        }

        for (int i = 0; i < especialidades.length; i++) {
            Medicos medico = medicosArray[i];
            medico.setEspecialidad(especialidades[i]);
        }

            boolean salir = false;
        while (!salir) {
             String[] opciones = {"Consulta de personal ", "Agendar cita", "Devolucion de espacios", "Revision de agendas","Salir"};
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
                    String dia = (String) JOptionPane.showInputDialog(null, "Seleccione el día de la cita:", "Seleccionar Día", JOptionPane.QUESTION_MESSAGE, null, diasSemana, diasSemana[0]);
                    String servicio = (String) JOptionPane.showInputDialog(null, "Seleccione el servicio médico:","Seleccionar Servicio", JOptionPane.QUESTION_MESSAGE, null, especialidades, especialidades[0]);

                    int horas = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de horas necesarias:"));

                    Cita cita = new Cita(cliente, telefono, dia, servicio, horas);
                    String medico = cita.asignarMedico(medicosArray);
                    float precio = cita.calcularPrecio();
                    citasList.add(cita);


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
                    String clienteeliminar = JOptionPane.showInputDialog(null, "Ingrese el nombre del cliente a liminar su cita:");
                    boolean resultado = Cita.eliminarcita(citasList, clienteeliminar);
                    if (resultado == true){
                        JOptionPane.showMessageDialog(null, "La cita se ha eliminado correctamente.");
                    }else{
                        JOptionPane.showMessageDialog(null, "No se ha encontrado la Cita programada");
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
