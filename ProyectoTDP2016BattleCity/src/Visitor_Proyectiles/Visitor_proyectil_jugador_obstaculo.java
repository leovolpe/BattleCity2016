package Visitor_Proyectiles;

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
	
	public Visitor_proyectil_jugador_obstaculo(Proyectil p)
	{
		proy = p;
	}

	@Override
	public void visitar(Agua a) 
	{
		// TODO Auto-generated method stub
		//si el proyectil toca agua no hay nada que hacer
	}

	@Override
	public void visitar(Arbol a) {
		// TODO Auto-generated method stub
		//si el proyectil toca arboles no hay nada que hacer
	}

	@Override
	public void visitar(Base b) {
		// TODO Auto-generated method stub
		//implementacion mas adelante
		
	}

	@Override
	public void visitar(ParedAcero p) 
	{
		// TODO Auto-generated method stub
		//las balas comunes no le afectan
		
	}

	@Override
	public void visitar(ParedLadrillo p) 
	{
		p.reducir_energia();
		proy.destruirse();
		
	}
	

}
