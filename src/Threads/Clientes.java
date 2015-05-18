package Threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import Clases.LeerMensajeCliente;

public class Clientes extends Thread {
	
Socket socketclient ;
BufferedReader entrada;
	 
	public Clientes(Socket socket){
		
		
		 this.socketclient = socket;
		
	}
	
	public void run(){
		
		 
        try {
        	 entrada = new BufferedReader(new InputStreamReader(socketclient.getInputStream()));
        	String	datos = entrada.readLine();
        	
        	
        	LeerMensajeCliente read=new LeerMensajeCliente(datos);
        	read.leer();
        	String timeStamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
        	if (datos==null){
                 }else{
             System.out.println(timeStamp+" "+datos);
              }
          } catch (IOException ex) {
            
        }
        desconnectar() ;
		
	}
	
	public void desconnectar() {
        try {
        	socketclient.close();
        } catch (IOException ex) {
           
        }
    }
}
