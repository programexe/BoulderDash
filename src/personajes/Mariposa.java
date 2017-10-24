package personajes; 

import Juego.Mapa;

/**
 * Clase para instanciar mariposas. Si una roca se encuentra sobre ella y esta es una roca cayente,
 * la mariposa explota convirtiendo un area de 3*3 en diamantes. De otra manera, la mariposa 
 * trata de moverse. Cada mariposa tiene una “direccion actual" (arriba, abajo, izquierda o derecha).
 * Si el siguiente casillero en su direccion está vacio, la mariposa se mueve a ese espacio. Si el 
 * siguiente  casillero no está vacio, la mariposa cambia su direccion en sentido contrario a las agujas 
 * del reloj, por ejemplo: si la dirección actual es arriba, la nueva direccion será hacia la izquierda.
 * 
 * @author Ezequiel Humar - Sebastián Sauer Rosas
 *
 */
public class Mariposa extends Explosivos {
	
	public Mariposa() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor que setea coordenadas.
	 * 
	 * @param i Coordenada X
	 * @param j Coordenada Y
	 */	
	public Mariposa(int i, int j) {
		super(i, j);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Cambia el sentido de la direccion de la mariposa.
	 */
	public void cambiarDireccion(){
		
		switch (this.getDireccionActual()){
		
			case "Izquierda": this.setDireccionActual("Abajo");
				break;
				
			case "Arriba": this.setDireccionActual("Izquierda");
				break;
		
			case "Derecha": this.setDireccionActual("Arriba");
				break;
		
			case "Abajo": this.setDireccionActual("Derecha");
				break;
		}
	}
	
	/**
	 * Mueve la luciernaga segun la direccion actual.
	 * @param m Mapa
	 */
	public void moverse(Mapa m){	
									
		switch (this.getDireccionActual()){
		
		case "Derecha": {
			if (m.getEspacios()[this.getX()+1][this.getY()] instanceof EspacioVacio){
				this.setX(this.getX()+1);
				m.modificarEspacio(this.getX(), this.getY(), this);
				m.modificarEspacio(this.getX()-1, this.getY(), new EspacioVacio(this.getX()-1, this.getY()));
				m.actualizarMapa();
			}
				else
					this.cambiarDireccion();
			}
		break;
		
		case "Abajo": {
			if (m.getEspacios()[this.getX()][this.getY()+1] instanceof EspacioVacio){
				this.setY(this.getY()+1);
				m.modificarEspacio(this.getX(), this.getY(), this);
				m.modificarEspacio(this.getX(), this.getY()-1, new EspacioVacio(this.getX(), this.getY()-1));
				m.actualizarMapa();
			}

				else
					this.cambiarDireccion();
			break;
			}
		
		
		
		case "Izquierda": {
			if (m.getEspacios()[this.getX()-1][this.getY()] instanceof EspacioVacio){
				this.setX(this.getX()-1);
				m.modificarEspacio(this.getX(), this.getY(), this);
				m.modificarEspacio(this.getX()+1, this.getY(), new EspacioVacio(this.getX()+1, this.getY()));
				m.actualizarMapa();
			}
				else
					this.cambiarDireccion();
			break;
			}
		
		case "Arriba": {
			if (m.getEspacios()[this.getX()][this.getY()-11] instanceof EspacioVacio){
				this.setY(this.getY()-1);
				m.modificarEspacio(this.getX(), this.getY(), this);
				m.modificarEspacio(this.getX(), this.getY()+1, new EspacioVacio(this.getX(), this.getY()+1));
				m.actualizarMapa();
			}
				else
					this.cambiarDireccion();
			break;
			}
	}
	}
	
	
	/**
	 * Explota convirtiendo un área de 3*3 en diamantes.
	 * @param m Mapa
	 */
	public void explotar(Mapa m){		
		
		if ((m.getEspacios()[this.getX()][this.getY()-1] instanceof Roca)){
			
			if(!(m.getEspacios()[this.getX()+1][this.getY()] instanceof Muro)){
				m.modificarEspacio(this.getX()+1, this.getY(), new Diamante(this.getX()+1, this.getY(), true));
			}
			else{
				m.modificarEspacio(this.getX()+1, this.getY(), new EspacioVacio(this.getX()+1, this.getY()));
			}
			
			if(!(m.getEspacios()[this.getX()-1][this.getY()] instanceof Muro)){
				m.modificarEspacio(this.getX()-1, this.getY(), new Diamante(this.getX()-1, this.getY(), true));
			}
			else{
				m.modificarEspacio(this.getX()-1, this.getY(), new EspacioVacio(this.getX()-1, this.getY()));
			}
			
			if(!(m.getEspacios()[this.getX()][this.getY()+1] instanceof Muro)){
				m.modificarEspacio(this.getX(), this.getY()+1, new Diamante(this.getX(), this.getY()+1, true));
			}
			else{
				m.modificarEspacio(this.getX(), this.getY()+1, new EspacioVacio(this.getX(), this.getY()+1));
			}
			
			if(!(m.getEspacios()[this.getX()][this.getY()-1] instanceof Muro)){
				m.modificarEspacio(this.getX(), this.getY()-1, new Diamante(this.getX(), this.getY()-1, true));
			}
			else{
				m.modificarEspacio(this.getX(), this.getY()-1, new EspacioVacio(this.getX(), this.getY()-1));
			}
			
			m.modificarEspacio(this.getX()+1, this.getY(), new Diamante(this.getX()+1, this.getY(), true));
			m.actualizarMapa();
			
			
		}
		
	}
	
	/**
	 * Actualiza el mapa para mover a la mariposa y evaluar si esta debe explotar.
	 * @param m Mapa
	 */
	public void actualizar (Mapa m){
		this.moverse(m);
		this.explotar(m);
		}
	
	/**
	 * Actualiza el mapa para mover a la mariposa luego de cierto tiempo.
	 * @param m Mapa
	 */
	public void actualizarPorTimer(Mapa m){
		this.moverse(m);
	}

	public void informar(){
		System.out.print("Es una mariposa");
	}


}
