package personajes;

public class Rockford extends Animados{
	private boolean muerto;
	private int posicion[][];
	private int recolectados;
	
	public boolean isMuerto() {
		return muerto;
	}
	public void setMuerto(boolean muerto) {
		this.muerto = muerto;
	}
	public int[][] getPosicion() {
		return posicion;
	}
	public void setPosicion(int[][] posicion) {
		this.posicion = posicion;
	}
	public int getRecolectados() {
		return recolectados;
	}
	public void setRecolectados(int recolectados) {
		this.recolectados = recolectados;
	}
	
}
