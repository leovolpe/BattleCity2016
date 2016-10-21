package Enemigos;

import javax.swing.JLabel;

import Graficas_Personajes.Enemigos.graficos_tanque_basico;
import Juego.Juego;
import Visitor_Proyectiles.Visitor_Proyectil_enemigos;
import Visitor_Proyectiles.Visitor_Proyectil_obstaculo;

public class EnemigoBasico extends Enemigo
{

	public EnemigoBasico( Juego j) {
		super(1, 2, 1, 1, 100, j);
		graficos = new graficos_tanque_basico();
		etiqueta=new JLabel(graficos.getAbajo());
		etiqueta.setSize(60, 60);
		this.setX(0);
		this.setY(0);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accept(Visitor_Proyectil_enemigos v) 
	{
		v.visitar(this);
		
	}

	

}
