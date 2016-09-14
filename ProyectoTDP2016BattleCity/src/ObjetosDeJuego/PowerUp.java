package ObjetosDeJuego;

import Entidades_Moviles.Tanque_Jugador;

public abstract class PowerUp extends ObjetoDeJuego {
	
protected int puntos;

public PowerUp(int p)
{
	puntos=p;
}

public void contacto(Tanque_Jugador ta)
{
	
}

protected abstract destruirse();

 

	
}
