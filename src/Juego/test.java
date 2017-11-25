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
		
		Mapa m = Mapa.getInstance();
		Rockford player= Rockford.getInstance();
		m.crearMapa(lvl);
				
		switch (lvl){
		
			case 1 :{
				player.moverAbajo();
				for (int i = 0; i<6; i++){
					player.moverDerecha();
				}
				for (int i=0; i<2; i++){
					player.moverArriba();
				}
				player.moverDerecha();
				for (int i=0; i<2; i++){
					player.moverAbajo();
				}
				for (int i=0; i<9; i++){
					player.moverDerecha();
				}
				for (int i=0; i<2; i++){
					player.moverAbajo();
				}
				for (int i=0; i<5; i++){
					player.moverDerecha();
				}
			}
			break;
			
			case 2:{
				player.moverDerecha();
				for (int i = 0; i<3; i++){
					player.moverArriba();
				}
				for (int i = 0; i<14; i++){
					player.moverIzquierda();
				}
				player.moverArriba();
			}
			break;
			
			default:
				System.out.println("El nivel no esta disponible");
		}
		
		

	}
	
}
