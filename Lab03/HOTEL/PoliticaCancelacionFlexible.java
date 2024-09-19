package HOTEL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PoliticaCancelacionFlexible implements PoliticaCancelacionIntercace{
	@Override
	public boolean puedeCancelar(Reserva reserva) {
		LocalDate ahora = LocalDate.now();
		long dias = ChronoUnit.DAYS.between(reserva.getFechaInicio(), ahora);
		if (dias < 24) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public double calcularPenalizacion(Reserva reserva) {
		return 0;
	}
}
