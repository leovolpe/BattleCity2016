package Gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Entidades_Moviles.Tanque_Jugador;
import Graficas_paneles.grafico_informacion;
import Graficas_paneles.grafico_juego;
import Juego.Juego;

@SuppressWarnings("serial")
public class Gui_Juego extends JFrame {
	
	
	private JPanel panelppal; //panel de fondo
	private grafico_juego gj; //contiene los paneles del juego
	private grafico_informacion gi; //contiene el panel de la informacion
	private Juego juego;
	
	public Gui_Juego(Juego j, Tanque_Jugador tanque)
	{
		juego=j;
		
		gj = new grafico_juego(tanque);
		gi = new grafico_informacion();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panelppal= new JPanel();
		setContentPane(panelppal);
		
		
		panelppal.setLayout(null);
		panelppal.setPreferredSize(new Dimension(1080, 600));
		this.pack();
		
		//seteo a la pantalla el oyente
		this.addKeyListener(juego.getTanque().getTeclado());
		
		
		centrar_pantalla();
		agregar_paneles();
		
		
		//seteo fondo
				ImageIcon fondo = new ImageIcon(getClass().getResource("/Imagenes/fondos/fondo.png"));
				JLabel labelimagen = new JLabel();
				labelimagen.setBounds(0,0,780,600);
				labelimagen.setIcon(fondo);
				panelppal.add(labelimagen);
		
	}
	
	
	
	private void agregar_paneles()
	{
		this.getContentPane().add(gj.getPanel_tanque());
		this.getContentPane().add(gj.getPanel_obstaculos());
		this.getContentPane().add(gi.getPanel_info());
	}
	
	
	public void centrar_pantalla()
	{
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int y = (int) dim.getHeight()/2;
		int x = (int) dim.getWidth()/2;
		y-=panelppal.getHeight()/2;
		x-=panelppal.getWidth()/2;
		
		this.setLocation(x,y);
	}



	public grafico_juego getGj() {
		return gj;
	}
	
	public grafico_informacion getGi() {
		return gi;
	}

}
