package HOTEL;

public class GestorCancelacionReserva {
    private PoliticaCancelacion polcan;
    
    public GestorCancelacionReserva(PoliticaCancelacion polcan) {
        this.polcan = polcan;
    }
    
    public void cancelar(Reserva reserva) {
        if (polcan == PoliticaCancelacion.NO_REEMBOLSABLE) {
            // Lógica para política no reembolsable
            System.out.println("Cancelación según política no reembolsable.");
        } else if (polcan == PoliticaCancelacion.REEMBOLSABLE) {
            // Lógica para política reembolsable
            double penalizacion = 0.0; // Implementar la lógica para penalización
            System.out.println("Cancelado exitosamente. Con penalización de: " + penalizacion);
            System.out.println("Monto total a pagar: " + (penalizacion + reserva.getMontoTotal()));
        } else {
            System.out.println("No se puede cancelar esta reserva según la política.");
        }
    }
}

