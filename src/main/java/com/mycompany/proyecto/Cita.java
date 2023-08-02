/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;
import java.util.List;
import com.mycompany.proyecto.App;

/**
 *
 * @author JAZ
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

    public String asignarMedico(Medicos[] lista) {
        String nombre = "";
        
    for (int i = 0; i < 4; i++){
        if(lista[i].getEspecialidad()==servicio) {
         nombre = lista[i].getNombreMedico();
        }
     }
        return nombre; 
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
    
    public static boolean eliminarcita(List<Cita> cita1, String cliente){
        boolean citaeliminada = cita1.removeIf(cita -> cita.getCliente().equals(cliente));
        return citaeliminada;
    }
    
    
    
    
}
