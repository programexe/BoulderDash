package personajes;
import Juego.*;

/* COMENTARIO DE PRUEBA PARA GIT*/

public class Rockford extends Animados{
	public Rockford() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rockford(int i, int j) {
		super(i, j);
		// TODO Auto-generated constructor stub
	}

	private boolean muerto=false;
	
	public void agarrarDiamante(Mapa m){
		m.modificarEspacio(this.getX(), this.getY(), new EspacioVacio(this.getX(), this.getY()));
		m.setDiamantesRecolectados(m.getDiamantesRecolectados()+1);
	}
	
	public void explotar(Mapa m){
		if ((m.getEspacios()[this.getX()][this.getY()-1]) instanceof Roca){
			
			m.modificarEspacio(this.getX(), this.getY(), new EspacioVacio(this.getX(), this.getY()));
			m.modificarEspacio(this.getX()-1, this.getY(), new EspacioVacio(this.getX()-1, this.getY()));
			m.modificarEspacio(this.getX()+1, this.getY(), new EspacioVacio(this.getX()+1, this.getY()));
			m.modificarEspacio(this.getX(), this.getY()-1, new EspacioVacio(this.getX(), this.getY()-1));
			m.modificarEspacio(this.getX(), this.getY()+1, new EspacioVacio(this.getX(), this.getY()+1));
			m.actualizarMapa();
			this.setMuerto(true); 
		}
		if (((m.getEspacios()[this.getX()][this.getY()-1]) instanceof Luciernaga) || (m.getEspacios()[this.getX()][this.getY()-1]) instanceof Mariposa){
			m.modificarEspacio(this.getX(), this.getY(), new EspacioVacio(this.getX(), this.getY()));
			m.modificarEspacio(this.getX()-1, this.getY(), new EspacioVacio(this.getX()-1, this.getY()));
			m.modificarEspacio(this.getX()+1, this.getY(), new EspacioVacio(this.getX()+1, this.getY()));
			m.modificarEspacio(this.getX(), this.getY()-1, new EspacioVacio(this.getX(), this.getY()-1));
			m.modificarEspacio(this.getX(), this.getY()+1, new EspacioVacio(this.getX(), this.getY()+1));
			this.setMuerto(true);
			m.actualizarMapa();
			 
		}
		
		if (((m.getEspacios()[this.getX()][this.getY()+1]) instanceof Luciernaga) || (m.getEspacios()[this.getX()][this.getY()+1]) instanceof Mariposa){
			
			m.modificarEspacio(this.getX(), this.getY(), new EspacioVacio(this.getX(), this.getY()));
			m.modificarEspacio(this.getX()-1, this.getY(), new EspacioVacio(this.getX()-1, this.getY()));
			m.modificarEspacio(this.getX()+1, this.getY(), new EspacioVacio(this.getX()+1, this.getY()));
			m.modificarEspacio(this.getX(), this.getY()-1, new EspacioVacio(this.getX(), this.getY()-1));
			m.modificarEspacio(this.getX(), this.getY()+1, new EspacioVacio(this.getX(), this.getY()+1));
			m.actualizarMapa();
			this.setMuerto(true); 
		}
		
		if (((m.getEspacios()[this.getX()-1][this.getY()]) instanceof Luciernaga) || (m.getEspacios()[this.getX()-1][this.getY()]) instanceof Mariposa){
			
			m.modificarEspacio(this.getX(), this.getY(), new EspacioVacio(this.getX(), this.getY()));
			m.modificarEspacio(this.getX()-1, this.getY(), new EspacioVacio(this.getX()-1, this.getY()));
			m.modificarEspacio(this.getX()+1, this.getY(), new EspacioVacio(this.getX()+1, this.getY()));
			m.modificarEspacio(this.getX(), this.getY()-1, new EspacioVacio(this.getX(), this.getY()-1));
			m.modificarEspacio(this.getX(), this.getY()+1, new EspacioVacio(this.getX(), this.getY()+1));
			m.actualizarMapa();
			this.setMuerto(true); 
		}
		
		if (((m.getEspacios()[this.getX()+1][this.getY()]) instanceof Luciernaga) || (m.getEspacios()[this.getX()+1][this.getY()]) instanceof Mariposa){
			
			m.modificarEspacio(this.getX(), this.getY(), new EspacioVacio(this.getX(), this.getY()));
			m.modificarEspacio(this.getX()-1, this.getY(), new EspacioVacio(this.getX()-1, this.getY()));
			m.modificarEspacio(this.getX()+1, this.getY(), new EspacioVacio(this.getX()+1, this.getY()));
			m.modificarEspacio(this.getX(), this.getY()-1, new EspacioVacio(this.getX(), this.getY()-1));
			m.modificarEspacio(this.getX(), this.getY()+1, new EspacioVacio(this.getX(), this.getY()+1));
			m.actualizarMapa();
			this.setMuerto(true); 
		}
	}
	
