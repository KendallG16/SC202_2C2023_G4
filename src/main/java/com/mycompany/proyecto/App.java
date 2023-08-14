/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;


/**
 *
 * @author JAZ
 */
public class App {

    public static void main(String[] args) {
        
        //Inicializacion de variables
        Medicos[] medicosArray = new Medicos[5];
        String[] diasSemana = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        String[] especialidades = {"Cirugía General", "Ginecología", "Neurología", "Dermatología", "Pediatría"};
        String[][] clientes = new String[4][198];
        List<Cita> citasList = new ArrayList<>();
        String mensaje = "";
        

        //Se agrega personal medico
        for (int i = 0; i < 5; i++) {
            boolean continuar = false;
            boolean continuar2 = false;
            Medicos medico = new Medicos();
            //nombre medico
            do { medico.setNombreMedico(JOptionPane.showInputDialog(null, "Ingrese el nombre del médico " + (i + 1) + ":"));
                 String prueba = medico.getNombreMedico();
                       if (!verificarletras(prueba)){
                       JOptionPane.showMessageDialog(null, "Error: El nombre no puede contener numeros o simbolos.", "Error", JOptionPane.ERROR_MESSAGE);
                       } else {continuar = true;}
                    } while(continuar == false);
            //hora almuerzo del medico
            do { medico.setHoraAlmuerzo(JOptionPane.showInputDialog(null, "Ingrese la hora de almuerzo para el médico " + medico.getNombreMedico() + ":"));
                 String hora = medico.getHoraAlmuerzo();
                       if (!validarHora(hora)){
                       JOptionPane.showMessageDialog(null, "Error: El formato de hora no es valido ", "Error", JOptionPane.ERROR_MESSAGE);
                       } else {continuar2 = true;}
                    } while(continuar2 == false);
            
            medicosArray[i] = medico;
        }
        for (int i = 0; i < especialidades.length; i++) { 
            Medicos medico = medicosArray[i];
            medico.setEspecialidad(especialidades[i]);
        }
        
        //Inicio de menu
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

                    String cliente;
                    do { cliente = JOptionPane.showInputDialog(null, "Ingrese el nombre del cliente:");
                       if (!verificarletras(cliente)){
                       JOptionPane.showMessageDialog(null, "Error: El nombre no puede contener numeros o simbolos.", "Error", JOptionPane.ERROR_MESSAGE);
                       }
                    } while(!verificarletras(cliente));
                    
                    String telefono;
                    do {
                         telefono = JOptionPane.showInputDialog(null, "Ingrese el teléfono del cliente:");
                         if (!verificarnumero(telefono)|| telefono.length() == 8) {
                         JOptionPane.showMessageDialog(null, "Error: El número de teléfono debe contener solo números y tener 8 digitos", "Error", JOptionPane.ERROR_MESSAGE);
                           }  
                    } while (!verificarnumero(telefono) || telefono.length() == 8);
                    
                    String dia = (String) JOptionPane.showInputDialog(null, "Seleccione el día de la cita:", "Seleccionar Día", JOptionPane.QUESTION_MESSAGE, null, diasSemana, diasSemana[0]);
                    String servicio = (String) JOptionPane.showInputDialog(null, "Seleccione el servicio médico:","Seleccionar Servicio", JOptionPane.QUESTION_MESSAGE, null, especialidades, especialidades[0]);

                    int horas = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de horas necesarias:"));

                    Cita cita = new Cita(cliente, telefono, dia, servicio, horas);
                    String medico = cita.asignarMedico(medicosArray);
                    float precio = cita.calcularPrecio();
                    citasList.add(cita);


                    mensaje = "Reservación de la cita:\n";
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
                    String clienteeliminar = JOptionPane.showInputDialog(null, "Ingrese el nombre del cliente a eliminar su cita:");
                    boolean resultado = Cita.eliminarcita(citasList, clienteeliminar);
                    if (resultado == true){
                        JOptionPane.showMessageDialog(null, "La cita se ha eliminado correctamente.");
                    }else{
                        JOptionPane.showMessageDialog(null, "No se ha encontrado la Cita programada");
                    }
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, mensaje); 
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
    
    
    //metodos de verificacion
    
        public static boolean verificarnumero (String cadena){
          try {
            Integer.parseInt(cadena);
          return true;
        } catch (NumberFormatException e) {
          return false;
        }
       }
        
        
        public static boolean verificarletras(String cadena2) {
         for (char caracter : cadena2.toCharArray()) {
            if (!Character.isLetter(caracter)) {
                return false;
            }
        }
        return true;
        }
        
        public static boolean validarHora(String hora) {
        SimpleDateFormat formatoHora = new SimpleDateFormat("h:mm");
        formatoHora.setLenient(false);

        try {
            formatoHora.parse(hora);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
        
        
        
        
        
        
        
}
