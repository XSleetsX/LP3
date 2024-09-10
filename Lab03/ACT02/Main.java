package ACT02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmailNotification emailNotification = new EmailNotification();
        SMSNotification smsNotification = new SMSNotification();
        int option;

       do {
            System.out.println("\nIngrese el mensaje que desea enviar (o ingrese '0' para salir):");
            String message = scanner.nextLine();

            if (message.equals("0")) {
                System.out.println("Saliendo...");
                break;
            }

            System.out.println("Seleccione el método de envío:");
            System.out.println("1. Enviar por correo electrónico");
            System.out.println("2. Enviar por SMS");
            System.out.println("0. Salir");
            option = scanner.nextInt();  

            scanner.nextLine();

            switch (option) {
                case 1:
                    emailNotification.sendEmail(message);
                    break;
                case 2:
                    smsNotification.sendSMS(message);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }

        } while (option != 0);  

        scanner.close();
    }
}
