package celebrities;

public class CelebrityBean {
	private String celeName , gender, path;
	private int picNum=0;
	public CelebrityBean(String celeName, String gender, String path, int picNum) {
		super();
		this.celeName = celeName;
		
		this.gender = gender;
		
		this.path = path;
		this.picNum = picNum;
	}
	public String getCeleName() {
		
		return celeName;
	}
	public String getGender() {
		
		return gender;
	}
	public String getPath() {
		return path;
	}
	public int getPicNum() {
		
		return picNum;
	}
	
	
}
