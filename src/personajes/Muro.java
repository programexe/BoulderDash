package personajes;

public abstract class Muro extends Inanimados{
	
	public Muro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Muro(int i, int j) {
		super(i, j);
		// TODO Auto-generated constructor stub
	}

	public void informar(){
		System.out.print("Es un muro");
	}

}
