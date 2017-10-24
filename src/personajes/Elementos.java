package personajes;
import Juego.*;

//Esta clase es la padre de todos los personajes que hay en el juego
//Contiene las coordenadas de su ubicacion en el mapa
public abstract class Elementos{
	private int x;
	private int y;
	
	public Elementos(){
		
	}
	public Elementos(int i,int j){
		this.y=j;
		this.x=i;
	}
	
	public void actualizar(Mapa m){
	}
	
	public void actualizarPorTimer(Mapa m){
		
	}
	
	public void informar(){
		System.out.print("Es elemento ");
	}


	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
