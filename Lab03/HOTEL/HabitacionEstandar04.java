package HOTEL;

public class HabitacionEstandar04 extends Habitacion implements ServicioComida, ServicioLimpieza {
    private String tipoCama;

    public HabitacionEstandar04(int numero, boolean disponible, double precio_base, GestorDisponibilidadHabitacion gdh, String tipoCama) {
        super(numero, disponible, precio_base, gdh);
        this.tipoCama = tipoCama;
    }

    public String getTipoCama() {
        return tipoCama;
    }

    public void setTipoCama(String tipoCama) {
        this.tipoCama = tipoCama;
    }

    @Override
    public void verificarDisponibilidad() {
        super.verificarDisponibilidad();
        System.out.println("La habitación tiene una cama " + tipoCama + ".");
    }

    @Override
    public void solicitarComida() {
        System.out.println("Comida solicitada en la habitación estándar.");
    }

    @Override
    public void solicitarLimpieza() {
        System.out.println("Servicio de limpieza solicitado para la habitación estándar.");
    }
}

