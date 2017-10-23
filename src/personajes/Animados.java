package personajes;


public abstract class Animados extends Elementos {
	public Animados() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Animados(int i, int j) {
		super(i, j);
		this.setDireccionActual("Derecha");
		
	}

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
	}
	
	public void Explotar(){
		
	}
}
