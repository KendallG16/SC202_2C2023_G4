import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
    Medicos[] medicosArray = new Medicos[5];
    Medicos medico = new Medicos();
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
                boolean salirmod1 = false;
                while(!salirmod1){
                String[] opcionesmod1 = {"Registrar medicos", "Ver informacion de medicos","Atras"};
                int opcionmod1 = JOptionPane.showOptionDialog(null,"Seleccione una opción:","Menú de administracion de personal",JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE,null,opcionesmod1,opcionesmod1[0]);
                if (opcionmod1 == 0){
                for (int i = 0; i < 5; i++) {
                medico.nombreMedico = JOptionPane.showInputDialog(null, "Ingrese el nombre del médico " + (i + 1) + ":");
                medico.horaAlmuerzo = JOptionPane.showInputDialog(null, "Ingrese la hora de almuerzo para el médico " + medico.nombreMedico + ":");
                medico.especialidad = JOptionPane.showInputDialog(null, "Ingrese la especialidad del médico " + medico.nombreMedico + ":");
                medicosArray[i] = medico;}
                 }else if (opcionmod1 == 1){
                   for (int i = 0; i < 5; i++) {
                   JOptionPane.showMessageDialog(null, "Detalles del médico " + (i + 1) + ":" + "\nNombre: " + medico.nombreMedico + "\nHora de almuerzo: " + medico.horaAlmuerzo + "\nEspecialidad: " + medico.especialidad);
                   }
                 }else{
                    salirmod1 = true;
                 }
              }
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Has seleccionado la Opción 2");
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Has seleccionado la Opción 3");
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

