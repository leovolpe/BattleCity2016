package graficos_balas;

import javax.swing.ImageIcon;

public class graficos_balas 
{
	private ImageIcon bala_jugador;
	
	
	
	public ImageIcon get_bala_jugador()
	{
		if (bala_jugador==null)
			bala_jugador = new ImageIcon(getClass().getResource("/Imagenes/Balas/bala_tanque.png"));
		return bala_jugador;
	}

}
