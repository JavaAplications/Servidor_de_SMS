package Threads;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor extends Thread{

	 ServerSocket sk = null;
	    boolean continuar=true;
	    int Puerto;
	
	public Servidor(int Puerto){
		
		
		this.Puerto=Puerto;
		
	}
	
	
	public void run(){
		

		   try {
		         sk = new ServerSocket(Puerto);
		         System.out.println();  
	        	 System.out.println("*****************************************************");
			     System.out.println("************    Servidor de SMS      ***********");
	             System.out.println("************    IP: "+InetAddress.getLocalHost().getHostAddress()+":"+Puerto+"     **********");
	             System.out.println("*****************************************************");
	             
	               System.out.println();
		         
	             while (continuar) { 
		        	//  System.out.println("Esperando cliente: "+continuar);
		        	  Socket socketclient;
		        	  socketclient = sk.accept();// se queda a la espera de un cliente
		           //   System.out.println("Ingreso Cliente");
		                ((Clientes) new Clientes(socketclient)).start();
		          
		         }
		   } catch (IOException e) {
		          System.out.println("Puerto ocupado o Server Cerrado");
		          
		            
		          
		          
		         
		   }
 	
		
		
	}
	
	 public void StopServer(){
   	  continuar = false;
   	  try {
			sk.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }

}
