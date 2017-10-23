package personajes;

public abstract class QueNoCaen extends Animados{
	
		
	public QueNoCaen() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QueNoCaen(int i, int j) {
		super(i, j);
		// TODO Auto-generated constructor stub
	}

	public void informar(){
		System.out.print("Es un elemento que no cae");
	}
	
}
