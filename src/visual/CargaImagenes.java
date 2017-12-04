package visual;
import java.awt.*;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Juego.Mapa;
import personajes.Ameba;
import personajes.Basura;
import personajes.Diamante;
import  personajes.Elementos;
import personajes.EspacioVacio;
import personajes.Luciernaga;
import personajes.Mariposa;
import personajes.Muro;
import personajes.MuroTitanio;
import personajes.Puerta;
import personajes.Roca;
import personajes.Rockford;


public class CargaImagenes extends JPanel {
	
	
	private Mapa mapa = Mapa.getInstance();
	Graphics g;
	
	private String imgFileNameAmeba = "imagenes/amoeba.gif";  
	private Image imgAmeba;  
	
	private String imgFileNameRoca = "imagenes/boulder.gif";  
	private Image imgRoca; 
	
	private String imgFileNameMariposa = "imagenes/butterfly.gif";  
	private Image imgMariposa; 
	
	private String imgFileNameDiamante = "imagenes/diamond.gif";  
	private Image imgDiamante; 
	
	private String imgFileNameVacio = "imagenes/empty.jpg";  
	private Image imgVacio; 
	
	private String imgFileNamePuerta = "imagenes/exit.gif";  
	private Image imgPuerta; 
	
	private String imgFileNameLuciernaga = "imagenes/firefly.gif";  
	private Image imgLuciernaga; 
	
	private String imgFileNameMagico = "imagenes/magic.gif";  
	private Image imgMagico; 
	
	private String imgFileNameRockford = "imagenes/rockford.gif";  
	private Image imgRockford; 
	
	private String imgFileNameTitanio = "imagenes/steel.gif";  
	private Image imgTitanio; 
	
	private String imgFileNameMuro = "imagenes/wall.gif";  
	private Image imgMuro; 
	
	private String imgFileNameBasura = "imagenes/Dirt.png";  
	private Image imgBasura; 
	
	public CargaImagenes(){
		this.cargar();
	}
	
