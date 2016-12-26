package ch09._07_Map;

import java.util.* ;
public class MapDemo  {
   public static void main(String[]   args)  {
      Map<String, Integer> m = new TreeMap<String, Integer>() ;
      m.put("129", 789) ;
      m.put("129", null) ;
      m.put("129", 654) ;
      m.put("009", 456) ;
      m.put("007", new Integer(123) )  ;
      Set<String> s = m.keySet() ;  
//      System.out.println(s);
      // case 1
      Iterator<String> it = s.iterator() ;
      while (it.hasNext()) {
    	 Object o = it.next();  // String o = it.next();  
         System.out.print("key=" +   o ) ;
         System.out.println(", value=" +   m.get(o) ) ;
      }
      System.out.println("--------------------------------") ;

      Set<Map.Entry<String, Integer>> set = m.entrySet(); 	// Case 2
      Iterator<Map.Entry<String, Integer>> it0 = set.iterator() ;
      while (it0.hasNext()) {
         Map.Entry<String, Integer> me = it0.next();
         System.out.print( "key=" + me.getKey() ) ;
         System.out.println( ", value=" + me.getValue() ) ;
      }
      System.out.println("--------------------------------") ;

      Collection<Integer> c = m.values() ;  				// case 3
      Iterator<Integer> it1 = c.iterator() ;
      while (it1.hasNext()) {
         Integer o = it1.next();
         System.out.println("value=" +   o ) ;
      }
   }
}   
