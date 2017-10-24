package personajes;
import Juego.*;

public class Luciernaga extends Explosivos {
	
	public Luciernaga() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Luciernaga(int i, int j) {
		super(i, j);
		// TODO Auto-generated constructor stub
	}


	public void cambiarDireccion(){		//Indica en que direccion debe moverse la luciernaga
		
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
	
	
	public void actualizarPorTimer(Mapa m){		//La luciernaga se movera cada vez que se ejecute el codigo del timer
		this.moverse(m);			
	}
	
	public void actualizar(Mapa m){	
		explotar(m);
	}
	
	public void explotar(Mapa m){		//Evalua si debe explotar y de ser asi lo hace
		if ((m.getEspacios()[this.getX()][this.getY()-1]) instanceof Roca){
			
			if(!(m.getEspacios()[this.getX()][this.getY()] instanceof Muro)){
				m.modificarEspacio(this.getX(), this.getY(), new EspacioVacio(this.getX(), this.getY()));
				
			}
			
			if(!(m.getEspacios()[this.getX()-1][this.getY()] instanceof Muro)){
				m.modificarEspacio(this.getX()-1, this.getY(), new EspacioVacio(this.getX()-1, this.getY()));
				
			}
			
			if(!(m.getEspacios()[this.getX()+1][this.getY()] instanceof Muro)){
				m.modificarEspacio(this.getX()+1, this.getY(), new EspacioVacio(this.getX()+1, this.getY()));
				
			}
			
			if(!(m.getEspacios()[this.getX()][this.getY()-1] instanceof Muro)){
				m.modificarEspacio(this.getX(), this.getY()-1, new EspacioVacio(this.getX(), this.getY()-1));
				
			}
			
			if(!(m.getEspacios()[this.getX()][this.getY()+1] instanceof Muro)){
				m.modificarEspacio(this.getX(), this.getY()+1, new EspacioVacio(this.getX(), this.getY()+1));
				
			}
			
			m.actualizarMapa();
		
	}
}
	
	public void moverse(Mapa m){
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
			System.out.println(m.getEspacios()[this.getX()-1][this.getY()].getClass().getName());
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
				
	public void informar(){
		System.out.print("Es una luciernaga");
	}

}
