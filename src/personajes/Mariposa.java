package personajes;
import Juego.*; 

import Juego.Mapa;


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
	
	public void moverse(Mapa m){
		switch (this.getDireccionActual()){
		
		case "Izquierda":{
			if (m.getEspacios()[this.getX()-1][this.getY()] instanceof EspacioVacio){
				this.setX(this.getX()-1);
				m.modificarEspacio(this.getX(), this.getY(), this);
				m.modificarEspacio(this.getX()+1, this.getY(), new EspacioVacio());
			}
			else{
				if (m.getEspacios()[this.getX()-1][this.getY()] instanceof Rockford){
					this.Explotar(m, (Rockford) m.getEspacios()[this.getX()-1][this.getY()]);
				}
				else
					this.cambiarDireccion();
			}
		}
		break;
		
		case "Abajo":{
			if (m.getEspacios()[this.getX()][this.getY()+1] instanceof EspacioVacio){
				this.setY(this.getY()+1);
				m.modificarEspacio(this.getX(), this.getY(), this);
				m.modificarEspacio(this.getX(), this.getY()-1, new EspacioVacio());
			}
			else{
				if (m.getEspacios()[this.getX()][this.getY()+1] instanceof Rockford){
					this.Explotar(m, (Rockford) m.getEspacios()[this.getX()][this.getY()+1]);
				}
				else
					this.cambiarDireccion();
			}
		}
		break;
		
		case "Derecha":{
			if (m.getEspacios()[this.getX()+1][this.getY()] instanceof EspacioVacio){
				this.setX(this.getX()+1);
				m.modificarEspacio(this.getX(), this.getY(), this);
				m.modificarEspacio(this.getX()-1, this.getY(), new EspacioVacio());
			}
			else{
				if (m.getEspacios()[this.getX()+1][this.getY()] instanceof Rockford){
					this.Explotar(m, (Rockford) m.getEspacios()[this.getX()+1][this.getY()]);
				}
				else
					this.cambiarDireccion();
			}
		}
		break;
		
		case "Arriba":{
			if (m.getEspacios()[this.getX()][this.getY()-1] instanceof EspacioVacio){
				this.setY(this.getY()-1);
				m.modificarEspacio(this.getX(), this.getY(), this);
				m.modificarEspacio(this.getX(), this.getY()+1, new EspacioVacio());
			}
			else{
				if (m.getEspacios()[this.getX()][this.getY()-1] instanceof Rockford){
					this.Explotar(m, (Rockford) m.getEspacios()[this.getX()][this.getY()-1]);
				}
				else
					this.cambiarDireccion();
			}
		}
	}
	}
	
	public void explotar(Mapa m){
		
		if ((m.getEspacios()[this.getX()][this.getY()-1] instanceof Roca)){
			
			if(!(m.getEspacios()[this.getX()+1][this.getY()] instanceof Muro)){
				m.modificarEspacio(this.getX()+1, this.getY(), new Diamante());
			}
			else{
				m.modificarEspacio(this.getX()+1, this.getY(), new EspacioVacio());
			}
			
			if(!(m.getEspacios()[this.getX()-1][this.getY()] instanceof Muro)){
				m.modificarEspacio(this.getX()-1, this.getY(), new Diamante());
			}
			else{
				m.modificarEspacio(this.getX()-1, this.getY(), new EspacioVacio());
			}
			
			if(!(m.getEspacios()[this.getX()][this.getY()+1] instanceof Muro)){
				m.modificarEspacio(this.getX(), this.getY()+1, new Diamante());
			}
			else{
				m.modificarEspacio(this.getX(), this.getY()+1, new EspacioVacio());
			}
			
			if(!(m.getEspacios()[this.getX()][this.getY()-1] instanceof Muro)){
				m.modificarEspacio(this.getX(), this.getY()-1, new Diamante());
			}
			else{
				m.modificarEspacio(this.getX(), this.getY()-1, new EspacioVacio());
			}
			
			m.modificarEspacio(this.getX()+1, this.getY(), new Diamante());
			
			
		}
		m.actualizarMapa();
	}
	
	public void actualizar (Mapa m){
		this.explotar(m);
		}
	
	public void actualizarPorTimer(Mapa m){
		this.moverse(m);
	}

	public void informar(){
		System.out.print("Es una mariposa");
	}


}
