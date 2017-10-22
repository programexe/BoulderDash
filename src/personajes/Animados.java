package personajes;

import Juego.Mapa;

public abstract class Animados extends Elementos {
	private String direccionActual;
	
	public void cambiarDireccion(){
		
	}
	
	public String getDireccionActual() {
		return direccionActual;
	}
	public void setDireccionActual(String direccionActual) {
		this.direccionActual = direccionActual;
	}
	
	public void informar(){
		System.out.print("Es un objeto animado");
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
			
			personaje.setMuerto(true); // duda aca porque si la roca cae sobre luciernaga o mariposa rockford no tiene que morir
		}
	}
}
