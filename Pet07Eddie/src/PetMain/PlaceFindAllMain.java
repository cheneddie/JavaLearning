package PetMain;

import java.util.List;

import PetMain.util.DBUtils;

public class PlaceFindAllMain {

	public static void main(String[] args) {
		PetDAO dao = new PetDAO();
		List<PetBean> lp = dao.findAll();
		for(PetBean pb:lp){
			DBUtils.displayData(pb);
			System.out.println("------------------");
		}
	}

	
	
	
	
	
}
