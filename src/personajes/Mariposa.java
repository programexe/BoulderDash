package personajes;

import Juego.Mapa;

public class Mariposa extends Explosivos {
	
	private int x;
	private int y;


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
	
	public void actualizar (Mapa m){
		
		switch (this.getDireccionActual()){
			
			case "Izquierda":{
				if (m.getEspacios()[this.getX()-1][this.getY()] instanceof EspacioVacio){
					this.setX(x-1);
					m.modificarEspacio(x, y, this);
					m.modificarEspacio(x, y, new EspacioVacio());
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
					this.setY(y+1);
					m.modificarEspacio(x, y, this);
					m.modificarEspacio(x, y-1, new EspacioVacio());
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
					this.setX(x+1);
					m.modificarEspacio(x, y, this);
					m.modificarEspacio(x-1, y, new EspacioVacio());
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
					this.setY(y-1);
					m.modificarEspacio(x, y, this);
					m.modificarEspacio(x, y+1, new EspacioVacio());
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

	public void informar(){
		System.out.print("Es un elemento explosivo");
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
