package personajes;

import Juego.Mapa;

public abstract class QueCaen extends Animados{
	
	public QueCaen() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QueCaen(int i, int j) {
		super(i, j);
		// TODO Auto-generated constructor stub
	}

	public boolean cayendo; //Indica si el elemento debe caer
	
	public void informar(){
		System.out.print("Es un elemento animado");
	}

	public boolean isCayendo() {
		return cayendo;
	}

	public void setCayendo(boolean cayendo) {
		this.cayendo = cayendo;
	}
	

	
	public void isEstacionario(Mapa m){		//Se evalua si el elemnto debe caer, y de ser se setea como verdadera la variable cayendo
		if (m.getEspacios()[this.getX()][this.getY()+1] instanceof EspacioVacio){ 
			this.setCayendo(true);
			m.actualizarMapa();
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
					m.actualizarMapa();
				}
				else{
					if ((m.getEspacios()[this.getX()+1][this.getY()] instanceof EspacioVacio) && 
							(m.getEspacios()[this.getX()+1][this.getY()+1] instanceof EspacioVacio)){
						this.setX(this.getX()+1);
						m.modificarEspacio(this.getX(), this.getY(), this);
						m.modificarEspacio(this.getX()-1, this.getY(), new EspacioVacio(this.getX()-1, this.getY()));
						this.setCayendo(true);
						m.actualizarMapa();
					}
				}
			}
		}
	}
		
	public void caer(Mapa m){  //Si cayendo es true hace caer el elemento
		if (m.getEspacios()[this.getY()][this.getY()+1] instanceof EspacioVacio){ // capaz con un case queda mejor
			this.setY(this.getY()+1);
			m.modificarEspacio(this.getX(), this.getY(), this);
			m.modificarEspacio(this.getX(), this.getY()-1, new EspacioVacio(this.getX(), this.getY()-1));
		}
		m.actualizarMapa();
		}
	
	public void actualizar(Mapa m){ //
		if (this.isCayendo()){
			this.caer(m);
		}
		else
			this.isEstacionario(m);
	}

}
