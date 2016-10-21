package ControladorDeTeclado;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Juego.Juego;

public class manejador_auxiliar_teclado implements KeyListener {

	/**Constante de la tecla para agregar/quitar un enemigo*/
	final static int enemigo = KeyEvent.VK_E;
	
	/**Constante de la tecla para quitar una pared*/
	final static int obstaculo = KeyEvent.VK_P;
	
	/**Constante de la tecla para aumentar nivel*/
	final static int aumentar_nivel = KeyEvent.VK_Q;
	
	/**Constante de la tecla para disparar*/
	final static int disparar = KeyEvent.VK_SPACE;
	
	
	private Juego j;
	
	public manejador_auxiliar_teclado(Juego juego)
	{
		j=juego;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		if (e.getKeyCode()==enemigo)
		{
			if (j.hayEnemigo())
			{
				System.out.println("quito enemigo");
				j.quitarEnemigo();
				
			}
			else
			{
				System.out.println("agrego enemigo");
				j.agregarEnemigo();
			}
			
		}
		else if (e.getKeyCode()==aumentar_nivel)
		{
			j.getTanque().aumentarNivel();
		}
		else if (e.getKeyCode()==disparar)
		{
			j.getTanque().disparar();
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
