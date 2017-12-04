package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import visual.interfazGrafica;

public class controlJuego implements ActionListener{
	
	interfazGrafica frame;
	
	public controlJuego(interfazGrafica frame){
		this.frame=frame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		frame.mostrarJuego();
		// TODO Auto-generated method stub
		
	}

}
