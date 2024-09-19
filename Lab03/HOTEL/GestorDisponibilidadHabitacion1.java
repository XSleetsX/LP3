package HOTEL;

public class GestorDisponibilidadHabitacion1 {

    // Método para verificar la disponibilidad de una habitación
    public void estaDisponible(Habitacion habitacion) {
        if (habitacion == null) {
            System.out.println("La habitación proporcionada es nula.");
            return;
        }

        // Comprobamos la disponibilidad de la habitación
        if (habitacion.getDisponible()) {
            System.out.println("La habitación N° " + habitacion.getNumero() + " está disponible.");
        } else {
            System.out.println("La habitación N° " + habitacion.getNumero() + " no está disponible.");
        }
    }
}
