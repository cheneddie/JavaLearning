package ch09._07_Map.property;
import java.util.Enumeration;
import java.util.Properties;
//本程式示範如何使用使用者自定環境變數
	// MM->Run->Run Configurations->Arguments
public class SystemPropertiesDemo {
	public static void main(String[] args) {
		String value1 = System.getProperty("xyz", "Not Found");
		String value2 = System.getProperty("arg2");
		System.out.println(value1);
		System.out.println(value2);
		System.out.println("--------------");
	    Properties prop = System.getProperties();
		Enumeration<String> en  = (Enumeration<String>) prop.propertyNames();
//		Enumeration en = prop.propertyNames();
		while (en.hasMoreElements()) {
			String key = (String) en.nextElement();
			System.out.println(key + "-->" + prop.getProperty(key));
		}
		System.out.println("-------------");
		System.out.println("查詢特定的環境變數: user.dir=" +  System.getProperty("user.dir"));
		System.out.println("查詢特定的環境變數: user.dirA=" +  System.getProperty("user.dirA","無此變數"));
	}
}

