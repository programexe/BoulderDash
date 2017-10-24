package Juego;
import personajes.*;
import java.util.Scanner;


public class test {
	
	//Pruebaaaaaa2
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese nivel que quiere recorrer");
		int lvl = sc.nextInt();
		
		Mapa m = Mapa.getInstance(null);
		Rockford player=m.crearMapa(lvl);
		
		if(m.espacios[4][3]!=null){
			System.out.println(m.espacios[4][3].getClass().getName());
		}
		
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
				for (int i = 0; i<12; i++){
					player.moverIzquierda(m);
					m.getEspacios()[player.getX()][player.getY()-1].informar();
				}
				player.moverArriba(m);
				for (int i = 0; i<12; i++){
					player.moverIzquierda(m);
				}
				if (player.isMuerto()){
				}
			}
			break;
			
			default:
				System.out.println("El nivel no esta disponible");
		}
		
		

	}
	
}
