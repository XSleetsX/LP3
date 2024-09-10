package EXP05;

public class EnviadorSMS implements CanalNotificacion {
    @Override
    public void enviarNotificacion(String mensaje, String remitente, String destinatario) {
        System.out.println("Enviando SMS desde " + remitente + " a " + destinatario + ": " + mensaje);
    }
}