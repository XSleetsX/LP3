package HOTEL;

import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al sistema de gestión de reservas del hotel.");

        int tipoHabitacion;
        do {
            System.out.println("Seleccione el tipo de habitación: \n1. Estándar \n2. Suite \n3. Lujo");
            tipoHabitacion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            if (tipoHabitacion < 1 || tipoHabitacion > 3) {
                System.out.println("Opción no válida. Por favor, seleccione una opción del 1 al 3.");
            }
        } while (tipoHabitacion < 1 || tipoHabitacion > 3);

        Habitacion habitacion = null;
        GestorDisponibilidadHabitacion gestor = new GestorDisponibilidadHabitacion(habitacion); // Instanciar gestor una vez

        switch (tipoHabitacion) {
            case 1:
                String tipoCama;
                do {
                    System.out.print("Ingrese el tipo de cama (Individual/Doble): ");
                    tipoCama = scanner.nextLine();
                    if (!tipoCama.equalsIgnoreCase("Individual") && !tipoCama.equalsIgnoreCase("Doble")) {
                        System.out.println("Tipo de cama no válido. Por favor, ingrese 'Individual' o 'Doble'.");
                    }
                } while (!tipoCama.equalsIgnoreCase("Individual") && !tipoCama.equalsIgnoreCase("Doble"));

                habitacion = new HabitacionEstandar04(1, true, 100.0, gestor, tipoCama);
                break;

            case 2:
                boolean jacuzziDisponible;
                String jacuzziInput;
                do {
                    System.out.print("¿Desea jacuzzi disponible? (Si/No): ");
                    jacuzziInput = scanner.nextLine();
                    if (!jacuzziInput.equalsIgnoreCase("Si") && !jacuzziInput.equalsIgnoreCase("No")) {
                        System.out.println("Entrada no válida. Ingrese 'Sí' o 'No'.");
                    }
                } while (!jacuzziInput.equalsIgnoreCase("Sí") && !jacuzziInput.equalsIgnoreCase("No"));
                jacuzziDisponible = jacuzziInput.equalsIgnoreCase("Sí");
                habitacion = new HabitacionSuite04(2, true, 200.0, gestor, jacuzziDisponible);
                break;

            case 3:
                boolean minibarDisponible;
                boolean accesoVIP;
                String minibarInput;
                String accesoVIPInput;

                do {
                    System.out.print("¿Minibar disponible? (Si/No): ");
                    minibarInput = scanner.nextLine();
                    if (!minibarInput.equalsIgnoreCase("Si") && !minibarInput.equalsIgnoreCase("No")) {
                        System.out.println("Entrada no válida. Ingrese 'Sí' o 'No'.");
                    }
                } while (!minibarInput.equalsIgnoreCase("Si") && !minibarInput.equalsIgnoreCase("No"));
                minibarDisponible = minibarInput.equalsIgnoreCase("Sí");

                do {
                    System.out.print("¿Acceso VIP? (Sí/No): ");
                    accesoVIPInput = scanner.nextLine();
                    if (!accesoVIPInput.equalsIgnoreCase("Si") && !accesoVIPInput.equalsIgnoreCase("No")) {
                        System.out.println("Entrada no válida. Ingrese 'Sí' o 'No'.");
                    }
                } while (!accesoVIPInput.equalsIgnoreCase("Si") && !accesoVIPInput.equalsIgnoreCase("No"));
                accesoVIP = accesoVIPInput.equalsIgnoreCase("Si");

                habitacion = new HabitacionLujo05(3, true, 300.0, gestor, 50.0, minibarDisponible, accesoVIP);
                break;
        }

        // Solicitar servicios adicionales
        boolean solicitarComida;
        boolean solicitarLavanderia;
        boolean solicitarLimpieza;

        do {
            System.out.println("¿Desea solicitar comida? (Si/No): ");
            solicitarComida = scanner.nextLine().equalsIgnoreCase("Si");
        } while (!scanner.nextLine().equalsIgnoreCase("Si") && !scanner.nextLine().equalsIgnoreCase("No"));

        do {
            System.out.println("¿Desea solicitar lavandería? (Si/No): ");
            solicitarLavanderia = scanner.nextLine().equalsIgnoreCase("Si");
        } while (!scanner.nextLine().equalsIgnoreCase("Si") && !scanner.nextLine().equalsIgnoreCase("No"));

        do {
            System.out.println("¿Desea solicitar limpieza? (Si/No): ");
            solicitarLimpieza = scanner.nextLine().equalsIgnoreCase("Si");
        } while (!scanner.nextLine().equalsIgnoreCase("Si") && !scanner.nextLine().equalsIgnoreCase("No"));

        if (solicitarComida && habitacion instanceof ServicioComida) {
            ((ServicioComida) habitacion).solicitarComida();
        }

        if (solicitarLavanderia && habitacion instanceof ServicioLavanderia) {
            ((ServicioLavanderia) habitacion).solicitarLavanderia();
        }

        if (solicitarLimpieza && habitacion instanceof ServicioLimpieza) {
            ((ServicioLimpieza) habitacion).solicitarLimpieza();
        }

        // Datos de la reserva
        LocalDate fechaFinal;
        do {
            System.out.print("Ingrese la fecha final de la reserva (YYYY-MM-DD): ");
            String fechaFinalStr = scanner.nextLine();
            try {
                fechaFinal = LocalDate.parse(fechaFinalStr);
                break;
            } catch (Exception e) {
                System.out.println("Fecha no válida. Intente de nuevo.");
            }
        } while (true);

        double montoTotal;
        do {
            System.out.print("Ingrese el monto total de la reserva: ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Monto no válido. Ingrese un número.");
                scanner.next(); // Limpiar la entrada inválida
            }
            montoTotal = scanner.nextDouble();
            scanner.nextLine(); // Consumir el salto de línea
            if (montoTotal < 0) {
                System.out.println("El monto no puede ser negativo. Intente de nuevo.");
            } else {
                break;
            }
        } while (true);

        int politicaCancelacion;
        do {
            System.out.println("Seleccione la política de cancelación: \n1. No reembolsable \n2. Reembolsable");
            politicaCancelacion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            if (politicaCancelacion < 1 || politicaCancelacion > 2) {
                System.out.println("Opción no válida. Seleccione 1 o 2.");
            }
        } while (politicaCancelacion < 1 || politicaCancelacion > 2);

        PoliticaCancelacion polcan = (politicaCancelacion == 1)
            ? PoliticaCancelacion.NO_REEMBOLSABLE
            : PoliticaCancelacion.REEMBOLSABLE;

        int canalNotificacion;
        do {
            System.out.println("Ingrese el tipo de canal de notificación: \n1. Correo \n2. SMS \n3. Slack");
            canalNotificacion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            if (canalNotificacion < 1 || canalNotificacion > 3) {
                System.out.println("Opción no válida. Seleccione una opción del 1 al 3.");
            }
        } while (canalNotificacion < 1 || canalNotificacion > 3);

        CanalNotificacion canal = null;
        switch (canalNotificacion) {
            case 1:
                canal = new EnviadorCorreo();
                break;
            case 2:
                canal = new EnviadorSMS();
                break;
            case 3:
                canal = new NotificadorSlack();
                break;
        }

        NotificadorReserva notificador = new NotificadorReserva(canal);

        // Datos del mensaje
        System.out.print("Ingrese el nombre del receptor del mensaje: ");
        String receptor = scanner.nextLine();
        System.out.print("Ingrese el mensaje a enviar: ");
        String mensaje = scanner.nextLine();

        // Crear y gestionar la reserva
        Reserva05 reserva = new Reserva05(fechaFinal, montoTotal, polcan, habitacion, new GestorCancelacionReserva(polcan));
        reserva.confirmarReserva();
        reserva.cancelarReserva();

        // Enviar el mensaje
        notificador.notificar("HOTEL", receptor, mensaje);

        System.out.println("Reserva gestionada exitosamente.");
    }
}



