package HOTEL;

public class HabitacionLujo05 extends HabitacionLujo implements ServicioComida, ServicioLavanderia, ServicioLimpieza {
    private boolean minibarDisponible;
    private boolean accesoVIP;

    public HabitacionLujo05(int numero, boolean disponible, double precio_base, GestorDisponibilidadHabitacion gdh, double tarifaServicioAdicional, boolean minibarDisponible, boolean accesoVIP) {
        super(numero, disponible, precio_base, gdh, tarifaServicioAdicional);
        this.minibarDisponible = minibarDisponible;
        this.accesoVIP = accesoVIP;
    }

    @Override
    public double getPrecioBase() {
        double precioTotal = super.getPrecioBase();
        if (minibarDisponible) {
            precioTotal += 50; // Ejemplo de tarifa adicional para minibar
        }
        if (accesoVIP) {
            precioTotal += 100; // Ejemplo de tarifa adicional para acceso VIP
        }
        return precioTotal;
    }

    public boolean isMinibarDisponible() {
        return minibarDisponible;
    }

    public void setMinibarDisponible(boolean minibarDisponible) {
        this.minibarDisponible = minibarDisponible;
    }

    public boolean isAccesoVIP() {
        return accesoVIP;
    }

    public void setAccesoVIP(boolean accesoVIP) {
        this.accesoVIP = accesoVIP;
    }

    @Override
    public void verificarDisponibilidad() {
        super.verificarDisponibilidad();
        System.out.println("Servicios adicionales:");
        if (minibarDisponible) {
            System.out.println("- Minibar disponible.");
        }
        if (accesoVIP) {
            System.out.println("- Acceso VIP disponible.");
        }
    }

    @Override
    public void solicitarComida() {
        System.out.println("Comida solicitada en la habitación de lujo.");
    }

    @Override
    public void solicitarLavanderia() {
        System.out.println("Servicio de lavandería solicitado para la habitación de lujo.");
    }

    @Override
    public void solicitarLimpieza() {
        System.out.println("Servicio de limpieza solicitado para la habitación de lujo.");
    }
}

