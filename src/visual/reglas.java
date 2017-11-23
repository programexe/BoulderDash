package visual;
import java.awt.*;
import javax.swing.*;

public class reglas extends JFrame{
	JTextArea textoReglas=new JTextArea("Reglas del juego", 10,15);
	
	public reglas() {
		JPanel panel=new JPanel();
		panel.add(textoReglas);
		panel.setVisible(true);
		textoReglas.setEditable(false);
		this.setLayout(new FlowLayout());
		this.add(panel);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		reglas reglitas=new reglas();
		reglitas.setVisible(true);

	}	
}


