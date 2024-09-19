package HOTEL;

public class HabitacionSuite04 extends HabitacionSuite implements ServicioComida, ServicioLimpieza {
    public HabitacionSuite04(int numero, boolean disponible, double precio_base, GestorDisponibilidadHabitacion gdh, boolean jacuzziDisponible) {
        super(numero, disponible, precio_base, gdh, jacuzziDisponible);
    }

    @Override
    public void verificarDisponibilidad() {
        super.verificarDisponibilidad();
        if (tieneJacuzzi()) {
            System.out.println("Esta habitación tiene jacuzzi disponible.");
        } else {
            System.out.println("El jacuzzi no está disponible.");
        }
    }

    @Override
    public void solicitarComida() {
        System.out.println("Comida solicitada en la habitación suite.");
    }

    @Override
    public void solicitarLimpieza() {
        System.out.println("Servicio de limpieza solicitado para la habitación suite.");
    }
}
