package personajes;

import Juego.Mapa;

/**
 * Esta es la clase padre de los elementos que pueden caer como la roca o el diamante.
 * 
 * @author Ezequiel Humar - Sebastián Sauer Rosas
 *
 */
public abstract class QueCaen extends Animados{

	private boolean cayendo; /* Indica si el elemento debe caer */
		
	public QueCaen() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Contructor del elemento que indica la posicion y si es un elemento que debe caer
	 * desde un principio o no.
	 * @param i Coordenada X
	 * @param j Coordenada Y
	 * @param cayendo Indica si el elemento debe caer
	 */
	public QueCaen(int i, int j, boolean cayendo) {
		super(i, j);
		this.cayendo = cayendo;
		// TODO Auto-generated constructor stub
	}
	
	public void informar(){
		System.out.print("Es un elemento animado");
	}

	public boolean isCayendo() {
		return cayendo;
	}

	public void setCayendo(boolean cayendo) {
		this.cayendo = cayendo;
	}
	

	/**
	 * Se evalua si el elemento debe caer, y de ser asi se setea como verdadera la variable cayendo
	 * @param m Mapa
	 */
	public void isEstacionario(Mapa m){		
		
		if (m.getEspacios()[this.getX()][this.getY()+1] instanceof EspacioVacio){ 
			this.setCayendo(true);
		}
		else{
			if((m.getEspacios()[this.getX()][this.getY()+1] instanceof Muro) ||
					(m.getEspacios()[this.getX()][this.getY()+1] instanceof Roca) ||
					(m.getEspacios()[this.getX()][this.getY()+1] instanceof Diamante)){
				if ((m.getEspacios()[this.getX()-1][this.getY()] instanceof EspacioVacio) && 
						(m.getEspacios()[this.getX()-1][this.getY()+1] instanceof EspacioVacio)){
					this.setX(this.getX()-1);
					m.modificarEspacio(this.getX(), this.getY(), this);
					m.modificarEspacio(this.getX()+1, this.getY(), new EspacioVacio(this.getX()+1, this.getY()));
					this.setCayendo(true);
				}
				else{
					if ((m.getEspacios()[this.getX()+1][this.getY()] instanceof EspacioVacio) && 
							(m.getEspacios()[this.getX()+1][this.getY()+1] instanceof EspacioVacio)){
						this.setX(this.getX()+1);
						m.modificarEspacio(this.getX(), this.getY(), this);
						m.modificarEspacio(this.getX()-1, this.getY(), new EspacioVacio(this.getX()-1, this.getY()));
						this.setCayendo(true);
					}
				}
			}
		}
	}
		
	/**
	 * Si la variable cayendo es verdadera modifica la posicion del elemento
	 * @param m Mapa
	 */
	public void caer(Mapa m){  
		if (m.getEspacios()[this.getY()][this.getY()+1] instanceof EspacioVacio){
			this.setY(this.getY()+1);
			m.modificarEspacio(this.getX(), this.getY(), this);
			m.modificarEspacio(this.getX(), this.getY()-1, new EspacioVacio(this.getX(), this.getY()-1));
			this.informarCaida();
			m.actualizarMapa();
		}
		else{
			this.setCayendo(false);

		}
	}
	
	/**
	 * Actualizar que ejecuta el metodo correspondiente de acuerdo al estado de cayendo
	 * @param Mapa
	 */
	public void actualizar(Mapa m){ //
		if (this.isCayendo()){
			this.caer(m);
		}
		else{
			this.isEstacionario(m);
		}
	}
	
	public void informarCaida(){
		System.out.println("La roca de la posicion " + this.getX() + "," + (this.getY()-1) + " cayo a " + this.getX() + "," + this.getY());
	}

}
