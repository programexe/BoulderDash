package personajes;


/**
 * Clase para intanciar muros de titanio. Es un elemento sin comportamiento,
 * que no se puede mover ni destruir, sirve para delimitar el mapa.
 * 
 * @author Ezequiel Humar - Sebasti�n Sauer Rosas
 * 
 */
public class MuroTitanio extends Muros{
	
	public MuroTitanio() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Costructor que setea coordenadas.
	 * 
	 * @param i Coordenada X
	 * @param j Coordenada Y
	 */
	public MuroTitanio(int i, int j) {
		super(i, j);
		// TODO Auto-generated constructor stub
	}

	public void informar(){
		System.out.print("Es un muro de titanio");
	}
	
	public boolean isMuroMagico() {
		return true;
	}

	public void explotar(){
		
	}	
	
	public String toStringPos() {
		return ("Titanio");

	}
	
	
}
