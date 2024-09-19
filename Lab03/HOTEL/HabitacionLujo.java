package HOTEL;

public class HabitacionLujo extends Habitacion {
    private double tarifaServicioAdicional;

    public HabitacionLujo(int numero, boolean disponible, double precio_base, GestorDisponibilidadHabitacion gdh, double tarifaServicioAdicional) {
        super(numero, disponible, precio_base, gdh);
        this.tarifaServicioAdicional = tarifaServicioAdicional;
    }

    @Override
    public double getPrecioBase() {
        return super.getPrecioBase() + tarifaServicioAdicional;
    }

    public double getTarifaServicioAdicional() {
        return tarifaServicioAdicional;
    }
}
