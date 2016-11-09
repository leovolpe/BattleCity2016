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
	private ImageIcon bala_E1;
	private ImageIcon bala_E2;
	private ImageIcon bala_E3;
	private ImageIcon bala_E4;
	
	public graficos_balas()
	{
		//distintos graficos, elegir uno para las balas de los enemigos, hay 4 opciones
		bala_jugador = new ImageIcon(getClass().getResource("/Imagenes/Balas/bala_tanque.png"));
		bala_E1 = new ImageIcon(getClass().getResource("/Imagenes/Balas/e1.png"));
		bala_E2 = new ImageIcon(getClass().getResource("/Imagenes/Balas/e2.png"));
		bala_E3 = new ImageIcon(getClass().getResource("/Imagenes/Balas/e3.png"));
		bala_E4 = new ImageIcon(getClass().getResource("/Imagenes/Balas/e4.png"));
		
	}

	public ImageIcon getBala_jugador() {
		return bala_jugador;
	}

	public ImageIcon getBala_E1() {
		return bala_E1;
	}

	public ImageIcon getBala_E2() {
		return bala_E2;
	}

	public ImageIcon getBala_E3() {
		return bala_E3;
	}

	public ImageIcon getBala_E4() {
		return bala_E4;
	}
	
	
	
	

}
