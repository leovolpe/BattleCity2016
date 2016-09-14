package Graficas_paneles;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**Clase encargada de manipular el panel encargado de mostrar la informacion del juego
 * 
 *
 */
public class grafico_informacion {
	
	private JPanel panel_info;
	
	public grafico_informacion()
	{
		panel_info = new JPanel();
		panel_info.setLayout(null);
		panel_info.setBounds(780, 0, 300, 600);
		JLabel temp = new JLabel("En este espacio se mostrar la informacion");
		panel_info.add(temp);
		temp.setLocation(0,0);
		temp.setSize(300,100);
		
	}

	/**
	 * Retorna el panel que contiene la informacion
	 * 
	 */
	public JPanel getPanel_info() {
		return panel_info;
	}

}
