package PowerUps;

import javax.swing.JLabel;

import Entidades_Moviles.Tanque_Jugador;
import Juego.Juego;

public class Tanque extends PowerUp {

	public Tanque(Juego j, int x, int y) 
	{
		super(j);
		etiqueta = new JLabel(graficos.getTanque());
		etiqueta.setSize(60,60);
		
		this.setX(x);
		this.setY(y);
	}
	

	@Override
	public void contacto(Tanque_Jugador ta) 
	{
		getJuego().getSounds().vida();
		ta.aumentarPuntaje(puntos);
		ta.aumentar_vida();
		destruirse();
	}



}