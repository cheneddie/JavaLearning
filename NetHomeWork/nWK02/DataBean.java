package nWK02;

import java.io.Serializable;

public class DataBean implements Serializable{
	private int num, max, min, sum;
	private double avg;
	public DataBean(int num, int max, int min, int sum, double avg) {
		super();
		this.num = num;
		this.max = max;
		this.min = min;
		this.sum = sum;
		this.avg = avg;
	}
	public int getNum() {
		return num;
	}
	public int getMax() {
		return max;
	}
	public int getMin() {
		return min;
	}
	public int getSum() {
		return sum;
	}
	public double getAvg() {
		return avg;
	}
	
}
