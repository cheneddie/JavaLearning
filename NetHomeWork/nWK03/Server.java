package nWK03;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try(ServerSocket ss = new ServerSocket(65432);
			Socket sk = ss.accept();
			InputStream is = sk.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
				) {
			Mammal m=(Mammal) ois.readObject();
			
//			if(m instanceof Cat){
//				Cat c = (Cat) o;
//				long l = c.getBirthday();
//				String date = sdf.format(l);
			System.out.println("Server03: "+m.toString() );
//				System.out.println(date);
//			}
//			else if(m instanceof Dog){
//				Dog d = (Dog) o;
//				long l =d.getBirthday();
//				String date = sdf.format(l);
//				System.out.println("Server03: "+m.toString() );
//			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
