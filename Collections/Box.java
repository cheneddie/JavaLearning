

public class Box implements Comparable<Box>{
	int width,height,depth;
	char code;
	public Box(int width, int height, int depth, char code) {
		super();
		this.width = width;
		this.height = height;
		this.depth = depth;
		this.code = code;
	}
	
	public double getSurfaceArea(){
		return 2 * (width * depth + height * depth + width * height);
	}
	public double getVolume(){
		return width*height*depth;
	}
	public String toString(){
		return "Code "+code+"\nSurface "+getSurfaceArea()+"\nVolume "+getVolume();
	}
	@Override
	public int compareTo(Box o){
		if(getVolume()==o.getVolume()){
			return 1;
		}else if(getVolume()>o.getVolume()){
			return 0;
		}else{
			return -1;
		}
		
	}
}
