package graficos_balas;

import javax.swing.ImageIcon;

/**Encapsula los grafios de las balas
 * 
 *
 */
public class graficos_balas 
{
	//por ahora hay un solo grafico
	private ImageIcon bala_jugador;
	
	/**
	 * retorna el grafico del proyectil
	 * @return
	 */
	public ImageIcon get_bala_jugador()
	{
		if (bala_jugador==null)
			bala_jugador = new ImageIcon(getClass().getResource("/Imagenes/Balas/bala_tanque.png"));
		return bala_jugador;
	}

}
