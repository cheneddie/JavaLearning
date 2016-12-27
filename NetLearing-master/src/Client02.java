package src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
public class Client02 {
	String ip;
    int portNo;
    public Client02(String ip, int portNo) {
		super();
		this.ip = ip;
		this.portNo = portNo;
		connect();
	}
	public void connect(){
    	try {
			Socket sock = new Socket(ip , portNo);
			System.out.println("C: �w�g�P���A���s�u");
			InputStream is = sock.getInputStream();
			OutputStream os = sock.getOutputStream();
			DataInputStream dis = new DataInputStream(is);
			DataOutputStream dos = new DataOutputStream(os);
			long n = dis.readLong();
			System.out.println("C: Ū��" + n);
			dos.writeLong(n*2);
			System.out.println("C: �g�^" + n*2);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	public static void main(String[] args) {
		Client02  ss01 = new Client02("127.0.0.1" , 65432);
//		ss01.sendData(0);
	}
}
