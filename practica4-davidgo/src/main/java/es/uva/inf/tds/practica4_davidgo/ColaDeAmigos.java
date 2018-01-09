package es.uva.inf.tds.practica4_davidgo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * 
 * @author davidgo
 *
 */
public class ColaDeAmigos {

	protected ArrayList<Persona> cola;
	protected HashMap<Persona, Integer> reservadores; //relaciona reservador con numero de amigos para los que ha reservado
	protected HashMap<Persona, ArrayList<Persona>> coladosPor; //relaciona reservador con los amigos que ha colado
	
	/**
	 * Crea un objeto ColaDeAmigos que representa una cola en la que se debe
	 * pedir la vez para entrar y en la que se puede reservar sitio para un
	 * grupo de amigos.
	 */
	public ColaDeAmigos() {
		cola = new ArrayList<>();
		reservadores = new HashMap<>();
		coladosPor = new HashMap<>();
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
		if(reservador == null) {
			throw new IllegalArgumentException("Reservador null");
		}
		if (nAmigos < 0) {
			throw new IllegalArgumentException("nAmigos negativo");
		}
		if (nAmigos > 10) {
			throw new IllegalArgumentException("nAmigos superior al limite de 10");
		}
		if (esReservador(reservador)) {
			throw new IllegalStateException("Reservador ya ha reservado previamente");
		}
		if (estaEnCola(reservador)) {
			throw new IllegalStateException("Reservador ya está en la cola");
		}
		reservadores.put(reservador, nAmigos);
		cola.add(reservador);
		coladosPor.put(reservador, new ArrayList<>());
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
		if (!haySiguiente()) {
			throw new IllegalStateException("No hay siguiente");
		}
		return cola.get(0);
	}

	/**
	 * Coloca a colado delante del primer reservador, el cual considere amigo al colado.
	 * 
	 * @param colado, Persona que va a ser colada
	 * 
	 * @pre.condition {@code colado != null}
	 * @pre.condition {@code puedeColarse(colado)}
	 * @post.condition {@code estaEnCola(colado)}
	 * @post.condition {@code !puedeColarse(colado)}
	 * @post.condition {@code cuantosPuedeColar(reservador_de_colado) == @pre.cuantosPuedeColar(reservador_de_colado)-1}
	 * @throws IllegalArgumentException si {@code colado == null}
	 * @throws IllegalStateException si {@code !puedeColarse(colado)} 
	 */
	public void colarA(Persona colado) {
		if (colado == null) {
			throw new IllegalArgumentException("Colado null");
		}
		if (!puedeColarse(colado)) {
			throw new IllegalStateException("Colado no puede colarse");
		}
				
		int posReservador = cola.size()-1; //en la ultima posicion de la cola siempre habra un reservador
		
		for (Persona reservador : reservadores.keySet()) {
			if (reservador.esAmigo(colado) && cuantosPuedeColar(reservador) > 0) {
				if (cola.indexOf(reservador) <= posReservador) {
					posReservador = cola.indexOf(reservador);
				}
			}
		}
		coladosPor.get(cola.get(posReservador)).add(colado); //metemos a colado en la lista de coladosPor el reservador correspondiente
		cola.add(posReservador, colado);
	}
	
	/**
	 * Devuelve si queda alguna Persona o no en la cola para ser atendido.
	 * 
	 * @return true si queda al menos uno en la cola. False en caso contrario
	 */
	public boolean haySiguiente() {
		return !cola.isEmpty();
	}

	/**
	 * Devuelve si personaEsperando es uno de los que ha pedido vez o no
	 * 
	 * @param personaEsperando, Persona que se encuentra en la cola y de la que se quiere saber si ha pedido vez o no
	 * @return true en caso de que haya pedido vez. False en caso contrario
	 * 
	 * @pre.condition {@code personaEsperando != null}
	 * @throws IllegalArgumentException si {@code personaEsperando == null}
	 */
	public boolean esReservador(Persona personaEsperando) {
		if (personaEsperando == null) {
			throw new IllegalArgumentException("personaEsperando null");
		}
		return reservadores.containsKey(personaEsperando);
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
		if (persona == null) {
			throw new IllegalArgumentException("Persona null");
		}
		return cola.contains(persona);
	}

	/**
	 * Devuelve si persona puede colarse delante de alguien que le considera
	 * amigo, o no. Una Persona puede colarse si no esta en la cola y
	 * hay alguien en la cola que ha reservado para algún amigo y dicha persona
	 * aún no haya colado tantos amigos como reservó cuando pidió vez.
	 * 
	 * 
	 * @param persona, Persona de la que se quiere saber si puede o no colarse
	 * 
	 * @pre.condition {@code persona != null}
	 * @throws IllegalArgumentException si {@code persona == null}
	 * 
	 * @return true si puede colarse, false en caso contrario
	 */
	public boolean puedeColarse(Persona persona) {
		if (persona == null) {
			throw new IllegalArgumentException("Persona null");
		}
		
		if (estaEnCola(persona)) {
			return false;
		} else {
			for (Persona reservador : reservadores.keySet()) {
				if (reservador.esAmigo(persona) && cuantosPuedeColar(reservador) > 0) {
					return true;
				}
			}
			return false;
		}
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
	public int cuantosPuedeColar(Persona reservador) {
		if (reservador == null) {
			throw new IllegalArgumentException("Reservador null");
		}
		if (!estaEnCola(reservador)) {
			throw new IllegalStateException("Reservador no está en la cola");
		}
		if (!esReservador(reservador)) {
			throw new IllegalStateException("Reservador no es un reservador");
		}
		return reservadores.get(reservador) - coladosPor.get(reservador).size();
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
		if (reservador == null) {
			throw new IllegalArgumentException("Reservador null");
		}
		if (!estaEnCola(reservador)) {
			throw new IllegalStateException("Reservador no está en cola");
		}
		if (!esReservador(reservador)) {
			throw new IllegalStateException("Reservador no es un reservador");
		}
		
		return reservadores.get(reservador);
	}

	/**
	 * Atiende al siguiente de la cola. Para ello, lo elimina de la cola.
	 * 
	 * @pre.condition {@code haySiguiente()}
	 * @post.condition {@code !estaEnCola(@pre.siguiente())}
	 * @throws IllegalStateException si {@code !haySiguiente()}
	 */
	public void atender() {
		if (!haySiguiente()) {
			throw new IllegalStateException("No hay siguiente a quien atender");
		}
		coladosPor.remove(cola.get(0));
		reservadores.remove(cola.get(0));
		cola.remove(0);
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
		if (reservador == null) {
			throw new IllegalArgumentException("Reservador null");
		}
		if (!estaEnCola(reservador)) {
			throw new IllegalStateException("Reservador no esta en cola");
		}
		if (!esReservador(reservador)) {
			throw new IllegalStateException("Reservador no es un reservador");
		}
		
		
		ArrayList<Persona> colados = new ArrayList<>();
		colados.addAll(coladosPor.get(reservador));
		Collections.reverse(colados);
		return colados.toArray(new Persona[0]);
	}
}
