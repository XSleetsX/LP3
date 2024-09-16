package EJER06;

public class TransaccionInmobiliaria {
    private String id;
    private Propiedad propiedad;
    private double precioTransaccion;

    public TransaccionInmobiliaria(String id, Propiedad propiedad, double precioTransaccion) throws PrecioInferiorException {
        if (precioTransaccion < propiedad.getPrecio()) {
            throw new PrecioInferiorException("El precio de la transacción no puede ser menor que el precio de la propiedad.");
        }
        this.id = id;
        this.propiedad = propiedad;
        this.precioTransaccion = precioTransaccion;
    }

    // Getters y setters
    public String getId() {
        return id;
    }

    public Propiedad getPropiedad() {
        return propiedad;
    }

    public double getPrecioTransaccion() {
        return precioTransaccion;
    }
}
