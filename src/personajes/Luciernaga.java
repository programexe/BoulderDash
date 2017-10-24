package personajes;
import Juego.*;

/**
 * Clase para instanciar luciernagas. Si una roca se encuentra sobre ella y esta es una roca cayente,
 * la luciernaga explota convirtiendo un area de 3*3 en espacio vacio. De otra manera, la luciernaga 
 * trata de moverse. Cada luciernaga tiene una “direccion actual" (arriba, abajo, izquierda o derecha).
 * Si el siguiente casillero en su direccion está vacio, la luciernaga se mueve a ese espacio. Si el 
 * siguiente  casillero no está vacio, la luciérnaga cambia su direccion de acuerdo a las agujas del 
 * reloj, por ejemplo: si la dirección actual es arriba, la nueva direccion será hacia la derecha.
 * 
 * @author Ezequiel Humar - Sebastián Sauer Rosas
 *
 */
public class Luciernaga extends Explosivos {
	
	public Luciernaga() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor que setea coordenadas.
	 * 
	 * @param i Coordenada X
	 * @param j Coordenada Y
	 */	
	public Luciernaga(int i, int j) {
		super(i, j);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Cambia el sentido de la direccion de la luciernaga.
	 */
	public void cambiarDireccion(){		
		
		switch (this.getDireccionActual()){
			case "Izquierda": this.setDireccionActual("Arriba");
				break;
			
			case "Arriba": this.setDireccionActual("Derecha");
				break;
		
			case "Derecha": this.setDireccionActual("Abajo");		
				break;
		
			case "Abajo": this.setDireccionActual("Izquierda");
				break;
		}
	}
	
	
	/*
	public void actualizarPorTimer(Mapa m){
		this.moverse(m);			
	}
	*/
	
	
	/**
	 * Actualiza el mapa para mover a la luciernaga y evaluar si esta debe explotar.
	 * @param m Mapa
	 */
	public void actualizar(Mapa m){	
		this.moverse(m);
		explotar(m);
	}
	
	/**
	 * Explota convirtiendo un área de 3*3 en espacios vacios.
	 * @param m Mapa
	 */
	public void explotar(Mapa m){		
		if ((m.getEspacios()[this.getX()][this.getY()-1]) instanceof Roca){
			
			if(!(m.getEspacios()[this.getX()][this.getY()] instanceof Muro)){
				m.modificarEspacio(this.getX(), this.getY(), new EspacioVacio(this.getX(), this.getY()));
				
			}
			
			if(!(m.getEspacios()[this.getX()-1][this.getY()] instanceof Muro)){
				m.modificarEspacio(this.getX()-1, this.getY(), new EspacioVacio(this.getX()-1, this.getY()));
				
			}
			
			if(!(m.getEspacios()[this.getX()+1][this.getY()] instanceof Muro)){
				m.modificarEspacio(this.getX()+1, this.getY(), new EspacioVacio(this.getX()+1, this.getY()));
				
			}
			
			if(!(m.getEspacios()[this.getX()][this.getY()-1] instanceof Muro)){
				m.modificarEspacio(this.getX(), this.getY()-1, new EspacioVacio(this.getX(), this.getY()-1));
				
			}
			
			if(!(m.getEspacios()[this.getX()][this.getY()+1] instanceof Muro)){
				m.modificarEspacio(this.getX(), this.getY()+1, new EspacioVacio(this.getX(), this.getY()+1));
				
			}
		
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
				System.out.println("La luciernaga se movio a : " + this.getX() + "," + this.getY());
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
				System.out.println("La luciernaga se movio a : " + this.getX() + "," + this.getY());
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
				System.out.println("La luciernaga se movio a : " + this.getX() + "," + this.getY());
				m.actualizarMapa();
			}
				else
					this.cambiarDireccion();
			break;
			}
		
		case "Arriba": {
			if (m.getEspacios()[this.getX()][this.getY()-1] instanceof EspacioVacio){
				this.setY(this.getY()-1);
				m.modificarEspacio(this.getX(), this.getY(), this);
				m.modificarEspacio(this.getX(), this.getY()+1, new EspacioVacio(this.getX(), this.getY()+1));
				System.out.println("La luciernaga se movio a : " + this.getX() + "," + this.getY());
				m.actualizarMapa();
			}
				else
					this.cambiarDireccion();
			break;
			}
	}
	}
				
	public void informar(){
		System.out.println("Es una luciernaga");
	}

}
