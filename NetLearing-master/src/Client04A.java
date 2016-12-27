package src;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
public class Client04A {
	String ip;
    int portNo;
    public Client04A(String ip, int portNo) {
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
//			DataInputStream dis = new DataInputStream(is);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			String filename = "rt.jar";
			long filesize = 0;
			String path = "d:/";
			File file = new File(path, filename);
			if(file.exists()){
				filesize = file.length();
			}else{
				filesize = 0;
			}
			FileDate fd = new FileDate(filename, filesize); 			
			
			FileOutputStream fos = new FileOutputStream
					   ("D:\\java004\\Data\\rt.jar");
			int count = 0;
			byte[] b = new byte[8192];
			int len = 0 ;
			while ((len=is.read(b))!=-1){
				fos.write(b, 0, len);
				count += len;
			}
			System.out.println("C: ����" + count + "�줸��");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	public static void main(String[] args) {
		Client04A  ss01 = new Client04A("127.0.0.1" , 65432);
//		ss01.sendData(0);
	}
}
