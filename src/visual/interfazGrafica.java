package visual;
import java.awt.*;
import javax.swing.*;

public class interfazGrafica extends JFrame{
	JButton reglas=new JButton("Reglas del juego");
	JButton jugar=new JButton("¡Quiero jugar!");
	JButton top5=new JButton("Top 5");
	JButton config=new JButton("Configuraciones");
	
	public interfazGrafica() {
		JPanel panel=new JPanel();
		//panel.setLayout(new GridBagLayout());
		//GridBagConstraints c=new GridBagConstraints();
		
		panel.setLayout(new GridLayout(4,1));
		panel.add(reglas);
		panel.add(jugar);
		panel.add(top5);
		panel.add(config);
		panel.setVisible(true);
		
		this.add(panel);
		
	}
	
	
	public static void main(String[] args) {
		interfazGrafica game=new interfazGrafica();
		game.setVisible(true);

	}
	
	
}
