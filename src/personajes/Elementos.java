package personajes;
import Juego.*;
import personajes.direccionAnimados;

/**
 * Esta clase es la padre de todos los personajes que hay en el juego
 * Contiene las coordenadas de su ubicacion en el mapa.
 * 
 * @author Ezequiel Humar - Sebastián Sauer Rosas
 *
 */
public abstract class Elementos{
	
	private int x;
	private int y;
	
	public Elementos(){
		
	}
	/**
	 * Constructor que setea coordenadas.
	 * 
	 * @param i Coordenada X
	 * @param j Coordenada Y
	 */	
	public Elementos(int i,int j){
		this.y=j;
		this.x=i;
	}
	
	public void actualizar(Mapa m){
	}
	
	public void actualizarPorTimer(Mapa m){
		
	}
	
	public void informar(){
		System.out.print("Es elemento ");
	}


	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public Elementos devolverPos(direccionAnimados dir, Mapa m){
		switch (dir){
		
		case IZQUIERDA:{
			return m.getEspacios()[this.getX()-1][this.getY()];
		}
		
		case DERECHA:{
			return m.getEspacios()[this.getX()+1][this.getY()];
		}
		
		case ARRIBA:{
			return m.getEspacios()[this.getX()][this.getY()-1];
		}
		
		case ABAJO:{
			return m.getEspacios()[this.getX()][this.getY()+1];
		}
		
		case ARRIBADER:{
			return m.getEspacios()[this.getX()+1][this.getY()-1];
		}
		
		default: return null;
		}
		
	}

}
