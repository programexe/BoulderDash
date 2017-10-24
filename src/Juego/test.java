package Juego;
import personajes.*;
import java.util.Scanner;

/**
 * Clase princial, donde se controla y ejecuta todo el juego
 * 
 * @author Ezequiel Humar - Sebastián Sauer Rosas
 *
 */
public class test {
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese nivel que quiere recorrer");
		int lvl = sc.nextInt();
		
		Mapa m = Mapa.getInstance(null);
		Rockford player=m.crearMapa(lvl);
				
		switch (lvl){
		
			case 1 :{
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
				for (int i=0; i<9; i++){
					player.moverDerecha(m);
				}
				for (int i=0; i<2; i++){
					player.moverAbajo(m);
				}
				for (int i=0; i<5; i++){
					player.moverDerecha(m);
				}
			}
			break;
			
			case 2:{
				player.moverDerecha(m);
				for (int i = 0; i<3; i++){
					player.moverArriba(m);
				}
				for (int i = 0; i<14; i++){
					player.moverIzquierda(m);
				}
				player.moverArriba(m);
			}
			break;
			
			default:
				System.out.println("El nivel no esta disponible");
		}
		
		

	}
	
}
