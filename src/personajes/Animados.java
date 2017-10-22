package personajes;

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
}
