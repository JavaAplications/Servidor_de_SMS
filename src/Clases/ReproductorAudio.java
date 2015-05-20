package Clases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		res=con.leerSolicitudAudio(dni);
		
		try {
			
			audio=	res.getString("AudioDni");
			
			System.out.println("audio"+audio);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// String audio= "C:/Users/Diego/Google Drive/FotosRadiobases/AUDIOS/mp3/DiegoGiovanazzi.wav";
		 
		 try {
			InputStream in=new FileInputStream(audio) ;
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
