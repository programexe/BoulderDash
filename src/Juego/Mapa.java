package Juego;
import personajes.*;
import java.util.Timer;
import java.util.TimerTask;
import CargaDeNiveles.*;

/**
 * Mapa donde se desarolla el juego
 * 
 * @author Ezequiel Humar - Sebasti�n Sauer Rosas
 *
 */
public class Mapa {
	
	
	private int tiempo;
	BDLevelReader lector=new BDLevelReader();
	Elementos espacios[][]= new Elementos[40][22];
	

	private static Mapa mapa = null; 
	
	private Mapa(){
		
	}
	
	/**
	 * @return la unica instancia existe de mapa.
	 */
	
	public static Mapa getInstance(){
		if (mapa == null)
			mapa = new Mapa();
				
		return mapa;
	}
	
	
	Timer timer;
	
	
	
	/**
	 * Carga el mapa a partir del nivel dado en su estilo original.
	 * Lee el archivo levels.xml y apartir de este 
	 * crea una matriz con los elementos correpondientes
	 * En el momento que crea el mapa, cuando encuentra a rockford crea una instancia de este y la retorna
	 * @param lvl 
	 * @return Retorna la instancia creada de Rockford
	 */

	public int crearMapa(int lvl){  //Lee el archivo levels.xml y apartir de este crea una matriz con los elementos correpondientes
										 //En el momento que crea el mapa, cuando encuentra a rockford crea una instancia de este y la retorna
		
		
		try {
			
			int levels = lector.readLevels("levels.xml");
			lector.setCurrentLevel(lvl);
			
			for(int i=0; i<lector.getWIDTH(); i++){
				for(int j=0; j<lector.getHEIGHT(); j++){
					switch (lector.getTile(i, j)){
					
						case EMPTY : espacios[i][j]=new EspacioVacio(i,j);
							break;
							
						case DIRT: espacios[i][j]=new Basura(i,j);
							break;              
						
						case TITANIUM: espacios[i][j]=new MuroTitanio(i,j);
							break;       
						
						case WALL: espacios[i][j]=new Muro(i,j);
							break;              
						
						case ROCK: espacios[i][j]=new Roca(i,j, false);
							break;               
						
						case FALLINGROCK: espacios[i][j]=new Roca(i,j, true);
							break;        
						
						case DIAMOND: espacios[i][j]=new Diamante(i,j, false);
							break;             
						
						case FALLINGDIAMOND: espacios[i][j]=new Diamante(i,j, true);
							break;     
						
						case AMOEBA: espacios[i][j]=new Ameba(i,j);
							break;              
						
						case FIREFLY: espacios[i][j]=new Luciernaga(i,j);
							break;
							
						case BUTTERFLY: espacios[i][j]=new Mariposa(i,j);
							break;
							
						case EXIT : espacios[i][j]= Puerta.getInstanceSetPosition(i, j);
							break;
							
						case PLAYER : espacios[i][j]= Rockford.getInstanceSetPosition(i, j);
							break;  
					}
				
				}
			}
			
			System.out.println("Se creo el mapa");	
			this.setTiempo(150);
			timer=new Timer();
		
		return 0;
		} catch (Exception e) {
				e.printStackTrace();
				return 1;
			}
	}
	
	TimerTask tarea = new TimerTask(){
		public void run(){
			act();
		}
	};
	
	public void act(){
		System.out.println("aaaaaaaaaaaaaaaaaaaaa");
		for(int i=0;  i<40; i++){
			for(int j=0; j<22; j++){
				mapa.getEspacio(i,j).actualizar();
				}
			}
		setTiempo(getTiempo()-1);
		
	}
	


	
	/**
	 * @return La matriz del mapa con los elementos en su ubicacion
	 */
	public Elementos[][] getEspacios() {
		return espacios;
	}

	/**
	 * @param espacios 
	 */
	public void setEspacios(Elementos[][] espacios) {
		this.espacios = espacios;
	}
	
	
	/**
	 * Devuelve el elemento en una posicion dada.
	 * 
	 * @param x
	 *            cordenadaX
	 * @param y
	 *            cordenadaY
	 * @return elemento del mapa.
	 */
	public Elementos getEspacio(int x, int y) {
		return this.espacios[x][y];
	}
	
	public int getTiempo() {
		return tiempo;
	}


	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	
	/**
	 * Agrega un elemento en la posicion dada.
	 * 
	 * @param x coordenada X
	 * 
	 * @param y coordenada Y
	 * 
	 * @param espacio elemento a ubicar
	 */
	public int modificarEspacio(int x, int y, Elementos espacio){
		if (this.espacios[x][y].isMuros() || (this.espacios[x][y].isPuerta() && !((Puerta) this.espacios[x][y]).isAbierta())){
			return 1;
		}
		else{
			this.espacios[x][y] = espacio;
			return 0;
		}
	}
	
	public void explotar(int x, int y) {
		
		modificarEspacio(x - 1, y -1, new EspacioVacio(x - 1,y - 1));
		modificarEspacio(x, y -1, new EspacioVacio(x,y - 1));
		modificarEspacio(x + 1, y -1, new EspacioVacio(x + 1,y - 1));
		modificarEspacio(x - 1, y, new EspacioVacio(x - 1,y));
		modificarEspacio(x, y, new EspacioVacio(x,y));
		modificarEspacio(x + 1, y, new EspacioVacio(x + 1,y));
		modificarEspacio(x - 1, y + 1, new EspacioVacio(x - 1,y + 1));
		modificarEspacio(x, y + 1, new EspacioVacio(x,y + 1));
		modificarEspacio(x + 1, y + 1, new EspacioVacio(x + 1,y + 1));
		
	}
	
	public void explotarDiamantes(int x, int y){
		
		modificarEspacio(x - 1, y -1, new Diamante(x - 1,y - 1));
		modificarEspacio(x, y -1, new Diamante(x,y - 1));
		modificarEspacio(x + 1, y -1, new Diamante(x + 1,y - 1));
		modificarEspacio(x - 1, y, new Diamante(x - 1,y));
		modificarEspacio(x, y, new Diamante(x,y));
		modificarEspacio(x + 1, y, new Diamante(x + 1,y));
		modificarEspacio(x - 1, y + 1, new Diamante(x - 1,y + 1));
		modificarEspacio(x, y + 1, new Diamante(x,y + 1));
		modificarEspacio(x + 1, y + 1, new Diamante(x + 1,y + 1));
		
	}

	
	
}
