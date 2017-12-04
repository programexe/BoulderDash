
package visual;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class CargaImagenes extends JPanel {
	
	
	
	private static HashMap<String, ImageIcon> image = null;
	
	
	public CargaImagenes() {
		super();
		if (image == null){
			image = new HashMap<String, ImageIcon>();
			
			image.put("Ameba", new ImageIcon(this.getClass().getResource("/imagenes/amoeba.gif")));
			image.put("Roca", new ImageIcon(this.getClass().getResource("/imagenes/boulder.gif")));
			image.put("Mariposa", new ImageIcon(this.getClass().getResource("/imagenes/butterfly.gif")));
			image.put("Diamante", new ImageIcon(this.getClass().getResource("/imagenes/diamond.gif")));
			image.put("Basura", new ImageIcon(this.getClass().getResource("/imagenes/Dirt.png")));
			image.put("Vacio", new ImageIcon(this.getClass().getResource("/imagenes/empty.jpg")));
			image.put("Puerta", new ImageIcon(this.getClass().getResource("/imagenes/exit.gif")));
			image.put("Luciernaga", new ImageIcon(this.getClass().getResource("/imagenes/firefly.gif")));
			image.put("MuroMagico", new ImageIcon(this.getClass().getResource("/imagenes/magic.gif")));
			image.put("Rockford", new ImageIcon(this.getClass().getResource("/imagenes/rockford.gif")));
			image.put("MuroTitanio", new ImageIcon(this.getClass().getResource("/imagenes/steel.gif")));
			image.put("Muro", new ImageIcon(this.getClass().getResource("/imagenes/wall.gif")));
			
			
		}
	}
	
	public void paintComponent(Graphics g){
		int w = this.getWidth() / 40;
		int h = this.getHeight() / 22;
		g.drawString(interfazGrafica.juego.getDiamantesPorRecolectar() + "-VIDAS: "
				+ interfazGrafica.juego.getVidas()
				+ interfazGrafica.juego.getDiamantesRecolectados()
				+ interfazGrafica.juego.getTiempo()
				+ interfazGrafica.juego.getScore(), 100, h/2);
		for (int i = 0; i < 22; i++){
			for (int j = 0; j < 40; j++){
				g.drawImage(image.get((interfazGrafica.juego.getElementosPos(j, i))).getImage(), (j) * w, (i + 1) * h, w, h, this);
			}
		}
	}
	
	
}

