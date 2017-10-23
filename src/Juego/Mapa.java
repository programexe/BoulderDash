package Juego;
import personajes.*;
import java.util.Timer;
import java.util.TimerTask;

import CargaDeNiveles.*;
public class Mapa {
	private int totalDiamantes;
	private int diamantesRecolectados;
	private int tiempo;
	private boolean nivelTerminado;
	BDLevelReader lector=new BDLevelReader();
	Elementos espacios[][]= new Elementos[40][22];
	

	private static Mapa m = null; 
	
	private Mapa(){
		
	}
	
	
	public static Mapa getInstance(Mapa m){
		if (m == null){
			m = new Mapa();
		}
		else
			System.out.println("No se puede crear el objeto porque ya existe un objeto de tipo Mapa");
		return m;
	}
	
	
	TimerTask tarea=new TimerTask(){
		public void run(){
			for(int i=0;i<40;i++){
				for(int j=0;j<22;j++){
					espacios[i][j].actualizarPorTimer(Mapa.getInstance(m));
					}
				}
			setTiempo(getTiempo()-1);
		}
	};
	
	public void actualizarMapa(){
		for(int i=0;i<40;i++){
			for(int j=0;j<22;j++){
				espacios[i][j].actualizar(Mapa.getInstance(m));
			}
		}
	}

	public void crearMapa(){
		
		try {
			int nivelElegido = 1;
			int levels = lector.readLevels("levels.xml");
			lector.setCurrentLevel(nivelElegido);
			
			for(int i=0; i<lector.getWIDTH(); i++){
				for(int j=0; j<lector.getHEIGHT(); j++){
					switch (lector.getTile(i, j)){
					
						case EMPTY : espacios[i][j]=new EspacioVacio(i,j);
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
			
			System.out.println("Se creo el mapa");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.setTiempo(150);
		Timer timer=new Timer();
		timer.schedule(tarea, 0, 1000);
		this.setTotalDiamantes(lector.getDiamondsNeeded());
		nivelTerminado=false;
	}

/*	
	public BDLevelReader getLector() {
		return lector;
	}

	public void setLector(BDLevelReader lector) {
		this.lector = lector;
	}
*/
	public Elementos[][] getEspacios() {
		return espacios;
	}

	public void setEspacios(Elementos[][] espacios) {
		this.espacios = espacios;
	}
	
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
