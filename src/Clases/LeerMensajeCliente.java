package Clases;

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
		System.out.println("SMS RECIBIDO !!!");	
		
		
		System.out.println("Msg: " +mensaje);
		
			
	
		try {
			dni=Integer.parseInt(mensaje);
			System.out.println("dni: "+dni);	
			
		} catch (Exception e) {
			System.out.println("no es un dni");	
			
		}
		
		//	Alarma=Integer.parseInt(arr[2]);
		// cuando la alarma es '1' es una keep alive.
		// caso contrario es una alarma de algun tipo.
		
		
	


	}
}

