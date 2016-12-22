package ex01;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import ex01.util.DBUtils;

public class PlaceFindByPrimaryKeyMain {

	public static void main(String[] args) {
		
		PlaceDAO dao = new PlaceDAO();
		PlaceBean pb = dao.findByPrimaryKey(1);
		if (pb!= null){
			DBUtils.displayData(pb);
		} else {
			System.out.println("查無此筆資料");
		}
		
	}

	
	
	
	
	
}
