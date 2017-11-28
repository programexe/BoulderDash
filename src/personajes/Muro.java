package personajes;

import Juego.Mapa;
import personajes.direccionAnimados;

/**
 * Clase para instanciar muros magicos. Este muro puede activarse, cuando lo hace convierte 
 * los elementos alrededor en diamantes siempre  y cuando no sea un muro. El tiempo que estar� 
 * activo es de 5 segundos cada 30 segundos
 */
public class Muro extends Muros {
	
	
	private boolean magico;
	
	/**
	 * Costructor que setea coordenadas.
	 * 
	 * @param i Coordenada X
	 * @param j Coordenada Y
	 */
	public Muro(int i, int j) {
		super(i, j);
		// TODO Auto-generated constructor stub
	}
	
	public Muro (int i, int j, boolean activo){
		this.x = i;
		this.y = j;
		this.magico = activo;
	}

	private int tiempo=0;		/*Esta variable guarda la cantidad de tiempo que el muro convertira los elementos en diamantes*/
	private int seg=0;

	public void informar(){
		System.out.print("Es un muro magico");
	}
	
	
	/**
	 * Por cada ejecucion de la tarea del timer disminuira el tiempo en que esta activo el muro magico
	 */
	public void actualizar(){
		if (tiempo!=0){
			tiempo--;
			if (!this.magico){
				if (( (QueCaen)this.devolverPos(direccionAnimados.ARRIBA) ).isCayendo())
					this.setMagico(true);
			}
			if (this.magico)
				this.transformar();
		}
		else if (seg!=10){
			seg++;
		}
		else {
			seg=0;
			tiempo=5;
		}
	}

	
	public void activarMagia(boolean estado){
		this.magico = estado;
		Elementos e = this.devolverPos(direccionAnimados.IZQUIERDA);
		if (e.isMuro())
			if ( ( (Muro) e).isMagico() != estado)
				((Muro) e).activarMagia(estado);
		e = this.devolverPos(direccionAnimados.DERECHA);
		if (e.isMuro())
			if (((Muro) e).isMagico() != estado)
				( (Muro) e).activarMagia(estado);
	}
	
	public void transformar(){
		if (( (QueCaen)this.devolverPos(direccionAnimados.ARRIBA) ).isCayendo()){
			Elementos e = this.devolverPos(direccionAnimados.ARRIBA);
			if (this.devolverPos(direccionAnimados.ABAJO).isEspacioVacio()){
				if (e.isRoca()) {
					mapa.modificarEspacio(x, y - 1, new EspacioVacio(x, y - 1));
					mapa.modificarEspacio(x, y + 1,  new Diamante(x, y + 1, true));
				}
				if (e.isDiamante()){
					mapa.modificarEspacio(x, y - 1, new EspacioVacio(x, y - 1));
					mapa.modificarEspacio(x, y + 1,  new Roca(x, y + 1, true));
				}
			}
		}
	}
		
	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	
	public boolean isMuro() {
		return true;
	}
	
	public boolean isMagico(){
		return magico;
	}
	
	public void setMagico(boolean e){
		this.magico = e;
	}
	
	public void explotar(){
		
	}	
}