package HOTEL;

public class NotificadorSlack implements CanalNotificacion {
    @Override
    public void enviarNotificacion(String mensaje, String remitente, String destinatario) {
        System.out.println("Enviando mensaje de Slack desde " + remitente + " a " + destinatario + ": " + mensaje);
    }
}
