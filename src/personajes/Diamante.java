package personajes;

/**
 * Clase para instancia diamantes. Un diamante pude caer o no.
 * 
 * @author Ezequiel Humar - Sebasti�n Sauer Rosas
 *
 */
public class Diamante extends QueCaen {
	
	public Diamante (int i, int j){
		super(i,j);
	}

	/**
	 * Costructor que setea coordenadas y el estado de que si debe caer o no.
	 * 
	 * @param i        Coordenada X
	 * @param j        Coordenada Y
	 * @param cayendo  Indica si el diamante debe caer
	 */
	public Diamante(int i, int j, boolean cayendo) {
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
	
	/**
	 * Si la variable cayendo es verdadera modifica la posicion del elemento
	 * @param m Mapa
	 */
	public void caer(){  
		mapa.modificarEspacio(x, y + 1, this);
		mapa.modificarEspacio(x, y, new EspacioVacio(x,y));
		this.y++;
	}
	
	public boolean detectar(){
		Elementos e = this.devolverPos(direccionAnimados.ABAJO);
		if (e.isRockford() || e.isLuciernaga() || e.isMariposa()){
			this.setCayendo(false);
			return true;
		}
		else
			return false;	
	}
	
	public void actualizar(){ 
		if (this.isCayendo())
			if (!(this.detectar())){
				this.caer();
				Elementos e = this.devolverPos(direccionAnimados.ABAJO);
				if (!(e.isEspacioVacio() || e.isRockford() || e.isLuciernaga() || e.isMariposa()))
					this.setCayendo(false);
			}
		else {
			Elementos e = this.devolverPos(direccionAnimados.ABAJO);
			if (e.isEspacioVacio())
				this.setCayendo(true);
			if (e.isRoca() || e.isMuro() || e.isDiamante()){
				if (e.devolverPos(direccionAnimados.IZQUIERDA).isEspacioVacio() && e.devolverPos(direccionAnimados.ABAJOIZQ).isEspacioVacio()){
					this.moverIzquierda();
					this.setCayendo(true);
				}
				if (e.devolverPos(direccionAnimados.DERECHA).isEspacioVacio() && e.devolverPos(direccionAnimados.ABAJODER).isEspacioVacio()){
					this.moverDerecha();
					this.setCayendo(true);
				}
					
			}
		}
	}
	

	public void informar(){
		System.out.print("Es diamante");
	}
	
	public boolean isDiamante() {
		return true;
	}
	
	public void explotar(){
		
	}
	
	public String toStringPos() {
		return ("(" + this.x + "," + this.y + ")Diamante      ");

	}
	
}
