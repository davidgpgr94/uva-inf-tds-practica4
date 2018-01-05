package es.uva.inf.tds.practica4_davidgo;

/**
 * 
 * @author davidgo
 *
 */
public class ColaDeAmigos {

	/**
	 * Crea un objeto ColaDeAmigos que representa una cola en la que se debe
	 * pedir la vez para entrar y en la que se puede reservar sitio para un
	 * grupo de amigos.
	 */
	public ColaDeAmigos() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Añade a reservador al final de la cola y reserva sitio delante de él para los nAmigos
	 * 
	 * @param reservador, Persona que pide la vez en la cola
	 * @param nAmigos, número de amigos para los que reservador ha reservador sitio
	 * 
	 * @pre.condition {@code reservador != null}
	 * @pre.condition {@code nAmigos >= 0 && nAmigos < 11}
	 * @pre.condition {@code !esReservador(reservador)}
	 * @pre.condition {@code !estaEnCola(reservador)}
	 * @post.condition {@code esReservador(reservador)}
	 * @post.condition {@code estaEnCola(reservador)}
	 * @throws IllegalArgumentException si {@code reservador == null}
	 * @throws IllegalArgumentException si {@code nAmigos < 0 || nAmigos > 10}
	 * @throws IllegalStateException si {@code esReservador(reservador)}
	 * @throws IllegalStateException si {@code estaEnCola(reservador)}
	 */
	public void pedirVez(Persona reservador, int nAmigos) {
		// TODO Auto-generated method stub
		
	}

	public Persona siguiente() {
		// TODO Auto-generated method stub
		return null;
	}

	public void colarA(Persona p2) {
		// TODO Auto-generated method stub
		
	}
}
