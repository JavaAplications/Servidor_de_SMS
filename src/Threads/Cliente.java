package Threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente extends Thread {
	
Socket socketclient ;
BufferedReader entrada;
	 
	public Cliente(Socket socket){
		
		
		 this.socketclient = socket;
		
	}
	
	public void run(){
		
		 
        try {
        	 entrada = new BufferedReader(new InputStreamReader(socketclient.getInputStream()));
        	String	datos = entrada.readLine();
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
