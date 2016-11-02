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
	private ImageIcon bala_Ebasico;
	private ImageIcon bala_Eblindado;
	private ImageIcon bala_Epoder;
	private ImageIcon bala_Erapido;
	
	public graficos_balas()
	{
		bala_jugador = new ImageIcon(getClass().getResource("/Imagenes/Balas/bala_tanque.png"));
		bala_Ebasico = new ImageIcon(getClass().getResource("/Imagenes/Balas/basico.png"));
		bala_Eblindado = new ImageIcon(getClass().getResource("/Imagenes/Balas/blindado.png"));
		bala_Epoder = new ImageIcon(getClass().getResource("/Imagenes/Balas/poder.png"));
		bala_Erapido = new ImageIcon(getClass().getResource("/Imagenes/Balas/rapido.png"));
		
	}

	public ImageIcon getBala_jugador() {
		return bala_jugador;
	}

	public ImageIcon getBala_Ebasico() {
		return bala_Ebasico;
	}

	public ImageIcon getBala_Eblindado() {
		return bala_Eblindado;
	}

	public ImageIcon getBala_Epoder() {
		return bala_Epoder;
	}

	public ImageIcon getBala_Erapido() {
		return bala_Erapido;
	}
	
	
	
	

}
