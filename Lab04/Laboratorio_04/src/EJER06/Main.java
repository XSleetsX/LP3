package EJER06;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Propiedad propiedad = null;
        TransaccionInmobiliaria transaccion = null;
        ContratoAlquiler contrato = null;
        HistorialDePagos pago = null;

        // Ingresar propiedad
        do {
            try {
                System.out.print("Ingrese la dirección de la propiedad: ");
                String direccion = scanner.nextLine().trim();
                if (direccion.isEmpty()) {
                    throw new DatosInvalidosException("La dirección no puede estar vacía.");
                }

                System.out.print("Ingrese el precio de la propiedad: ");
                double precioPropiedad = Double.parseDouble(scanner.nextLine().trim());
                if (precioPropiedad <= 0) {
                    throw new DatosInvalidosException("El precio de la propiedad debe ser mayor a cero.");
                }

                System.out.print("Ingrese el tamaño de la propiedad: ");
                double tamaño = Double.parseDouble(scanner.nextLine().trim());
                if (tamaño <= 0) {
                    throw new DatosInvalidosException("El tamaño de la propiedad debe ser mayor a cero.");
                }

                propiedad = new Propiedad(direccion, precioPropiedad, tamaño);
                break; // Salir del ciclo si los datos son válidos
            } catch (DatosInvalidosException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido.");
            }
        } while (true);

        // Ingresar transacción
        do {
            try {
                System.out.print("Ingrese el ID de la transacción: ");
                String idTransaccion = scanner.nextLine().trim();
                if (idTransaccion.isEmpty()) {
                    throw new DatosInvalidosException("El ID de la transacción no puede estar vacío.");
                }

                System.out.print("Ingrese el precio de la transacción: ");
                double precioTransaccion = Double.parseDouble(scanner.nextLine().trim());
                if (precioTransaccion <= 0) {
                    throw new DatosInvalidosException("El precio de la transacción debe ser mayor a cero.");
                }

                if (precioTransaccion < propiedad.getPrecio()) {
                    throw new PrecioInferiorException("El precio de la transacción no puede ser menor que el precio de la propiedad.");
                }

                transaccion = new TransaccionInmobiliaria(idTransaccion, propiedad, precioTransaccion);
                break; // Salir del ciclo si los datos son válidos
            } catch (DatosInvalidosException | PrecioInferiorException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido.");
            }
        } while (true);

        // Ingresar contrato de alquiler
        do {
            try {
                System.out.print("Ingrese la duración del contrato (meses): ");
                int duracionMeses = Integer.parseInt(scanner.nextLine().trim());
                if (duracionMeses <= 0) {
                    throw new ContratoInvalidoException("La duración del contrato debe ser mayor a cero.");
                }

                System.out.print("Ingrese el monto del alquiler: ");
                double montoAlquiler = Double.parseDouble(scanner.nextLine().trim());
                if (montoAlquiler <= 0) {
                    throw new ContratoInvalidoException("El monto del alquiler debe ser mayor a cero.");
                }

                if (montoAlquiler > propiedad.getPrecio()) {
                    throw new ContratoInvalidoException("El monto del alquiler no puede ser mayor que el precio de la propiedad.");
                }

                contrato = new ContratoAlquiler(duracionMeses, montoAlquiler);
                break; // Salir del ciclo si los datos son válidos
            } catch (ContratoInvalidoException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido.");
            }
        } while (true);

        // Ingresar pago
        do {
            try {
                System.out.print("Ingrese la fecha del pago (AAAA-MM-DD): ");
                String fechaPagoStr = scanner.nextLine().trim();
                LocalDate fechaPago = LocalDate.parse(fechaPagoStr); // Validar el formato de fecha

                System.out.print("Ingrese el monto del pago: ");
                double montoPago = Double.parseDouble(scanner.nextLine().trim());
                if (montoPago <= 0) {
                    throw new PagoInvalidoException("El monto del pago debe ser mayor a cero.");
                }

                if (fechaPago.isAfter(LocalDate.now())) {
                    throw new PagoInvalidoException("La fecha del pago no puede ser una fecha futura.");
                }

                pago = new HistorialDePagos(fechaPago, montoPago);
                break; // Salir del ciclo si los datos son válidos
            } catch (PagoInvalidoException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (DateTimeParseException e) {
                System.out.println("Error: El formato de la fecha es incorrecto. Use AAAA-MM-DD.");
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido.");
            }
        } while (true);

        System.out.println("Transacción, contrato y pagos registrados exitosamente.");
        scanner.close();
    }
}

