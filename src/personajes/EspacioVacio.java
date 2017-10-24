package personajes;

/**
* Clase para intanciar espacios vacios. No tienen ningun comportamiendo, solo existe
* para identificar los huecos en el mapa.
* 
* @author Ezequiel Humar - Sebastián Sauer Rosas
* 
*/
public class EspacioVacio extends Inanimados {
	
	public EspacioVacio() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Costructor que setea coordenadas.
	 * 
	 * @param i	Coordenada X
	 * @param j	Coordenada Y
	 */
	public EspacioVacio(int i, int j) {
		super(i, j);
		// TODO Auto-generated constructor stub
	}

	public void informar(){
		System.out.print("Es un espacio vacio");
	}

}
