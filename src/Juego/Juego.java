package Juego;

import java.util.Timer;
import java.util.TimerTask;

import personajes.*;

public class Juego {
	
	private static Juego juego = null;
	private Mapa mapa = Mapa.getInstance();
	private Rockford jugador = Rockford.getInstance();
	private DatosJuego datos = DatosJuego.getInstance();
	private Puerta puerta = Puerta.getInstance();
	private int i;
	private int j;
	private boolean finJuego;
	public int tiempo;
	
	
	private Juego(){	
	}
	
	public static Juego getInstance(){
		if (juego == null)
			juego = new Juego();
		
		return juego;
	}
	
	
	TimerTask tarea = new TimerTask(){
		public void run(){
			System.out.println("aaaaaaaaaaaaaaaaaaaaa");
			for(i=0; i<40; i++){
				for(j=0; j<22; j++){
					mapa.getEspacio(i,j).actualizar();
					}
				}
			setTiempo(getTiempo()-1);
		}
	};
	
	/**
	 * Actualiza las posiciones de cada elemento en el mapa
	 */
	
	public void actualizar(){
		Timer timer=new Timer();
		timer.schedule(tarea, 10);
		
		if (datos.getDiamantesRecolectados() == datos.getDiamantesPorRecolectar())
			puerta.setAbierta(true);
		
		if (puerta.isAbierta() && jugador.getX() == puerta.getX() && jugador.getY() == puerta.getY()){
			this.finJuego = true;
			timer.cancel();
		}
		
		if (jugador.isMuerto()){
			this.finJuego = true;
			timer.cancel();
		}
		
		
	}
	
	
	
	public int cargarNivel (int l){
	
		this.setTiempo(150);
		
		if (mapa.crearMapa(l) == 0){
			jugador.setMuerto(false);
			puerta.setAbierta(false);
			this.finJuego = false;
			return 0;
		}
		
		return 1;
	}
	
	
	public int getTiempo() {
		return tiempo;
	}


	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
}
