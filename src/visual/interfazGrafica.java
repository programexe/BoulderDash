
package visual;
import control.*;

import java.awt.*;
import javax.imageio.ImageIO;
import java.net.URL;
import java.util.Timer;

import javax.*;

import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Juego.DatosJuego;

public class interfazGrafica extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
<<<<<<< HEAD
		
=======
	private String imgFileName= "imagenes/img.gif";
	private Image img;
>>>>>>> branch 'master' of https://github.com/programexe/BoulderDash
	
	JButton reglas=new JButton("Reglas");
	JButton jugar=new JButton("¡Jugar!");
	JButton topX=new JButton("Ranking");
	JButton config=new JButton("Configuración");
	JButton atras=new JButton("Atras");
	JButton atras2=new JButton("Atras");
	JButton atras3=new JButton("Atras");
	JTextArea textoReglas;
	int cantJugadoresTabla=5;
	Object[] titulosTabla = {"Puesto","Nombre","Puntos"};
	Object[][] datosPuntajes=new Object[15][3];
	
	ControlTeclas teclado;
	
	
	JComboBox elegirX;
	DefaultTableModel modeloTablaTopX;
	panelPrincipal panel;
	JPanel panelReglas;
	JPanel panelTopX;
	JTable tablaTopX;
	JPanel panelConfig;
	JPanel panelJuego;
	private CargaImagenes mapa;
	public static DatosJuego juego = DatosJuego.getInstance();
	
	public interfazGrafica() {
		//this.cargarImagenFondo();
		//dibujarFondo();
		teclado=new ControlTeclas();
		this.addKeyListener(teclado);
		this.setFocusable(true);
		
		Image imgIconoFrame;
		imgIconoFrame = new ImageIcon("Imagenes/rockford.gif").getImage();
		if (imgIconoFrame!=null) {
			this.setIconImage(imgIconoFrame);
			
		}
		else {
			System.out.println("No se pudo encntrar el archivo");
		}
		
		this.setTitle("Boulder Dash");
		crearPanel();
		crearPanelReglas();
		crearPanelTopX();
		crearPanelJuego();
<<<<<<< HEAD
		crearPanelConfig();
=======
		crearPanelConfig();
		
>>>>>>> branch 'master' of https://github.com/programexe/BoulderDash
	}
	
	private void crearPanelReglas() {
		panelReglas=new JPanel();
		//panelReglas=new JScrollPane();
		//panelReglas.setLayout(null);
		//panelReglas.setBounds(296, 70, 120, 70);	
		panelReglas.setLayout(new BorderLayout());
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
		
		textoReglas.setEditable(false);
		atras3.addActionListener(new controlAtras(this));
		panelReglas.add(textoReglas,BorderLayout.CENTER);
		panelReglas.add(atras3, BorderLayout.NORTH);
		
		//textoReglas.setBounds(160, 165, 120, 170);
	}

	
	private void crearPanel() {
		panel=new panelPrincipal();
		this.setBounds(0, 0, 450, 335);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel.setLayout(null);
		panel.add(reglas);
		reglas.setBounds(276, 164, 140, 40);
		reglas.addActionListener(new controlReglas(this));
		panel.add(jugar);
		jugar.setBounds(276, 28, 140, 40);
		//jugar.addActionListener(new ManejoJugar(this));
		panel.add(topX);
		topX.setBounds(276, 96, 140, 40);
		topX.addActionListener(new controlTopX(this));
		atras.addActionListener(new controlAtras(this));
		panel.add(config);
		config.setBounds(276, 232, 140, 40);
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
		atras2.addActionListener(new controlAtras(this));
		panelConfig.add(atras2, BorderLayout.NORTH);
		panelConfig.add(elegirX, BorderLayout.SOUTH);
		panelConfig.add(textoConfig, BorderLayout.CENTER);
		
		//this.add(panelConfig);
		//panelConfig.setVisible(false);
	}
	
