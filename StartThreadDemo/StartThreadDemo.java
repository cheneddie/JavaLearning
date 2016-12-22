package StartThreadDemo;

public class StartThreadDemo extends Thread{
	char ch;
	int num=7;
	public void run(){
		Thread t = Thread.currentThread();
		System.out.println("T N="+t.getName());
		for(int n=0;n<num;n++){
			for(int x=0;x<n;x++){
				if(t.getName().equals("Thread-0")){
					System.out.print(ch);
				}else{
					System.err.print(ch);
				}
			}
			if(t.getName().equals("Thread-0")){
				System.out.println(ch);
			}else{
				System.err.println(ch);
			}
		}
	}
	public StartThreadDemo(char ch) {
		this.ch = ch;
	}
		
	public StartThreadDemo(char ch, int num) {
		this.ch = ch;
		this.num = num;
		
	}

	}


