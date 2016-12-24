
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class BoxMain {

	public static void main(String[] args) {
		Box b1 = new Box(20, 20, 20, 'A');
		Box b2 = new Box(40, 40, 40, 'B');
		Box b3 = new Box(30, 30, 30, 'C');
		List<Box> a = new  ArrayList<>();
		a.add(b1);a.add(b2);a.add(b3);
		Iterator it = (Iterator) a.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	
		
		

	}

}
