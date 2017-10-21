package personajes;

public abstract class QueNoCaen extends Animados{
	private String direccionActual;
	
	public void cambiarDireccion(){
	}
	public void informar(){
		System.out.print("Es un elemento que no cae");
	}
	public String getDireccionActual() {
		return direccionActual;
	}
	public void setDireccionActual(String direccionActual) {
		this.direccionActual = direccionActual;
	}
}
