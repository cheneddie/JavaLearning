package ex01;

public class PlaceDeleteMain {

	public static void main(String[] args) {
		PlaceDAO dao = new PlaceDAO();
		int n = dao.delete(3);
		if(n==1){
			System.out.println("Delete one");
		}else{
			System.out.println("Delete anyone");
		}
		System.out.println("--------------------");
		int n1 = dao.delete(300);
		if(n1==1){
			System.out.println("Delete one");
		}else{
			System.out.println("Delete anyone");
		}
	}

	
	
	
	
	
}
