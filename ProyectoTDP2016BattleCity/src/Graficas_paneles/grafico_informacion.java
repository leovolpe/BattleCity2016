package Graficas_paneles;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


/**Clase encargada de manipular el panel encargado de mostrar la informacion del juego
 * 
 *
 */
public class grafico_informacion {
	
	private JPanel panel_info;
	private JLabel etiqueta_puntaje, etiqueta_txt_vidas,enemigos_restantes; //, etiqueta_vidas;
	
	
	
	public grafico_informacion(int restantes)
	{
		
		panel_info = new JPanel();
		panel_info.setLayout(null);
		panel_info.setBounds(780, 0, 300, 600);
		
		
		inicializar_etiqueta_puntaje();
		inicializar_etiqueta_texto_vidas();
		inicialziar_etiqueta_restantes(restantes);
		panel_info.setBackground(Color.BLACK);
		
	}
	
	public void inicializar_etiqueta_puntaje()
	{
		//etiqueta puntaje inicializacion
		etiqueta_puntaje = new JLabel("Puntaje: 0",SwingConstants.CENTER);
		etiqueta_puntaje.setLocation(0,0);
		etiqueta_puntaje.setSize(300,100);
		
		etiqueta_puntaje.setForeground(Color.white);
		//etiqueta_puntaje.setBorder(new javax.swing.border.LineBorder(Color.RED));
		etiqueta_puntaje.setFont(new Font("Serif", Font.BOLD, 30));
		panel_info.add(etiqueta_puntaje);
	}
	
	public void inicializar_etiqueta_texto_vidas()
	{
		//etiqueta puntaje inicializacion
		etiqueta_txt_vidas = new JLabel("Vidas : 4",SwingConstants.CENTER);
		etiqueta_txt_vidas.setLocation(0,100);
		etiqueta_txt_vidas.setSize(300,50);
		etiqueta_txt_vidas.setForeground(Color.white);
		//etiqueta_txt_vidas.setBorder(new javax.swing.border.LineBorder(Color.RED));
		etiqueta_txt_vidas.setFont(new Font("Serif", Font.BOLD, 30));
		panel_info.add(etiqueta_txt_vidas);
	}
	
	public void inicialziar_etiqueta_restantes(int restantes)
	{
		
		enemigos_restantes = new JLabel("Restantes :"+restantes,SwingConstants.CENTER);
		enemigos_restantes.setLocation(0,400);
		enemigos_restantes.setSize(300,50);
		enemigos_restantes.setForeground(Color.white);
		enemigos_restantes.setFont(new Font("Serif", Font.BOLD, 30));
		panel_info.add(enemigos_restantes);
	}
	
	/*
	public void inicializar_etiqueta_vidas()
	{
		//etiqueta puntaje inicializacion
		etiqueta_vidas = new JLabel(graficos_corazones.getC4());
		etiqueta_vidas.setLocation(0,150);
		etiqueta_vidas.setSize(300,300);
		etiqueta_vidas.setBorder(new javax.swing.border.LineBorder(Color.RED));
		panel_info.add(etiqueta_vidas);
	}
	*/

	/**
	 * Retorna el panel que contiene la informacion
	 * 
	 */
	public JPanel getPanel_info() 
	{
		return panel_info;
	}

	public void setVidas(int v)
	{
		String vid = "Vidas "+v;
		etiqueta_txt_vidas.setText(vid);
	}
	
	public void setPuntaje(int p)
	{
		etiqueta_puntaje.setText("Puntaje "+p);
		panel_info.repaint();
	}

	public void setRestantes(int i) 
	{
		enemigos_restantes.setText("Restantes :"+i);
		
	}
}
