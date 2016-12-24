import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
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
//			OutputStream os = sk.getOutputStream();
//			DataInputStream dis = new DataInputStream(is);//Input from Client
//			long n = dis.readLong();
//			System.out.println("C: Input:"+n);
//			
//			DataOutputStream dos = new DataOutputStream(os); //Output to Cliente 
//			long w = 654893156645645656L;
//			dos.writeLong(w);
//			System.out.println("C: Output:"+w);
			FileOutputStream fos = new FileOutputStream("dog1.jpg");
			int count = 0;
			byte[] b = new byte[8192];
			int len = 0;
			while ((len = is.read(b)) != -1) {
				fos.write(b, 0, len);
				count += len;
			}
			System.out.println("S: Receive "+count+"Byte.");
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
