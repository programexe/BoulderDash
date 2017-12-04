package Juego;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Timer;
import java.util.TimerTask;

import control.ControlTeclas;
import personajes.*;
import visual.interfazGrafica;

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
	Timer timer;
	String nombreArchivo="puntajes.txt";
	File archivoPuntaje=new File(nombreArchivo);
	Scanner sc=new Scanner(System.in);
	
	
	private interfazGrafica ig;
	
	

	private Juego(){	
		ig=new interfazGrafica();
		ig.setVisible(true);
	}
	

	
	public static Juego getInstance(){
		if (juego == null)
			juego = new Juego();
		
		return juego;
	}
	
/*
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
	};*/
	
	/**
	 * Actualiza las posiciones de cada elemento en el mapa
	 */
	
	public static void escribirArchivo(String s, File f) throws IOException{ //Inserta la linea s al archivo f
		FileWriter fw=new FileWriter(f,true);
		fw.write(s+"\n");
		fw.close();
	}
	public static void escribirArchivoSobre(String s, File f) throws IOException{ //Lo mismo que el de arriba, pero sobrescribe el archivo
		FileWriter fw=new FileWriter(f);
		fw.write(s+"\n");
		fw.close();
	}
	public static void escribirArchivo(int s, File f) throws IOException{//Este y el de abajo trabajan igual que los de arriba, solamente que s es integer
		FileWriter fw=new FileWriter(f,true);
		fw.write(s+"\n");
		fw.close();
	}
	public static void escribirArchivoSobre(int s, File f) throws IOException{
		FileWriter fw=new FileWriter(f);
		fw.write(s+"\n");
		fw.close();
	}
	
	private void ingresarPuntajePartida() {
		ig.mostrarPanelGuardarPuntaje();
		//System.out.println("Ingrese su nombre:");
		//agregarNuevoPuntaje(sc.next(),DatosJuego.getInstance().getDiamantesRecolectados());
		
	}
	
	public void agregarNuevoPuntaje(String nuevoNombre, int nuevoPuntos) {  //Este metodo agraga el nuevo puntaje con sus datos en la posicion correcta (Ordenados los puntajes de mayor a menos)
		String line;
		int puesto=1;
		String nombre;
		int puntos;
		int sumarAPuesto=0;  //Es lo que se suma a los puestos ya existentes. Cuando el nuevo puntaje es agregado se pasa el valor a 1, asi el resto de los puntajes contiene el nro de puesto correcto
		BufferedReader br;
		boolean entroAlWhile=false;
		File archivoTemporal=new File("puntaje.tmp");
		if(archivoTemporal.exists()) {  //Si ya habia un archivo temporal se lo elimina, asi no se trabaja con datos anteriores
			archivoTemporal.delete();
		}
		try {  //Se va a leer el archivo de puntajes y se lo va a copiar en otro archivo temporal,  se agrega el nuevo puntaje en la posicion correcta y luego se continua copiando el resto de los datos
			br = new BufferedReader(new FileReader("puntos.txt"));
			line = br.readLine();
			while (line != null){
				entroAlWhile=true;
				puesto =Integer.parseInt(line);
				nombre= br.readLine();
				puntos=Integer.parseInt(br.readLine());
				if (puntos<nuevoPuntos) { //Aca es cuando se encuentra el espacio donde va en nuevo puntaje, entonces se lo agrega al archivo
					escribirArchivo(puesto, archivoTemporal);
					escribirArchivo(nuevoNombre,archivoTemporal);
					escribirArchivo(nuevoPuntos,archivoTemporal);
					sumarAPuesto=1;
				}
				else {
					escribirArchivo(puesto+sumarAPuesto, archivoTemporal);
					escribirArchivo(nuevoNombre,archivoTemporal);
					escribirArchivo(nuevoPuntos,archivoTemporal);
				}
			}
			if (!entroAlWhile) { //En caso de que no se haya entrado al while (osea que el archivo estaba vacio) se agrega directamente el nuevo puntaje
				puesto =Integer.parseInt(line);
				nombre= br.readLine();
				puntos=Integer.parseInt(br.readLine());
				escribirArchivoSobre(puesto, archivoTemporal);
				escribirArchivoSobre(nuevoNombre,archivoTemporal);
				escribirArchivoSobre(nuevoPuntos,archivoTemporal);
			}
			File archivoPermanente=new File("puntos.txt");
			if(archivoPermanente.exists()) { //El archivo permanente se elimina (se vuelve a crear automaticamente cuando se le agregan datos) y luego se copia todo el contenido del archivo temporal
				archivoPermanente.delete();
			}
			br = new BufferedReader(new FileReader("puntaje.tmp"));
			line=br.readLine();
			while(line!= null) {
				escribirArchivo(line,archivoPermanente);
				line=br.readLine();
				}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void actualizar(){ 
		
		mapa.act();
		
		
		if (datos.getDiamantesRecolectados() == datos.getDiamantesPorRecolectar())
			puerta.setAbierta(true);
		
		if (puerta.isAbierta() && jugador.getX() == puerta.getX() && jugador.getY() == puerta.getY()){
			this.finJuego = true;
			timer.cancel();
		}
		
		if (jugador.isMuerto()){
			System.out.println("lalalalalalalalalalalala");
			
			this.finJuego = true;
			mapa.timer.cancel();
			this.ingresarPuntajePartida();
			
		}
		
		
	}
	
	
	
	public int cargarNivel (int l){
	
		
		
		if (mapa.crearMapa(l) == 0){
			jugador.setMuerto(false);
			puerta.setAbierta(false);
			this.finJuego = false;
			return 0;
		}
		
		return 1;
	}
	
	
	
}
