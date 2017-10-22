package personajes;

public abstract class Elementos{
	private int x;
	private int y;
	private boolean destructible;
	
	public void actualizar(){
	}
	
	public void actualizarPorTimer(){
		
	}
	
	public void informar(){
		System.out.print("Es elemento");
	}


	public boolean isDestructible() {
		return destructible;
	}

	public void setDestructible(boolean destructible) {
		this.destructible = destructible;
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
