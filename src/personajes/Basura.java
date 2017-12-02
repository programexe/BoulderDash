package personajes;

/**
 * Clase para intanciar basuras. No tienen ningun comportamiendo, solo existe
 * para sostener otros elementos del mapa.
 * 
 * 
 * @author Ezequiel Humar - Sebasti�n Sauer Rosas
 * 
 */
public class Basura extends Inanimados {

	public Basura() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor que setea coordenadas.
	 * 
	 * @param i Coordenada X
	 * @param j Coordenada Y
	 */
	public Basura(int i, int j) {
		super(i, j);
		// TODO Auto-generated constructor stub
	}

	public void informar(){
		System.out.print("Es basura");
	}
	
	public boolean isBasura() {
		return true;
	}
	
	public void explotar(){
		
	}	
	
	public String toStringPos() {
		return ("(" + this.x + "," + this.y + ")Basura      ");

	}
	
}
