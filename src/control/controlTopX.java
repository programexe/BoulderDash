package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import visual.interfazGrafica;

public class controlTopX implements ActionListener{
	
	interfazGrafica frame;
	
	public controlTopX(interfazGrafica frame) {
		this.frame=frame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		frame.mostrarTopX();
		
	}

}
