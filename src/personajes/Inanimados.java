package personajes;

public abstract class Inanimados extends Elementos{

	public Inanimados(int i, int j) {
		super(i, j);
		// TODO Auto-generated constructor stub
	}
	public Inanimados(){
		super();
		
	}

	public void informar(){
		System.out.print("Es un elemento inanimado");
	}
}
