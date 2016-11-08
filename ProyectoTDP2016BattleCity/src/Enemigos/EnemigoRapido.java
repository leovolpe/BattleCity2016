package Enemigos;

import javax.swing.JLabel;
import Graficas_Personajes.Enemigos.graficos_tanque_rapido;
import Juego.Juego;
import Visitor_Proyectiles.Visitor_Proyectil_enemigos;

/**Enemigo rapido
 *
 */
public class EnemigoRapido extends Enemigo
{

	public EnemigoRapido( Juego j) 
	{
		super(1, 8, 14, 1, 200, j);
		graficos = new graficos_tanque_rapido();
		etiqueta=new JLabel(graficos.getAbajo());
		etiqueta.setSize(60, 60);
		this.setX(0);
		this.setY(0);
	}

	@Override
	public void accept(Visitor_Proyectil_enemigos v) 
	{
		v.visitar(this);
		
	}

}
