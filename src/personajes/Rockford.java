package personajes;
import Juego.*;

/* COMENTARIO DE PRUEBA PARA GIT*/

public class Rockford extends Animados{
	private boolean muerto=false;
	
	public void agarrarDiamante(Mapa m){
		m.modificarEspacio(this.getX(), this.getY(), new EspacioVacio());
		m.setDiamantesRecolectados(m.getDiamantesRecolectados()+1);
	}
	
	public void moverDerecha(Mapa m){
<<<<<<< HEAD
		

=======
>>>>>>> a8ef37f11a2c3e1e998450c779c9d645f4fbf9f5
		if ((m.getEspacios()[this.getX()+1][this.getY()]) instanceof Basura){
			m.modificarEspacio(this.getX(), this.getY(), new EspacioVacio());
			this.setX(this.getX()+1);
			m.modificarEspacio(this.getX(), this.getY(), this);
		}
		else
		{
			if (m.getEspacios()[this.getX()+1][this.getY()] instanceof EspacioVacio){
				m.modificarEspacio(this.getX(), this.getY(), new EspacioVacio());
				this.setX(this.getX()+1);
				m.modificarEspacio(this.getX(), this.getY(), this);
			}
			else{
				
				if (m.getEspacios()[this.getX()+1][this.getY()] instanceof Puerta){
<<<<<<< HEAD

=======
>>>>>>> a8ef37f11a2c3e1e998450c779c9d645f4fbf9f5
					Puerta puertaAuxiliar= (Puerta) m.getEspacios()[this.getX()+1][this.getY()];
					if(!puertaAuxiliar.isAbierta()){
						System.out.print("La puerta esta cerrada");
					}
					
					else{
						m.modificarEspacio(this.getX(), this.getY(), new EspacioVacio());
						m.setNivelTerminado(true);
<<<<<<< HEAD

					Puerta p = new Puerta();
						if(p = (Puerta) m.getEspacios()[this.getX()+1][this.getY()]) //??????)
						{
						System.out.print("La puerta esta cerrada");
						}
						else{
						//pasar nivel????
						}
=======
>>>>>>> a8ef37f11a2c3e1e998450c779c9d645f4fbf9f5
					}
				}
				else
				{
					if((m.getEspacios()[this.getX()+1][this.getY()]) instanceof Diamante){
						m.modificarEspacio(this.getX(), this.getY(), new EspacioVacio());
						this.setX(this.getX()+1);
						agarrarDiamante(m);
						m.modificarEspacio(this.getX(), this.getY(), this);
					}
					else{
						System.out.print("Rockford no puede moverse a ese lugar");
					}
				}
			}
		}
		m.actualizarMapa();
	}
		
	
	public void moverIzquierda(Mapa m){
		
		if ((m.getEspacios()[this.getX()-1][this.getY()]) instanceof Basura){
			m.modificarEspacio(this.getX(), this.getY(), new EspacioVacio());
			this.setX(this.getX()-1);
			m.modificarEspacio(this.getX(), this.getY(), this);
		}
		else
		{
			if (m.getEspacios()[this.getX()-1][this.getY()] instanceof EspacioVacio){
				m.modificarEspacio(this.getX(), this.getY(), new EspacioVacio());
				this.setX(this.getX()-1);
				m.modificarEspacio(this.getX(), this.getY(), this);
			}
			else{
				
				if (m.getEspacios()[this.getX()-1][this.getY()] instanceof Puerta){
					Puerta puertaAuxiliar= (Puerta) m.getEspacios()[this.getX()-1][this.getY()];
					if(!puertaAuxiliar.isAbierta()){
						System.out.print("La puerta esta cerrada");
					}
					else{
						m.modificarEspacio(this.getX(), this.getY(), new EspacioVacio());
						m.setNivelTerminado(true);
					}
				}
				else
				{
					if((m.getEspacios()[this.getX()-1][this.getY()]) instanceof Diamante){
						m.modificarEspacio(this.getX(), this.getY(), new EspacioVacio());
						this.setX(this.getX()-1);
						agarrarDiamante(m);
						m.modificarEspacio(this.getX(), this.getY(), this);
					}
					else{
						System.out.print("Rockford no puede moverse a ese lugar");
					}
				}
			}
		}	
		m.actualizarMapa();
	}
	
	public void moverArriba(Mapa m){
		
		if ((m.getEspacios()[this.getX()][this.getY()+1]) instanceof Basura){
			m.modificarEspacio(this.getX(), this.getY(), new EspacioVacio());
			this.setY(this.getY()+1);
			m.modificarEspacio(this.getX(), this.getY(), this);
		}
		else
		{
			if (m.getEspacios()[this.getX()][this.getY()+1] instanceof EspacioVacio){
				m.modificarEspacio(this.getX(), this.getY(), new EspacioVacio());
				this.setY(this.getY()+1);
				m.modificarEspacio(this.getX(), this.getY(), this);
			}
			else{
				
				if (m.getEspacios()[this.getX()][this.getY()+1] instanceof Puerta){
					Puerta puertaAuxiliar= (Puerta) m.getEspacios()[this.getX()][this.getY()+1];
					if(!puertaAuxiliar.isAbierta()){
						System.out.print("La puerta esta cerrada");
					}
					else{
						m.modificarEspacio(this.getX(), this.getY(), new EspacioVacio());
						m.setNivelTerminado(true);
					}
				}
				else
				{
					if((m.getEspacios()[this.getX()][this.getY()+1]) instanceof Diamante){
						m.modificarEspacio(this.getX(), this.getY(), new EspacioVacio());
						this.setY(this.getY()+1);
						agarrarDiamante(m);
						m.modificarEspacio(this.getX(), this.getY(), this);
					}
					else{
						System.out.print("Rockford no puede moverse a ese lugar");
					}
				}
			}
		}	
		m.actualizarMapa();
	}
	
	public void moverAbajo(Mapa m){
		
		if ((m.getEspacios()[this.getX()][this.getY()-1]) instanceof Basura){
			m.modificarEspacio(this.getX(), this.getY(), new EspacioVacio());
			this.setY(this.getY()-1);
			m.modificarEspacio(this.getX(), this.getY(), this);
		}
		else
		{
			if (m.getEspacios()[this.getX()][this.getY()-1] instanceof EspacioVacio){
				m.modificarEspacio(this.getX(), this.getY(), new EspacioVacio());
				this.setY(this.getY()-1);
				m.modificarEspacio(this.getX(), this.getY(), this);
			}
			else{
				
				if (m.getEspacios()[this.getX()][this.getY()-1] instanceof Puerta){
					Puerta puertaAuxiliar= (Puerta) m.getEspacios()[this.getX()][this.getY()-1];
					if(!puertaAuxiliar.isAbierta()){
						System.out.print("La puerta esta cerrada");
					}
					else{
						m.modificarEspacio(this.getX(), this.getY(), new EspacioVacio());
						m.setNivelTerminado(true);
					}
				}
				else
				{
					if((m.getEspacios()[this.getX()][this.getY()-1]) instanceof Diamante){
						m.modificarEspacio(this.getX(), this.getY(), new EspacioVacio());
						this.setY(this.getY()-1);
						agarrarDiamante(m);
						m.modificarEspacio(this.getX(), this.getY(), this);
					}
					else{
						System.out.print("Rockford no puede moverse a ese lugar");
					}
				}
			}
		}
		m.actualizarMapa();
	}
	
	public boolean isMuerto() {
		return muerto;
	}
	public void setMuerto(boolean muerto) {
		this.muerto = muerto;
	}
}
