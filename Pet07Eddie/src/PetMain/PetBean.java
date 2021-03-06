package PetMain;
/*
設立SQL欄位的建構子，SET；GET方法
 */
public class PetBean {
	int id;
	String petName, masterName, birthday, filename;
	double weight, price;
	byte[] picture;
	char[] comment;

	public PetBean() {
		super();
	}

	public PetBean(int id, String petName, String masterName, String birthday, double price, double weight,
			String filename, byte[] picture, char[] comment) {
		super();
		this.id = id;
		this.petName = petName;
		this.masterName = masterName;
		this.birthday = birthday;
		this.filename = filename;
		this.weight = weight;
		this.price = price;
		this.picture = picture;
		this.comment = comment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getMasterName() {
		return masterName;
	}

	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public char[] getComment() {
		return comment;
	}

	public void setComment(char[] comment) {
		this.comment = comment;
	}

}
