package visual;
import java.awt.*;
import javax.imageio.ImageIO;
import java.net.URL;

import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.*;

public class interfazGrafica extends JFrame{
	private String imgFileName= "imagenes/img.gif";
	private Image img;
	
	JButton reglas=new JButton("Reglas");
	JButton jugar=new JButton("¡Quiero jugar!");
	JButton top5=new JButton("Top 5");
	JButton config=new JButton("Config");
	
	JPanel panel;
	JPanel panelReglas;
	JPanel panelTop5;
	JPanel panelConfig;
	JPanel panelJuego;
	
	public interfazGrafica() {
		panel=new JPanel();
		this.setBounds(0, 0, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel.setLayout(null);
		panel.add(reglas);
		reglas.setBounds(296, 70, 120, 70);
		reglas.addActionListener(new ManejoReglas(this));
		panel.add(jugar);
		jugar.setBounds(160, 165, 120, 70);
		//jugar.addActionListener(new ManejoJugar(this));
		panel.add(top5);
		top5.setBounds(24, 70, 120, 70);
		//top5.addActionListener(new ManejoTop5(this));
		panel.add(config);
		config.setBounds(360, 0, 90, 40);
		//config.addActionListener(new ManejoConfig(this));
		panel.setVisible(true);
		this.add(panel);
		
		panelReglas=new JPanel();
		
		panelReglas.setLayout(null);
		
		panelReglas.setBounds(296, 70, 120, 70);
		
		//////////////////////////////////////////////////////////////
		
		URL imgUrl=getClass().getClassLoader().getResource(imgFileName);
		if(imgUrl==null){
			System.err.println("No se encuentra el archivo:" + imgFileName);
		} else {
			try{
				img= ImageIO.read(imgUrl);
			}
			catch (IOException ex){
				ex.printStackTrace();
			}
		}
		
		
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

	public JPanel getPanelReglas() {
		return panelReglas;
	}

	public void setPanelReglas(JPanel panelReglas) {
		this.panelReglas = panelReglas;
	}
	
	
}
