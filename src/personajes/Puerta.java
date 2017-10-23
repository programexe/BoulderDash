package personajes;

import Juego.Mapa;

public class Puerta extends Inanimados{
	
	public Puerta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Puerta(int i, int j) {
		super(i, j);
		// TODO Auto-generated constructor stub
	}

	private boolean abierta;  //Variable que indica si la puerta esta abierta. Si esta abierta es true

	public void informar(){
		if (abierta){
			System.out.print("Es una puerta abierta");
		}
		else System.out.print("Es una puerta cerrada");
	}

	public boolean isAbierta() {
		return abierta;
	}

	public void setAbierta(boolean abierta) {
		this.abierta = abierta;
	}
	
	public void actualizar(Mapa m){		//Evalua si se recolectaros todos los diamantes. De ser asi se abre la puerta
		if(m.getTotalDiamantes()-m.getDiamantesRecolectados()==0){
			this.setAbierta(true);
		}
	}
}
