package nWK02;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		try(Socket sk = new Socket("127.0.0.1", 65432);
			InputStream in = sk.getInputStream();
			OutputStream out = sk.getOutputStream();
			ObjectInputStream ois = new ObjectInputStream(in);
			DataOutputStream dos = new DataOutputStream(out);) {
			System.out.println("Client: Aleady System");
			int n = (int) (Math.random() * (10 - 5) + 5);
			dos.writeInt(n);
			while (n >= 0) {
				System.out.println("Client: n= " + n);
				int r = (int) (Math.random() * 100 + 1);
				dos.writeInt(r);
				System.out.println("Client: Sended " + r);
				n--;
			}
			Object o = null;
			while((o = ois.readObject())!=null){
				DataBean db = (DataBean) o;
			System.out.println("Client: Size " + db.getNum());
			System.out.println("Client: Max " + db.getMax());
			System.out.println("Client: Min " + db.getMin());
			System.out.println("Client: Sum " + db.getSum());
			System.out.println("Client: Avg " + db.getAvg());
			System.out.println("Client: Done");
			}

		} catch (IOException e) {
			// TODO �ԄӮa���� catch �^�K
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
