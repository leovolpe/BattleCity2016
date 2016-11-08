package Gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Juego.Juego;



public class Gui_informacionInicialFinal extends JFrame 
{
	private Juego juego;
	private String nombrejugador;
	private String apellidojugador;
	
	//panel inicial
	private JPanel panel_inicial;
	private JLabel nombre, apellido, labelfondo;
	private ImageIcon fondo_inicial;
	private JTextField nom,ape;
	private JButton iniciar;
	
	//panel final
	private JPanel panel_final;
	private JLabel fondofinal;
	private ImageIcon imgfondofinal;
	private JLabel nomb, puntaje;
	private JButton reiniciar;
	
	
	
	public Gui_informacionInicialFinal(Juego j)
	{
		juego=j;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setPreferredSize(new Dimension(800, 600));
		this.pack();
		centrar_pantalla();
		inicializar_panel_inicial();
		inicializar_panel_final();
	}
	
	private void inicializar_panel_final()
	{
		panel_final = new JPanel();
		panel_final.setLayout(null);
		panel_final.setBounds(0, 0, 800, 600);
		
		
		nomb = new JLabel();
		nomb.setFont(new java.awt.Font("Tahoma", 0, 36)); 
		nomb.setHorizontalAlignment(JLabel.CENTER);
		nomb.setOpaque(true);
		nomb.setBounds(100,200,600,100);
		nomb.setOpaque(false);
		nomb.setForeground(Color.white);
		panel_final.add(nomb);
		
		puntaje = new JLabel();
		puntaje.setFont(new java.awt.Font("Tahoma", 0, 36)); 
		puntaje.setHorizontalAlignment(JLabel.CENTER);
		puntaje.setOpaque(true);
		puntaje.setBounds(100,300,600,100);
		puntaje.setOpaque(false);
		puntaje.setForeground(Color.white);
		panel_final.add(puntaje);
		
		reiniciar = new JButton("Jugar de Nuevo");
		reiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				setInicio();
				
			}
		});
		reiniciar.setBounds(250,400,300,100);
		panel_final.add(reiniciar);
		
		
	}
	
	public void derrota(int pts)
	{
		getContentPane().removeAll();
		getContentPane().add(panel_final);
		nomb.setText("Jugador : "+nombrejugador+" "+apellidojugador);
		imgfondofinal = new ImageIcon(getClass().getResource("/Imagenes/fondos/derrotado.png"));
		fondofinal = new JLabel(imgfondofinal);
		fondofinal.setBounds(0, 0, 800, 600);
		panel_final.add(fondofinal);
		puntaje.setText("Puntaje : "+pts);
	}
	
	public void victoria(int pts)
	{
		getContentPane().removeAll();
		getContentPane().add(panel_final);
		nomb.setText("Jugador : "+nombrejugador+" "+apellidojugador);
		imgfondofinal = new ImageIcon(getClass().getResource("/Imagenes/fondos/victoria.png"));
		fondofinal = new JLabel(imgfondofinal);
		fondofinal.setBounds(0, 0, 800, 600);
		panel_final.add(fondofinal);
		puntaje.setText("Puntaje : "+pts);
	}
	
	private void inicializar_panel_inicial()
	{
		//FONDO
		panel_inicial = new JPanel();
		panel_inicial.setLayout(null);
		panel_inicial.setBounds(0, 0, 800, 600);
		
		
		//NOMBRE
		nombre = new JLabel("NOMBRE");
		nombre.setFont(new java.awt.Font("Tahoma", 0, 36)); 
		nombre.setHorizontalAlignment(JLabel.CENTER);
		nombre.setOpaque(true);
		nombre.setBounds(100,200,300,100);
		panel_inicial.add(nombre);
		nom = new JTextField("anonimo");
		nom.setFont(new java.awt.Font("Tahoma", 0, 36)); 
		nom.setBounds(410, 200, 300,100);
		panel_inicial.add(nom);
		
		
		//apellido
		apellido = new JLabel("APELLIDO");
		apellido.setFont(new java.awt.Font("Tahoma", 0, 36)); 
		apellido.setHorizontalAlignment(JLabel.CENTER);
		apellido.setOpaque(true);
		apellido.setBounds(100,301,300,100);
		panel_inicial.add(apellido);
		ape = new JTextField("anonimo");
		ape.setFont(new java.awt.Font("Tahoma", 0, 36)); 
		ape.setBounds(410, 301, 300,100);
		panel_inicial.add(ape);
		
		
		iniciar = new JButton("INICIAR");
		iniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				System.out.println("anda");
				nombrejugador = nom.getText();
				apellidojugador = nom.getText();
				if (nombre.equals("")) nombrejugador ="anonimo";
				if (apellido.equals("")) apellidojugador ="anonimo";
				juego.iniciar_juego();
				
			}
		});
		iniciar.setBounds(250, 410, 300, 100);
		panel_inicial.add(iniciar);
		
		fondo_inicial = new ImageIcon(getClass().getResource("/Imagenes/fondos/fondoincial.jpg"));
		labelfondo = new JLabel();
		labelfondo.setBounds(0,0,800,600);
		labelfondo.setIcon(fondo_inicial);
		panel_inicial.add(labelfondo);
				
		
	}
	
	/*
	 * panel_tanque = new JPanel();
		panel_tanque.setLayout(null);
		panel_tanque.setOpaque(false);
		panel_tanque.setBounds(0, 0, 780, 600);
		panel_tanque.add(t.getEtiqueta());
		panel_tanque.repaint();
	 */
	
	
	
	
	 
	 public void centrar_pantalla()
		{
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			int y = (int) dim.getHeight()/2;
			int x = (int) dim.getWidth()/2;
			y-=getContentPane().getHeight()/2;
			x-=getContentPane().getWidth()/2;
			
			this.setLocation(x,y);
		}

	public void setInicio() 
	{
		getContentPane().removeAll();
		getContentPane().repaint();
		getContentPane().add(panel_inicial);
		
	}
	 
	
	

}
