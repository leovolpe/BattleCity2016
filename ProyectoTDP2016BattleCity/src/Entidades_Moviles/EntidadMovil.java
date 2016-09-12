package Entidades_Moviles;

public abstract class EntidadMovil {
	
	private int resistencia;
	private int vel_mov;
	private int vel_disp;
	private int disparos_simultaneos;
	private int disparos_en_pantalla;
	
	public EntidadMovil(int r, int vm, int vd, int ds, int dp)
	{
		resistencia = r;
		vel_mov=vm;
		vel_disp=vd;
		disparos_simultaneos = ds;
		disparos_en_pantalla = dp;
	}
	
	public void adelante()
	{
		
	}
	
	public void atras()
	{
		
	}
	
	public void izquierda()
	{
		
	}
	
	public void derecha()
	{
		
	}
	
	public abstract void disparar();
	
	public abstract boolean puede_disparar();
	

}
