package EXP03;

public class LimiteCreditoExcedidoException extends RuntimeException {
    private static final long serialVersionUID = 1L; // Identificador de versión

    public LimiteCreditoExcedidoException(String mensaje) {
        super(mensaje);
    }
}
