package EJER06;

import java.time.LocalDate;

public class HistorialDePagos {
    private LocalDate fechaPago;
    private double montoPago;

    public HistorialDePagos(LocalDate fechaPago, double montoPago) throws PagoInvalidoException {
        if (montoPago <= 0) {
            throw new PagoInvalidoException("El monto del pago debe ser positivo.");
        }
        if (fechaPago.isAfter(LocalDate.now())) {
            throw new PagoInvalidoException("La fecha del pago no puede ser futura.");
        }
        this.fechaPago = fechaPago;
        this.montoPago = montoPago;
    }

    // Getters y setters
    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public double getMontoPago() {
        return montoPago;
    }
}
