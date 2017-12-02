package personajes;

import Juego.Mapa;

/**
 * Clase para instanciar muros magicos. Este muro puede activarse, cuando lo hace convierte 
 * los elementos alrededor en diamantes siempre  y cuando no sea un muro. El tiempo que estar� 
 * activo es de 5 segundos cada 30 segundos
 */
public class MuroMagico extends Muro {
	
	//public MuroMagico() {
	//	super();
		// TODO Auto-generated constructor stub
	//}
	
	/**
	 * Costructor que setea coordenadas.
	 * 
	 * @param i Coordenada X
	 * @param j Coordenada Y
	 */
	public MuroMagico(int i, int j) {
		super(i, j);
		// TODO Auto-generated constructor stub
	}

	private int tiempo;		/*Esta variable guarda la cantidad de tiempo que el muro convertira los elementos en diamantes*/
	private int seg30=0;

	public void informar(){
		System.out.print("Es un muro magico");
	}
	
	public void actualizar(Mapa m){
		//convertir(m);
		}
	/**
	 * Por cada ejecucion de la tarea del timer disminuira el tiempo en que esta activo el muro magico
	 */
	public void actualizarPorTimer(){
		if (tiempo!=0){
			tiempo--;
		}
		else if (seg30!=30){
			seg30++;
		}
		else {
			seg30=0;
			tiempo=5;
		}
	}

	
	/**
	 * Convierte los elementos a su alrededor siempre y cuando este activo (tiempo!=0)
	 * y el elemento a su alrededor no sea un muro
	 * 
	 * @param m Mapa
	 */
	/*public void convertir(Mapa m){	
		
		if((this.getTiempo()!=0) && (m.getEspacios()[this.getX()+1][this.getY()] instanceof Diamante)){
			m.modificarEspacio(this.getX()+1, this.getY(), new Roca());
		}
		else{
			if ((this.getTiempo()!=0) && (m.getEspacios()[this.getX()+1][this.getY()] instanceof Roca)){
				m.modificarEspacio(this.getX()+1, this.getY(), new Diamante());
			}
		}
		
		if((this.getTiempo()!=0) && (m.getEspacios()[this.getX()-1][this.getY()] instanceof Diamante)){
			m.modificarEspacio(this.getX()-1, this.getY(), new Roca());
		}
		else{
			if ((this.getTiempo()!=0) && (m.getEspacios()[this.getX()-1][this.getY()] instanceof Roca)){
				m.modificarEspacio(this.getX()-1, this.getY(), new Diamante());
			}
		}
		
		if((this.getTiempo()!=0) && (m.getEspacios()[this.getX()][this.getY()+1] instanceof Diamante)){
			m.modificarEspacio(this.getX(), this.getY()+1, new Roca());
		}
		else{
			if ((this.getTiempo()!=0) && (m.getEspacios()[this.getX()+1][this.getY()] instanceof Roca)){
				m.modificarEspacio(this.getX(), this.getY()+1, new Diamante());
			}
		}
		
		if((this.getTiempo()!=0) && (m.getEspacios()[this.getX()][this.getY()-1] instanceof Diamante)){
			m.modificarEspacio(this.getX(), this.getY()-1, new Roca());
		}
		else{
			if ((this.getTiempo()!=0) && (m.getEspacios()[this.getX()][this.getY()-1] instanceof Roca)){
				m.modificarEspacio(this.getX(), this.getY()-1, new Diamante());
			}
		}
	}
	*/
	
		
	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	
	public boolean isMuroMagico() {
		return true;
	}
	
	public void explotar(){
		
	}	
	
	public String toStringPos() {
		return ("(" + this.x + "," + this.y + ")MuroMagico       ");

	}
}
