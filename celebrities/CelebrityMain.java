package celebrities;

import java.io.IOException;

public class CelebrityMain {

	public static void main(String[] args) throws IOException {
		String Path1 = "http://www.space-fox.com/wallpapers/celebsm/vin-diesel/vin_diesel_1.jpg";
		String Path2 = "http://www.space-fox.com/wallpapers/celebs/penelope-cruz/penelope_cruz_1.jpg";
		String Path3 = "http://www.space-fox.com/wallpapers/celebsm/tom-cruise/tom_cruise_1.jpg";

		CelebrityDAO c = new CelebrityDAO();
		c.resetTable();
//		c.downloadToFile(arrayPath1, 9, "Female");
		c.insert(Path1, 9, "Female");
		c.insert(Path2, 64, "Male");
		c.insert(Path3, 10, "Female");
		
	}

}
