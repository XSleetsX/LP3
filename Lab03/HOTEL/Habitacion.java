package HOTEL;

public class Habitacion {
    // Atributos
    private int numero;
    private boolean disponible;
    private double precio_base;
    private GestorDisponibilidadHabitacion gdh;

    // Constructor
    public Habitacion(int numero, boolean disponible, double precio_base, GestorDisponibilidadHabitacion gdh) {
        this.numero = numero;
        this.disponible = disponible; // Se usará el valor proporcionado
        this.precio_base = precio_base;
        this.gdh = gdh;
    }

    // Setters
    public void setNumero(int numero) { this.numero = numero; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
    public void setPrecioBase(double precio_base) { this.precio_base = precio_base; }

    // Getters
    public int getNumero() { return numero; }
    public boolean getDisponible() { return disponible; }
    public double getPrecioBase() { return precio_base; }

    // Métodos
    public void verificarDisponibilidad() {
        if (gdh != null) {
            gdh.estaDisponible(this);
        } else {
            System.out.println("El gestor de disponibilidad no está inicializado.");
        }
    }
}
