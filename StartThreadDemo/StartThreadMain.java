package StartThreadDemo;

public class StartThreadMain {

	public static void main(String[] args) {
		StartThreadDemo st1 = new StartThreadDemo('#');
		st1.start();
		StartThreadDemo st2 = new StartThreadDemo('*',15);
		st2.start();
		

	}

}
