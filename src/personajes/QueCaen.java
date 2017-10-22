package personajes;

import Juego.Mapa;

public abstract class QueCaen extends Animados{
	
	public boolean cayendo;
	
	public void informar(){
		System.out.print("Es un elemento animado");
	}

	public boolean isCayendo() {
		return cayendo;
	}

	public void setCayendo(boolean cayendo) {
		this.cayendo = cayendo;
	}
	

	
	public void isEstacionario(Mapa m){
		if (m.getEspacios()[this.getX()][this.getY()+1] instanceof EspacioVacio){ //caso base 
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
					m.modificarEspacio(this.getX()+1, this.getY(), new EspacioVacio());
					this.setCayendo(true);
					m.actualizarMapa();
				}
				else{
					if ((m.getEspacios()[this.getX()+1][this.getY()] instanceof EspacioVacio) && 
							(m.getEspacios()[this.getX()+1][this.getY()+1] instanceof EspacioVacio)){
						this.setX(this.getX()+1);
						m.modificarEspacio(this.getX(), this.getY(), this);
						m.modificarEspacio(this.getX()-1, this.getY(), new EspacioVacio());
						this.setCayendo(true);
						m.actualizarMapa();
					}
				}
			}
		}
	}
		
	public void caer(Mapa m){
		if (m.getEspacios()[this.getY()][this.getY()+1] instanceof EspacioVacio){ // capaz con un case queda mejor
			this.setY(this.getY()+1);
			m.modificarEspacio(this.getX(), this.getY(), this);
			m.modificarEspacio(this.getX(), this.getY()-1, new EspacioVacio());
		}
		this.caer(m);//Acá me parece que seria el llamado recursivo
		m.actualizarMapa();
		}
	
	public void actualizar(Mapa m){ //aca creo que se tendria que ejecutar en los actualizar
		if (this.isCayendo()){
			this.caer(m);
		}
		else
			this.isEstacionario(m);
	}

}
