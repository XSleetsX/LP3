package EXP03;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Banco banco = new Banco(); // Usa Banco para gestionar cuentas

            CuentaCredito cuentaCredito = null;

            // Validación de datos para la creación de la cuenta
            boolean cuentaCreada = false;
            while (!cuentaCreada) {
                try {
                    System.out.println("Ingrese el número de cuenta (10 dígitos):");
                    String numeroCuenta = scanner.nextLine();
                    while (numeroCuenta.length() != 10 || !numeroCuenta.matches("\\d+")) {
                        System.out.println("Número de cuenta inválido. Debe tener 10 dígitos.");
                        numeroCuenta = scanner.nextLine();
                    }

                    System.out.println("Ingrese el nombre del titular (no vacío):");
                    String titular = scanner.nextLine();
                    while (titular.trim().isEmpty()) {
                        System.out.println("El nombre del titular no puede estar vacío.");
                        titular = scanner.nextLine();
                    }

                    double saldo = obtenerNumeroDouble(scanner, "Ingrese el saldo inicial:");
                    double limiteCredito = obtenerNumeroDouble(scanner, "Ingrese el límite de crédito:");

                    cuentaCredito = new CuentaCredito(numeroCuenta, titular, saldo, limiteCredito);
                    banco.agregarCuenta(cuentaCredito); // Agrega cuenta al banco
                    System.out.println("Cuenta creada con éxito.");
                    cuentaCreada = true;

                } catch (IllegalArgumentException e) {
                    System.out.println("Error al crear la cuenta: " + e.getMessage());
                    return;
                }
            }

            boolean continuar = true;

            while (continuar) {
                try {
                    System.out.println("\n--- MENÚ ---");
                    System.out.println("1. Consultar saldo");
                    System.out.println("2. Retirar dinero");
                    System.out.println("3. Transferir dinero");
                    System.out.println("4. Generar reporte de transacciones");
                    System.out.println("5. Salir");
                    System.out.print("Seleccione una opción: ");
                    int opcion = scanner.nextInt();

                    switch (opcion) {
                        case 1:
                            System.out.println("Saldo actual: " + cuentaCredito.getSaldo());
                            break;
                        case 2:
                            double montoRetiro = obtenerNumeroDouble(scanner, "Ingrese el monto a retirar:");
                            try {
                                cuentaCredito.retirar(montoRetiro);
                                System.out.println("Retiro exitoso. Saldo actual: " + cuentaCredito.getSaldo());
                            } catch (LimiteCreditoExcedidoException e) {
                                System.out.println("Error en el retiro: " + e.getMessage());
                            }
                            break;
                        case 3:
                            double montoTransferencia = obtenerNumeroDouble(scanner, "Ingrese el monto a transferir:");
                            scanner.nextLine(); // Limpiar el buffer después de nextDouble()
                            System.out.print("Ingrese el número de cuenta destino: ");
                            String numeroCuentaDestino = scanner.nextLine();
                            try {
                                CuentaBancaria cuentaDestino = banco.buscarCuenta(numeroCuentaDestino);
                                cuentaCredito.transferir(cuentaDestino, montoTransferencia);
                                System.out.println("Transferencia exitosa.");
                            } catch (CuentaNoEncontradaException e) {
                                System.out.println("Error en la transferencia: " + e.getMessage());
                            } catch (LimiteCreditoExcedidoException e) {
                                System.out.println("Error en la transferencia: " + e.getMessage());
                            }
                            break;
                        case 4:
                            try {
                                cuentaCredito.generarReporteTransacciones();
                            } catch (HistorialVacioException e) {
                                System.out.println("Error al generar el reporte: " + e.getMessage());
                            }
                            break;
                        case 5:
                            continuar = false;
                            System.out.println("Saliendo del sistema.");
                            break;
                        default:
                            System.out.println("Opción no válida.");
                            break;
                    }
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                    scanner.nextLine(); // Limpiar el buffer en caso de error
                }
            }
        }
    }

    private static double obtenerNumeroDouble(Scanner scanner, String mensaje) {
        double numero = 0;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.println(mensaje);
                numero = scanner.nextDouble();
                if (numero < 0) {
                    System.out.println("El valor debe ser mayor o igual a cero.");
                } else {
                    valido = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Debe ingresar un número.");
                scanner.next(); // Limpiar el buffer del scanner
            }
        }
        return numero;
    }
}
