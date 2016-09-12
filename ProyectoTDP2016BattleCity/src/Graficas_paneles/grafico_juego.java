package Graficas_paneles;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class grafico_juego {
	
	private JPanel paneljuego;
	
	
	
	public grafico_juego()
	{
		paneljuego = new JPanel();
		paneljuego.setLayout(null);
		//paneljuego.setOpaque(false);
		paneljuego.setBounds(0, 0, 780, 600);
		paneljuego.setBackground(Color.BLUE);
		
		
		
	}

	public JPanel getPaneljuego() {
		return paneljuego;
	}

}
