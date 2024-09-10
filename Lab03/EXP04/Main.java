package EXP04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ControladorReserva controlador = new ControladorReserva();

        System.out.println("Seleccione el tipo de habitación: \n1. Estándar \n2. Suite");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                HabitacionEstandar habitacionEstandar = HabitacionEstandar.crearHabitacion();
                controlador.gestionarServicio(habitacionEstandar);
                break;

            case 2:
                HabitacionSuite habitacionSuite = HabitacionSuite.crearHabitacion();
                controlador.gestionarServicio(habitacionSuite);
                break;

            default:
                System.out.println("Opción no válida.");
        }

        scanner.close();
    }
}
