package ex01;

import java.sql.Blob;
import java.sql.Clob;



import ex01.util.DBUtils;

public class PlaceUpdateMain {

	public static void main(String[] args) {
		byte[] picture = DBUtils.fileToBytes("images/UpdatePicture.jpg");
		char[] comment = DBUtils.fileToChars("text/UpdateText.txt", "big5");

		PlaceDAO dao = new PlaceDAO();
		PlaceBean pb = new PlaceBean(3, 5, "韓式烤肉", "02-55661122", 
			"台北市新生南路一段100號", 125.112233, 24.225588, 
			"http://www.restaurant.com", "picture.gif", 
			picture, comment); 
		int n = dao.update(pb);
		if (n == 1) {
			System.out.println("刪除一筆紀錄");
		} else {
			System.out.println("未刪除任何紀錄");
		}
		System.out.println("----------------------------");
		n = dao.delete(300);
		if (n == 1) {
			System.out.println("刪除一筆紀錄");
		} else {
			System.out.println("未刪除任何紀錄");
		}
	}
}
