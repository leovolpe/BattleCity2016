package Gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Entidades_Moviles.Tanque_Jugador;
import Graficas_paneles.grafico_informacion;
import Graficas_paneles.grafico_juego;
import Juego.Juego;

public class Gui_Juego extends JFrame {
	
	private JPanel panelppal;
	private grafico_juego gj;
	private grafico_informacion gi;
	private Juego juego;
	
	public Gui_Juego(Juego j, Tanque_Jugador tanque)
	{
		juego=j;
		
		
		gj = new grafico_juego(tanque);
		gi = new grafico_informacion();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panelppal= new JPanel();
		setContentPane(panelppal);
		this.getContentPane().setBackground(Color.RED);
		panelppal.setLayout(null);
		panelppal.setPreferredSize(new Dimension(1080, 600));
		this.pack();
		this.addKeyListener(juego.getTanque().getTeclado());
		centrar_pantalla();
		agregar_paneles();
		
		
	}
	
	
	
	private void agregar_paneles()
	{
		this.getContentPane().add(gj.getPaneljuego());
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

}
