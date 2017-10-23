package Juego;
import personajes.*;
import java.util.Scanner;


public class test {
	
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese nivel que quiere recorrer");
		int lvl = sc.nextInt();
		
		Mapa m = Mapa.getInstance(null);		
		Rockford player=m.crearMapa(lvl);
		
	
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
		System.out.println(m.getDiamantesRecolectados());
		
		

	}
	
}
