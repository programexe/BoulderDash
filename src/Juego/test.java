package Juego;
import personajes.*;
import java.util.Scanner;

/**
 * Clase princial, donde se controla y ejecuta todo el juego
 * 
 * @author Ezequiel Humar - Sebasti�n Sauer Rosas
 *
 */
public class test {
	
	public static void main(String[] args) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese nivel que quiere recorrer");
		int lvl = sc.nextInt();
		
		Mapa m = Mapa.getInstance();
		Rockford player= Rockford.getInstance();
		Juego juego = Juego.getInstance(); 
		juego.cargarNivel(lvl);
		/*		
		switch (lvl){
		
			case 1 :{
				juego.cargarNivel(lvl);
				m.imprimirMapa();
				juego.actualizar();
				player.moverAbajo();
				juego.actualizar();
				for (int i = 0; i<6; i++){
					player.moverDerecha();
					juego.actualizar();
				}
				for (int i=0; i<2; i++){
					player.moverArriba();
					juego.actualizar();
				}
				player.moverDerecha();
				juego.actualizar();
				for (int i=0; i<2; i++){
					player.moverAbajo();
					juego.actualizar();
				}
				for (int i=0; i<9; i++){
					player.moverDerecha();
					juego.actualizar();
				}
				for (int i=0; i<2; i++){
					player.moverAbajo();
					juego.actualizar();
				}
				for (int i=0; i<5; i++){
					player.moverDerecha();
					juego.actualizar();
				}
			}
			System.out.println("Se termino el nivel");
			System.out.println("Rockford termio en: " + player.getX() + " , " + player.getY());
			m.imprimirMapa();
			if (player.isMuerto())
				System.out.println("Rockford se murio");
			break;
			
			case 2:{
				juego.cargarNivel(lvl);
				m.imprimirMapa();
				juego.actualizar();
				player.moverDerecha();
				for (int i = 0; i<3; i++){
					player.moverArriba();
				}
				for (int i = 0; i<14; i++){
					player.moverIzquierda();
				}
				player.moverArriba();
			}
			System.out.println("Se termino el nivel");
			System.out.println("Rockford termio en: " + player.getX() + " , " + player.getY());
			m.imprimirMapa();
			if (player.isMuerto())
				System.out.println("Rockford se murio");
			break;
			
			default:
				System.out.println("El nivel no esta disponible");
		}
		*/
		
		

	}
	
}
