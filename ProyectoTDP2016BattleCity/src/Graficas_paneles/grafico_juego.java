package Graficas_paneles;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Entidades_Moviles.Tanque_Jugador;

public class grafico_juego {
	
	private JPanel paneljuego;
	
	
	
	public grafico_juego(Tanque_Jugador tanque)
	{
		paneljuego = new JPanel();
		paneljuego.setLayout(null);
		paneljuego.setOpaque(false);
		paneljuego.setBounds(0, 0, 780, 600);
		
		
		paneljuego.add(tanque.getEtiqueta());
		
		
	}

	public JPanel getPaneljuego() {
		return paneljuego;
	}

	

}
