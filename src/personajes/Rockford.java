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
		
		if ((m.getEspacios()[this.getX()+1][this.getY()]) instanceof Basura){
			this.setX(this.getX()+1);
			m.modificarEspacio(this.getX(), this.getY(), this);
		}
		else
		{
			if (m.getEspacios()[this.getX()+1][this.getY()] instanceof EspacioVacio){
				this.setX(this.getX()+1);
				m.modificarEspacio(this.getX(), this.getY(), this);
			}
			else{
				
				if (m.getEspacios()[this.getX()+1][this.getY()] instanceof Puerta){
					Puerta puertaAuxiliar= (Puerta) m.getEspacios()[this.getX()+1][this.getY()];
					if(!puertaAuxiliar.isAbierta()){
						System.out.print("La puerta esta cerrada");
					}
					else m.setNivelTerminado(true);
				}
				else
				{
					if((m.getEspacios()[this.getX()+1][this.getY()]) instanceof Diamante){
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
			this.setX(this.getX()-1);
			m.modificarEspacio(this.getX(), this.getY(), this);
		}
		else
		{
			if (m.getEspacios()[this.getX()-1][this.getY()] instanceof EspacioVacio){
				this.setX(this.getX()-1);
				m.modificarEspacio(this.getX(), this.getY(), this);
			}
			else{
				
				if (m.getEspacios()[this.getX()-1][this.getY()] instanceof Puerta){
					Puerta puertaAuxiliar= (Puerta) m.getEspacios()[this.getX()-1][this.getY()];
					if(!puertaAuxiliar.isAbierta()){
						System.out.print("La puerta esta cerrada");
					}
					else m.setNivelTerminado(true);
				}
				else
				{
					if((m.getEspacios()[this.getX()-1][this.getY()]) instanceof Diamante){
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
			this.setY(this.getY()+1);
			m.modificarEspacio(this.getX(), this.getY(), this);
		}
		else
		{
			if (m.getEspacios()[this.getX()][this.getY()+1] instanceof EspacioVacio){
				this.setY(this.getY()+1);
				m.modificarEspacio(this.getX(), this.getY(), this);
			}
			else{
				
				if (m.getEspacios()[this.getX()][this.getY()+1] instanceof Puerta){
					Puerta puertaAuxiliar= (Puerta) m.getEspacios()[this.getX()][this.getY()+1];
					if(!puertaAuxiliar.isAbierta()){
						System.out.print("La puerta esta cerrada");
					}
					else m.setNivelTerminado(true);
				}
				else
				{
					if((m.getEspacios()[this.getX()][this.getY()+1]) instanceof Diamante){
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
			this.setY(this.getY()-1);
			m.modificarEspacio(this.getX(), this.getY(), this);
		}
		else
		{
			if (m.getEspacios()[this.getX()][this.getY()-1] instanceof EspacioVacio){
				this.setY(this.getY()-1);
				m.modificarEspacio(this.getX(), this.getY(), this);
			}
			else{
				
				if (m.getEspacios()[this.getX()][this.getY()-1] instanceof Puerta){
					Puerta puertaAuxiliar= (Puerta) m.getEspacios()[this.getX()][this.getY()-1];
					if(!puertaAuxiliar.isAbierta()){
						System.out.print("La puerta esta cerrada");
					}
					else m.setNivelTerminado(true);
				}
				else
				{
					if((m.getEspacios()[this.getX()][this.getY()-1]) instanceof Diamante){
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
