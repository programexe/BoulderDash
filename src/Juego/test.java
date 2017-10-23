package Juego;
import CargaDeNiveles.*;
public class test {
	public static void main(String[] args){
		Mapa m=new Mapa();
		m.crearMapa();
		int lvl=0;
		m.getLector().readLevels(levels.xml);
		m.getLector().setCurrentLevel(lvl);
	}
	
}
