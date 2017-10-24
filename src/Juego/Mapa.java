package Juego;
import personajes.*;
import java.util.Timer;
import java.util.TimerTask;
import CargaDeNiveles.*;

/**
 * Mapa donde se desarolla el juego
 * 
 * @author Ezequiel Humar - Sebastián Sauer Rosas
 *
 */
public class Mapa {
	
	private int totalDiamantes;
	private int diamantesRecolectados=0;
	private int tiempo;
	private boolean nivelTerminado=false;
	BDLevelReader lector=new BDLevelReader();
	Elementos espacios[][]= new Elementos[40][22];
	

	private static Mapa m = null; 
	
	private Mapa(){
		
	}
	
	/**
	 * @return la unica instancia existe de mapa.
	 */
	
	public static Mapa getInstance(Mapa m){
		if (m == null){
			m = new Mapa();
		}
		else
			System.out.println("No se puede crear el objeto porque ya existe un objeto de tipo Mapa");
		return m;
	}
	
	/**
	 * Actualiza las posiciones de cada elemento en el mapa
	 */
	TimerTask tarea = new TimerTask(){
		public void run(){
			for(int i=0;i<40;i++){
				for(int j=0;j<22;j++){
					espacios[i][j].actualizarPorTimer(Mapa.getInstance(m));
					}
				}
			setTiempo(getTiempo()-1);
		}
	};
	
	/**
	 * Actualiza las posiciones de cada elemento en el mapa luego de determinado tiempo
	 */
	public void actualizarMapa(){
		if (!this.isNivelTerminado()){
			for(int i=0;i<40;i++){
				for(int j=0;j<22;j++){
					espacios[i][j].actualizar(this);
				}
			}
		}
	}
	
	/**
	 * Carga el mapa a partir del nivel dado en su estilo original.
	 * Lee el archivo levels.xml y apartir de este 
	 * crea una matriz con los elementos correpondientes
	 * En el momento que crea el mapa, cuando encuentra a rockford crea una instancia de este y la retorna
	 * @param lvl 
	 * @return Retorna la instancia creada de Rockford
	 */

	public Rockford crearMapa(int lvl){  //Lee el archivo levels.xml y apartir de este crea una matriz con los elementos correpondientes
										 //En el momento que crea el mapa, cuando encuentra a rockford crea una instancia de este y la retorna
		Rockford player=new Rockford();
		
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
						
						case WALL: espacios[i][j]=new MuroTitanio(i,j);
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
							
						case EXIT : espacios[i][j]=new Puerta(i,j);
							break;
							
						case PLAYER : espacios[i][j]=new Rockford(i,j);
						player= (Rockford) espacios[i][j];
							break;  
					}
				
				}
			}
			
			System.out.println("Se creo el mapa");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		this.setTiempo(150);
		Timer timer=new Timer();
		timer.schedule(tarea, 1000);	
		this.setTotalDiamantes(lector.getDiamondsNeeded());
		nivelTerminado=false;
	
		
		
		this.actualizarMapa();
		return player;
	}

/*	
	public BDLevelReader getLector() {
		return lector;
	}

	public void setLector(BDLevelReader lector) {
		this.lector = lector;
	}
*/
	
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
	 * Agrega un elemento en la posicion dada.
	 * 
	 * @param x coordenada X
	 * 
	 * @param y coordenada Y
	 * 
	 * @param espacio elemento a ubicar
	 */
	public void modificarEspacio(int x,int y, Elementos espacio){
		this.espacios[x][y]=espacio;
	}

	public int getTotalDiamantes() {
		return totalDiamantes;
	}

	public void setTotalDiamantes(int totalDiamantes) {
		this.totalDiamantes = totalDiamantes;
	}

	public int getDiamantesRecolectados() {
		return diamantesRecolectados;
	}

	public void setDiamantesRecolectados(int diamantesRecolectados) {
		this.diamantesRecolectados = diamantesRecolectados;
	}

	public boolean isNivelTerminado() {
		return nivelTerminado;
	}

	public void setNivelTerminado(boolean nivelTerminado) {
		this.nivelTerminado = nivelTerminado;
	}


	public int getTiempo() {
		return tiempo;
	}


	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	
}
