package Control_Teclado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Hashtable;
import java.util.Map;

import Entidades_Moviles.Tanque_Jugador;



/**Clase que permite realizar acciones cuando dos o  mas teclas se presionan al mismo tiempo
 * 
 *
 */
@SuppressWarnings("serial")
public class Accionadordeteclas  extends javax.swing.Timer 
{
	/** Constante de la tecla para avanzar */
	final static int adelante = KeyEvent.VK_UP;

	/** Constante de la tecla para ir a la izquierda */
	final static int izquierda = KeyEvent.VK_LEFT;

	/** Constante de la tecla para ir a la derecha */
	final static int derecha = KeyEvent.VK_RIGHT;
	
	/**Constante de la tecla para retroceder*/
	final static int atras = KeyEvent.VK_DOWN;
	
	
	
	/** Mapeo que contiene las letras y un booleano que indica si esta siendo presionada*/
	private Map<Integer, Boolean> teclas;
	
	protected boolean pausa;
	
	/**Tanque del jugador que se controlara */
	private Tanque_Jugador tanque;
	
	
	
	
	public Accionadordeteclas(Tanque_Jugador t,int retardo)
	{
		super(retardo,null);
		teclas = new Hashtable<Integer, Boolean>();
		tanque = t;
		
		
		teclas.put(adelante, false);
		teclas.put(izquierda, false);
		teclas.put(derecha, false);
		teclas.put(atras, false);
		
		
		pausa=false;
		
		ActionListener oyente = crearOyente();
		addActionListener(oyente);
		
	}
	
	/**
	 * juego en pausa
	 */
	public void pausa()
	{
		pausa=true;
	}
	
	/**
	 * juego deja de estar en pausa
	 */
	public void fin_pausa()
	{
		pausa=false;
	}
	
/**Crea un oyente que realiza determinada accion dependiendo que teclas hay presionadas
 * 
 * @return oyente
 */
	private ActionListener crearOyente() {
		ActionListener oyente = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				

					
				if (!pausa)
				{
				
					if (teclas.get(adelante))
					{
						tanque.adelante();
						
					}
					else if (teclas.get(atras))
					{
						tanque.atras();
					}
					else if (teclas.get(derecha))
					{
						tanque.derecha();
					}
					else if (teclas.get(izquierda))
					{
						tanque.izquierda();
					}
					
					
					
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
	public void setTecla(int tecla, boolean estado) 
	{
		teclas.put(tecla, estado);
	}

	

}
