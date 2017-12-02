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
	
	public int x;
	public int y;
	
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
	
	/**
	 * Todo elemento tiene sus cordenadas, una referencia al mapa y un estado
	 * modificable.
	 */
	protected static final Mapa mapa = Mapa.getInstance();
	
	public void actualizar(){
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
	
	public boolean isAmeba() {
		return false;
	}
	
	public boolean isAnimados() {
		return false;
	}
	
	public boolean isBasura() {
		return false;
	}
	
	public boolean isDiamante() {
		return false;
	}
	
	public boolean isElementos() {
		return false;
	}
	
	public boolean isEspacioVacio() {
		return false;
	}
	
	public boolean isExplosivos() {
		return false;
	}
	public boolean isInanimados() {
		return false;
	}
	
	public boolean isLuciernaga() {
		return false;
	}
	
	public boolean isMariposa() {
		return false;
	}
	
	public boolean isMuros() {
		return false;
	}
	
	public boolean isMuro() {
		return false;
	}
	
	public boolean isMuroTitanio() {
		return false;
	}
	
	public boolean isNoExplosivos() {
		return false;
	}
	
	public boolean isPuerta() {
		return false;
	}
	
	public boolean isQueCaen() {
		return false;
	}
	
	public boolean isQueNoCaen() {
		return false;
	}
	
	public boolean isRoca() {
		return false;
	}
	
	public boolean isRockford() {
		return false;
	}
	
	public Elementos devolverPos(direccionAnimados dir){
		switch (dir){
		
		case IZQUIERDA:{
			return mapa.getEspacios()[this.getX()-1][this.getY()];
		}
		
		case DERECHA:{
			return mapa.getEspacios()[this.getX()+1][this.getY()];
		}
		
		case ARRIBA:{
			return mapa.getEspacios()[this.getX()][this.getY()-1];
		}
		
		case ABAJO:{
			return mapa.getEspacios()[this.getX()][this.getY()+1];
		}
		
		case ARRIBADER:{
			return mapa.getEspacios()[this.getX()+1][this.getY()-1];
		}
		
		case ARRIBAIZQ:{
			return mapa.getEspacios()[this.getX()-1][this.getY()-1];
		}
		
		case ABAJODER:{
			return mapa.getEspacios()[this.getX()+1][this.getY()+1];
		}
		
		case ABAJOIZQ:{
			return mapa.getEspacios()[this.getX()-1][this.getY()+1];
		}
		
		default: return null;
		}
		
	}
	
	public abstract void explotar();
	
	public abstract String toStringPos();	

}
