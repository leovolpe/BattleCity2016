package Control_Teclado;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Entidades_Moviles.Tanque_Jugador;


/**Clase encargada de detectar los eventos del teclado y de manejarlos
 * 
 * @author Javier Graff
 * @author Eric Avondet
 * @author Rodrigo Herrera
 *
 */
public class ManejadorDeTeclas implements KeyListener 
{

	//procesador de teclas
	protected Accionadordeteclas procesador;
	
	protected Tanque_Jugador tanque;
	
	
	
	
	/**
	 * Constructor
	 * @param t tanque
	 */
	public ManejadorDeTeclas(Tanque_Jugador t)
	{
		tanque=t;
		procesador = new Accionadordeteclas(t,40);
		procesador.start();
		
		
		
	}
	
	/**
	 * se deja de actuar ante la presion de las teclas
	 */
	public void fin()
	{
		procesador.stop();
		
		
	}
	
	/**
	 * juego en pausa, el teclado no responde
	 */
	public void pausa()
	{
		procesador.pausa();
		
	}
	
	/**
	 * juego deja de estar en pausa, el teclado responde
	 */
	public void fin_pausa()
	{
		procesador.fin_pausa();
		
	}
	
	
	/**
	 * setea en el procesador determinado las teclas presionadas
	 */
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
	
	

	/**
	 * Setea en el procesador determinado las teclas que se dejan de apretar
	 */
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
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		
	}

}
