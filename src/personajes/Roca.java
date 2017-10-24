package personajes;

/**
 * Clase para instanciar rocas. Una roca pude caer o no.
 * 
 * @author Ezequiel Humar - Sebastián Sauer Rosas
 *
 */
public class Roca extends QueCaen{

	public Roca() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Costructor que setea coordenadas y el estado de que si debe caer o no.
	 * 
	 * @param i        Coordenada X
	 * @param j        Coordenada Y
	 * @param cayendo  Indica si la roca debe caer
	 */
	public Roca(int i, int j, boolean cayendo) {
		super(i, j, cayendo);
		// TODO Auto-generated constructor stub
	}

	public void informar(){
		System.out.print("Es una roca");
	}
}
