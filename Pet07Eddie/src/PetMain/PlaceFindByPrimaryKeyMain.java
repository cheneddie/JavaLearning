package PetMain;

import PetMain.util.DBUtils;

public class PlaceFindByPrimaryKeyMain {

	public static void main(String[] args) {
		
		PetDAO dao = new PetDAO();
		PetBean pb = dao.findByPrimaryKey(2);
		if (pb!= null){
			DBUtils.displayData(pb);
		} else {
			System.out.println("查無此筆資料");
		}
		
	}

	
	
	
	
	
}
