package personajes;

public class Puerta extends Inanimados{
	
	private boolean abierta;

	public void informar(){
		if (abierta){
			System.out.print("Es una puerta abierta");
		}
		else System.out.print("Es una puerta cerrada");
	}
}
