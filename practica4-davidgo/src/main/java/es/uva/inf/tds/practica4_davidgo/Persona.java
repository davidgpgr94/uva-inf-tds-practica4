package es.uva.inf.tds.practica4_davidgo;
/**
 * 
 * @author davidgo
 *
 */
public class Persona {

	/**
	 * Crea un objeto persona dado un nombre
	 * 
	 * @param nombre, nombre de la persona
	 * 
	 * @pre.condition {@code nombre != null}
	 * @post.condition {@code nombre == this.getNombre()}
	 * @post.condition {@code null == this.getConocidos()}
	 * @post.condition {@code null == this.getAmigos()}
	 * @throws IllegalArgumentException si {@code nombre == null} 
	 */
	public Persona(String nombre) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Crea un objeto persona dado un nombre y un array de Persona que representa sus conocidos
	 * 
	 * @param nombre, nombre de la persona
	 * @param conocidos, array de Persona que representa los conocidos de this
	 * 
	 * @pre.condition {@code nombre != null}
	 * @pre.condition {@code conocidos != null}
	 * @pre.condition {@code conocidos.length > 0}
	 * @pre.condition {@code conocidos[i] != null} para todo i desde 0 hasta conocidos.length-1
	 * @post.condition {@code nombre == this.getNombre()}
	 * @post.condition {@code Arrays.equals(conocidos, this.getConocidos())}
	 * @post.condition {@code null == this.getAmigos()}
	 * @throws IllegalArgumentException cuando no se cumple alguna de las precondiciones
	 */
	public Persona(String string, Persona[] conocidos) {
		// TODO Auto-generated constructor stub
	}

	public Persona[] getAmigos() {
		// TODO Auto-generated method stub
		return null;
	}

	public Persona[] getConocidos() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}
}
