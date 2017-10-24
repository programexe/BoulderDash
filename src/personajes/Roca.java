package personajes;

public class Roca extends QueCaen{

	public Roca() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Roca(int i, int j, boolean cayendo) {
		super(i, j, cayendo);
		// TODO Auto-generated constructor stub
	}

	public void informar(){
		System.out.print("Es una roca");
	}
}