	public void moverDerecha(Mapa m){
		if ((m.getEspacios()[this.getX()+1][this.getY()]) instanceof Basura){
			m.modificarEspacio(this.getX(), this.getY(), new EspacioVacio(this.getX(), this.getY()));
			this.setX(this.getX()+1);
			m.modificarEspacio(this.getX(), this.getY(), this);
			m.getEspacios()[this.getX()][this.getY()].informar();
		}
		else
		{
			if (m.getEspacios()[this.getX()+1][this.getY()] instanceof EspacioVacio){
				m.modificarEspacio(this.getX(), this.getY(), new EspacioVacio(this.getX(), this.getY()));
				this.setX(this.getX()+1);
				m.modificarEspacio(this.getX(), this.getY(), this);
				m.getEspacios()[this.getX()][this.getY()].informar();
			}
			else{
				
				if (m.getEspacios()[this.getX()+1][this.getY()] instanceof Puerta){

					Puerta puertaAuxiliar= (Puerta) m.getEspacios()[this.getX()+1][this.getY()];
					if(!puertaAuxiliar.isAbierta()){
						System.out.print("La puerta esta cerrada");
					}						
					
					else{
						m.modificarEspacio(this.getX(), this.getY(), new EspacioVacio(this.getX(), this.getY()));
						System.out.println("Nivel Terminado");
						m.setNivelTerminado(true);

					}
				}
				else
				{
					if((m.getEspacios()[this.getX()+1][this.getY()]) instanceof Diamante){
						m.modificarEspacio(this.getX(), this.getY(), new EspacioVacio(this.getX(), this.getY()));
						this.setX(this.getX()+1);
						agarrarDiamante(m);
						System.out.println("Rockford agarro el diamante de la posicion: " + this.getX() + "," + this.getY());
						m.modificarEspacio(this.getX(), this.getY(), this);
						m.getEspacios()[this.getX()][this.getY()].informar();
					}
					else {
						if(((m.getEspacios()[this.getX()+1][this.getY()]) instanceof Roca) && ((m.getEspacios()[this.getX()+2][this.getY()]) instanceof EspacioVacio)) {
							m.modificarEspacio(this.getX()+2, this.getY(), m.getEspacios()[this.getX()+1][this.getY()]);
							m.modificarEspacio(this.getX(), this.getY(), new EspacioVacio(this.getX(), this.getY()));
							this.setX(this.getX()+1);
							m.modificarEspacio(this.getX(), this.getY(), this);
							m.getEspacios()[this.getX()][this.getY()].informar();
						}
							
						else{
							System.out.print("Rockford no puede moverse a ese lugar");
						}
						
					
				}
			}
		}
	}
	System.out.println("Rockford esta en:" + this.getX() + ";" + this.getY());
	m.actualizarMapa();
}
		
	
	public void moverIzquierda(Mapa m){
		
		if ((m.getEspacios()[this.getX()-1][this.getY()]) instanceof Basura){
			m.modificarEspacio(this.getX(), this.getY(), new EspacioVacio(this.getX(), this.getY()));
			this.setX(this.getX()-1);
			m.modificarEspacio(this.getX(), this.getY(), this);
			m.getEspacios()[this.getX()][this.getY()].informar();
		}
		else
		{
			if (m.getEspacios()[this.getX()-1][this.getY()] instanceof EspacioVacio){
				m.modificarEspacio(this.getX(), this.getY(), new EspacioVacio(this.getX(), this.getY()));
				this.setX(this.getX()-1);
				m.modificarEspacio(this.getX(), this.getY(), this);
				m.getEspacios()[this.getX()][this.getY()].informar();
			}
			else{
				
				if (m.getEspacios()[this.getX()-1][this.getY()] instanceof Puerta){
					Puerta puertaAuxiliar= (Puerta) m.getEspacios()[this.getX()-1][this.getY()];
					if(!puertaAuxiliar.isAbierta()){
						System.out.print("La puerta esta cerrada");
					}
					else{
						m.modificarEspacio(this.getX(), this.getY(), new EspacioVacio(this.getX(), this.getY()));
						m.setNivelTerminado(true);
					}
				}
				else
				{
					if((m.getEspacios()[this.getX()-1][this.getY()]) instanceof Diamante){
						m.modificarEspacio(this.getX(), this.getY(), new EspacioVacio(this.getX(), this.getY()));
						this.setX(this.getX()-1);
						agarrarDiamante(m);
						System.out.println("Rockford agarro el diamante de la posicion: " + this.getX() + "," + this.getY());
						m.modificarEspacio(this.getX(), this.getY(), this);
						m.getEspacios()[this.getX()][this.getY()].informar();
					}
					else {
						if(((m.getEspacios()[this.getX()-1][this.getY()]) instanceof Roca) && ((m.getEspacios()[this.getX()-2][this.getY()]) instanceof EspacioVacio)) {
							m.modificarEspacio(this.getX()-2, this.getY(), m.getEspacios()[this.getX()-1][this.getY()]);
							m.modificarEspacio(this.getX(), this.getY(), new EspacioVacio(this.getX(), this.getY()));
							this.setX(this.getX()-1);
							m.modificarEspacio(this.getX(), this.getY(), this);
							m.getEspacios()[this.getX()][this.getY()].informar();
						}
							
						else{
							System.out.print("Rockford no puede moverse a ese lugar");
						}
				}
			}
		}	
	}
	System.out.println("Rockford esta en:" + this.getX() + ";" + this.getY());
	m.actualizarMapa();
}
	
