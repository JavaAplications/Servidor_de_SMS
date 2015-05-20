package Threads;

import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextArea;

import Clases.LeerMensajeCliente;

public class Clientes extends Thread {
	
Socket socketclient ;
BufferedReader entrada;
JTextArea consolaArea;
	 
	public Clientes(Socket socket,JTextArea consolaArea){
		
		
		 this.socketclient = socket;
		 this.consolaArea=consolaArea;
		
	}
	
	public void run(){
		String timeStamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
		     
		 
        try {
        	 entrada = new BufferedReader(new InputStreamReader(socketclient.getInputStream()));
        	String	datos = entrada.readLine();
        	  System.out.println(timeStamp+" "+datos);
     	     
        	
        	LeerMensajeCliente read=new LeerMensajeCliente(datos,consolaArea);
        	read.leer();
        	if (datos==null){
        		 System.out.println(" dato nulo ");
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
