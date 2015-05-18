import Threads.Servidor;


public class ServidorSMS {

	static Servidor s;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("hola");

			s=new Servidor(9001);
s.run();

	}

}
