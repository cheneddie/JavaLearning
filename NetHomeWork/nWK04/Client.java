package nWK04;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	
	public static void main(String[] args) {
		String[]  sa = {"MLB／王建民登板 球速飆到150公里",
		        "中心打線發威貢獻6分-皇家拿下2連勝",	   
			     "MLB／王建民登板 球速飆到150公里", 
				   "光芒大破紅襪 結束11連敗"};
		int r = (int)(Math.random()*sa.length+1);
		
		try(Socket sk = new Socket("127.0.0.1", 65432);
			OutputStream os = sk.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
				){
			dos.writeUTF(sa[r]);
			System.out.println("Client04: 隨機字串為 "+sa[r]);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
