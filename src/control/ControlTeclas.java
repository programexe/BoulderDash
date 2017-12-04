package control;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import personajes.Rockford;

public class ControlTeclas implements KeyListener{
	int codigoTecla;
	Rockford player= Rockford.getInstance();
	
	public ControlTeclas() {
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		codigoTecla=e.getKeyCode();
		switch(codigoTecla) {
		case (KeyEvent.VK_UP): player.moverArriba();
		//System.out.print("arriba");
		break;
		case (KeyEvent.VK_DOWN): player.moverAbajo();
			//System.out.print("abajo");
		break;
		case (KeyEvent.VK_RIGHT): player.moverDerecha();
			//System.out.print("derecha");
		break;
		case (KeyEvent.VK_LEFT): player.moverIzquierda();
			//System.out.print("izquierda");
		break;
		case (KeyEvent.VK_ENTER):player.setMuerto(true);
		default: e.consume();
		break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

}
