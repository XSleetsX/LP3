package EXP03;

public class SaldoInsuficienteException extends RuntimeException {
    private static final long serialVersionUID = 1L; // Identificador de versión

    public SaldoInsuficienteException(String mensaje) {
        super(mensaje);
    }
}
