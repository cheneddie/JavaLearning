import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server01 {
	int portNo;

	public Server01(int portNo) {
		super();
		this.portNo = portNo;
		listen();
	}
	public void listen(){
		System.out.println("S: Creating ServerSocket.");
		try {
			ServerSocket ss = new ServerSocket(portNo);
			Socket sk = ss.accept();
			System.out.println("S: Client Connected.");
			InputStream is = sk.getInputStream();
			OutputStream os = sk.getOutputStream();
			int w = 100;
			os.write(w);
			System.out.println("S: Output:"+w);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Server01 ss01 = new Server01(65432);
	}
	
}
