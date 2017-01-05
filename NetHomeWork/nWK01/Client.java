package nWK01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		try(Socket sock = new Socket("127.0.0.1", 65432);
			InputStream is = sock.getInputStream();
			OutputStream os = sock.getOutputStream();
			DataInputStream dis = new DataInputStream(is);
			DataOutputStream dos = new DataOutputStream(os);
				){
			System.out.println("Client: Aleady System");
			int x = (int) (Math.random() * 100 + 1), y = (int) (Math.random() * 100 + 1);
			dos.writeInt(x);dos.writeInt(y);
			System.out.println("Client: Sended "+x+" and "+y+"");
			System.out.println("Client: Receive Random of two Sum"+(dis.readInt()));
			System.out.println("Client: Receive Random of two Sub"+(dis.readInt()));
			System.out.println("Client: Receive Random of two Mul"+(dis.readDouble()));
			System.out.println("Client: Receive Random of two Div"+(dis.readDouble()));
			dos.close();
			System.out.println("Client: Done");
			
			
		}  catch (IOException e) {
			// TODO �ԄӮa���� catch �^�K
			e.printStackTrace();
		}
	}
}
