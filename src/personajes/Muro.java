package personajes;

/**
* Clase para intanciar muros. Es la clase padre del muro magico y el de titanio.
* 
* @author Ezequiel Humar - Sebastián Sauer
* 
*/
public abstract class Muro extends Inanimados{
	
	public Muro() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor que setea coordenadas.
	 * 
	 * @param i Coordenada X
	 * @param j Coordenada Y
	 */
	public Muro(int i, int j) {
		super(i, j);
		// TODO Auto-generated constructor stub
	}

	public void informar(){
		System.out.print("Es un muro");
	}

}
