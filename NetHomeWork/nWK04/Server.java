package nWK04;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try(ServerSocket ss = new ServerSocket(65432);
			Socket sk = ss.accept();
			InputStream is = sk.getInputStream();
			DataInputStream dis = new DataInputStream(is);
				) {
			String s = dis.readUTF();
			System.out.println("Server04: 客戶端送來的字串為 "+ s);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
