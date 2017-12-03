package visual;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class panelPrincipal extends JPanel {
	private String rutaImgFondo= "ImagenFondo.png";
	private Image imgFondo;
	
	
	
	public panelPrincipal() {
		
		URL imgUrl = getClass().getClassLoader().getResource(rutaImgFondo);
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+rutaImgFondo);
			} else {
				try {
					imgFondo = ImageIO.read(imgUrl); // carga imagen en img
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			} 
	}
	public void paintComponent(Graphics g)
    { 
        super.paintComponent(g);
        g.drawImage(imgFondo, 0, 0, 450, 300, null);
    }

}
