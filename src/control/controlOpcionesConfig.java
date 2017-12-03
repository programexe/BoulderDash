package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.table.DefaultTableModel;

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
		frame.setCantJugadoresTabla(Integer.parseInt(cantidadSeleccionada));
		
		frame.leerArchivoPuntaje();
		frame.setModeloTablaTopX();
		
		//DefaultTableModel nuevoModelo=new DefaultTableModel(datos,frame.getTitulosTabla());
		//frame.getTablaTopX().setModel(nuevoModelo);
		
		
	}

	

}
