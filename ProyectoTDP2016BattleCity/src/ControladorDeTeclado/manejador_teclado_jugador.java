package ControladorDeTeclado;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Entidades_Moviles.Tanque_Jugador;

/**
 * Clase encargada de capturar los eventos de teclado y modificar el estado del tanque
 * moviendolo por pantalla, disparando, etc.
 *
 */
public class manejador_teclado_jugador implements KeyListener {

	/**tanque que sera manipulado por las acciones del teclado que captura esta clase */
	private Tanque_Jugador t;
	
	/** Constante de la tecla para avanzar */
	final static int adelante = KeyEvent.VK_UP;

	/** Constante de la tecla para ir a la izquierda */
	final static int izquierda = KeyEvent.VK_LEFT;

	/** Constante de la tecla para ir a la derecha */
	final static int derecha = KeyEvent.VK_RIGHT;
	
	/**Constante de la tecla para retroceder*/
	final static int atras = KeyEvent.VK_DOWN;
	
	/**Constante de la tecla para agregar/quitar un enemigo*/
	final static int enemigo = KeyEvent.VK_E;
	
	
	public manejador_teclado_jugador(Tanque_Jugador tanque)
	{
		t=tanque;
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		
		if (adelante==e.getKeyCode())
		{
			t.adelante();
		}
		else if (atras==e.getKeyCode())
		{
			t.atras();
		}
		else if (izquierda==e.getKeyCode())
		{
			t.izquierda();
		}
		else if (derecha==e.getKeyCode())
		{
			t.derecha();
		}
		else if (enemigo==e.getKeyCode())
		{
			if (t.getJuego().hayEnemigo())
			{
				t.getJuego().quitarEnemigo();
				t.getJuego().setHayEnem(false);
			}
			else
			{
				t.getJuego().agregarEnemigo();
				t.getJuego().setHayEnem(true);
			}
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
