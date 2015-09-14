package yjy.hiho;

public class PrintABC {
	
	public static int turn = 0;
	
	public static void main(String[] args){
		Object obj = new Object();
		ThreadA a = new ThreadA(obj);
		ThreadB b = new ThreadB(obj);
		ThreadC c = new ThreadC(obj);
		a.start();
		b.start();
		c.start();
	}
}

class ThreadA extends Thread{
	
	private Object key;
	
	ThreadA(Object key){
		super();
		this.key = key;
	}
	
	@Override
	public void run(){
		for(int i=0;i<10;i++){
			synchronized(key){
				while(PrintABC.turn != 0){
					try {
						key.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("A");
				PrintABC.turn = 1;
				key.notifyAll();
			}
		}
	}
}

class ThreadB extends Thread{
	
	private Object key;
	
	ThreadB(Object key){
		super();
		this.key = key;
	}
	
	@Override
	public void run(){
		for(int i=0;i<10;i++){
			synchronized(key){
				while(PrintABC.turn != 1){
					try {
						key.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("B");
				PrintABC.turn = 2;
				key.notifyAll();
			}
		}
	}
}

class ThreadC extends Thread{
	
	private Object key;
	
	ThreadC(Object key){
		super();
		this.key = key;
	}
	
	@Override
	public void run(){
		for(int i=0;i<10;i++){
			synchronized(key){
				while(PrintABC.turn != 2){
					try {
						key.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("C");
				PrintABC.turn = 0;
				key.notifyAll();
			}
		}
	}
}

