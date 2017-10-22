package personajes;

import Juego.Mapa;

public abstract class Explosivos extends QueNoCaen{
	
	public void Explotar(Mapa m, Rockford personaje){ //esto iria en animados???
		if ((m.getEspacios()[this.getX()-1][this.getX()] instanceof Rockford) || 
				(m.getEspacios()[this.getX()+1][this.getX()] instanceof Rockford) || 
				(m.getEspacios()[this.getX()][this.getX()-1]) instanceof Rockford || 
				(m.getEspacios()[this.getX()][this.getX()+1] instanceof Rockford)){
			
			m.modificarEspacio(this.getX()-1, this.getY(), new EspacioVacio());
			m.modificarEspacio(this.getX()+1, this.getY(), new EspacioVacio());
			m.modificarEspacio(this.getX(), this.getY()-1, new EspacioVacio());
			m.modificarEspacio(this.getX(), this.getY()+1, new EspacioVacio());
			
			personaje.setMuerto(true);
		}
	}
	
	public void informar(){
		System.out.print("Es explosivo");
	}
}