<<<<<<< HEAD
	private void crearPanelJuego() {
		panelJuego=new CargaImagenes();
=======
	private void crearPanelJuego(){
		panelJuego=new JPanel();
		panelJuego.setLayout(new BorderLayout());
		mapa = new CargaImagenes();		
		panelJuego.add(mapa, BorderLayout.CENTER);	
		//mapa.paint(g);
>>>>>>> branch 'master' of https://github.com/programexe/BoulderDash
	}
<<<<<<< HEAD
	
=======
>>>>>>> branch 'master' of https://github.com/programexe/BoulderDash
	
	public void leerArchivoPuntaje() {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("puntos.txt"));
			StringBuilder sb = new StringBuilder();
		    String line = br.readLine();
		    int a=0;
		    int b=0;
		    datosPuntajes[b][a]=line;
		    a++;
		    while (line != null) {
		    	if (a>2) {
		    		a=0;
		    		b++;
		    	}
		    	if(b>cantJugadoresTabla-1) {
		    		break;
		    	}
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		        datosPuntajes[b][a]=line;
		        a++;
		    }
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	public void setModeloTablaTopX() {
		modeloTablaTopX=new ModeloTabla(datosPuntajes,titulosTabla);
		tablaTopX.setModel(modeloTablaTopX);
		datosPuntajes=new Object[15][3];
		
	}
	private void crearPanelTopX() {
		
		leerArchivoPuntaje();
		
		topX.addActionListener(new controlTopX(this));
		
		panelTopX=new JPanel();
		tablaTopX=new JTable();
		JScrollPane scrollTabla=new JScrollPane(tablaTopX);
		setModeloTablaTopX(); 
		panelTopX.setLayout(new BorderLayout());
		panelTopX.add(scrollTabla, BorderLayout.CENTER);
		panelTopX.add(atras,BorderLayout.NORTH);
		
	}
	
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
	
	public void mostrarPanel() {
		
		panelTopX.setVisible(false);
		this.remove(panelTopX);
		//panelJuego.setVisible(false);
		//this.remove(panelJuego);
		panelConfig.setVisible(false);
		this.remove(panelConfig);
		panelReglas.setVisible(false);
		this.remove(panelReglas);
		panel.setVisible(true);
		this.add(panel);
	}
	
	public void mostrarTopX() {
		
		panel.setVisible(false);
		this.remove(panel);
		panelTopX.setVisible(true);
		this.add(panelTopX);
		//panelJuego.setVisible(false);
		//this.remove(panelJuego);
		panelConfig.setVisible(false);
		this.remove(panelConfig);
		this.remove(panelReglas);
		panelReglas.setVisible(false);
	}
	/*
	public void mostrarJuego() {
		
		panel.setVisible(false);
		this.remove(panel);
		//panelTopX.setVisible(false);
		//this.remove(panelTopX);
		panelJuego.setVisible(true);
		this.add(panelJuego);
		panelConfig.setVisible(false);
		this.remove(panelConfig);
		this.remove(panelReglas);
		panelReglas.setVisible(false);
	}
	*/
	
	
	
	public static void main(String[] args) throws Exception {
		interfazGrafica game=new interfazGrafica();
		game.setVisible(true);

	}

	public panelPrincipal getPanel() {
		return panel;
	}

	public void setPanel(panelPrincipal panel) {
		this.panel = panel;
	}

	public JPanel getPanelReglas() {
		return panelReglas;
	}

	public void setPanelReglas(JPanel panelReglas) {
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

	public int getCantJugadoresTabla() {
		return cantJugadoresTabla;
	}

	public void setCantJugadoresTabla(int cantJugadoresTabla) {
		this.cantJugadoresTabla = cantJugadoresTabla;
	}

	public Object[][] getDatosPuntajes() {
		return datosPuntajes;
	}

	public void setDatosPuntajes(Object[][] datos) {
		this.datosPuntajes = datos;
	}

	public JTable getTablaTopX() {
		return tablaTopX;
	}

	public void setTablaTopX(JTable tablaTopX) {
		this.tablaTopX = tablaTopX;
	}

	public Object[] getTitulosTabla() {
		return titulosTabla;
	}

	public void setTitulosTabla(Object[] titulosTabla) {
		this.titulosTabla = titulosTabla;
	}

	
	
	
}
