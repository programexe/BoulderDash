package personajes;
import Juego.*;

/* COMENTARIO DE PRUEBA PARA GIT*/

public class Rockford extends Animados{
	private boolean muerto=false;
	private int x;
	private int y;
	private int recolectados=0;
	
	public void agarrarDiamante(Mapa m){
		m.modificarEspacio(this.getX(), this.getY(), new EspacioVacio());
		recolectados++;
	}
	
	public void moverDerecha(Mapa m){
		
<<<<<<< HEAD
		if ((m.getEspacios()[this.getX()+1][this.getY()]) instanceof Basura){
			this.setX(x+1);
			m.modificarEspacio(this.getX(), this.getY(), this);
		}
		else
			if (m.getEspacios()[this.getX()+1][this.getY()] instanceof EspacioVacio){
				this.setX(x+1);
				m.modificarEspacio(this.getX(), this.getY(), this);
			}
			else
				if (m.getEspacios()[this.getX()+1][this.getY()] instanceof Puerta){
					if(!(m.getEspacios()[this.getX()+1][this.getY()]).isAbierta()//??????)
					{
						System.out.print("La puerta esta cerrada");
					}
				else //pasar nivel????
				}
				else
					if((m.getEspacios()[this.getX()+1][this.getY()]) instanceof Diamante){
						agarrarDiamante(m);
						this.setX(x+1);
						m.modificarEspacio(this.getX(), this.getY(), this);
					}
					else{
						System.out.print("Rockford no puede moverse a ese lugar");
					}
=======
>>>>>>> 9a82865c183485cd18e6dc272740fe815617e826
		
	}
	
	public void moverIzquierda(Mapa m){
		
		if ((m.getEspacios()[this.getX()][this.getY()]) instanceof Basura){
			this.setX(x-1);
		}
		else
			if (m.getEspacios()[this.getX()][this.getY()] instanceof EspacioVacio){
				this.setX(x-1);
			}
			else
				if (m.getEspacios()[this.getX()][this.getY()] instanceof Puerta){
					
				}
				else{
					System.out.println("Rokford no puede moverse al lugar seleccionado");
				}
		
	}
	
	public void moverArriba(Mapa m){
		
		if ((m.getEspacios()[this.getX()][this.getY()]) instanceof Basura){
			this.setY(y-1);
		}
		else
			if (m.getEspacios()[this.getX()][this.getY()] instanceof EspacioVacio){
				this.setY(y-1);
			}
			else
				if (m.getEspacios()[this.getX()][this.getY()] instanceof Puerta){
					
				}
				else{
					System.out.println("Rokford no puede moverse al lugar seleccionado");
				}
		
	}
	
	public void moverAbajo(Mapa m){
		
		if ((m.getEspacios()[this.getX()][this.getY()]) instanceof Basura){
			this.setY(y+1);
		}
		else
			if (m.getEspacios()[this.getX()][this.getY()] instanceof EspacioVacio){
				this.setY(y+1);
			}
			else
				if (m.getEspacios()[this.getX()][this.getY()] instanceof Puerta){
					
				}
				else{
					System.out.println("Rokford no puede moverse al lugar seleccionado");
				}
		
	}
	
	public boolean isMuerto() {
		return muerto;
	}
	public void setMuerto(boolean muerto) {
		this.muerto = muerto;
	}

	public int getRecolectados() {
		return recolectados;
	}
	public void setRecolectados(int recolectados) {
		this.recolectados = recolectados;
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
