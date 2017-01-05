package nWK03;

import java.io.Serializable;
import java.text.SimpleDateFormat;

public class Mammal implements Serializable{
	private String name;
	private long birthday;
	
	public Mammal(String name, long birthday) {
		this.name = name;
		this.birthday = birthday;
	}

	public Mammal(long birthday) {
		this.name = "無名氏";
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getBirthday() {
		
		return birthday;
	}

	public void setBirthday(long birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sdf.format(birthday);

		return getClass().getName() + "\n姓名: " + name + "\n生日: " + date;
	}
}
