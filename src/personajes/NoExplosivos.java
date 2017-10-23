package personajes;

public abstract class NoExplosivos extends QueNoCaen{

	public NoExplosivos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NoExplosivos(int i, int j) {
		super(i, j);
		// TODO Auto-generated constructor stub
	}

	public void informar(){
		System.out.print("Es un elemento explosivo");
	}
}
