package EXP05;

public class EnviadorCorreo implements CanalNotificacion {
    @Override
    public void enviarNotificacion(String mensaje, String remitente, String destinatario) {
        System.out.println("Enviando correo desde " + remitente + " a " + destinatario + ": " + mensaje);
    }
}

