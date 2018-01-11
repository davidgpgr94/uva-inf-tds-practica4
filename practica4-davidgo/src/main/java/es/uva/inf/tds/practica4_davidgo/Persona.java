package es.uva.inf.tds.practica4_davidgo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author davidgo
 *
 */
public class Persona {

	protected ArrayList<Persona> amigos;
	protected ArrayList<Persona> conocidos;
	protected String dni;
	
	/**
	 * Crea un objeto persona dado un dni
	 * 
	 * @param dni,
	 *            dni de la persona
	 * 
	 * @pre.condition {@code dni != null}
	 * @pre.condition {@code dni != ""}
	 * @post.condition {@code dni == this.getNombre()}
	 * @post.condition {@code null == this.getConocidos()}
	 * @post.condition {@code null == this.getAmigos()}
	 * @throws IllegalArgumentException
	 *             si {@code dni == null || dni == ""}
	 */
	public Persona(String nombre) {
		if (nombre == null) {
			throw new IllegalArgumentException("Nombre null");
		}
		if (nombre.equals("")) {
			throw new IllegalArgumentException("Nombre vacio");
		}
		amigos = new ArrayList<>();
		conocidos = new ArrayList<>();
		this.dni = nombre;
	}

	/**
	 * Crea un objeto persona dado un dni y un array de Persona que
	 * representa sus conocidos
	 * 
	 * @param dni,
	 *            dni de la persona
	 * @param conocidos,
	 *            array de Persona que representa los conocidos de this
	 * 
	 * @pre.condition {@code dni != null}
	 * @pre.condition {@code dni != ""}
	 * @pre.condition {@code conocidos != null}
	 * @pre.condition {@code conocidos.length > 0}
	 * @pre.condition {@code conocidos[i] != null} para todo i desde 0 hasta
	 *                conocidos.length-1
	 * @post.condition {@code dni == this.getNombre()}
	 * @post.condition {@code Arrays.equals(conocidos, this.getConocidos())}
	 * @post.condition {@code null == this.getAmigos()}
	 * @throws IllegalArgumentException
	 *             cuando no se cumple alguna de las precondiciones
	 */
	public Persona(String nombre, Persona[] conocidos) {
		if (nombre == null) {
			throw new IllegalArgumentException("Nombre null");
		}
		if (nombre.equals("")) {
			throw new IllegalArgumentException("Nombre vacio");
		}
		if (conocidos == null) {
			throw new IllegalArgumentException("Conocidos null");
		}
		if (conocidos.length <= 0) {
			throw new IllegalArgumentException("Conocidos vacio");
		}
		for (int i = 0; i < conocidos.length; i++) {
			if (conocidos[i] == null) {
				throw new IllegalArgumentException("Algún conocido es null");
			}
		}
		amigos = new ArrayList<>();
		this.conocidos = new ArrayList<>();
		this.dni = nombre;
		for (int i = 0; i < conocidos.length; i++) {
			this.conocidos.add(conocidos[i]);
		}
	}

	public Persona[] getAmigos() {
		return amigos.toArray(new Persona[0]);
	}

	public Persona[] getConocidos() {
		return conocidos.toArray(new Persona[0]);
	}

	public String getDni() {
		String aux = new String(dni);
		return aux;
	}

	/**
	 * Añade a la lista de amigos a un conocido
	 * 
	 * @param conocido,
	 *            el conocido al que se quiere hacer amigo
	 * 
	 * @pre.condition {@code conocido != null}
	 * @pre.condition {@code conocido != this}
	 * @pre.condition {@code esConocido(conocido)}
	 * @pre.condition {@code !esAmigo(conocido)}
	 * @post.condition {@code esAmigo(conocido)}
	 * @throws IllegalArgumentException
	 *             si {@code conocido == null}
	 * @throws IllegalArgumentException
	 *             si {@code conocido == this}
	 * @throws IllegalStateException
	 *             si {@code !esConocido(conocido)}
	 * @throws IllegalStateException
	 *             si {@code esAmigo(conocido)}
	 */
	public void serAmigoDe(Persona conocido) {
		if (conocido == null) {
			throw new IllegalArgumentException("Conocido null");
		}
		if (conocido.equals(this)) {
			throw new IllegalArgumentException("Conocido no puede ser this");
		}
		if (!esConocido(conocido)) {
			throw new IllegalStateException("Previamente ha de ser conocido para poder ser amigo");
		}
		if (esAmigo(conocido)) {
			throw new IllegalStateException("Conocido ya es amigo de this.");
		}
		amigos.add(conocido);
	}

