package personajes;

/**
 * Clase para instanciar rocas. Una roca pude caer o no.
 * 
 * @author Ezequiel Humar - Sebasti�n Sauer Rosas
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
	
	private void moverDerecha(){
		mapa.modificarEspacio(x + 1, y, this);
		mapa.modificarEspacio(x, y, new EspacioVacio(x,y));
		this.x++;
	}
	
	private void moverIzquierda(){
		mapa.modificarEspacio(x - 1, y, this);
		mapa.modificarEspacio(x, y, new EspacioVacio(x,y));
		this.x--;
	}
	
	public void empujarDerecha(){
		if (mapa.getPosition(x + 1, y).isEspacioVacio() && !(this.isCayendo()))
			this.moverDerecha();
	}
	
	public void empujarIzquierda(){
		if (mapa.getPosition(x - 1, y).isEspacioVacio() && !(this.isCayendo()))
			this.moverIzquierda();
	}

	public void informar(){
		System.out.print("Es una roca");
	}
	
	public boolean isRoca() {
		return true;
	}
	
	public void explotar(){
		
	}	
}
