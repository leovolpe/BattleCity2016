package Visitor_Proyectiles;

import Juego.Juego;
import Obstaculos.Agua;
import Obstaculos.Arbol;
import Obstaculos.Base;
import Obstaculos.ParedAcero;
import Obstaculos.ParedLadrillo;
import Proyectil.Proyectil;


/**Visitor de un proyectil lanzado por el jugador afectando a los obstaculos
 * 
 *
 */
public class Visitor_proyectil_jugador_obstaculo extends Visitor_Proyectil_obstaculo
{
	
	public Visitor_proyectil_jugador_obstaculo(Proyectil p,Juego j)
	{
		juego=j;
		proy = p;
	}

	@Override
	public void visitar(Agua a) 
	{
		// TODO Auto-generated method stub
		//si el proyectil toca agua no hay nada que hacer
	}

	@Override
	public void visitar(Arbol a) 
	{
		// TODO Auto-generated method stub
		//si el proyectil toca arboles no hay nada que hacer
	}

	@Override
	public void visitar(Base b) {
		// TODO Auto-generated method stub
		//implementacion mas adelante
		proy.destruirse();
		juego.perder();
		
	}

	@Override
	public void visitar(ParedAcero p) 
	{
		// TODO Auto-generated method stub
		//las balas comunes no le afectan
		proy.destruirse();
		
	}

	@Override
	public void visitar(ParedLadrillo p) 
	{
		p.reducir_energia();
		proy.destruirse();
		
	}
	

}
