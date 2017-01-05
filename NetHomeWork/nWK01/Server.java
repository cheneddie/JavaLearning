package nWK01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try(ServerSocket ss = new ServerSocket(65432);
			Socket sock = ss.accept();
			InputStream is = sock.getInputStream();
			OutputStream os = sock.getOutputStream();
			DataInputStream dis = new DataInputStream(is);
			DataOutputStream dos = new DataOutputStream(os);
				){
			System.out.println("Server: Aleady system");
			int x= dis.readInt(),y= dis.readInt();
			System.out.println("Server: Received "+x+" "+y);
			int sum = x+y;
			dos.writeInt(sum);
			System.out.println("Server: Sended Random of two Sum"+sum);
			int sub = x-y;
			dos.writeInt(sub);
			System.out.println("Server: Sended Random of two Sub"+sub);
			double mul = x*y;
			dos.writeDouble(mul);
			System.out.println("Server: Sended Random of two Mul"+mul);
			double div = x%y;
			dos.writeDouble(div);
			System.out.println("Server: Sended Random of two Div"+div);
			dos.close();
			System.out.println("Server: Done");
			
			
		} catch (IOException e) {
			// TODO ×Ô„Ó®aÉúµÄ catch …^‰K
			e.printStackTrace();
		}

	}

}
