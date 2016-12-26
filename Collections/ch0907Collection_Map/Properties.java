package ch09._07_Map.property;

import java.util.*;
import java.util.Map.Entry;

public class PropertiesDemo {
	public static void main(String[] args) {
		Properties prop = new Properties();
		System.out.println(prop.size());
		prop.put("Key01", "含淚學Java");
		prop.put("Key02", "快樂學Java");
		prop.put("Key03", "快樂去上班");
		Enumeration<String> en = (Enumeration<String>) prop.propertyNames();
		while (en.hasMoreElements()) {
			String key = (String) en.nextElement();
			System.out.println(key + "-->" + prop.getProperty(key));
		}
		System.out.println("----------------------");
		Set<Object> set = prop.keySet();
		Iterator<Object> it = set.iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			System.out.println(key + "-->" + prop.getProperty(key));
		}
		System.out.println("----------------------");
		Collection<Object> coll = prop.values();
		Iterator<Object> it1 = coll.iterator();
		while (it1.hasNext()) {
			String value = (String) it1.next();
			System.out.println("-->" + value);
		}
		System.out.println("------------------------------");
		Set<Entry<Object, Object>> set1 = prop.entrySet();
		for(Map.Entry<Object, Object> me :set1){
			System.out.println(me.getKey() + "-->" + me.getValue());
		}
	}

}

