package EXP04;

import java.util.Scanner;

public class HabitacionSuite implements ServicioLimpieza, ServicioComida, ServicioLavanderia {
    private double montoPagado;

    public HabitacionSuite(double montoPagado) {
        if (montoPagado <= 0) {
            throw new IllegalArgumentException("El monto pagado debe ser mayor a 0.");
        }
        this.montoPagado = montoPagado;
    }

    public double getMontoPagado() {
        return montoPagado;
    }

    @Override
    public void solicitarLimpieza() {
        System.out.println("Limpieza solicitada para la suite.");
    }

    @Override
    public void solicitarComida() {
        System.out.println("Comida solicitada a la suite.");
    }

    @Override
    public void solicitarLavanderia() {
        System.out.println("Servicio de lavandería solicitado para la suite.");
    }

    public static HabitacionSuite crearHabitacion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el monto pagado por la suite:");
        double monto = scanner.nextDouble();
        return new HabitacionSuite(monto);
    }
}
