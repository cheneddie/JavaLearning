package ch0905Generics;


public class Gen<T> {
    private T data;
    private int idx = 0;
    private int capacity = 50;
    @SuppressWarnings("unchecked")
	T[] container =  (T[])(new Object[capacity]);
    public Gen(T data){
    	this.data = data;
    }
    public Gen(){
    }
    public T getData() {
    	return data;
    }
    public void addWithLimit(T data) throws Exception{
    	if (idx >= capacity) {
    		throw new Exception("�����ƶq�W�L�̤j��:"+capacity);
    		
    	}
    	container[idx]= data;
    	idx++;
    	
    }
    public void list(){
    	for(int n = 0 ; n < idx; n++) {
    		T da = container[n];
    		System.out.println(da);
    	}
    }
    
    // ���q�ԭz�|�۰��X�R�}�C�������Ӽ�
//    T[] container =  (T[])(new Object[capacity]);
    public void add(T data){
    	container[idx]= data;
    	idx++;
    	if (idx >= capacity) {
    		capacity *= 2 ;
    		@SuppressWarnings("unchecked")
			T[] temp = (T[])(new Object[capacity]);
    		for(int n=0 ; n < container.length   ; n++){
    			temp[n] = container[n];
    		}
    		container = temp;
    	}
    }  
}
