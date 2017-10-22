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
	
	public void Explotar(Mapa m, Rockford personaje){ //esto iria en animados???
		if ((m.getEspacios()[this.getX()-1][this.getX()] instanceof Rockford) || 
				(m.getEspacios()[this.getX()+1][this.getX()] instanceof Rockford) || 
				(m.getEspacios()[this.getX()][this.getX()-1]) instanceof Rockford || 
				(m.getEspacios()[this.getX()][this.getX()+1] instanceof Rockford)){
			
			m.modificarEspacio(this.getX()-1, this.getY(), new EspacioVacio());
			m.modificarEspacio(this.getX()+1, this.getY(), new EspacioVacio());
			m.modificarEspacio(this.getX(), this.getY()-1, new EspacioVacio());
			m.modificarEspacio(this.getX(), this.getY()+1, new EspacioVacio());
			
			personaje.setMuerto(true); // duda aca porque si la roca cae sobre luciernaga o mariposa rockford no tiene que morir
		}
	}

}
