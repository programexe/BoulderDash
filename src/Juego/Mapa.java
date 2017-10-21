package Juego;
import personajes.*;
import CargaDeNiveles.*;
public class Mapa {
	BDLevelReader lector=new BDLevelReader();
	Elementos espacios[][]= new Elementos[lector.getWIDTH()][lector.getHEIGHT()]; 
	
	public void crearMapa(){
		for(int i=0;i<40;i++){
			for(int j=0;j<22;j++){
				switch (lector.getTile(i, j)){
				case EMPTY : espacios[i][j]=new EspacioVacio();
				break;
				case DIRT: espacios[i][j]=new Basura();
				break;              
				case TITANIUM: espacios[i][j]=new MuroTitanio();
				break;       
				case WALL: espacios[i][j]=new MuroTitanio();
				break;              
				case ROCK: espacios[i][j]=new Roca();
				break;               
				case FALLINGROCK: espacios[i][j]=new Roca();
				break;        
				case DIAMOND: espacios[i][j]=new Diamante();
				break;             
				case FALLINGDIAMOND: espacios[i][j]=new Diamante();
				break;     
				case AMOEBA: espacios[i][j]=new Ameba();
				break;              
				case FIREFLY: espacios[i][j]=new Luciernaga();
				break;             
				case BUTTERFLY: espacios[i][j]=new Mariposa();
				break;           
				case EXIT : espacios[i][j]=new Puerta();
				break;               
				case PLAYER : espacios[i][j]=new Rockford();
				break;  
				}
				
			}
		}
	}

	public BDLevelReader getLector() {
		return lector;
	}

	public void setLector(BDLevelReader lector) {
		this.lector = lector;
	}

	public Elementos[][] getEspacios() {
		return espacios;
	}

	public void setEspacios(Elementos[][] espacios) {
		this.espacios = espacios;
	}
	
	public void modificarEspacio(int x,int y, Elementos espacio){
		this.espacios[x][y]=espacio;
	}
}
