import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente01 {
	String ip;
	int portNo;

	
	public Cliente01(String ip, int portNo) {
		super();
		this.ip = ip;
		this.portNo = portNo;
		connect();
	}
	public void connect(){
		try {
			Socket sk = new Socket(ip, portNo);
			System.out.println("C: Aleady Connected.");
			InputStream is = sk.getInputStream();
			OutputStream os = sk.getOutputStream();
			int n = is.read();
			System.out.println("c: Input:"+n);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Cliente01 c01 = new Cliente01("127.0.0.1", 65432 );


	}

}
