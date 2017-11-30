package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import visual.interfazGrafica;

public class controlOpcionesConfig implements ItemListener {
	
	private interfazGrafica frame;
	private String cantidadSeleccionada;
	private int cantidadAMostrar=5;
	
	public controlOpcionesConfig(interfazGrafica frame) {
		this.frame=frame;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		cantidadSeleccionada=frame.getElegirX().getSelectedItem().toString();
		
		switch(cantidadSeleccionada) {
		case "5": this.cantidadAMostrar=5;
		break;
		
		case "10": this.cantidadAMostrar=10;
		break;
		
		case "15": this.cantidadAMostrar=15;
		break;
		}
		
		
	}

	

}
