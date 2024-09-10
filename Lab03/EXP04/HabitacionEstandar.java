package EXP04;

import java.util.Scanner;

public class HabitacionEstandar implements ServicioLimpieza {
    private double montoPagado;

    public HabitacionEstandar(double montoPagado) {
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
        System.out.println("Limpieza solicitada para la habitación estándar.");
    }

    public static HabitacionEstandar crearHabitacion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el monto pagado por la habitación estándar:");
        double monto = scanner.nextDouble();
        return new HabitacionEstandar(monto);
    }
}
