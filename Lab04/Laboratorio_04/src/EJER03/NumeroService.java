package EJER03;

import java.util.Scanner;

public class NumeroService {

    private Scanner scanner;

    public NumeroService() {
        this.scanner = new Scanner(System.in);
    }

    // Método para leer el número ingresado por el usuario
    public double leerNumero() {
        System.out.print("Por favor, ingrese un número: ");
        // Manejo de errores de entrada incorrecta
        while (!scanner.hasNextDouble()) {
            System.out.println("Entrada inválida. Por favor, ingrese un número válido.");
            scanner.next(); // Limpiar la entrada incorrecta
        }
        return scanner.nextDouble();
    }

    // Método para procesar el número y manejar excepciones
    public void procesarNumero() {
        double valor = leerNumero(); // Leer el valor ingresado
        try {
            Numero numero = new Numero(valor);
            System.out.println("El valor del número es: " + numero.getValor());
        } catch (NumeroNegativoException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
