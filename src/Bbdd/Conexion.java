package Bbdd;

import java.sql.*;


public class Conexion {
	
public Conexion() {
		
	}



public  Connection Conectar(){
	
	Connection con=null;
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con= DriverManager.getConnection("jdbc:mysql://localhost/bdradiobases","root","");	
		
	} catch (Exception e) {
		System.out.println("No se pudo conectar");
	}
	return con;
	
}
	



public void InsertarSolicitud(int Id_Dni)

{
	
	Connection con=Conectar();
	
		PreparedStatement pst;
		try {
			pst = con.prepareStatement("INSERT INTO solicitudes (Id_Dni) VALUES (?)");
				pst.setInt(1,Id_Dni);
			
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	

}

public String leerSolicitudAudio(int Id_Dni)
{
	
	  String url = null;
		
		Connection con=Conectar();
		Statement st;
		ResultSet rs=null;
		try {
			st=con.createStatement();
			rs=st.executeQuery("SELECT * FROM dni WHERE Id_Dni='"+Id_Dni+"' ");
			 while(rs.next()){
			      
			     url=rs.getString("Audio_dni");
			       
			       System.out.println(url);
			   }
			
			} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return url;
	
	

}
	
	

}
