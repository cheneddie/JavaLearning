import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
//			InputStream is = sk.getInputStream();
			OutputStream os = sk.getOutputStream();
//			DataOutputStream dos = new DataOutputStream(os);//Output to Cliente 
//			long w = 1006545645645656L;
//			dos.writeLong(w);
//			System.out.println("S: Output:"+w);
//			
//			DataInputStream dis = new DataInputStream(is);//Input from Client
//			long n = dis.readLong();
//			System.out.println("S: Input:"+n);
			FileInputStream fis = new FileInputStream("dog.jpg");
			int count = 0;
			byte[] b= new byte[8192];
			int len = 0;
			while((len=fis.read(b))!=-1){
				os.write(b,0,len);
				count+=len;
			}
			System.out.println("C: Send "+count+"Byte.");
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Server01 ss01 = new Server01(65432);
	}
	
}
