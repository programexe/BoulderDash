package visual;
import java.awt.*;

import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import Imagenes.*;

public class CargaImagenes {
	
	
	private String fileAmeba = "imagenes/amoeba.gif";
	private Image imgAmeba; 
	
	private String fileBoulder= "imagenes/boulder.gif";
	private Image imgRoca; 
	
	private String fileButterfly = "imagenes/butterfly.gif";
	private Image imgMariposa; 
	
	private String fileDiamond = "imagenes/diamond.gif";
	private Image imgDiamante; 
	
	private String fileEmpty = "imagenes/empty.gif";
	private Image imgVacio; 
	
	private String fileExit = "imagenes/exit.gif";
	private Image imgPuerta; 
	
	private String fileDirt = "imagenes/dirt.gif";
	private Image imgBasura; 
	
	private String fileFirefly = "imagenes/firefly.gif";
	private Image imgLuciernaga; 
	
	private String fileMagic = "imagenes/magic.gif";
	private Image imgMuroMagico; 
	
	private String fileRockford = "imagenes/rockford.gif";
	private Image imgRockford; 
	
	private String fileSteel = "imagenes/steel.gif";
	private Image imgMuroTitanio; 
	
	private String fileWall = "imagenes/wall.gif";
	private Image imgMuro; 
	

		public CargaImagenes() {
			
			URL imgUrlAmeba = getClass().getClassLoader().getResource(fileAmeba);
			if (imgUrlAmeba == null) {
				System.err.println("No se encuentra el archivo:"+fileAmeba);
			} else {
				try {
					imgAmeba = ImageIO.read(imgUrlAmeba); 
			} 	catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		
		
		
		URL imgUrlRoca = getClass().getClassLoader().getResource(fileBoulder);
		
		if (imgUrlRoca == null) {
			System.err.println("No se encuentra el archivo:"+fileBoulder);
		} else {
			try {
				imgRoca = ImageIO.read(imgUrlRoca); 
		} 	catch (IOException ex) {
				ex.printStackTrace();
			}
		}


		URL imgUrlMariposa = getClass().getClassLoader().getResource(fileButterfly);
		if (imgUrlMariposa == null) {
			System.err.println("No se encuentra el archivo:"+fileButterfly);
		} else {
			try {
				imgMariposa = ImageIO.read(imgUrlMariposa);
		} 	catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		
		URL imgUrlDiamante = getClass().getClassLoader().getResource(fileDiamond);
		if (imgUrlDiamante == null) {
			System.err.println("No se encuentra el archivo:"+fileDiamond);
		} else {
			try {
				imgDiamante = ImageIO.read(imgUrlDiamante); 
		} 	catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		
		URL imgUrlBasura = getClass().getClassLoader().getResource(fileDirt);
		if (imgUrlBasura == null) {
			System.err.println("No se encuentra el archivo:"+fileDirt);
		} else {
			try {
				imgBasura = ImageIO.read(imgUrlBasura);
		} 	catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		
		URL imgUrlVacio = getClass().getClassLoader().getResource(fileEmpty);
		if (imgUrlVacio == null) {
			System.err.println("No se encuentra el archivo:"+fileEmpty);
		} else {
			try {
				imgVacio = ImageIO.read(imgUrlVacio);
		} 	catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		
		URL imgUrlPuerta = getClass().getClassLoader().getResource(fileExit);
		if (imgUrlPuerta == null) {
			System.err.println("No se encuentra el archivo:"+fileExit);
		} else {
			try {
				imgPuerta = ImageIO.read(imgUrlPuerta); 
		} 	catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		
		URL imgUrlLuciernaga = getClass().getClassLoader().getResource(fileFirefly);
		if (imgUrlMariposa == null) {
			System.err.println("No se encuentra el archivo:"+fileButterfly);
		} else {
			try {
				imgMariposa = ImageIO.read(imgUrlLuciernaga); 
		} 	catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		
		URL imgUrlMuroMagico = getClass().getClassLoader().getResource(fileMagic);
		if (imgUrlMuroMagico == null) {
			System.err.println("No se encuentra el archivo:"+fileMagic);
		} else {
			try {
				imgMuroMagico = ImageIO.read(imgUrlMuroMagico); 
		} 	catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		
		URL imgUrlRockford = getClass().getClassLoader().getResource(fileRockford);
		if (imgUrlRockford == null) {
			System.err.println("No se encuentra el archivo:"+fileRockford);
		} else {
			try {
				imgRockford = ImageIO.read(imgUrlRockford); 
		} 	catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		
		URL imgUrlMuroTitanio = getClass().getClassLoader().getResource(fileSteel);
		if (imgUrlMuroTitanio == null) {
			System.err.println("No se encuentra el archivo:"+fileSteel);
		} else {
			try {
				imgMuroTitanio = ImageIO.read(imgUrlMuroTitanio); 
		} 	catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		
		URL imgUrlMuro = getClass().getClassLoader().getResource(fileWall);
		if (imgUrlMuro == null) {
			System.err.println("No se encuentra el archivo:"+fileWall);
		} else {
			try {
				imgMuro = ImageIO.read(imgUrlMuro); 
		} 	catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		
		}
		
}
