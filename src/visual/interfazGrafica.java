package visual;
import java.awt.*;
import java.awt.event.MouseListener;

import javax.swing.*;

public class interfazGrafica extends JFrame{
	JButton reglas=new JButton("Reglas");
	JButton jugar=new JButton("¡Quiero jugar!");
	JButton top5=new JButton("Top 5");
	JButton config=new JButton("Config");
	
	public interfazGrafica() {
		JPanel panel=new JPanel();
		this.setBounds(0, 0, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel.setLayout(null);
		panel.add(reglas);
		reglas.setBounds(296, 70, 120, 70);
		reglas.addActionListener(new manejoBotones(this));
		panel.add(jugar);
		jugar.setBounds(160, 165, 120, 70);
		panel.add(top5);
		top5.setBounds(24, 70, 120, 70);
		panel.add(config);
		config.setBounds(360, 0, 90, 40);
		panel.setVisible(true);
		
		this.add(panel);
		
	}
	
	public void cambiarPanel(){
		JTextArea textoReglas=new JTextArea("Reglas del juego", 10,15);
		JPanel panel=new JPanel();
		panel.add(textoReglas);
		panel.setVisible(true);
		textoReglas.setEditable(false);
		this.setLayout(new FlowLayout());
		this.add(panel);
	}
	
	
	public static void main(String[] args) {
		interfazGrafica game=new interfazGrafica();
		game.setVisible(true);

	}
	
	
}
