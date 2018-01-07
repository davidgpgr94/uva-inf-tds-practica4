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

	/**
	 * Devuelve si personaEsperando es uno de los que ha pedido vez o no
	 * 
	 * @param personaEsperando, Persona que se encuentra en la cola y de la que se quiere saber si ha pedido vez o no
	 * @return true en caso de que haya pedido vez. False en caso contrario
	 * 
	 * @pre.condition {@code personaEsperando != null}
	 * @pre.condition {@code estaEnCola(personaEsperando)}
	 * @throws IllegalArgumentException si {@code personaEsperando == null}
	 * @throws IllegalStateException si {@code !estaEnCola(personaEsperando)}
	 */
	public boolean esReservador(Persona personaEsperando) {
		// TODO Auto-generated method stub
		return false;
	}

	
	/**
	 * Devuelve si persona esta en la cola o no
	 * 
	 * @param persona, Persona de la que se quiere saber si esta en la cola o no
	 * @return true si persona está en la cola. False en caso contrario
	 * 
	 * @pre.condition {@code persona != null}
	 * @throws IllegalArgumentException si {@code persona == null}
	 */
	public boolean estaEnCola(Persona persona) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Devuelve si persona puede colarse delante de alguien que le considera
	 * amigo, o no. Una Persona puede colarse si hay alguien en la cola que ha
	 * reservado para algún amigo y dicha persona aún no haya colado tantos
	 * amigos como reservó cuando pidió vez.
	 * 
	 * @param persona, Persona de la que se quiere saber si puede o no colarse
	 * 
	 * @pre.condition {@code persona != null}
	 * @throws IllegalArgumentException si {@code persona == null}
	 * 
	 * @return true si puede colarse, false en caso contrario
	 */
	public boolean puedeColarse(Persona persona) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Devuelve el número de amigos a los cuales reservador puede todavía colar delante suya.
	 * 
	 * @param reservador, Persona de la que se quiere saber el número de amigos que aún puede colar
	 * 
	 * @pre.condition {@code reservador != null}
	 * @pre.condition {@code estaEncola(reservador)}
	 * @pre.condition {@code esReservador(reservador)}
	 * @post.condition {@code nColados >= 0 && nColados <= numeroDeAmigosReservados(reservador)}
	 * @throws IllegalArgumentException si {@code reservador == null}
	 * @throws IllegalStateException si {@code !estaEnCola(reservador)}
	 * @throws IllegalStateException si {@code !esReservador(reservador)}
	 * 
	 * @return nColados, el número de amigos que todavía puede colar
	 */
	public int cuantosPuedeColar(Persona p1) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Devuelve el número de amigos para los que pidió vez reservador
	 * 
	 * @param reservador
	 * 
	 * @pre.condition {@code reservador != null}
	 * @pre.condition {@code estaEnCola(reservador)}
	 * @pre.condition {@code esReservador(reservador)}
	 * @post.condition {@code nAmigos >= 0 && nAmigos <= 10}
	 * @throws IllegalArgumentException si {@coded reservador == null}
	 * @throws IllegalStateException si {@code !estaEnCola(reservador)}
	 * @throws IllegalStateException si {@code !esReservador(reservador)}
	 * 
	 * @return nAmigos, número de amigos para los que pidió vez
	 */
	public int numeroAmigosReservados(Persona reservador) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Atiende al siguiente de la cola. Para ello, lo elimina de la cola.
	 * 
	 * @pre.condition {@code haySiguiente()}
	 * @post.condition {@code !estaEnCola(@pre.siguiente())}
	 * @throws IllegalStateException si {@code !haySiguiente()}
	 */
	public void atender() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Devuelve las personas que aún están en la cola y que han sido coladas por reservador
	 * 
	 * @param reservador, Persona de la que se quiere saber a quiénes ha colado
	 * 
	 * @pre.condition {@code reservador != null}
	 * @pre.condition {@code estaEnCola(reservador)}
	 * @pre.condition {@code esReservador(reservador)}
	 * @throws IllegalArgumentException si {@code reservador == null}
	 * @throws IllegalStateException si {@code !estaEnCola(reservador)}
	 * @throws IllegalStateException si {@code !esReservador(reservador)}
	 * 
	 * @return array de Persona que representa las personas a las que ha colado
	 *         reservador y que aún siguen en la cola. Si no ha colado a nadie,
	 *         o no queda nadie en la cola a quien haya colado, entonces
	 *         devuelve un array vacio
	 */
	public Persona[] coladosPor(Persona reservador) {
		// TODO Auto-generated method stub
		return null;
	}
}
