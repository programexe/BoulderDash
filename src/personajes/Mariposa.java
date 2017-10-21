package personajes;
import Juego.*;

public class Mariposa extends Explosivos {
	
	public void cambiarDireccion(){
		switch (this.getDireccionActual()){
		case "Izquierda": this.setDireccionActual("Abajo");
		break;
		case "Arriba": this.setDireccionActual("Izquierda");
		break;
		case "Derecha": this.setDireccionActual("Arriba");
		break;
		case "Abajo": this.setDireccionActual("Derecha");
		break;
		}
	}
	
	public void Explotar(Mapa m, Rockford personaje){
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
		System.out.print("Es un elemento explosivo");
	}

}
