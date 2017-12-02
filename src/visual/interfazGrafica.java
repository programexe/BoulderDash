package visual;
import control.*;
import personajes.Ameba;
import personajes.Basura;
import personajes.Diamante;
import personajes.EspacioVacio;
import personajes.Luciernaga;
import personajes.Mariposa;
import personajes.Muro;
import personajes.MuroTitanio;
import personajes.Puerta;
import personajes.Roca;
import personajes.Rockford;

import java.awt.*;
import javax.imageio.ImageIO;
import java.net.URL;
import java.util.Timer;

import javax.*;

import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class interfazGrafica extends JFrame{
	private String imgFileName= "imagenes/img.gif";
	private Image img;
	
	JButton reglas=new JButton("Reglas");
	JButton jugar=new JButton("�Quiero jugar!");
	JButton topX=new JButton("Top 5");
	JButton config=new JButton("Config");
	JTextArea textoReglas;
	
	JComboBox elegirX;
	
	JPanel panel;
	JScrollPane panelReglas;
	JTable panelTopX;
	JPanel panelConfig;
	JPanel panelJuego;
	
	public interfazGrafica() {
		crearPanel();
		crearPanelReglas();
		//crearPanelTopX();
		//crearPanelJuego();
		
		
		crearPanelConfig();
		
		
	}
	
	private void crearPanelTopX() {
		
		DefaultTableModel modeloTabla=new DefaultTableModel();
		panelTopX=new JTable(modeloTabla);
	}
	
	
	/*
	private void crearPanelJuego() {
		panelJuego=new JPanel();
	}
	*/
	private void crearPanelReglas() {
		
		panelReglas=new JScrollPane();
		panelReglas.setLayout(null);
		panelReglas.setBounds(296, 70, 120, 70);	
		
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("file.txt"));
			StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    String everything = sb.toString();
		    textoReglas=new JTextArea(everything, 10, 15);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		panelReglas.add(textoReglas);
		
		textoReglas.setBounds(160, 165, 120, 170);
	}
	
	private void crearPanel() {
		panel=new JPanel();
		this.setBounds(0, 0, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel.setLayout(null);
		panel.add(reglas);
		reglas.setBounds(296, 70, 120, 70);
		reglas.addActionListener(new controlReglas(this));
		panel.add(jugar);
		jugar.setBounds(160, 165, 120, 70);
		//jugar.addActionListener(new ManejoJugar(this));
		panel.add(topX);
		topX.setBounds(24, 70, 120, 70);
		//top5.addActionListener(new ManejoTop5(this));
		panel.add(config);
		config.setBounds(360, 0, 90, 40);
		config.addActionListener(new controlConfig(this));
		panel.setVisible(true);
		this.add(panel);
	}
	
	private void crearPanelConfig(){
		panelConfig=new JPanel();
		
		panelConfig.setLayout(new BorderLayout());
		
		JTextArea textoConfig=new JTextArea("Seleccione cuantos jugadores se mostrarán en el ranking:");
		textoConfig.setEditable(false);
		elegirX=new JComboBox();
		elegirX.addItem("5");
		elegirX.addItem("10");
		elegirX.addItem("15");
		
		elegirX.addItemListener(new controlOpcionesConfig(this));
		
		panelConfig.add(elegirX, BorderLayout.SOUTH);
		panelConfig.add(textoConfig, BorderLayout.NORTH);
	}
	/*
	private void crearPanelJuego() {
		
		
		
		panelJuego.setLayout(new GridLayout(40,22));
		pan
		
		
		
		
		
		
		
		
		public int crearMapa(int lvl){  //Lee el archivo levels.xml y apartir de este crea una matriz con los elementos correpondientes
			 //En el momento que crea el mapa, cuando encuentra a rockford crea una instancia de este y la retorna
		
		
					
					try {
					
					int levels = lector.readLevels("levels.xml");
					lector.setCurrentLevel(lvl);
					
					for(int i=0; i<lector.getWIDTH(); i++){
					for(int j=0; j<lector.getHEIGHT(); j++){
					switch (lector.getTile(i, j)){
					
					case EMPTY : espacios[i][j]=new EspacioVacio(i,j);
					break;
					
					case DIRT: espacios[i][j]=new Basura(i,j);
					break;              
					
					case TITANIUM: espacios[i][j]=new MuroTitanio(i,j);
					break;       
					
					case WALL: espacios[i][j]=new Muro(i,j);
					break;              
					
					case ROCK: espacios[i][j]=new Roca(i,j, false);
					break;               
					
					case FALLINGROCK: espacios[i][j]=new Roca(i,j, true);
					break;        
					
					case DIAMOND: espacios[i][j]=new Diamante(i,j, false);
					break;             
					
					case FALLINGDIAMOND: espacios[i][j]=new Diamante(i,j, true);
					break;     
					
					case AMOEBA: espacios[i][j]=new Ameba(i,j);
					break;              
					
					case FIREFLY: espacios[i][j]=new Luciernaga(i,j);
					break;
					
					case BUTTERFLY: espacios[i][j]=new Mariposa(i,j);
					break;
					
					case EXIT : espacios[i][j]= Puerta.getInstanceSetPosition(i, j);
					break;
					
					case PLAYER : espacios[i][j]= Rockford.getInstanceSetPosition(i, j);
					break;  
					}
					
					}
}

System.out.println("Se creo el mapa");	
this.setTiempo(150);
timer=new Timer();

return 0;
} catch (Exception e) {
e.printStackTrace();
return 1;
}
}
	}
	*/
	public void mostrarConfig() {
		
		panel.setVisible(false);
		this.remove(panel);
		//panelTopX.setVisible(false);
		//this.remove(panelTopX);
		//panelJuego.setVisible(false);
		//this.remove(panelJuego);
		panelConfig.setVisible(true);
		this.add(panelConfig);
		this.remove(panelReglas);
		panelReglas.setVisible(false);
	}
	
	public void mostrarReglas() {
		panel.setVisible(false);
		this.remove(panel);
		//panelTopX.setVisible(false);
		//this.remove(panelTopX);
		//panelJuego.setVisible(false);
		//this.remove(panelJuego);
		panelConfig.setVisible(false);
		this.remove(panelConfig);
		this.add(panelReglas);
		panelReglas.setVisible(true);
	}
	/*
	public void mostrarTopX() {
		
		panel.setVisible(false);
		this.remove(panel);
		panelTopX.setVisible(true);
		this.add(panelTopX);
		panelJuego.setVisible(false);
		this.remove(panelJuego);
		panelConfig.setVisible(false);
		this.remove(panelConfig);
		this.remove(panelReglas);
		panelReglas.setVisible(false);
	}
	
	public void mostrarJuego() {
		
		panel.setVisible(false);
		this.remove(panel);
		panelTopX.setVisible(false);
		this.remove(panelTopX);
		panelJuego.setVisible(true);
		this.add(panelJuego);
		panelConfig.setVisible(false);
		this.remove(panelConfig);
		this.remove(panelReglas);
		panelReglas.setVisible(false);
	}
	*/
	
	
	public static void main(String[] args) {
		interfazGrafica game=new interfazGrafica();
		game.setVisible(true);

	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JScrollPane getPanelReglas() {
		return panelReglas;
	}

	public void setPanelReglas(JScrollPane panelReglas) {
		this.panelReglas = panelReglas;
	}


	public JTable getPanelTopX() {
		return panelTopX;
	}




	public void setPanelTopX(JTable panelTopX) {
		this.panelTopX = panelTopX;
	}




	public JPanel getPanelConfig() {
		return panelConfig;
	}




	public void setPanelConfig(JPanel panelConfig) {
		this.panelConfig = panelConfig;
	}




	public JPanel getPanelJuego() {
		return panelJuego;
	}




	public void setPanelJuego(JPanel panelJuego) {
		this.panelJuego = panelJuego;
	}


	public void setElegirX(JComboBox elegirX) {
		this.elegirX = elegirX;
	}

	public JComboBox getElegirX() {
		return elegirX;
	}

	
	
	
}
