/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto;
import javax.swing.JOptionPane;

/**
 *
 * @author kenda
 */
public class Proyecto {

    public static void main(String[] args) {
        
        String[][][] calendario = new String[12][30][10];

        
        Medicos[] medicosArray = new Medicos[5];
        
        Medicos.IngresarDetalles(medicosArray, calendario);

        boolean salir = false;
            
        while (!salir) {
             String[] opciones = {"Administracion de personal", "Reservacion de espacios", "Devolucion de espacios", "Consultar Citas","Consultar agenda de los medicos", "Salir"};
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
                    Medicos.Consulta(medicosArray);
                    break;
                case 1:
                    Cita.hacerCita(medicosArray);
                    break;
                case 2:
                    Cita.cancelarCita(medicosArray);
                    break;
                case 3:
                    Cita.hacerConsulta(medicosArray);

                    break;
                case 4:
                    Medicos.consultarAgenda(medicosArray);

                    break;
                case 5:
                    salir = true;
                    break;
                default:
                 
                    salir = true;
                    break;
        }
    }
    }       
    
}
