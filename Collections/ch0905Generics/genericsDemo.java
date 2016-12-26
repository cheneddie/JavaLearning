package ch09._05_Generics._04._03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import ch09._05_Generics._01.Cat;

public class WildcardDemo {
	public void printCollectionGen(Collection<Object> c) {
		for (Object e : c) {
			System.out.println(e);
		}
	}
	
	public void printCollectionWild(Collection<?> c) {
		for (Object e : c) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		Collection<Object> c1 = new ArrayList<Object>();
		Collection<Number> c2 = new ArrayList<Number>();
		Collection<Cat> c3 = new ArrayList<>();
		WildcardDemo wd = new WildcardDemo();
		wd.printCollectionGen(c1);
		// wd.printCollectionGen(c2); // NG
		wd.printCollectionWild(c1);
		wd.printCollectionWild(c2);
		wd.printCollectionWild(c3);
	}

}
