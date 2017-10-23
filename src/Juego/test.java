package Juego;
import personajes.*;


public class test {
	
	
	public static void main(String[] args){
		
		Mapa m = Mapa.getInstance(null);		
		m.crearMapa();
		
		Rockford player = (Rockford) m.getEspacios()[3][2];
		
	
		player.moverAbajo(m);
		for (int i = 0; i<6; i++){
			player.moverDerecha(m);
		}
		for (int i=0; i<2; i++){
			player.moverArriba(m);
		}
		player.moverDerecha(m);
		for (int i=0; i<2; i++){
			player.moverAbajo(m);
		}
		for (int i=0; i<7; i++){
			player.moverDerecha(m);
		}
		for (int i=0; i<2; i++){
			player.moverAbajo(m);
		}
		for (int i=0; i<5; i++){
			player.moverDerecha(m);
		}
		
		

	}
	
}
