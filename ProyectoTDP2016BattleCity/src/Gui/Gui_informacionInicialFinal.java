package Gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Gui_informacionInicialFinal extends JFrame 
{
	private JPanel panel_inicial;
	private JLabel nombre, apellido, labelfondo;
	private ImageIcon fondo_inicial;
	
	public Gui_informacionInicialFinal()
	{
		getContentPane().setPreferredSize(new Dimension(800, 600));
		this.pack();
		centrar_pantalla();
		inicializar_panel_inicial();
	}
	
	private void inicializar_panel_inicial()
	{
		//FONDO
		panel_inicial = new JPanel();
		panel_inicial.setLayout(null);
		panel_inicial.setBounds(0, 0, 800, 600);
		getContentPane().add(panel_inicial);
		
		//NOMBRE
		nombre = new JLabel("NOMBRE");
		
		
		
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
	
	
	
	 private void cambiarPanel(JPanel panel1, JPanel panel2) 
	 {
		getContentPane().remove(panel1);
		getContentPane().add(panel2);
	}
	 
	 public void centrar_pantalla()
		{
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			int y = (int) dim.getHeight()/2;
			int x = (int) dim.getWidth()/2;
			y-=getContentPane().getHeight()/2;
			x-=getContentPane().getWidth()/2;
			
			this.setLocation(x,y);
		}
	 
	 public static void main(String args[])
	 {
		 Gui_informacionInicialFinal g  = new Gui_informacionInicialFinal();
		 g.setVisible(true);
	 }
	

}
