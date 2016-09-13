package ControladorDeTeclado;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Entidades_Moviles.Tanque_Jugador;

public class manejador_teclado_jugador implements KeyListener {

	private Tanque_Jugador t;
	
	
	public manejador_teclado_jugador(Tanque_Jugador tanque)
	{
		t=tanque;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		
		if (KeyEvent.VK_UP==e.getKeyCode())
		{
			t.adelante();
		}
		else if (KeyEvent.VK_DOWN==e.getKeyCode())
		{
			t.atras();
		}
		else if (KeyEvent.VK_LEFT==e.getKeyCode())
		{
			t.izquierda();
		}
		else if (KeyEvent.VK_RIGHT==e.getKeyCode())
		{
			t.derecha();
		}
		// TODO Auto-generated method stub
		
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
