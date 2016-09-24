package Graficas_paneles;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Enemigos.Enemigo;
import Entidades_Moviles.Tanque_Jugador;
import Obstaculos.Obstaculo;

/**Clase encargada de mantener los paneles que contienen las entidades del juego
 * 
 *
 */
public class grafico_juego {
	
	
	private JPanel panel_tanque;
	private JPanel panel_obstaculos;
	
	
	public grafico_juego(Tanque_Jugador tanque)
	{
		inicializar_panel_tanque(tanque);
		inicializar_panel_obstaculos();
	}
	
	private void inicializar_panel_tanque(Tanque_Jugador t)
	{
		panel_tanque = new JPanel();
		panel_tanque.setLayout(null);
		panel_tanque.setOpaque(false);
		panel_tanque.setBounds(0, 0, 780, 600);
		panel_tanque.add(t.getEtiqueta());
		panel_tanque.repaint();
			
	}
	
	private void inicializar_panel_obstaculos()
	{
		panel_obstaculos = new JPanel();
		panel_obstaculos.setLayout(null);
		panel_obstaculos.setOpaque(false);
		panel_obstaculos.setBounds(0, 0, 780, 600);	
		
		
	}
	
	
	/**Agrega un obstaculo al panel correspondiente
	 * 
	 */
	public void agregar_obstaculo(Obstaculo o)
	{
		panel_obstaculos.add(o.getEtiqueta());
		panel_obstaculos.repaint();
	}

	public void agregar_enemigo(Enemigo e)
	{
		panel_tanque.add(e.getEtiqueta());
		panel_tanque.repaint();
	}

	
	/**
	 * Retorna el panel del tanque
	 * 
	 */
	public JPanel getPanel_tanque() {
		return panel_tanque;
	}
	
	/**Retorna el panel de los obstaculos
	 * 
	 */
	public JPanel getPanel_obstaculos() {
		return panel_obstaculos;
	}

	

}
