package Juego;
import CargaDeNiveles.*;
public class test {
	public static void main(String[] args) {
		BDLevelReader levelReader = new BDLevelReader();
		try {
			int nivelElegido = 1;
			int levels = levelReader.readLevels("levels.xml");
			levelReader.setCurrentLevel(nivelElegido);

			StringBuilder sb = new StringBuilder();
			sb.append("NIVELES DISPONIBLES:");
			sb.append(levels);
			sb.append("\n");
			sb.append("DIAMANTES NECESARIOS DEL NIVEL ");
			sb.append(nivelElegido);
			sb.append(":");
			sb.append(levelReader.getDiamondsNeeded());
			System.out.println(sb);
			
			Mapa m=new Mapa();
			m.crearMapa(levelReader);

			
			levelReader.imprimirMapa();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