	private void cargarAmeba(){
		URL imgUrl = getClass().getClassLoader().getResource(imgFileNameAmeba);
	
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgFileNameAmeba);
		} else {
			try {
				imgAmeba = ImageIO.read(imgUrl); 
	
			} catch (IOException ex) {
			ex.printStackTrace();
			}
		} 
	}
	
	private void cargarRoca(){
		URL imgUrl = getClass().getClassLoader().getResource(imgFileNameRoca);
	
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgFileNameRoca);
		} else {
			try {
				imgRoca = ImageIO.read(imgUrl); 
	
			} catch (IOException ex) {
			ex.printStackTrace();
			}
		} 
	}
	
	private void cargarMariposa(){
		URL imgUrl = getClass().getClassLoader().getResource(imgFileNameMariposa);
	
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgFileNameMariposa);
		} else {
			try {
				imgMariposa = ImageIO.read(imgUrl); 
	
			} catch (IOException ex) {
			ex.printStackTrace();
			}
		} 
	}
	
	private void cargarDiamante(){
		URL imgUrl = getClass().getClassLoader().getResource(imgFileNameDiamante);
	
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgFileNameDiamante);
		} else {
			try {
				imgDiamante = ImageIO.read(imgUrl); 
	
			} catch (IOException ex) {
			ex.printStackTrace();
			}
		} 
	}
	
	private void cargarBasura(){
		URL imgUrl = getClass().getClassLoader().getResource(imgFileNameBasura);
	
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgFileNameBasura);
		} else {
			try {
				imgBasura = ImageIO.read(imgUrl); 
	
			} catch (IOException ex) {
			ex.printStackTrace();
			}
		} 
	}
	
	private void cargarVacio(){
		URL imgUrl = getClass().getClassLoader().getResource(imgFileNameVacio);
	
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgFileNameVacio);
		} else {
			try {
				imgVacio = ImageIO.read(imgUrl); 
	
			} catch (IOException ex) {
			ex.printStackTrace();
			}
		} 
	}
	
	private void cargarPuerta(){
		URL imgUrl = getClass().getClassLoader().getResource(imgFileNamePuerta);
	
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgFileNamePuerta);
		} else {
			try {
				imgPuerta = ImageIO.read(imgUrl); 
	
			} catch (IOException ex) {
			ex.printStackTrace();
			}
		} 
	}
	
	private void cargarLuciernaga(){
		URL imgUrl = getClass().getClassLoader().getResource(imgFileNameLuciernaga);
	
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgFileNameLuciernaga);
		} else {
			try {
				imgLuciernaga = ImageIO.read(imgUrl); 
	
			} catch (IOException ex) {
			ex.printStackTrace();
			}
		} 
	}
	
	private void cargarMagico(){
		URL imgUrl = getClass().getClassLoader().getResource(imgFileNameMagico);
	
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgFileNameMagico);
		} else {
			try {
				imgMagico = ImageIO.read(imgUrl); 
	
			} catch (IOException ex) {
			ex.printStackTrace();
			}
		} 
	}
	
	private void cargarRockford(){
		URL imgUrl = getClass().getClassLoader().getResource(imgFileNameRockford);
	
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgFileNameRockford);
		} else {
			try {
				imgRockford = ImageIO.read(imgUrl); 
	
			} catch (IOException ex) {
			ex.printStackTrace();
			}
		} 
	}
	
	private void cargarTitanio(){
		URL imgUrl = getClass().getClassLoader().getResource(imgFileNameTitanio);
	
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgFileNameTitanio);
		} else {
			try {
				imgTitanio = ImageIO.read(imgUrl); 
	
			} catch (IOException ex) {
			ex.printStackTrace();
			}
		} 
	}
	
	private void cargarMuro(){
		URL imgUrl = getClass().getClassLoader().getResource(imgFileNameMuro);
	
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgFileNameMuro);
		} else {
			try {
				imgMuro = ImageIO.read(imgUrl); 
	
			} catch (IOException ex) {
			ex.printStackTrace();
			}
		} 
	}
	
	
	private void cargar(){
		this.cargarAmeba();
		this.cargarBasura();
		this.cargarDiamante();
		this.cargarLuciernaga();
		this.cargarMagico();
		this.cargarMariposa();
		this.cargarMuro();
		this.cargarPuerta();
		this.cargarRoca();
		this.cargarRockford();
		this.cargarTitanio();
		this.cargarVacio();
	}
	
	public void paintComponent(Graphics g)
    { 
        super.paintComponent(g);
        //g.drawImage(imgBasura, 16, 16, null);
        
        
        for (int i=0; i < 40; i++){
        	for (int j=0; j < 22; j++){
        		
        		switch (mapa.getEspacio(i, j).toStringPos()){
        		
        		case "Ameba" : g.drawImage(imgAmeba, i*16, j*16, null);
				break;
				
        		case "Roca" : g.drawImage(imgRoca, i*16, j*16, null);
				break;              
			
				case "Mariposa" : g.drawImage(imgMariposa, i*16, j*16, null);
					break;       
				
				case "Diamante" : g.drawImage(imgDiamante, i*16, j*16, null);;
					break;              
				
				case "Basura" : g.drawImage(imgBasura, i*16, j*16, null);
					break;               
				
				case "Vacio" : g.drawImage(imgVacio, i*16, j*16, null);
					break;        
				
				case "Puerta" : g.drawImage(imgPuerta, i*16, j*16, null);
					break;             
				
				case "Luciernaga" : g.drawImage(imgLuciernaga, i*16, j*16, null);
					break;     
				
				case "Magico" : g.drawImage(imgMagico, i*16, j*16, null);
					break;              
				
				case "Titanio" : g.drawImage(imgTitanio, i*16, j*16, null);
					break;
					
				case "Muro" : g.drawImage(imgMuro, i*16, j*16, null);
					break;
					
				case "Rockford" : g.drawImage(imgRockford, i*16, j*16, null);
					break;
					
				default: ;
		} 
        		}
        	}
        	
        }
        
        
        
}