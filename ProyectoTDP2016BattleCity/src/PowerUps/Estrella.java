package PowerUps;

import javax.swing.JLabel;

import Entidades_Moviles.Tanque_Jugador;
import Juego.Juego;

public class Estrella extends PowerUp {

	public Estrella(Juego j, int x, int y) 
	{
		super(j);
		etiqueta = new JLabel(graficos.getEstrella());
		etiqueta.setSize(60,60);
		
		this.setX(x);
		this.setY(y);
	}

	
	@Override
	public void contacto(Tanque_Jugador ta) 
	{
		ta.aumentarPuntaje(puntos);
		ta.aumentarNivel();
		destruirse();
	}

	




}