package ex01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import ex01.util.DBUtils;

public class PlaceInitMain {

	public static void main(String[] args) {
		
		PlaceDAO dao = new PlaceDAO();
        dao.createTables();
        DBUtils.initPlace("PlaceData.csv", "BIG5");    
//		PlaceBean pb = dao.findByPrimaryKey(5);
//		if (pb!= null){
//			DBUtils.displayData(pb);
//		} else {
//			System.out.println("查無此筆資料");
//		}
		
	}

	
	
	
	
	
}
