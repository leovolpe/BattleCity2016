package Gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	private JLabel nombre, apellido, labelfondo,labeltitulo;
	private ImageIcon fondo_inicial;
	private JTextField nom,ape;
	private JButton iniciar;
	
	//panel final
	private JPanel panel_final;
	private JLabel fondofinal;
	private ImageIcon imgfondofinalv,imgfondofinald;
	private JLabel nomb, puntaje;
	private JButton reiniciar;
	
	//seleccionar mapa
	private JPanel panel_mapa;
	private JButton b1,b2,b3,b4;
	private ImageIcon m1,m2,m3,m4;
	private JLabel infomapa;
	
	
	
	public Gui_informacionInicialFinal(Juego j)
	{
		juego=j;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setPreferredSize(new Dimension(800, 600));
		this.pack();
		centrar_pantalla();
		inicializar_panel_inicial();
		inicializar_panel_final();
		inicializar_panel_mapas();
	}
	
	private void inicializar_panel_mapas()
	{
		panel_mapa = new JPanel();
		panel_mapa.setLayout(null);
		panel_mapa.setBackground(Color.black);
		panel_mapa.setBounds(0, 0, 800, 600);
		
		infomapa = new JLabel("Seleccionar Mapa");
		infomapa.setBounds(0, 0, 800, 30);
		infomapa.setForeground(Color.white);
		infomapa.setHorizontalAlignment(JLabel.CENTER);
		infomapa.setFont(new java.awt.Font("consolas", 0, 36)); 
		panel_mapa.add(infomapa);
		
		/*
		 * 
		nomb.setFont(new java.awt.Font("Tahoma", 0, 36)); 
		nomb.setHorizontalAlignment(JLabel.CENTER);
		nomb.setOpaque(true);
		nomb.setBounds(100,200,600,100);
		nomb.setOpaque(false);
		nomb.setForeground(Color.white);
		panel_final.add(nomb);
		 */
		
		
		m1 = new ImageIcon(getClass().getResource("/Imagenes/mapas/m1.png"));
		b1 = new JButton();
		b1.setIcon(m1);
		b1.setBounds(100, 33, 250, 250);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				juego.iniciar_juego(1);	
			}
		});
		panel_mapa.add(b1);
		
		m2 = new ImageIcon(getClass().getResource("/Imagenes/mapas/m2.png"));
		b2 = new JButton();
		b2.setIcon(m2);
		b2.setBounds(100, 316, 250, 250);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				juego.iniciar_juego(2);	
			}
		});
		panel_mapa.add(b2);
		
		m3 = new ImageIcon(getClass().getResource("/Imagenes/mapas/m3.png"));
		b3 = new JButton();
		b3.setIcon(m3);
		b3.setBounds(450, 33, 250, 250);
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				juego.iniciar_juego(3);	
			}
		});
		panel_mapa.add(b3);
		
		m4 = new ImageIcon(getClass().getResource("/Imagenes/mapas/m4.png"));
		b4 = new JButton();
		b4.setIcon(m4);
		b4.setBounds(450, 316, 250, 250);
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				juego.iniciar_juego(4 );	
			}
		});
		panel_mapa.add(b4);
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
		
		imgfondofinald = new ImageIcon(getClass().getResource("/Imagenes/fondos/derrotado.png"));
		imgfondofinalv = new ImageIcon(getClass().getResource("/Imagenes/fondos/victoria.png"));
		fondofinal = new JLabel();
		fondofinal.setBounds(0, 0, 800, 600);
		panel_final.add(fondofinal);
	}
	
	public void derrota(int pts)
	{
		
		getContentPane().removeAll();
		getContentPane().add(panel_final);
		nomb.setText("Jugador : "+nombrejugador+" "+apellidojugador);
		fondofinal.setIcon(imgfondofinald);
		puntaje.setText("Puntaje : "+pts);
		getContentPane().repaint();
		panel_final.repaint();
	}
	
	public void victoria(int pts)
	{
		getContentPane().removeAll();
		getContentPane().add(panel_final);
		nomb.setText("Jugador : "+nombrejugador+" "+apellidojugador);
		fondofinal.setIcon(imgfondofinalv);
		puntaje.setText("Puntaje : "+pts);
		getContentPane().repaint();
		panel_final.repaint();
	}
	
	private void inicializar_panel_inicial()
	{
		//FONDO
		panel_inicial = new JPanel();
		panel_inicial.setLayout(null);
		panel_inicial.setBounds(0, 0, 800, 600);
		
		//titulo
		labeltitulo = new JLabel("Battle City");
		labeltitulo.setFont(new java.awt.Font("consolas", 0, 70)); 
		labeltitulo.setHorizontalAlignment(JLabel.CENTER);
		labeltitulo.setBounds(0, 0, 800, 100);
		labeltitulo.setOpaque(false);
		panel_inicial.add(labeltitulo);
		
		//NOMBRE
		nombre = new JLabel("NOMBRE");
		nombre.setFont(new java.awt.Font("consolas", 0, 36)); 
		nombre.setHorizontalAlignment(JLabel.CENTER);
		nombre.setOpaque(true);
		nombre.setBounds(100,200,300,100);
		panel_inicial.add(nombre);
		nom = new JTextField();
		nom.setFont(new java.awt.Font("consolas", 0, 36)); 
		nom.setBounds(410, 200, 300,100);
		nom.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                nom.setText("");
            }
        });

		panel_inicial.add(nom);
		
		
		//apellido
		apellido = new JLabel("APELLIDO");
		apellido.setFont(new java.awt.Font("consolas", 0, 36)); 
		apellido.setHorizontalAlignment(JLabel.CENTER);
		apellido.setOpaque(true);
		apellido.setBounds(100,301,300,100);
		panel_inicial.add(apellido);
		ape = new JTextField();
		ape.setFont(new java.awt.Font("consolas", 0, 36)); 
		ape.setBounds(410, 301, 300,100);
		ape.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                ape.setText("");
            }
        });
		panel_inicial.add(ape);
		
		
		iniciar = new JButton("INICIAR JUEGO");
		iniciar.setFont(new java.awt.Font("consolas", 0, 20)); 
		iniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				nombrejugador = nom.getText();
				apellidojugador = ape.getText();
				if (nombrejugador.equals("")) nombrejugador ="Player1Nom";
				if (apellidojugador.equals("")) apellidojugador ="Player1Ape";
				
				
				
				mapas();
				//juego.iniciar_juego();
				
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
		getContentPane().repaint();
		
	}
	
	public void mapas()
	{
		getContentPane().removeAll();
		getContentPane().repaint();
		getContentPane().add(panel_mapa);
		getContentPane().repaint();
	}
	 
	
	

}
