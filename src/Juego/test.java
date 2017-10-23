package Juego;
<<<<<<< HEAD


public class test {
	public static void main(String[] args){
		
		Mapa m = Mapa.getInstance(null);		
		m.crearMapa();
=======
import CargaDeNiveles.*;
public class test {
	public static void main(String[] args){
		Mapa m=new Mapa();
		m.crearMapa();
		int lvl=0;
		m.getLector().readLevels(levels.xml);
		m.getLector().setCurrentLevel(lvl);
>>>>>>> dff9f7c3528a8edd57b3a95651c70276da3516ab
	}
	
}
