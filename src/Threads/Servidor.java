package Threads;


import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JTextArea;


public class Servidor extends Thread{

	private ServerSocket sk = null;
	private    boolean continuar=true;
	  private  int Puerto;
	   private JTextArea consolaArea;
	
	public Servidor(int Puerto, JTextArea consolaArea){
		
		
		this.Puerto=Puerto;
		this.consolaArea=consolaArea;
		
	}
	
	
	public void run(){
		

		   try {
		         sk = new ServerSocket(Puerto);
		         System.out.println();  
		     	 System.out.println("*****************************************************");
	        	 consolaArea.append("*****************************************************\n");
			     System.out.println("************       Servidor de SMS      *************");
			     consolaArea.append("************         Servidor de SMS        *************\n");
	             System.out.println("************       IP: "+InetAddress.getLocalHost().getHostAddress()+":"+Puerto+"     **********");
	             consolaArea.append("************     IP: "+InetAddress.getLocalHost().getHostAddress()+":"+Puerto+"     **********\n");
	             System.out.println("*****************************************************");
	             consolaArea.append("******************************************************\n");
	             
	               System.out.println();
	               consolaArea.append("");
	             while (continuar) { 
		        	  System.out.println("Esperando cliente: "+continuar);
		        	  Socket socketclient;
		        	  socketclient = sk.accept();// se queda a la espera de un cliente
		                 Clientes c=new Clientes(socketclient,consolaArea);
		               c.start();
		          
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
