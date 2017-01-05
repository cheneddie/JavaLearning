package nWK03;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/*
 *A. 將 "2010-12-20 18:27:36" 轉換為long型態的整數: ins.
  B. 隨機產生1個介於1-10的亂數，如果此數為偶數，產生一個Cat物件， Cat c = new Cat("Kitty", ins);
	   並於螢幕上顯示『Client03: 產生Cat物件』
	   如果此數為機奇數，產生一個Dog物件
	      Dog d = new Dog("Snoopy", ins);
	   並於螢幕上顯示『Client03: 產生Dog物件』
  C.將此物件寫出，透過網路送達到Server端，由Server03.java讀取
  
  D. 顯示『Client03: 程式結束』
 * */
public class Client {
	
	public static void main(String[] args) {
		//B
		int r = (int)(Math.random()*10+1);
		long ins = 0;
		String date = "2010-12-20 18:27:36";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try(Socket sk = new Socket("127.0.0.1", 65432);
			OutputStream out = sk.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(out);
			){
			//A
			ins = sdf.parse(date).getTime();
			if(r%2==0)
				{
				Cat c = new Cat("Kitty", ins);
				oos.writeObject(c);
				System.out.println("Client03: 產生Cat物件 " +c);
				}
			else{
				Dog d = new Dog("Snoopy", ins);
				oos.writeObject(d);
				System.out.println("Client03: 產生Dog物件 " +d);
				}
			}catch(ParseException e){
				e.printStackTrace();
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
