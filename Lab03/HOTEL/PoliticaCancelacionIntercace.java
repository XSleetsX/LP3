package HOTEL;

public interface PoliticaCancelacionIntercace {
    boolean puedeCancelar(Reserva reserva);
    double calcularPenalizacion(Reserva reserva);
}
