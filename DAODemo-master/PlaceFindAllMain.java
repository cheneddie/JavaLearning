package ex01;

import java.util.List;
import ex01.util.DBUtils;

public class PlaceFindAllMain {

	public static void main(String[] args) {
		PlaceDAO dao = new PlaceDAO();
		List<PlaceBean> lp = dao.findAll();
		for(PlaceBean pb:lp){
			DBUtils.displayData(pb);
			System.out.println("------------------");
		}
	}

	
	
	
	
	
}
