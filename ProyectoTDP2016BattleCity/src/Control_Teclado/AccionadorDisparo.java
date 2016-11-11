package Control_Teclado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Hashtable;
import java.util.Map;

import Entidades_Moviles.Tanque_Jugador;



/**Clase que permite realizar acciones cuando dos o  mas teclas se presionan al mismo tiempo, dedicada a los disparos
 * 
 * @author Javier Graff
 * @author Eric Avondet
 * @author Rodrigo Herrera
 *
 */
@SuppressWarnings("serial")
public class AccionadorDisparo extends javax.swing.Timer  {
	


	private Tanque_Jugador tanque;
	
	
	/** Constante de la tecla para disparar recto */
	final static int disparar = KeyEvent.VK_S;
	
	final static int nivel = KeyEvent.VK_Q;

	
	private Map<Integer, Boolean> teclas;
	
	protected boolean pausa;
	
	
	
	public AccionadorDisparo(Tanque_Jugador t,int retardo)
	{
		super(retardo,null);
		
		tanque=t;
		teclas = new Hashtable<Integer, Boolean>();
		teclas.put(disparar, false);
		teclas.put(nivel, false);
		pausa=false;
		
		ActionListener oyente = crearOyente();
		addActionListener(oyente);
	}
	
	/**
	 * Juego en pausa
	 */
	public void pausa()
	{
		pausa=true;
	}
	
	/**
	 * Juego deja de estar en pausa
	 */
	public void fin_pausa()
	{
		pausa=false;
	}
	
	/**
	 * Crea un oyente que realiza determinada accion dependiendo que teclas hay presionadas
	 * @return oyente
	 */
	private ActionListener crearOyente() {
		
		ActionListener oyente = new ActionListener() {

			
			public void actionPerformed(ActionEvent e) 
			{
				if (!pausa)
				{
					if (teclas.get(disparar))
						tanque.disparar();
					else if (teclas.get(nivel))
						tanque.aumentarNivel();
				}
			}
				
			};
			return oyente;
		}
	
	
	/**
	 * Setea el estado de una tecla
	 * @param tecla tecla
	 * @param estado true o false
	 */
	public void setTecla(int tecla, boolean estado) {
		teclas.put(tecla, estado);
	}
			

	
	
}
