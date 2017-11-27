package visual;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ManejoReglas implements ActionListener{
	
	interfazGrafica frame;
	
	public ManejoReglas(interfazGrafica frame){
		this.frame=frame;
		
	}
	
	JTextArea textoReglas;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("file.txt"));
			StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    String everything = sb.toString();
		    textoReglas=new JTextArea(everything, 10, 15);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		frame.getPanelReglas().add(textoReglas);
		frame.add(frame.getPanelReglas());
		frame.getPanel().setVisible(false);
		frame.getPanelReglas().setVisible(true);
		textoReglas.setBounds(160, 165, 120, 170);
	}
	

}