	/**
	 * Devuelve si otro es un conocido de this o no. Se considera conocido
	 * aquellos en la lista de conocidos, y a los de la lista de amigos
	 * 
	 * @param otro
	 * 
	 * @pre.condition {@code otro != null}
	 * @pre.condition {@code otro != this}
	 * @throws IllegalArgumentException
	 *             cuando no se cumple alguna precondición
	 * 
	 * @return true si otro es un conocido de this. False en caso contrario
	 */
	public boolean esConocido(Persona otro) {
		if (otro == null) {
			throw new IllegalArgumentException("Otro es null");
		}
		if (otro.equals(this)) {
			throw new IllegalArgumentException("Otro no puede ser this");
		}
		return conocidos.contains(otro);
	}

	/**
	 * Devuelve si otro es un amigo de this o no. Se considera amigo solamente
	 * aquellos en la lista de amigos.
	 * 
	 * @param otro
	 * 
	 * @pre.condition {@code otro != null}
	 * @pre.condition {@code otro != this}
	 * @throws IllegalArgumentException
	 *             cuando no se cumple alguna precondición
	 * 
	 * @return true si otro es un amigo de this. False en caso contrario
	 */
	public boolean esAmigo(Persona otro) {
		if (otro == null) {
			throw new IllegalArgumentException("Otro es null");
		}
		if (otro.equals(this)) {
			throw new IllegalArgumentException("Otro no puede ser this");
		}
		return amigos.contains(otro);
	}

	/**
	 * Añade a la lista de conocidos a una Persona
	 *
	 * @param nuevoConocido,
	 *            array de Persona que son los nuevos conocidos de this
	 * 
	 * @pre.condition {@code nuevoConocido[i] != null} para todo i desde 0 hasta
	 *                nuevoConocido.length-1
	 * @pre.condition {@code nuevoConocido[i] != this} para todo i desde 0 hasta
	 *                nuevoConocido.length-1
	 * @pre.condition {@code !esConocido(nuevoConocido[i])} para todo i desde 0
	 *                hasta nuevoConocido.length-1
	 * @post.condition {@code esConocido(nuevoConocido[i])} para todo i desde 0
	 *                 hasta nuevoConocido.length-1
	 * @throws IllegalArgumentException
	 *             si {@code nuevoConocido[i] == null} para algún i desde 0
	 *             hasta nuevoConocido.length-1
	 * @throws IllegalArgumentException
	 *             si {@code nuevoConocido[i] == this} para algún i desde 0
	 *             hasta nuevoConocido.length-1
	 * @throws IllegalStateException
	 *             si {@code esConocido(nuevoConocido[i])} para algún i desde 0
	 *             hasta nuevoConocido.length-1
	 */
	public void conocerA(Persona[] nuevoConocido) {
		for (int i = 0; i < nuevoConocido.length; i++) {
			if (nuevoConocido[i] == null) {
				throw new IllegalArgumentException("Algun nuevo conocido es null");
			}
			if (nuevoConocido[i].equals(this)) {
				throw new IllegalArgumentException("Algún nuevo conocido es this");
			}
			if (esConocido(nuevoConocido[i])) {
				throw new IllegalStateException("Algún nuevo conocido ya es conocido");
			}
		}

		for (int i = 0; i < nuevoConocido.length; i++) {
			conocidos.add(nuevoConocido[i]);
		}
	}

	
	/**
	 * Elimina a exAmigo de la lista de amigos y lo deja como conocido.
	 * 
	 * @param exAmigo, Persona que dejará de ser amigo de this
	 * 
	 * @pre.condition {@code exAmigo != null}
	 * @pre.condition {@code exAmigo != this}
	 * @pre.condition {@code esAmigo(exAmigo)}
	 * @post.condition {@code !esAmigo(exAmigo) && esConocido(exAmigo)}
	 * @throws IllegalArgumentException si {@code exAmigo == null || exAmigo == this}
	 * @throws IllegalStateException si {@code !esAmigo(exAmigo)}
	 */
	public void dejarSerAmigoDe(Persona exAmigo) {
		if (exAmigo == null) {
			throw new IllegalArgumentException("Examigo null");
		}
		if (exAmigo.equals(this)) {
			throw new IllegalArgumentException("Examigo no puede ser this");
		}
		if (!esAmigo(exAmigo)) {
			throw new IllegalStateException("Examigo ha de ser previamente amigo");
		}
		amigos.remove(exAmigo);
	}

	/**
	 * Devuelve si this y obj representan a la misma persona o no.
	 * Si obj es instancia de Persona, tiene el mismo dni, conocidos y amigos, entonces representa
	 * la misma persona que this. En caso contrario, false.
	 */
	@Override
	public boolean equals(Object otro) {
		if (this == otro) {
			return true;
		}
		if (otro instanceof Persona) {
			Persona tmpOtro = (Persona)otro;
			if (!this.dni.equals(tmpOtro.getDni())) {
				return false;
			} else if (Arrays.equals(this.getConocidos(), tmpOtro.getConocidos())) {
				return Arrays.equals(this.getAmigos(), tmpOtro.getAmigos());
			}
		}
		return false;
	}
}