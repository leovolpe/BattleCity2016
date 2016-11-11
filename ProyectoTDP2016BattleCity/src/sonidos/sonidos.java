package sonidos;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class sonidos 
{
	
	 private Clip clip;
	 protected URL url_ene, url_tanque,url_cambionivel,url_exp,url_victoria, url_derrota,url_timer,url_par,url_vida, url;
	 private AudioInputStream ais;
	 
	 public sonidos()
	 {
		 url_tanque = getClass().getResource("/sonidos/sounds/disptanque.wav");
		 url_ene = getClass().getResource("/sonidos/sounds/disp_ene.wav");
		 url_cambionivel = getClass().getResource("/sonidos/sounds/nivel.wav");
		 url_exp = getClass().getResource("/sonidos/sounds/explosion.wav");
		 url_victoria = getClass().getResource("/sonidos/sounds/victoria.wav");
		 url_derrota = getClass().getResource("/sonidos/sounds/derrota.wav");
		 url_timer = getClass().getResource("/sonidos/sounds/timer.wav");
		 url_par = getClass().getResource("/sonidos/sounds/paredes.wav");
		 url_vida = getClass().getResource("/sonidos/sounds/vida.wav");
	 }
	 
	 public void vida()
	 {
		 url = url_vida;
		 reproducir();
	 }
	 
	 public void paredes()
	 {
		 url = url_par;
		 reproducir();
	 }
	 
	 public void timer()
	 {
		 url = url_timer;
		 reproducir();
	 }
	 
	 public void derrota()
	 {
		 url = url_derrota;
		 reproducir();
	 }
	 
	 public void victoria()
	 {
		 url = url_victoria;
		 reproducir();
	 }
	 
	 public void cambio_nivel()
	 {
		 url = url_cambionivel;
		 reproducir();
	 }
	 
	 public void disparo_t()
	 {
		 url = url_tanque;
		 reproducir();
	 }
	 
	 public void disparo_e()
	 {
		 url = url_ene;
		 reproducir();
	 }
	 
	 public void explosion() 
	 {
		 url = url_exp;
		 reproducir();
	 }
	 
	 private void reproducir()
	 {
		
		 	try {
		 		
		 		ais =  AudioSystem.getAudioInputStream(url);
		 		clip = AudioSystem.getClip();
				clip.open(ais);
				clip.start();
				
		 	} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedAudioFileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 	
	 }

	

}
