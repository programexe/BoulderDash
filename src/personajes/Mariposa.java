package personajes; 
import static personajes.direccionAnimados.*;
import Juego.Mapa;

/**
 * Clase para instanciar mariposas. Si una roca se encuentra sobre ella y esta es una roca cayente,
 * la mariposa explota convirtiendo un area de 3*3 en diamantes. De otra manera, la mariposa 
 * trata de moverse. Cada mariposa tiene una �direccion actual" (arriba, abajo, izquierda o derecha).
 * Si el siguiente casillero en su direccion est� vacio, la mariposa se mueve a ese espacio. Si el 
 * siguiente  casillero no est� vacio, la mariposa cambia su direccion en sentido contrario a las agujas 
 * del reloj, por ejemplo: si la direcci�n actual es arriba, la nueva direccion ser� hacia la izquierda.
 * 
 * @author Ezequiel Humar - Sebasti�n Sauer Rosas
 *
 */
public class Mariposa extends Explosivos {
	
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
		
			case IZQUIERDA: this.setDireccionActual(ABAJO);
				break;
				
			case ARRIBA: this.setDireccionActual(IZQUIERDA);
				break;
		
			case DERECHA: this.setDireccionActual(ARRIBA);
				break;
		
			case ABAJO: this.setDireccionActual(DERECHA);
				break;
			default:
				break;
		}
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
	 * Mueve la mariposa segun la direccion actual.
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
	 * Explota convirtiendo un �rea de 3*3 en diamantes.
	 * @param m Mapa
	 */
	public void explotar(){		
		mapa.explotarDiamantes(x, y);
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
	
	
	/**
	 * Actualiza el mapa para mover a la mariposa y evaluar si esta debe explotar.
	 * @param m Mapa
	 */
	public void actualizar (){
		this.moverse();
		}
	
	/**
	 * Actualiza el mapa para mover a la mariposa luego de cierto tiempo.
	 * @param m Mapa
	 */
	public void actualizarPorTimer(Mapa m){
		this.moverse();
	}

	public void informar(){
		System.out.print("Es una mariposa");
	}
	
	public boolean isMariposa() {
		return true;
	}

	

}
