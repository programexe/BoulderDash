package personajes;

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
		}
	}
	public void informar(){
		System.out.print("Es una luciernaga");
	}

}
