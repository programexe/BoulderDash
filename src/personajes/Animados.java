package personajes;
import Juego.Mapa;
import static personajes.direccionAnimados.*;

/**
* Clase padre de todos los elementos que son capaces de cambiar su ubicacion en el mapa del juego.
* Consta de una atributo que indica la direccion en la cual debe moverse el elemento.
* 
* @author Ezequiel Humar - Sebastián Sauer Rosas
* 
*/
public abstract class Animados extends Elementos {
	
	private direccionAnimados direccionActual;		
	public Animados() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor que setea coordenadas.
	 * 
	 * @param i Coordenada X
	 * @param j Coordenada Y
	 */	
	public Animados(int i, int j) {
		super(i, j);
		this.setDireccionActual(ABAJO);
		
	}
	
	public void cambiarDireccion(){
		
	}
	
	public direccionAnimados getDireccionActual() {
		return direccionActual;
	}
	public void setDireccionActual(direccionAnimados direccionActual) {
		this.direccionActual = direccionActual;
	}
	
	public void informar(){
	}
	
	public void Explotar(Mapa m){
		
	}
}
