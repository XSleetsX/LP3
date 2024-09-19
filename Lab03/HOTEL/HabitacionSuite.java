package HOTEL;

public class HabitacionSuite extends Habitacion {
    private boolean jacuzziDisponible;

    public HabitacionSuite(int numero, boolean disponible, double precio_base, GestorDisponibilidadHabitacion gdh, boolean jacuzziDisponible) {
        super(numero, disponible, precio_base, gdh);
        this.jacuzziDisponible = jacuzziDisponible;
    }

    public boolean tieneJacuzzi() {
        return jacuzziDisponible;
    }
}
