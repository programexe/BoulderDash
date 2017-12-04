package personajes;
import Juego.*;
import static personajes.direccionAnimados.*;


/**
 * Clase para instanciar amebas. La ameba no se mueve y su toque es inofensivo para cualquiera, pero esta 
 * lentamente se va expandiendo por los casilleros vac�os, haciendo eventualmente imposible moverse al jugador. 
 * En cada turno, la ameba tiene �pocas probabilidades� de expandirse. La expansi�n busca un casillero vecino 
 * en una direcci�n elegida de manera random, y si ese casillero est� vac�o o sucio, se convierte en una ameba.
 * 
 * @author Ezequiel Humar - Sebasti�n Sauer Rosas
 *
 */
public class Ameba extends Animados {

	public Ameba() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor que setea coordenadas.
	 * 
	 * @param i Coordenada X
	 * @param j Coordenada Y
	 */
	public Ameba(int i, int j) {
		super(i, j);
		// TODO Auto-generated constructor stub
	}
	 
	/**
	 * Metodo que cambiar la direccion en la que se expande la ameba de manera aleatoria
	 */
	public void cambiarDireccion(){
		int n = (int) (Math.random() * 4) + 1;
		
		switch (n){
		
		case 1: this.setDireccionActual(ABAJO);
			break;
			
		case 2: this.setDireccionActual(IZQUIERDA);
			break;
	
		case 3: this.setDireccionActual(ARRIBA);
			break;
	
		case 4: this.setDireccionActual(DERECHA);
			break;
	}
	}
	
	/**
	 * Actualiza el mapa para expandir a la ameba.
	 * @param m Mapa
	 */
	public void actualizar(Mapa m){
		expandirse(m);
	}
	
	/**
	 * Actualiza el mapa para expandir a la ameba luego de cierto tiempo.
	 * @param m Mapa
	 */
	public void actualizarPorTimer(Mapa m){
		expandirse(m);	
	}
	
	
	/**
	 * Evalua si la ameba puede expandirse en la direccion actual que tiene, y en caso de tener 
	 * el casillero vecino, indicado en dicha direccion, con basura o un espaco vacio se expande.
	 * @param m Mapa
	 */
	public void expandirse(Mapa m){			
											
		
		switch (this.getDireccionActual()){
		
		case IZQUIERDA:{
			if ((m.getEspacios()[this.getX()-1][this.getY()] instanceof EspacioVacio) ||
					(m.getEspacios()[this.getX()-1][this.getY()] instanceof Basura)) {
				this.setX(this.getX()-1);
				m.modificarEspacio(this.getX(), this.getY(), this);
			}
			else 
				this.cambiarDireccion();
		}
		break;
	
		case ABAJO:{
			if ((m.getEspacios()[this.getX()][this.getY()+1] instanceof EspacioVacio) ||
				(m.getEspacios()[this.getX()][this.getY()+1] instanceof Basura)){
				this.setY(this.getY()+1);
				m.modificarEspacio(this.getX(), this.getY(), this);
			}
			else 
				this.cambiarDireccion();
		}
		break;
		
		case DERECHA:{
			if ((m.getEspacios()[this.getX()+1][this.getY()] instanceof EspacioVacio) ||
					(m.getEspacios()[this.getX()+1][this.getY()] instanceof Basura)){
				this.setX(this.getX()+1);
				m.modificarEspacio(this.getX(), this.getY(), this);
			}
			else 
				this.cambiarDireccion();
		}
		break;
		
		case ARRIBA:{
			if ((m.getEspacios()[this.getX()][this.getY()-1] instanceof EspacioVacio) ||
					(m.getEspacios()[this.getX()][this.getY()-1] instanceof Basura)){
				this.setY(this.getY()-1);
				m.modificarEspacio(this.getX(), this.getY(), this);
			}
			else 
				this.cambiarDireccion();
		}
		break;
	}
}
	
	public boolean isAmeba() {
		return true;
	}
	
	public void informar(){
		System.out.print("Es ameba");
	}
	
	public void explotar(){
		
	}
	
	public String toStringPos() {
		return ("Ameba");

	}

}
