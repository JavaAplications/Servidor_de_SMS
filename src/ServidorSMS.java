import Threads.Servidor;


public class ServidorSMS {
static int Puerto=9003;
	static Servidor s;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("hola");

			s=new Servidor(Puerto);
    s.run();

	}

}
