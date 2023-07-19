/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.modulo1;
import javax.swing.JOptionPane;
import java.util.Random;

/**
 *
 * @author kenda
 */
public class APP {

    public static void main(String[] args) {
        
        Medicos[] medicosArray = new Medicos[5];
<<<<<<< Updated upstream:APP.java
=======
        String[] diasSemana = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        String[] especialidades = {"Cirugía General", "Ginecología", "Neurología", "Dermatología", "Pediatría"};
        String[][] clientes = new String[198][5];
>>>>>>> Stashed changes:Proyecto Java/src/main/java/com/mycompany/app/APP.java

        for (int i = 0; i < 5; i++) {
            Medicos medico = new Medicos();
            medico.setNombreMedico(JOptionPane.showInputDialog(null, "Ingrese el nombre del médico " + (i + 1) + ":"));
            medico.setHoraAlmuerzo(JOptionPane.showInputDialog(null, "Ingrese la hora de almuerzo para el médico " + medico.getNombreMedico() + ":"));
            medico.setEspecialidad(JOptionPane.showInputDialog(null, "Ingrese la especialidad del médico " + medico.getNombreMedico() + ":"));
            medicosArray[i] = medico;
        }

<<<<<<< Updated upstream:APP.java
        for (int i = 0; i < 5; i++) {
            Medicos medico = medicosArray[i];
            System.out.println("Detalles del médico " + (i + 1) + ":");
            System.out.println("Nombre: " + medico.getNombreMedico());
            System.out.println("Hora de almuerzo: " + medico.getHoraAlmuerzo());
            System.out.println("Especialidad: " + medico.getEspecialidad());
            System.out.println();
=======
        for (int i = 0; i < especialidades.length; i++) {
            Medicos medico = medicosArray[i];
            medico.setEspecialidad(especialidades[i]);
>>>>>>> Stashed changes:Proyecto Java/src/main/java/com/mycompany/app/APP.java
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
<<<<<<< Updated upstream:APP.java
                    JOptionPane.showMessageDialog(null, "Has seleccionado la Opción 2");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Has seleccionado la Opción 3");
=======
                    String cliente = JOptionPane.showInputDialog(null, "Ingrese el nombre del cliente:");
                    String telefono = JOptionPane.showInputDialog(null, "Ingrese el teléfono del cliente:");
                    String dia = (String) JOptionPane.showInputDialog(null, "Seleccione el día de la cita:", "Seleccionar Día", JOptionPane.QUESTION_MESSAGE, null, diasSemana, diasSemana[0]);
                    String servicio = (String) JOptionPane.showInputDialog(null, "Seleccione el servicio médico:", "Seleccionar Servicio", JOptionPane.QUESTION_MESSAGE, null, especialidades, especialidades[0]);
                    String hora = JOptionPane.showInputDialog(null, "Ingrese las horas que necesiten:");
                    int horas = Integer.parseInt(hora);
                    String[] datosCita = {cliente, servicio, telefono, dia, hora};
                
                    int columnaVacia = 0;
                    int filaActual = 0;

                    for (int i = 0; i < datosCita.length; i++) {
                        if (columnaVacia + i < clientes[filaActual].length) {
                            clientes[filaActual][columnaVacia + i] = datosCita[i];
                        } else {
                            break; 
                        }
                    }
                    

                    System.out.println("Contenido de la matriz clientes:");
                    for (int columna = 0; columna < clientes[filaActual].length; columna++) {
                        System.out.print(clientes[filaActual][columna] + " ");
                    }
                    System.out.println();
                    break;
                case 2:

>>>>>>> Stashed changes:Proyecto Java/src/main/java/com/mycompany/app/APP.java
                    break;
                case 3:
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    salir = true;
                    break;
            }
<<<<<<< Updated upstream:APP.java
=======
        }
>>>>>>> Stashed changes:Proyecto Java/src/main/java/com/mycompany/app/APP.java
    }
}

