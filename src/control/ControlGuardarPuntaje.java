package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import visual.interfazGrafica;

public class ControlGuardarPuntaje implements ActionListener {
	interfazGrafica frame;
	String nombre;
	public ControlGuardarPuntaje(interfazGrafica frame) {
		this.frame=frame;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		nombre=frame.getNombrePuntaje().getText();
		// TODO Auto-generated method stub
		
	}
	

}
