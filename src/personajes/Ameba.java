package personajes;
import Juego.*;

public class Ameba extends Animados {
	
	int x;
	int y;
	
	public void cambiarDireccion(){
		int n = (int) (Math.random() * 4) + 1;
		
		switch (n){
		
		case 1: this.setDireccionActual("Abajo");
			break;
			
		case 2: this.setDireccionActual("Izquierda");
			break;
	
		case 3: this.setDireccionActual("Arriba");
			break;
	
		case 4: this.setDireccionActual("Derecha");
			break;
	}
	}
	
	public void actualizar(Mapa m){
		
		switch (this.getDireccionActual()){
		
			case "Izquierda":{
				if ((m.getEspacios()[this.getX()-1][this.getY()] instanceof EspacioVacio) ||
						(m.getEspacios()[this.getX()-1][this.getY()] instanceof Basura)) {
					this.setX(x-1);
					m.modificarEspacio(x, y, this);
				}
				else 
					this.cambiarDireccion();
			}
			break;
		
			case "Abajo":{
				if ((m.getEspacios()[this.getX()][this.getY()+1] instanceof EspacioVacio) ||
					(m.getEspacios()[this.getX()-1][this.getY()] instanceof Basura)){
					this.setY(y+1);
					m.modificarEspacio(x, y, this);
				}
				else 
					this.cambiarDireccion();
			}
			break;
			
			case "Derecha":{
				if ((m.getEspacios()[this.getX()+1][this.getY()] instanceof EspacioVacio) ||
						(m.getEspacios()[this.getX()-1][this.getY()] instanceof Basura)){
					this.setX(x+1);
					m.modificarEspacio(x, y, this);
				}
				else 
					this.cambiarDireccion();
			}
			break;
			
			case "Arriba":{
				if ((m.getEspacios()[this.getX()][this.getY()-1] instanceof EspacioVacio) ||
						(m.getEspacios()[this.getX()-1][this.getY()] instanceof Basura)){
					this.setY(y-1);
					m.modificarEspacio(x, y, this);
				}
				else 
					this.cambiarDireccion();
			}
			break;
		}
	}
	
	public void informar(){
		System.out.print("Es ameba");
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	

}
