package PowerUps;

import Entidades_Moviles.Tanque_Jugador;
import ObjetosDeJuego.ObjetoDeJuego;

public abstract class PowerUp extends ObjetoDeJuego {
	
protected int puntos;

public PowerUp(int p)
{
	puntos=p;
}

public void contacto(Tanque_Jugador ta)
{
	
}

protected abstract void destruirse();

 

	
}
