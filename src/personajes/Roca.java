package personajes;
import Juego.*;

public class Roca extends QueCaen{
	
	// el argumento de y es y+1
	public void isEstacionario(Mapa m){
		if (m.getEspacios()[this.getX()][this.getY()+1] instanceof EspacioVacio){ //caso base 
			this.setCayendo(true);;
		}
		else{
			if((m.getEspacios()[this.getX()][this.getY()+1] instanceof Muro) ||
					(m.getEspacios()[this.getX()][this.getY()+1] instanceof Roca) ||
					(m.getEspacios()[this.getX()][this.getY()+1] instanceof Diamante)){
				if ((m.getEspacios()[this.getX()-1][this.getY()] instanceof EspacioVacio) && 
						(m.getEspacios()[this.getX()-1][this.getY()+1] instanceof EspacioVacio)){
					this.setX(this.getX()+1);
					m.modificarEspacio(this.getX(), this.getY(), this);
					m.modificarEspacio(this.getX()-1, this.getY(), new EspacioVacio());
					//iria un actualizar aca?????
					this.setCayendo(true);						
				}
				else{
					if ((m.getEspacios()[this.getX()+1][this.getY()] instanceof EspacioVacio) && 
							(m.getEspacios()[this.getX()+1][this.getY()+1] instanceof EspacioVacio)){
						m.modificarEspacio(this.getX()+1, this.getY(), this);
						//iria un actualizar aca?????
						this.setCayendo(true);
					}
				}
			}
		}
	}
		
	public void isCayendo(Mapa m){
		if (m.getEspacios()[this.getY()][this.getY()+1] instanceof EspacioVacio){ // capaz con un case queda mejor
			this.setY(this.getY()+1);
			m.modificarEspacio(this.getX(), this.getY(), this);
			m.modificarEspacio(this.getX(), this.getY()-1, new EspacioVacio());
			//iria un llamado recursivo aca???
		}
		else{
			if(m.getEspacios()[this.getY()][this.getY()+1] instanceof Rockford){
				this.Explotar(m, (Rockford) m.getEspacios()[this.getX()][this.getY()+1]);
			}
			else{
				if(m.getEspacios()[this.getY()][this.getY()+1] instanceof Luciernaga){
					this.Explotar(m, (Rockford) m.getEspacios()[this.getX()][this.getY()+1]); //corregir cast aca despues de solucionar la duda
				}
				else{
					if(m.getEspacios()[this.getY()][this.getY()+1] instanceof Mariposa){
						this.Explotar(m, (Rockford) m.getEspacios()[this.getX()][this.getY()+1]); //lo mismo aca
					}
					else
						this.setCayendo(false);
				}
			}
		}
			
	}
	
	public void actualizar(Mapa m){ //aca creo que se tendria que ejecutar en los actualizar
		if (this.isCayendo()){
			this.isCayendo(m);
		}
		else
			this.isEstacionario(m);
	}

	public void informar(){
		System.out.print("Es una roca");
	}
}
