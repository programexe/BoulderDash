package personajes;
import static personajes.direccionAnimados.*;

/**
 * Clase para instanciar luciernagas. Si una roca se encuentra sobre ella y esta es una roca cayente,
 * la luciernaga explota convirtiendo un area de 3*3 en espacio vacio. De otra manera, la luciernaga 
 * trata de moverse. Cada luciernaga tiene una �direccion actual" (arriba, abajo, izquierda o derecha).
 * Si el siguiente casillero en su direccion est� vacio, la luciernaga se mueve a ese espacio. Si el 
 * siguiente  casillero no est� vacio, la luci�rnaga cambia su direccion de acuerdo a las agujas del 
 * reloj, por ejemplo: si la direcci�n actual es arriba, la nueva direccion ser� hacia la derecha.
 * 
 * @author Ezequiel Humar - Sebasti�n Sauer Rosas
 *
 */
public class Luciernaga extends Explosivos {
	
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
			case IZQUIERDA: this.setDireccionActual(ARRIBA);
				break;
			
			case ARRIBA: this.setDireccionActual(DERECHA);
				break;
		
			case DERECHA: this.setDireccionActual(ABAJO);		
				break;
		
			case ABAJO: this.setDireccionActual(IZQUIERDA);
				break;
				
			default:
				break;
		}
	}
	
	
	/**
	 * Actualiza el mapa para mover a la luciernaga luego del tiempo determinado por el timer.
	 */
	public void actualizarPorTimer(){
		this.moverse();			
	}
	
	
	/**
	 * Actualiza el mapa para mover a la luciernaga y evaluar si esta debe explotar.
	 */
	public void actualizar(){	
		this.moverse();
		System.out.println("SE MUEVE");
	}
	
	
	private void moverArriba(){
		mapa.modificarEspacio(x, y - 1, this);
		mapa.modificarEspacio(x, y, new EspacioVacio(x,y));
		this.y--;
	}
	
	private void moverDerecha(){
		mapa.modificarEspacio(x + 1, y, this);
		mapa.modificarEspacio(x, y, new EspacioVacio(x,y));
		this.x++;
	}
	
	private void moverAbajo(){
		mapa.modificarEspacio(x, y + 1, this);
		mapa.modificarEspacio(x, y, new EspacioVacio(x,y));
		this.y--;
	}
	
	private void moverIzquierda(){
		mapa.modificarEspacio(x - 1, y, this);
		mapa.modificarEspacio(x, y, new EspacioVacio(x,y));
		this.x--;
	}
	
	
	
	/**
	 * Mueve la luciernaga segun la direccion actual.
	 * @param m Mapa
	 */
	public void moverse(){
		
		Elementos e;
		switch (this.getDireccionActual()){
		
			case DERECHA: {
				e = this.devolverPos(DERECHA);
				if (e.isEspacioVacio()){
					this.moverDerecha();
					System.out.println("La luciernaga se movio a : " + this.getX() + "," + this.getY());
				}
					else
						this.cambiarDireccion();
			}
				break;
			
			case ABAJO: {
				e = this.devolverPos(ABAJO);
				if (e.isEspacioVacio()){
					this.moverAbajo();
					System.out.println("La luciernaga se movio a : " + this.getX() + "," + this.getY());
				}
					else
						this.cambiarDireccion();
			}
				break;
			
			case IZQUIERDA: {
				e = this.devolverPos(IZQUIERDA);
				if (e.isEspacioVacio()){
					this.moverIzquierda();
					System.out.println("La luciernaga se movio a : " + this.getX() + "," + this.getY());
				}
					else
						this.cambiarDireccion();
			}
				break;
			
			case ARRIBA: {
				e = this.devolverPos(ARRIBA);
				if (e.isEspacioVacio()){
					this.moverArriba();
					System.out.println("La luciernaga se movio a : " + this.getX() + "," + this.getY());
				}
					else
						this.cambiarDireccion();
			}
				break;
			
			default: 
				break;
		}
		
		this.detectar();
	}
	
	
	/**
	 * Explota convirtiendo un area de 3*3 en espacios vacios.
	 */
	public void explotar(){		
		mapa.explotar(x, y);
	}
	
	
	public void detectar(){
		Elementos e = this.devolverPos(ARRIBA);
		if (e.isRoca())
			if ( ((Roca) e).isCayendo())
				this.explotar();
		else {
			if (e.isRockford()){
				e.explotar();
			}
			else {
				e = this.devolverPos(DERECHA);
				if (e.isRockford()){
					e.explotar();
				}
				else {
					e = this.devolverPos(ABAJO);
					if (e.isRockford()){
						e.explotar();
					}
					else {
						e = this.devolverPos(IZQUIERDA);
						if (e.isRockford()){
							e.explotar();
						}
					}
				}
			}
		}
		
	}
	
				
	public void informar(){
		System.out.println("Es una luciernaga");
	}
	
	public boolean isLuciernaga() {
		return true;
	}
	
	public String toStringPos() {
		return ("(" + this.x + "," + this.y + ")Luciernaga      ");

	}

}
