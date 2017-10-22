package personajes;
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
	


	public void informar(){
		System.out.print("Es un elemento explosivo");
	}

}
