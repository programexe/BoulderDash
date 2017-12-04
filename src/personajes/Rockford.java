package personajes;
import Juego.DatosJuego;
import personajes.direccionAnimados;


/**
 * Clase para instancia a Rockford. �ste puede moverse, recolectar diamantes, morir.
 * 
 * @author Ezequiel Humar - Sebasti�n Sauer
 *
 */
public class Rockford extends Animados{
	
	private static Rockford player;
	private boolean muerto=false; 
	private static DatosJuego datos = DatosJuego.getInstance();
	
	
	
	/**
	 * Constructor para instanciar al jugador en la posicion dada
	 * @param i Coordenada X
	 * @param j Coordenada Y
	 */
	private Rockford(int i, int j) {
		this.setX(i);
		this.setY(j);
	}
	

	/**
	 * @return la unica instancia existente de jugador.
	 */
	public static Rockford getInstance(){
		if (player == null)
			player = new Rockford(0, 0);
		
		return player;
	}
	
	/**
	 * Devuelve la unica instancia existente de jugador, pero seteandole las
	 * pociciones.
	 * 
	 * @param i		positionX
	 * 
	 * @param j		positionY
	 * 
	 * @return la unica instancia existente de salida.
	 */
	public static Rockford getInstanceSetPosition(int i, int j){
		if (player == null)
			player = new Rockford (i, j);
		else{
			player.setX(i);
			player.setY(j);
		}
			
		return player;
	}
	
	/**
	 * Modifica la cantidad de diamantes recoletados.
	 * @param m Mapa
	 */
	public void agarrarDiamante(){
		datos.increaseDiamantesRecolectados(1);		
	}
	
	/**
	 * Evalua si Rockford debe explotar. De ser el caso, lo hace.
	 * @param m
	 */
	public void explotar(){  
		if(!muerto){
			mapa.explotar(x, y);
			this.setMuerto(true);
		}	
	}	
	
	public void setDireccion (direccionAnimados dir){
		this.direccionActual = dir;
	}
	
	
	
	public void moverArriba(){
		this.setDireccion(direccionAnimados.ARRIBA);
		Elementos e = this.devolverPos(direccionAnimados.ARRIBA);
		if (e.isMuro() || e.isMuroTitanio() || e.isRoca()){
			System.out.println("Rockford no puede moverse a ese lugar");
		}
		else {
			if (e.isDiamante())
				this.agarrarDiamante();		
			if (mapa.modificarEspacio(x, y - 1, this) == 0) {   
				mapa.modificarEspacio(x, y, new EspacioVacio(x,y));
				this.y--; 
			}
		}
	
	}
	
	public void moverDerecha(){
		this.setDireccion(direccionAnimados.DERECHA);
		Elementos e = this.devolverPos(direccionAnimados.DERECHA);
		if (e.isRoca())
			this.empujarRoca( (Roca) e);
		if (e.isMuro() || e.isMuroTitanio()){
			System.out.println("Rockford no puede moverse a ese lugar");
		}
		else {
			if (e.isDiamante())
				this.agarrarDiamante();
			if (mapa.modificarEspacio(x + 1, y, this) == 0){
				mapa.modificarEspacio(x, y, new EspacioVacio(x,y));
				this.x++;
			}
		}
	}
	
	public void moverAbajo(){
		this.setDireccion(direccionAnimados.ABAJO);
		Elementos e = this.devolverPos(direccionAnimados.ABAJO);
		if (e.isMuro() || e.isMuroTitanio() || e.isRoca()){
			System.out.println("Rockford no puede moverse a ese lugar");
		}
		else {
			if (e.isDiamante())
				this.agarrarDiamante();
			if (mapa.modificarEspacio(x, y + 1, this) == 0){
				mapa.modificarEspacio(x, y, new EspacioVacio(x,y));
				this.y++;
			}
		}
	}
	
	public void moverIzquierda(){
		this.setDireccion(direccionAnimados.IZQUIERDA);
		Elementos e = this.devolverPos(direccionAnimados.IZQUIERDA);
		if (e.isRoca())
			this.empujarRoca( (Roca) e);
		if (e.isMuro() || e.isMuroTitanio()) {
			System.out.println("Rockford no puede moverse a ese lugar");
		}
		else {
			if (e.isDiamante())
				this.agarrarDiamante();
			if (mapa.modificarEspacio(x - 1, y, this) == 0){
				mapa.modificarEspacio(x, y, new EspacioVacio(x,y));
				this.x--;
			}
		}
	}
	
	private void empujarRoca(Roca r){
		if (this.getDireccionActual() == direccionAnimados.DERECHA)
			r.empujarDerecha();
		else {
			if (this.getDireccionActual() == direccionAnimados.IZQUIERDA)
				r.empujarIzquierda();
		}
	}
	
	
	public boolean isMuerto() {
		return muerto;
	}
	
	public void setMuerto(boolean muerto) {
		this.muerto = muerto;
		System.out.println("El jugador ha muerto");
	}
	
	public void actualizar(){
		
	}
	
	public boolean isRockford() {
		return true;
	}
	
	public String toStringPos() {
		return ("Rockford");

	}
}
