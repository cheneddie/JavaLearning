package net;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server01 {
    int portNo;
	public Server01(int portNo) {
		this.portNo = portNo;
		listen();
	}
    public void listen(){
    	System.out.println("S: ���b�غcServerSocket����");
    	try {
			ServerSocket ss = new ServerSocket(portNo);
			Socket sock = ss.accept();
			System.out.println("S: ���Ȥ�ݹq�����X�s�u");
			InputStream is = sock.getInputStream();
			OutputStream os = sock.getOutputStream();
			int n = 511;
			os.write(n);
			System.out.println("S: �g�X" + n);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }





	public static void main(String[] args) {
		Server01  ss01 = new Server01(65432);

	}

}
