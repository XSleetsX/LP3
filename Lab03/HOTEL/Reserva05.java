package HOTEL;

import java.time.LocalDate;

public class Reserva05 extends Reserva {
    public Reserva05(LocalDate fechaFinal, double montoTotal, PoliticaCancelacion polcan, Habitacion habitacion, GestorCancelacionReserva gestorCancelacionReserva05) {
        super(fechaFinal, montoTotal, polcan, habitacion, gestorCancelacionReserva05);
    }

    @Override
    public void cancelarReserva() {
        super.cancelarReserva();
        notificarUsuario();
    }

    private void notificarUsuario() {
        System.out.println("Se ha enviado un correo electrónico confirmando la cancelación de su reserva.");
    }

    public void confirmarReserva() {
        System.out.println("La reserva ha sido confirmada para la habitación número " + getHabitacion().getNumero() +
                           " desde " + getFechaInicio() + " hasta " + getFechaFinal() + ".");
        notificarConfirmacion();
    }

    private void notificarConfirmacion() {
        System.out.println("Se ha enviado un correo electrónico con los detalles de su reserva.");
    }
}
