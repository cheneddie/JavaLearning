package ch09._05_Generics._01.moreComplex.copy;

public class GenDemo {
	public static void main(String[] args) throws Exception {
        Gen<Integer>  gi = new  Gen<Integer>();
        gi.addWithLimit(100);
        gi.addWithLimit(300);
        gi.addWithLimit(500);
        for(int n =0 ; n < 545; n++){
//        	gi.addWithLimit(n);
        	gi.add(n);
        }
        gi.list();
        System.out.println("------------");
        Gen<String>  gs = new  Gen<String>();
        gs.addWithLimit("Kitty");
        gs.addWithLimit("Micky");
        gs.addWithLimit("Pinky");
        gs.list();

	}
}

