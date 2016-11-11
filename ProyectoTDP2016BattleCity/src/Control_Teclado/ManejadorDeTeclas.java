package Control_Teclado;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Entidades_Moviles.Tanque_Jugador;


/**Clase encargada de detectar los eventos del teclado y de manejarlos
 * 
 */
public class ManejadorDeTeclas implements KeyListener 
{

	//procesador de teclas
	protected Accionadordeteclas procesador;
	protected Tanque_Jugador tanque;
	
	
	
	
	
	public ManejadorDeTeclas(Tanque_Jugador t)
	{
		tanque=t;
		procesador = new Accionadordeteclas(t,45);
		procesador.start();
	}
	
	
	
	public void keyPressed(KeyEvent k) {
		
		if ((k.getKeyCode() == KeyEvent.VK_UP)
				|| (k.getKeyCode() == KeyEvent.VK_LEFT)
				|| (k.getKeyCode() == KeyEvent.VK_RIGHT)
				|| (k.getKeyCode() == KeyEvent.VK_DOWN)
				) 
			{
				procesador.setTecla(k.getKeyCode(), true);
			}
	
			
		if (k.getKeyCode()==KeyEvent.VK_S)
		{
			tanque.disparar();
		}
		
		if (k.getKeyCode()==KeyEvent.VK_Q)
		{
			tanque.aumentarNivel();
		}

	}
	
	

	public void keyReleased(KeyEvent k) 
	{
		
		if ((k.getKeyCode() == KeyEvent.VK_UP)
				|| (k.getKeyCode() == KeyEvent.VK_LEFT)
				|| (k.getKeyCode() == KeyEvent.VK_RIGHT)
				|| (k.getKeyCode() == KeyEvent.VK_DOWN)
				) 
		{
			procesador.setTecla(k.getKeyCode(), false);
		}
	
	}

	
	@Override
	public void keyTyped(KeyEvent arg0) 
	{
		// TODO Auto-generated method stub
	}

}
