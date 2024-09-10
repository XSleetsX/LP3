package EXP05;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione el canal de notificación:");
        System.out.println("1. Enviar por correo electrónico");
        System.out.println("2. Enviar por SMS");
        System.out.println("3. Enviar por Slack");

        int opcion = scanner.nextInt();
        scanner.nextLine();  

        CanalNotificacion canal;

        switch (opcion) {
            case 1:
                canal = new EnviadorCorreo();
                break;
            case 2:
                canal = new EnviadorSMS();
                break;
            case 3:
                canal = new NotificadorSlack();
                break;
            default:
                System.out.println("Opción no válida. Usando correo por defecto.");
                canal = new EnviadorCorreo();
        }

        NotificadorReserva notificador = new NotificadorReserva(canal);

        System.out.println("Ingrese el remitente:");
        String remitente = scanner.nextLine();

        System.out.println("Ingrese el destinatario:");
        String destinatario = scanner.nextLine();

        System.out.println("Ingrese el mensaje de la reserva:");
        String mensaje = scanner.nextLine();

        notificador.notificar(mensaje, remitente, destinatario);

        System.out.println("Mensaje enviado con éxito.");

        scanner.close();
    }
}
