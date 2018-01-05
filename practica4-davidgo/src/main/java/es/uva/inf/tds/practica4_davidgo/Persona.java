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
	 * @param nombre,
	 *            nombre de la persona
	 * 
	 * @pre.condition {@code nombre != null}
	 * @pre.condition {@code nombre != ""}
	 * @post.condition {@code nombre == this.getNombre()}
	 * @post.condition {@code null == this.getConocidos()}
	 * @post.condition {@code null == this.getAmigos()}
	 * @throws IllegalArgumentException
	 *             si {@code nombre == null || nombre == ""}
	 */
	public Persona(String nombre) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Crea un objeto persona dado un nombre y un array de Persona que
	 * representa sus conocidos
	 * 
	 * @param nombre,
	 *            nombre de la persona
	 * @param conocidos,
	 *            array de Persona que representa los conocidos de this
	 * 
	 * @pre.condition {@code nombre != null}
	 * @pre.condition {@code nombre != ""}
	 * @pre.condition {@code conocidos != null}
	 * @pre.condition {@code conocidos.length > 0}
	 * @pre.condition {@code conocidos[i] != null} para todo i desde 0 hasta
	 *                conocidos.length-1
	 * @post.condition {@code nombre == this.getNombre()}
	 * @post.condition {@code Arrays.equals(conocidos, this.getConocidos())}
	 * @post.condition {@code null == this.getAmigos()}
	 * @throws IllegalArgumentException
	 *             cuando no se cumple alguna de las precondiciones
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
		// TODO Auto-generated method stub

	}

	/**
	 * Devuelve si otro es un conocido de this o no Se considera conocido
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
		// TODO Auto-generated method stub
		return false;
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
		// TODO Auto-generated method stub
		return false;
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
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub
		
	}

}