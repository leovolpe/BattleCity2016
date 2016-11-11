package Graficas_paneles;




import javax.swing.JLabel;
import javax.swing.JPanel;

import Control_Teclado.ManejadorDeTeclas;
import Enemigos.Enemigo;
import Entidades_Moviles.Tanque_Jugador;
import Obstaculos.Obstaculo;
import PowerUps.PowerUp;
import Proyectil.Proyectil;


/**Clase encargada de mantener los paneles que contienen las entidades del juego
 * hay un panel para los tanques, otro para los obstaculos y otro para las balas
 * 
 *
 */
public class grafico_juego {
	
	
	private JPanel panel_tanque;		//panel del tanque
	private JPanel panel_obstaculos;	//panel de los obstaculos
	private JPanel panel_balas;			//panel de balas
	private JPanel panel_pwp;
	
	
	public grafico_juego()
	{
		inicializar_panel_tanque();
		inicializar_panel_obstaculos();
		inicializar_panel_balas();
		inicializar_panel_pwp();
		
	}
	
	private void inicializar_panel_pwp() 
	{
		panel_pwp = new JPanel();
		panel_pwp.setLayout(null);
		panel_pwp.setOpaque(false);
		panel_pwp.setBounds(0, 0, 780, 600);	
		
	}

	/**inicializa el panel del tanque
	 * 
	 * @param t
	 */
	private void inicializar_panel_tanque()
	{
		panel_tanque = new JPanel();
		panel_tanque.setLayout(null);
		panel_tanque.setOpaque(false);
		panel_tanque.setBounds(0, 0, 780, 600);
		
		panel_tanque.repaint();

	}
	
	/**inicializa el panel de los obstaculos
	 * 
	 */
	private void inicializar_panel_obstaculos()
	{
		panel_obstaculos = new JPanel();
		panel_obstaculos.setLayout(null);
		panel_obstaculos.setOpaque(false);
		panel_obstaculos.setBounds(0, 0, 780, 600);	
		

	}
	
	/**inicializa el panel de las balas
	 * 
	 */
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

	/**Agraga un enemigo
	 * 
	 * @param e
	 */
	public void agregar_enemigo(Enemigo e)
	{
		panel_tanque.add(e.getEtiqueta());
		panel_tanque.repaint();
	}
	
	/**Elimina el enemigo e de su panel
	 * 
	 * @param e
	 */
	public void borrar_enemigo(Enemigo e) 
	{
		panel_tanque.remove(e.getEtiqueta());
		panel_tanque.repaint();
		
	}

	
	/**
	 * Retorna el panel del tanque
	 * 
	 */
	public JPanel getPanel_tanque() 
	{
		return panel_tanque;
	}
	
	/**Retorna el panel de los obstaculos
	 * 
	 */
	public JPanel getPanel_obstaculos() 
	{
		return panel_obstaculos;
	}

	/**Retorna el panel de las balas
	 * 
	 */
	public JPanel getPanel_balas() 
	{
		return panel_balas;
	}

	/**Agraga un nuevo proyectil a su panel
	 * 
	 * @param p
	 */
	public void agregar_proyectil(Proyectil p) 
	{
		panel_balas.add(p.getEtiqueta());
		panel_balas.repaint();
	}
	
	/**elimina un proyectil de su panel
	 * 
	 * @param p
	 */
	public void borrar_proyectil(Proyectil p)
	{
		panel_balas.remove(p.getEtiqueta());
		panel_balas.repaint();
	}

	public void agregar_pwp(PowerUp p) 
	{
		panel_pwp.add(p.getEtiqueta());
		panel_pwp.repaint();
	}
	
	public void borrar_pwp(PowerUp p)
	{
		panel_pwp.remove(p.getEtiqueta());
		panel_pwp.repaint();
	}

	public JPanel getPanel_pwp() {
		return panel_pwp;
	}



	public void addexplosion60x60(JLabel j)
	{
		panel_obstaculos.add(j);
		panel_obstaculos.repaint();
	}
	
	public void removeexplosion60x60(JLabel j)
	{
		panel_obstaculos.remove(j);
		panel_obstaculos.repaint();
	}

	public void addTanque(Tanque_Jugador t) 
	{
		panel_tanque.add(t.getEtiqueta());
		
	}

	
	

	

}
