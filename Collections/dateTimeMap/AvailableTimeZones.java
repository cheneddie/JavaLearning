package dateTimeMap;

import java.util.TimeZone;

public class AvailableTimeZones {
	public String[] zoneShow(){
	String[] zone = TimeZone.getAvailableIDs();
	
	for(String z:zone){
		System.out.println(z);
	}
	return zone;
	}
}
