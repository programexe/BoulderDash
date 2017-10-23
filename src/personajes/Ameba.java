package personajes;
import Juego.*;

public class Ameba extends Animados {
	
	


	public Ameba() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ameba(int i, int j) {
		super(i, j);
		// TODO Auto-generated constructor stub
	}

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
		
		expandirse(m);	
	}
	
	public void expandirse(Mapa m){			//Evalua si la ameba tiene que expandirse y en cual direccion.
											//Si debe expandirse lo hace
		
		switch (this.getDireccionActual()){
		
		case "Izquierda":{
			if ((m.getEspacios()[this.getX()-1][this.getY()] instanceof EspacioVacio) ||
					(m.getEspacios()[this.getX()-1][this.getY()] instanceof Basura)) {
				this.setX(this.getX()-1);
				m.modificarEspacio(this.getX(), this.getY(), this);
			}
			else 
				this.cambiarDireccion();
		}
		break;
	
		case "Abajo":{
			if ((m.getEspacios()[this.getX()][this.getY()+1] instanceof EspacioVacio) ||
				(m.getEspacios()[this.getX()][this.getY()+1] instanceof Basura)){
				this.setY(this.getY()+1);
				m.modificarEspacio(this.getX(), this.getY(), this);
			}
			else 
				this.cambiarDireccion();
		}
		break;
		
		case "Derecha":{
			if ((m.getEspacios()[this.getX()+1][this.getY()] instanceof EspacioVacio) ||
					(m.getEspacios()[this.getX()+1][this.getY()] instanceof Basura)){
				this.setX(this.getX()+1);
				m.modificarEspacio(this.getX(), this.getY(), this);
			}
			else 
				this.cambiarDireccion();
		}
		break;
		
		case "Arriba":{
			if ((m.getEspacios()[this.getX()][this.getY()-1] instanceof EspacioVacio) ||
					(m.getEspacios()[this.getX()][this.getY()-1] instanceof Basura)){
				this.setY(this.getY()-1);
				m.modificarEspacio(this.getX(), this.getY(), this);
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

}
