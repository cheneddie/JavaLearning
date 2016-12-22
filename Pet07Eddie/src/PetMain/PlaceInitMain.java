package PetMain;

import PetMain.util.DBUtils;

public class PlaceInitMain {

	public static void main(String[] args) {
		PetDAO dao = new PetDAO();
		dao.createTables();
		DBUtils.initPlace("informations.txt", "BIG5");
	}

}
