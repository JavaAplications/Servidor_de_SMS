package Clases;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import javax.swing.JTextArea;

import Bbdd.SolicitudIngreso;

public class LeerMensajeCliente {


	 private static final Pattern SPACE = Pattern.compile(" ");
	 int dni;
	// String StringAlarma;
	 JTextArea consolaArea;
	 String mensaje=null;
	 SolicitudIngreso solicitud;
	
public LeerMensajeCliente(String mensaje,JTextArea consolaArea){
		
		
		this.mensaje=mensaje;
		this.consolaArea=consolaArea;
		
	}
	
	
	public void leer(){
		
		String timeStamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
		
		System.out.println(timeStamp +"Msg: " +mensaje);
		
			
	
		try {
			dni=Integer.parseInt(mensaje);
			String msg=" Solicitud de ingreso DNI: "+dni+" "+timeStamp;
			
			if(dni>3000000){	
			
				solicitud=new SolicitudIngreso(dni);
				solicitud.escribirBBDD();
				consolaArea.append(msg);
				
			
			}else{	System.out.println("Faltan numeros al DNI");	
			}
			
		} catch (Exception e) {
			System.out.println("Ingrese DNI sin espacios y sin puntos");	
			
		}
	}
}

