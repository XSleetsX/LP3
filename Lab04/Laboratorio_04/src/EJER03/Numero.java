package EJER03;

public class Numero {
    private double valor;

    public Numero(double valor) {
        setValor(valor); // Validación al instanciar un objeto
    }

    public double getValor() {
        return valor;
    }

    // SRP: Este método es responsable solo de asignar un valor válido.
    public void setValor(double valor) {
        if (valor < 0) {
            throw new NumeroNegativoException("El valor no puede ser negativo: " + valor);
        }
        this.valor = valor;
    }
}
