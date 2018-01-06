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

	/**
	 * Muestra la siguiente Persona en ser atendida
	 * 
	 * @return la siguiente Persona que será atendida
	 * 
	 * @pre.condition {@code haySiguiente()}
	 * @throws IllegalStateException si {@code !haySiguiente()}
	 */
	public Persona siguiente() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Coloca a colado delante del primer reservador, el cual considere amigo al colado.
	 * 
	 * @param colado, Persona que va a ser colada
	 * 
	 * @pre.condition {@code colado != null}
	 * @pre.condition {@code !esReservador(colado)}
	 * @pre.condition {@code puedeColarse(colado)}
	 * @post.condition {@code estaEnCola(colado)}
	 * @post.condition {@code cuantosPuedeColar(reservador_de_colado) == @pre.cuantosPuedeColar(reservador_de_colado)-1}
	 * @throws IllegalArgumentException si {@code colado == null}
	 * @throws IllegalStateException si {@code esReservador(colado)}
	 * @throws IllegalStateException si {@code !puedeColarse(colado)} 
	 */
	public void colarA(Persona colado) {
		// TODO Auto-generated method stub
		
	}

	
	/**
	 * Devuelve si queda alguna Persona o no en la cola para ser atendido.
	 * 
	 * @return true si queda al menos uno en la cola. False en caso contrario
	 */
	public boolean haySiguiente() {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean esReservador(Persona p1) {
		// TODO Auto-generated method stub
		return false;
	}
}
