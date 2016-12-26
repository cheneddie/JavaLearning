package ch09._06_Collection;
import java.util.*;
public class CollectionDemo {
    public static void main(String[] args) { 
       List<Object> c = new ArrayList<Object>() ;  // 此列用到泛型
       Integer i = new Integer(123) ;
       Integer j = new Integer(456) ;
       c.add(i);                // 加一個整數物件
       Cat kitty = new Cat() ;  
       Cat lucky = new Cat() ;
       c.add(kitty) ;			// 加兩個Cat物件
       c.add(lucky) ;
       c.add("abc") ;			// 加兩個String物件
       c.add("abc") ;
       // 查詢集成c是否包含物件i
       System.out.println("集成c是否包含物件i:" + c.contains(i));
       // 集成c的元素個數
       System.out.println("集成c的元素個數:" + c.size());
       // 移除集成c內的物件i
       c.remove(i) ;					
       System.out.println("集成c的元素個數:" + c.size());
       
       Collection<Integer> s = new Vector<>();
       s.add(i);
       s.add(j);
       System.out.println("集成c的元素個數:" + c.size());
       System.out.println("集成c是否完全含有集成s的元素:" + c.containsAll(s));   
       System.out.println("註解c.remove(i)後，再判斷一次");
       Object[] oa = c.toArray(); // 集成c轉換為Object陣列
       System.out.println("集成c的元素個數:" + oa.length);
       Integer[] i0 = new Integer[0];   //Integer[] i0 = new Integer[s.size()];
       // 集成s轉換為整數陣列
       Integer[] ia = s.toArray(i0);
       System.out.println("集成s的元素個數:" + ia.length);
       s.clear();
       System.out.println("清除所有元素後，集成s的元素個數:" + s.size());
    }
}    
class Cat {
}	
