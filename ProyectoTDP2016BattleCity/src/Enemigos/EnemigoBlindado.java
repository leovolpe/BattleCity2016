package Enemigos;

import javax.swing.JLabel;

import Graficas_Personajes.Enemigos.graficos_tanque_blindado;
import Juego.Juego;
import Visitor_Proyectiles.Visitor_Proyectil_enemigos;

/**Enemigo blindado
 * 
 *
 */
public class EnemigoBlindado extends Enemigo
{

	public EnemigoBlindado(Juego j) {
		super(4, 2, 3, 1, 100, j); //entrega 100 puntos por cada disparo recibido
		graficos = new graficos_tanque_blindado();
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
