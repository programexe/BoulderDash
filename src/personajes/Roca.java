package personajes;

/**
 * Clase para instanciar rocas. Una roca pude caer o no.
 * 
 * @author Ezequiel Humar - Sebasti�n Sauer Rosas
 *
 */
public class Roca extends QueCaen{

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
		if (mapa.getEspacio(x + 1, y).isEspacioVacio() && !(this.isCayendo()))
			this.moverDerecha();
	}
	
	public void empujarIzquierda(){
		if (mapa.getEspacio(x - 1, y).isEspacioVacio() && !(this.isCayendo()))
			this.moverIzquierda();
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
			e.explotar();
			return true;
		}
		else
			return false;	
	}

	
	/**
	 * Actualizar que ejecuta el metodo correspondiente de acuerdo al estado de cayendo
	 */
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
		System.out.print("Es una roca");
	}
	
	public boolean isRoca() {
		return true;
	}
	
	public void explotar(){
		
	}	
	
	public String toStringPos() {
		return ("(" + this.x + "," + this.y + ")Roca      ");

	}
}
