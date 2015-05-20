package Clases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;


import Bbdd.Conexion;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class ReproductorAudio {
    
	Conexion con;
	int dni;
	 String audio=null;
	ResultSet res=null;
	public ReproductorAudio(int dni){
		
		this.dni=dni;
	
		
		
	}
	
	
	public void play(){
		
		con= new Conexion();
		String url=con.leerSolicitudAudio(dni);
		
		 
		 try {
			InputStream in=new FileInputStream(url) ;
			AudioStream aud=new  AudioStream(in);
			AudioPlayer.player.start(aud);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
