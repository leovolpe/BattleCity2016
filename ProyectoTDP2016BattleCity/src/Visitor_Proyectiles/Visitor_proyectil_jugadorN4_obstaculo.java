package Visitor_Proyectiles;

import Juego.Juego;
import Obstaculos.Agua;
import Obstaculos.Arbol;
import Obstaculos.Base;
import Obstaculos.ParedAcero;
import Obstaculos.ParedLadrillo;
import Proyectil.Proyectil;

public class Visitor_proyectil_jugadorN4_obstaculo extends Visitor_Proyectil_obstaculo 
{
	public Visitor_proyectil_jugadorN4_obstaculo(Proyectil p, Juego j)
	{
		juego=j;
		proy=p;
	}
	

	@Override
	public void visitar(Agua a) 
	{
		// TODO Auto-generated method stub
	}

	
	@Override
	public void visitar(Arbol a) 
	{
		// TODO Auto-generated method stub
	}

	
	@Override
	public void visitar(Base b) 
	{
		System.out.println("perdi");
		juego.perder();
	}

	
	@Override
	public void visitar(ParedAcero p) 
	{
		p.reducir_energia();
		proy.destruirse();
	}
	

	@Override
	public void visitar(ParedLadrillo p) 
	{
		p.reducir_energia();
		proy.destruirse();
	}

}
