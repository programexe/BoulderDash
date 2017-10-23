package personajes;

public abstract class Explosivos extends QueNoCaen{
	
	public Explosivos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Explosivos(int i, int j) {
		super(i, j);
		// TODO Auto-generated constructor stub
	}

	public void informar(){
		System.out.print("Es explosivo");
	}
}
