package PetMain;

import PetMain.util.DBUtils;

public class PlaceUpdateMain {

	public static void main(String[] args) {
		byte[] picture = DBUtils.fileToBytes("pics/UpdatePicture.jpg");
		char[] comment = DBUtils.fileToChars("txts/UpdateText.txt", "big5");

		PetDAO dao = new PetDAO();
//		PetBean pb = new PetBean(id, petName, masterName, birthday, price, weight, filename, picture, comment)
		PetBean pb = new PetBean(1, "dog", "Eddie", "1989-01-01",10000,  7.2,"pics/dog.jpg", picture, comment);
		int n = dao.update(pb);
		if (n == 1) {
			System.out.println("修改一筆紀錄");
		} else {
			System.out.println("未修改任何紀錄");
		}
		
	}
}
