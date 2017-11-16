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
	
	public boolean isMuro() {
		return false;
	}
	
	public boolean isMuroMagico() {
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