	public void moverAbajo(Mapa m){
		
		if ((m.getEspacios()[this.getX()][this.getY()+1]) instanceof Basura){
			m.modificarEspacio(this.getX(), this.getY(), new EspacioVacio(this.getX(), this.getY()));
			this.setY(this.getY()+1);
			m.modificarEspacio(this.getX(), this.getY(), this);
			m.getEspacios()[this.getX()][this.getY()].informar();
		}
		else
		{
			if (m.getEspacios()[this.getX()][this.getY()+1] instanceof EspacioVacio){
				m.modificarEspacio(this.getX(), this.getY(), new EspacioVacio(this.getX(), this.getY()));
				this.setY(this.getY()+1);
				m.modificarEspacio(this.getX(), this.getY(), this);
				m.getEspacios()[this.getX()][this.getY()].informar();
			}
			else{
				
				if (m.getEspacios()[this.getX()][this.getY()+1] instanceof Puerta){
					Puerta puertaAuxiliar= (Puerta) m.getEspacios()[this.getX()][this.getY()+1];
					if(!puertaAuxiliar.isAbierta()){
						System.out.print("La puerta esta cerrada");
					}
					else{
						m.modificarEspacio(this.getX(), this.getY(), new EspacioVacio(this.getX(), this.getY()));
						m.setNivelTerminado(true);
					}
				}
				else
				{
					if((m.getEspacios()[this.getX()][this.getY()+1]) instanceof Diamante){
						m.modificarEspacio(this.getX(), this.getY(), new EspacioVacio(this.getX(), this.getY()));
						this.setY(this.getY()+1);
						agarrarDiamante(m);
						System.out.println("Rockford agarro el diamante de la posicion: " + this.getX() + "," + this.getY());
						m.modificarEspacio(this.getX(), this.getY(), this);
						m.getEspacios()[this.getX()][this.getY()].informar();
					}
					else {
						if(((m.getEspacios()[this.getX()][this.getY()+1]) instanceof Roca) && ((m.getEspacios()[this.getX()][this.getY()+2]) instanceof EspacioVacio)) {
							m.modificarEspacio(this.getX(), this.getY()+2, m.getEspacios()[this.getX()][this.getY()+1]);
							m.modificarEspacio(this.getX(), this.getY(), new EspacioVacio(this.getX(), this.getY()));
							this.setY(this.getY()+1);
							m.modificarEspacio(this.getX(), this.getY(), this);
							m.getEspacios()[this.getX()][this.getY()].informar();
						}
							
						else{
							System.out.print("Rockford no puede moverse a ese lugar");
						}
						
					
				}
			}
		}
	}
	System.out.println("Rockford esta en:" + this.getX() + ";" + this.getY());
	m.actualizarMapa();
}
	
