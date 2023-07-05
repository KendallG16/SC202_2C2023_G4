package com.mycompany.modulo1;

import java.util.Random;

public class Reservacion {
    private int codigo;
    private int numerocliente;
    private String nombrecliente;
    private String fechacliente;
    private String servicio;
    private int precioentresemana;
    private int preciofinde;

    public Reservacion() {
        Random random = new Random();
        codigo = random.nextInt(1000000) + 1;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getNumerocliente() {
        return numerocliente;
    }

    public void setNumerocliente(int numerocliente) {
        this.numerocliente = numerocliente;
    }

    public String getNombrecliente() {
        return nombrecliente;
    }

    public void setNombrecliente(String nombrecliente) {
        this.nombrecliente = nombrecliente;
    }

    public String getFechacliente() {
        return fechacliente;
    }

    public void setFechacliente(String fechacliente) {
        this.fechacliente = fechacliente;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public int getPrecioentresemana() {
        return precioentresemana;
    }

    public void setPrecioentresemana(int precioentresemana) {
        this.precioentresemana = precioentresemana;
    }

    public int getPreciofinde() {
        return preciofinde;
    }

    public void setPreciofinde(int preciofinde) {
        this.preciofinde = preciofinde;
    }
}

