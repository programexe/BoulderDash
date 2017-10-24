package personajes; 

import Juego.Mapa;


public class Mariposa extends Explosivos {
	
	public Mariposa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mariposa(int i, int j) {
		super(i, j);
		// TODO Auto-generated constructor stub
	}

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
	
	public void moverse(Mapa m){	//Evelua a donde debe moverse la mariposa y en que direccion
									//Si debe moverse lo hace
		switch (this.getDireccionActual()){
		
		case "Derecha": {
			if (m.getEspacios()[this.getX()+1][this.getY()] instanceof EspacioVacio){
				this.setX(this.getX()+1);
				m.modificarEspacio(this.getX(), this.getY(), this);
				m.modificarEspacio(this.getX()-1, this.getY(), new EspacioVacio(this.getX()-1, this.getY()));
				m.actualizarMapa();
			}
				else
					this.cambiarDireccion();
			}
		break;
		
		case "Abajo": {
			if (m.getEspacios()[this.getX()][this.getY()+1] instanceof EspacioVacio){
				this.setY(this.getY()+1);
				m.modificarEspacio(this.getX(), this.getY(), this);
				m.modificarEspacio(this.getX(), this.getY()-1, new EspacioVacio(this.getX(), this.getY()-1));
				m.actualizarMapa();
			}

				else
					this.cambiarDireccion();
			break;
			}
		
		
		
		case "Izquierda": {
			if (m.getEspacios()[this.getX()-1][this.getY()] instanceof EspacioVacio){
				this.setX(this.getX()-1);
				m.modificarEspacio(this.getX(), this.getY(), this);
				m.modificarEspacio(this.getX()+1, this.getY(), new EspacioVacio(this.getX()+1, this.getY()));
				m.actualizarMapa();
			}
				else
					this.cambiarDireccion();
			break;
			}
		
		case "Arriba": {
			if (m.getEspacios()[this.getX()][this.getY()-11] instanceof EspacioVacio){
				this.setY(this.getY()-1);
				m.modificarEspacio(this.getX(), this.getY(), this);
				m.modificarEspacio(this.getX(), this.getY()+1, new EspacioVacio(this.getX(), this.getY()+1));
				m.actualizarMapa();
			}
				else
					this.cambiarDireccion();
			break;
			}
	}
	}
	
	public void explotar(Mapa m){		//Evalua si debe explotar y de ser asi lo hace
		
		if ((m.getEspacios()[this.getX()][this.getY()-1] instanceof Roca)){
			
			if(!(m.getEspacios()[this.getX()+1][this.getY()] instanceof Muro)){
				m.modificarEspacio(this.getX()+1, this.getY(), new Diamante(this.getX()+1, this.getY(), true));
			}
			else{
				m.modificarEspacio(this.getX()+1, this.getY(), new EspacioVacio(this.getX()+1, this.getY()));
			}
			
			if(!(m.getEspacios()[this.getX()-1][this.getY()] instanceof Muro)){
				m.modificarEspacio(this.getX()-1, this.getY(), new Diamante(this.getX()-1, this.getY(), true));
			}
			else{
				m.modificarEspacio(this.getX()-1, this.getY(), new EspacioVacio(this.getX()-1, this.getY()));
			}
			
			if(!(m.getEspacios()[this.getX()][this.getY()+1] instanceof Muro)){
				m.modificarEspacio(this.getX(), this.getY()+1, new Diamante(this.getX(), this.getY()+1, true));
			}
			else{
				m.modificarEspacio(this.getX(), this.getY()+1, new EspacioVacio(this.getX(), this.getY()+1));
			}
			
			if(!(m.getEspacios()[this.getX()][this.getY()-1] instanceof Muro)){
				m.modificarEspacio(this.getX(), this.getY()-1, new Diamante(this.getX(), this.getY()-1, true));
			}
			else{
				m.modificarEspacio(this.getX(), this.getY()-1, new EspacioVacio(this.getX(), this.getY()-1));
			}
			
			m.modificarEspacio(this.getX()+1, this.getY(), new Diamante(this.getX()+1, this.getY(), true));
			m.actualizarMapa();
			
			
		}
		
	}
	
	public void actualizar (Mapa m){
		this.moverse(m);
		this.explotar(m);
		}
	
	/*public void actualizarPorTimer(Mapa m){
		this.moverse(m);
	}*/

	public void informar(){
		System.out.print("Es una mariposa");
	}


}
