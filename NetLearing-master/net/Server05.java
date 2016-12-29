package net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server05 {
	int portNo;
	public Server05(int portNo) {
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
			BufferedReader br = new  BufferedReader(
					new InputStreamReader(is, "UTF-8"));
			String line  = null;
			while ((line = br.readLine())!= null){
				if (line.trim().length() == 0)
					break;
				System.out.println("�s�����e�Ӫ����:" + line);
			}
		    System.out.println("Ū������....");
		    PrintWriter pw = new PrintWriter(
		    		    new OutputStreamWriter(os, "UTF-8"));
		    pw.println("HTTP/1.1  200  OK");   // ���A�C
		    //pw.println("Content-Type: image/gif");   // �^�����Y
		    pw.println("Content-Type: text/html; charset=UTF-8");   // �^�����Y
		    pw.println("Connection: Close");   // �^�����Y
		    pw.println("");   // �Ť@�C�ťզ�
		    // �^��������
		    pw.println("<html><head><title>�Ѥp�p���A���e�X���^��");  
		    pw.println("</title></head><body>");
		    pw.println("<h1>Hello World, �j�a�n</h1>");
		    pw.println("<hr>");
		    pw.println("<h2>Hello World, �j�a�n</h2>");
		    pw.println("</body></html>");
		    pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
// MIME Type
	public static void main(String[] args) {
		Server05  ss01 = new Server05(65432);

	}

}
/*
			PrintWriter pw = new PrintWriter(
					new OutputStreamWriter(os, "UTF-8"));
			pw.println("HTTP/1.1  200  OK");
			pw.println("Content-Type: text/html; charset=UTF-8");
			pw.println("Connection: close");
			pw.println();
			pw.println("<html><body><h1>Hello, World�A�A�n��?</h1></body></html>");
			pw.close();
*/			

