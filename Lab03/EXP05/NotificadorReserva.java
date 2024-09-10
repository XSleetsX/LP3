package EXP05;

public class NotificadorReserva {
    private CanalNotificacion canalNotificacion;

    public NotificadorReserva(CanalNotificacion canalNotificacion) {
        this.canalNotificacion = canalNotificacion;
    }

    public void notificar(String mensaje, String remitente, String destinatario) {
        canalNotificacion.enviarNotificacion(mensaje, remitente, destinatario);
    }
}