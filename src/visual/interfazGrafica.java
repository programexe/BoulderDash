package visual;
import control.*;

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

import Juego.DatosJuego;

public class interfazGrafica extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
	JPanel panelTopX;
	JPanel panelConfig;
	JPanel panelJuego;
	private CargaImagenes mapa;
	public static DatosJuego juego = DatosJuego.getInstance();
	
	public interfazGrafica() {
		crearPanel();
		crearPanelReglas();
		//crearPanelTopX();
		//crearPanelJuego();
		
		
		crearPanelConfig();
		
		
	}
	
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
			// TODO Auto-generated catch block
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
		//config.addActionListener(new ManejoConfig(this));
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
		
		//this.add(panelConfig);
		//panelConfig.setVisible(false);
	}
	private void crearPanelJuego() throws Exception{
		panelJuego.setLayout(new BorderLayout());
		mapa = new CargaImagenes();		
		panelJuego.add(mapa, BorderLayout.CENTER);		
	}
	
	public void mostrarJuego(){
		panel.setVisible(false);
		this.add(panelJuego);
		panelJuego.setVisible(true);
	}
	
	public void mostrarConfig(){
		panel.setVisible(false);
		this.add(panelConfig);
		panelConfig.setVisible(true);
	}
	
	public void mostrarReglas() {
		panel.setVisible(false);
		this.add(panelReglas);
		panelConfig.setVisible(true);
	}
	
	
	
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


	public JPanel getPanelTopX() {
		return panelTopX;
	}




	public void setPanelTopX(JPanel panelTopX) {
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
