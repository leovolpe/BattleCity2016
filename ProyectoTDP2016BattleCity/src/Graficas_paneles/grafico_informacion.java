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
	private JLabel etiqueta;
	
	public grafico_informacion()
	{
		panel_info = new JPanel();
		panel_info.setLayout(null);
		panel_info.setBounds(780, 0, 300, 600);
		etiqueta = new JLabel("Puntaje: 0");
		panel_info.add(etiqueta);
		etiqueta.setLocation(0,0);
		etiqueta.setSize(300,100);
		
	}

	/**
	 * Retorna el panel que contiene la informacion
	 * 
	 */
	public JPanel getPanel_info() {
		return panel_info;
	}

	public JLabel getEtiqueta()
	{
		return etiqueta;
	}
}
