package Entidades_Moviles;

public class Tanque_Jugador extends EntidadMovil {

	private int puntaje;
	private int vidas;
	private boolean inmunidad;
	private int nivel;
	
	
	public Tanque_Jugador(int r, int vm, int vd, int ds, int dp) {
		super(4, 2, 2, 2, 3);
		puntaje=0;
		vidas=4;
		inmunidad=false;
		nivel=1;
	}


	@Override
	public void disparar() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean puede_disparar() {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
