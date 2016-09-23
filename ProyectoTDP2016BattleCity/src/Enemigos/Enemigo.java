package Enemigos;

import Entidades_Moviles.EntidadMovil;

public class Enemigo extends EntidadMovil{
	
	protected int puntos;
	
	public Enemigo (int r, int vm, int vd, int ds, int dp, int p)
	{
		super(r, vm, vd, ds, dp, 's');
		puntos=p;
	}

	@Override
	public void disparar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destruirse() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean puede_disparar() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public int recibirDisparo()
	{
		return puntos;
	}

}
