package HOTEL;


public class PoliticaCancelacionEstricta implements PoliticaCancelacionIntercace{
	@Override
	public boolean puedeCancelar(Reserva reserva) {
		return false;
	}
	
	@Override
	public double calcularPenalizacion(Reserva reserva) {
		return reserva.getMontoTotal();
	}
}
