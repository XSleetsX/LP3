package EXP04;

public class ControladorReserva {

    public void gestionarServicio(ServicioHabitacion habitacion) {
        if (habitacion instanceof ServicioLimpieza) {
            ((ServicioLimpieza) habitacion).solicitarLimpieza();
        }
        if (habitacion instanceof ServicioComida) {
            ((ServicioComida) habitacion).solicitarComida();
        }
        if (habitacion instanceof ServicioLavanderia) {
            ((ServicioLavanderia) habitacion).solicitarLavanderia();
        }

        if (habitacion instanceof HabitacionEstandar) {
            System.out.println("Monto pagado por la habitación estándar: " +
                ((HabitacionEstandar) habitacion).getMontoPagado());
        } else if (habitacion instanceof HabitacionSuite) {
            System.out.println("Monto pagado por la suite: " +
                ((HabitacionSuite) habitacion).getMontoPagado());
        }
    }
}
