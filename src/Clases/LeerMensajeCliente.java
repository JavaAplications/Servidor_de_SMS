package Clases;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class LeerMensajeCliente {


	 private static final Pattern SPACE = Pattern.compile(" ");
	 int dni;
	// String StringAlarma;

	 String mensaje=null;
	
public LeerMensajeCliente(String mensaje){
		
		
		this.mensaje=mensaje;
		
		
	}
	
	
	public void leer(){
		
		String timeStamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
		
		System.out.println(timeStamp +"Msg: " +mensaje);
		
			
	
		try {
			dni=Integer.parseInt(mensaje);
			if(dni>4000000){	System.out.println(timeStamp+" DNI: "+dni);	
			}else{	System.out.println("Faltan numeros al DNI");	
			}
			
			
		} catch (Exception e) {
			System.out.println("Ingrese DNI sin espacios y sin puntos");	
			
		}
	}
}

