package com.mycompany.app;

public class Medicos {

    private String NombreMedico = "";
    private String Especialidad = "";
    private String HoraAlmuerzo = "";
   
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

    public void setHoraAlmuerzo(String HoraAlmuerzo){
        this.HoraAlmuerzo = HoraAlmuerzo;
    }       

    public String getHoraAlmuerzo(){
        return HoraAlmuerzo;
    }
   
}