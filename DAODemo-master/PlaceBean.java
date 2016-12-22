package ex01;

import java.io.Serializable;

public class PlaceBean implements Serializable {
	  int placeId; 	
	  int typeId; 		
	  String name; 		
	  String phone; 		
	  String address; 	
	  double longitude; 	
	  double latitude; 	
	  String link; 		
	  String filename;
	  byte[] picture; 	
	  char[] comment; 	
	
	
    public PlaceBean(int placeId, int typeId, String name, String phone, String address, double longitude,
			double latitude, String link, String filename, byte[] picture, char[] comment) {
		super();
		this.placeId = placeId;
		this.typeId = typeId;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.longitude = longitude;
		this.latitude = latitude;
		this.link = link;
		this.filename = filename;
		this.picture = picture;
		this.comment = comment;
	}


	public PlaceBean(){
    	
    }


	public String getFilename() {
		return filename;
	}


	public void setFilename(String filename) {
		this.filename = filename;
	}


	public int getPlaceId() {
		return placeId;
	}


	public void setPlaceId(int placeId) {
		this.placeId = placeId;
	}


	public int getTypeId() {
		return typeId;
	}


	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public double getLongitude() {
		return longitude;
	}


	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	public double getLatitude() {
		return latitude;
	}


	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	public String getLink() {
		return link;
	}


	public void setLink(String link) {
		this.link = link;
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
