package Graficas_paneles;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Enemigos.Enemigo;
import Entidades_Moviles.Tanque_Jugador;
import Obstaculos.Obstaculo;
import Proyectil.Proyectil;
import Proyectil.ProyectilJugador;

/**Clase encargada de mantener los paneles que contienen las entidades del juego
 * 
 *
 */
public class grafico_juego {
	
	
	private JPanel panel_tanque;
	private JPanel panel_obstaculos;
	private JPanel panel_balas;
	
	
	public grafico_juego(Tanque_Jugador tanque)
	{
		inicializar_panel_tanque(tanque);
		inicializar_panel_obstaculos();
		inicializar_panel_balas();
		
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
	
	private void inicializar_panel_balas()
	{
		panel_balas = new JPanel();
		panel_balas.setLayout(null);
		panel_balas.setOpaque(false);
		panel_balas.setBounds(0, 0, 780, 600);	

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

	public JPanel getPanel_balas() {
		return panel_balas;
	}

	public void agregar_proyectil(Proyectil p) 
	{
		panel_tanque.add(p.getEtiqueta());
		panel_tanque.repaint();
		//panel_balas.add(p.getEtiqueta());
		
	}

	

}
