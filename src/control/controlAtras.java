package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import visual.interfazGrafica;

public class controlAtras implements ActionListener{
	interfazGrafica frame;
	
	public controlAtras(interfazGrafica frame) {
		this.frame=frame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		frame.mostrarPanel();
	}

}
