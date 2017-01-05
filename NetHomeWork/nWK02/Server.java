package nWK02;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;

public class Server {

	public static void main(String[] args) {
		try(ServerSocket ss = new ServerSocket(65432);
			Socket sk = ss.accept();
			InputStream in = sk.getInputStream();
			OutputStream out = sk.getOutputStream();
			DataInputStream dis = new DataInputStream(in);
			ObjectOutputStream oos = new ObjectOutputStream(out);
				){
			System.out.println("Server: Aleady system");
			ArrayList<Integer> al = new ArrayList<Integer>();
			int num = dis.readInt(), sum = 0;
			int max = 0, min = 0;
			double avg = 0;
			while (num >= 0) {
				int n = dis.readInt();
				al.add(n);
				sum += n;
				num--;
			}
			int als = al.size();
			avg = sum / als;
			Collections.sort(al, Collections.reverseOrder());
			System.out.println("Server: Array " + al);
			max = al.get(0);
			min = al.get(al.size() - 1);
			DataBean db = new DataBean(als, max, min, sum, avg);
			System.out.println("Server: Size " + als);
			System.out.println("Server: Max " + max);
			System.out.println("Server: Min " + min);
			System.out.println("Server: Sum " + sum);
			System.out.println("Server: Avg " + avg);
			oos.writeObject(db);
			oos.writeObject(null);
			dis.close();
			System.out.println("Server: Done");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
