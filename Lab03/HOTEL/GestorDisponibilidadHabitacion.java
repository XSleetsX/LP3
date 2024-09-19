package HOTEL;
public class GestorDisponibilidadHabitacion {
	//Atributos
	private Habitacion habitacion;
	
	//Constructor
	public GestorDisponibilidadHabitacion (Habitacion habitacion) {
		this.habitacion = habitacion;
	}
	
	//Métodos
	public void estaDisponible(Habitacion habitacion) {
		if (habitacion.getDisponible() == true) {
			System.out.println("La habitación N° " + habitacion.getNumero() + " está disponible.");
		} else {
			System.out.println("La habitación N° " + habitacion.getNumero() + " no está disponible.");
		}
	}
}
