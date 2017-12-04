package control;
import visual.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class controlConfig implements ActionListener{
	
	private interfazGrafica frame;
	
	public controlConfig(interfazGrafica frame){
		this.frame=frame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		frame.mostrarConfig();
		//frame.mostrarPanelGuardarPuntaje();
		
		
	}
	
	

}
