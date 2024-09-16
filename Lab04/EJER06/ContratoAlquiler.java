package EJER06;

public class ContratoAlquiler {
    private int duracionMeses;
    private double montoAlquiler;

    public ContratoAlquiler(int duracionMeses, double montoAlquiler) throws ContratoInvalidoException {
        if (duracionMeses <= 0 || montoAlquiler <= 0) {
            throw new ContratoInvalidoException("La duración del contrato debe ser positiva y el monto de alquiler debe ser mayor que cero.");
        }
        this.duracionMeses = duracionMeses;
        this.montoAlquiler = montoAlquiler;
    }

    // Getters y setters
    public int getDuracionMeses() {
        return duracionMeses;
    }

    public double getMontoAlquiler() {
        return montoAlquiler;
    }
}
