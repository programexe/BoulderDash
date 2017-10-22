package personajes;
import Juego.*;

public class Luciernaga extends Explosivos {
	
	public void cambiarDireccion(){
		
		switch (this.getDireccionActual()){
			case "Izquierda": this.setDireccionActual("Arriba");
				break;
			
			case "Arriba": this.setDireccionActual("Derecha");
				break;
		
			case "Derecha": this.setDireccionActual("Abajo");		
				break;
		
			case "Abajo": this.setDireccionActual("Izquierda");
				break;
			
			default: break;
		}
	}
	
	
	public void actualizar(Mapa m){
		
		switch (this.getDireccionActual()){
		
			case "Derecha": {
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
			
			case "Abajo": {
				if (m.getEspacios()[this.getX()][this.getY()+1] instanceof EspacioVacio){
					this.setY(this.getY()+1);
					m.modificarEspacio(this.getX(), this.getY(), this);
					m.modificarEspacio(this.getX(), this.getY()-1, new EspacioVacio());
				}
				else{
					if (m.getEspacios()[this.getX()+1][this.getY()] instanceof Rockford){
						this.Explotar(m, (Rockford) m.getEspacios()[this.getX()][this.getY()+1]);
					}
					else
						this.cambiarDireccion();
				}
			}
			break;
			
			case "Izquierda": {
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
			
			case "Arriba": {
				if (m.getEspacios()[this.getX()][this.getY()+1] instanceof EspacioVacio){
					this.setY(this.getY()-1);
					m.modificarEspacio(this.getX(), this.getY(), this);
					m.modificarEspacio(this.getX(), this.getY()+1, new EspacioVacio());
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
		}
			
	}
				
	public void informar(){
		System.out.print("Es una luciernaga");
	}

}
