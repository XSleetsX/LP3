package HOTEL;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PoliticaCancelacionModerada implements PoliticaCancelacionIntercace{
	@Override
	public boolean puedeCancelar(Reserva reserva) {
		LocalDate ahora = LocalDate.now();
		long dias = ChronoUnit.DAYS.between(reserva.getFechaInicio(), ahora);
		if (dias < 72) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public double calcularPenalizacion(Reserva reserva) {
		return reserva.getMontoTotal() * 0.5;
	}
}
