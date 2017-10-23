package personajes;

import Juego.Mapa;

public class MuroMagico extends Muro {
	
	public MuroMagico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MuroMagico(int i, int j) {
		super(i, j);
		// TODO Auto-generated constructor stub
	}

	private int tiempo;
	private int seg30=0;

	public void informar(){
		System.out.print("Es un muro magico");
	}
	
	public void actualizar(Mapa m){
		convertir(m);
		}
	
	public void actualizarPorTimer(){
		if (tiempo!=0){
			tiempo--;
		}
		else if (seg30!=30){
			seg30++;
		}
		else {
			seg30=0;
			tiempo=5;
		}
	}
	
	public void convertir(Mapa m){
		
		if((this.getTiempo()!=0) && (m.getEspacios()[this.getX()+1][this.getY()] instanceof Diamante)){
			m.modificarEspacio(this.getX()+1, this.getY(), new Roca());
		}
		else{
			if ((this.getTiempo()!=0) && (m.getEspacios()[this.getX()+1][this.getY()] instanceof Roca)){
				m.modificarEspacio(this.getX()+1, this.getY(), new Diamante());
			}
		}
		
		if((this.getTiempo()!=0) && (m.getEspacios()[this.getX()-1][this.getY()] instanceof Diamante)){
			m.modificarEspacio(this.getX()-1, this.getY(), new Roca());
		}
		else{
			if ((this.getTiempo()!=0) && (m.getEspacios()[this.getX()-1][this.getY()] instanceof Roca)){
				m.modificarEspacio(this.getX()-1, this.getY(), new Diamante());
			}
		}
		
		if((this.getTiempo()!=0) && (m.getEspacios()[this.getX()][this.getY()+1] instanceof Diamante)){
			m.modificarEspacio(this.getX(), this.getY()+1, new Roca());
		}
		else{
			if ((this.getTiempo()!=0) && (m.getEspacios()[this.getX()+1][this.getY()] instanceof Roca)){
				m.modificarEspacio(this.getX(), this.getY()+1, new Diamante());
			}
		}
		
		if((this.getTiempo()!=0) && (m.getEspacios()[this.getX()][this.getY()-1] instanceof Diamante)){
			m.modificarEspacio(this.getX(), this.getY()-1, new Roca());
		}
		else{
			if ((this.getTiempo()!=0) && (m.getEspacios()[this.getX()][this.getY()-1] instanceof Roca)){
				m.modificarEspacio(this.getX(), this.getY()-1, new Diamante());
			}
		}
	}
	
	
		
	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	
	
}