	public void moverArriba(Mapa m){
		
		if ((m.getEspacios()[this.getX()][this.getY()-1]) instanceof Basura){
			m.modificarEspacio(this.getX(), this.getY(), new EspacioVacio(this.getX(), this.getY()));
			this.setY(this.getY()-1);
			m.modificarEspacio(this.getX(), this.getY(), this);
			m.getEspacios()[this.getX()][this.getY()].informar();
		}
		else
		{
			if (m.getEspacios()[this.getX()][this.getY()-1] instanceof EspacioVacio){
				m.modificarEspacio(this.getX(), this.getY(), new EspacioVacio(this.getX(), this.getY()));
				this.setY(this.getY()-1);
				m.modificarEspacio(this.getX(), this.getY(), this);
				m.getEspacios()[this.getX()][this.getY()].informar();
			}
			else{
				
				if (m.getEspacios()[this.getX()][this.getY()-1] instanceof Puerta){
					Puerta puertaAuxiliar= (Puerta) m.getEspacios()[this.getX()][this.getY()-1];
					if(!puertaAuxiliar.isAbierta()){
						System.out.print("La puerta esta cerrada");
					}
					else{
						m.modificarEspacio(this.getX(), this.getY(), new EspacioVacio(this.getX(), this.getY()));
						m.setNivelTerminado(true);
					}
				}
				else
				{
					if((m.getEspacios()[this.getX()][this.getY()-1]) instanceof Diamante){
						m.modificarEspacio(this.getX(), this.getY(), new EspacioVacio(this.getX(), this.getY()));
						this.setY(this.getY()-1);
						agarrarDiamante(m);
						System.out.println("Rockford agarro el diamante de la posicion: " + this.getX() + "," + this.getY());
						m.modificarEspacio(this.getX(), this.getY(), this);
						m.getEspacios()[this.getX()][this.getY()].informar();
					}
					else {
						if(((m.getEspacios()[this.getX()][this.getY()-1]) instanceof Roca) && ((m.getEspacios()[this.getX()][this.getY()-2]) instanceof EspacioVacio)) {
							m.modificarEspacio(this.getX(), this.getY()-2, m.getEspacios()[this.getX()][this.getY()-1]);
							m.modificarEspacio(this.getX(), this.getY(), new EspacioVacio(this.getX(), this.getY()));
							this.setY(this.getY()-1);
							m.modificarEspacio(this.getX(), this.getY(), this);
							m.getEspacios()[this.getX()][this.getY()].informar();
						}
							
						else{
							System.out.print("Rockford no puede moverse a ese lugar");
						}
						
					
				}
			}
		}
	}
	System.out.println("Rockford esta en:" + this.getX() + ";" + this.getY());
	m.actualizarMapa();
}
	
	public boolean isMuerto() {
		return muerto;
	}
	public void setMuerto(boolean muerto) {
		this.muerto = muerto;
	}
	
	public void actualizar(Mapa m){
		this.explotar(m);
	}
}
