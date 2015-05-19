package Bbdd;


public class SolicitudIngreso {
	Conexion con;
	int dni;
	public SolicitudIngreso(int dni){
		this.dni=dni;
		
	
	}
	
	
	public void escribirBBDD(){
		
		
		 con=new Conexion();
		  con.Conectar();
		  con.InsertarSolicitud(dni);
		
	}
	
	public void leerBBDD(){
		
		
		 con=new Conexion();
		  con.Conectar();
		  con.leerSolicitud(dni);
		
	}
}
