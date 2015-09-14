package yjy.hiho;

public class ProducerConsumer {
	
	public static int count = 0;
	
	public static void main(String[] args){
		Integer key = new Integer(0);
		MyProducer p0 = new MyProducer(0,key);
		MyProducer p1 = new MyProducer(1,key);
		MyConsumer c0 = new MyConsumer(2,key);
		MyConsumer c1 = new MyConsumer(3,key);
		c0.start();
		c1.start();
		p0.start();
		p1.start();
	}
}

class MyProducer extends Thread{
	
	private Object obj;
	private int id;
	
	MyProducer(int id, Integer obj){
		this.id = id;
		this.obj = obj;
	}
	
	@Override
	public void run(){
		for(int i=0;i<1000;i++){
			synchronized(this.obj){
				while(ProducerConsumer.count==100){
					try {
						this.obj.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				ProducerConsumer.count = ProducerConsumer.count + 1;
				System.out.println("Producer Thread id-"+this.id+" "+ProducerConsumer.count);
				this.obj.notify();
			}
		}
	}
}

class MyConsumer extends Thread{

	private Object obj;
	private int id;
	
	MyConsumer(int id, Integer obj){
		this.id = id;
		this.obj = obj;
	}
	
	@Override
	public void run(){
		for(int i=0;i<1000;i++){
			synchronized(this.obj){
				while(ProducerConsumer.count==0){
					try {
						this.obj.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				ProducerConsumer.count = ProducerConsumer.count - 1;
				System.out.println("Consumer Thread id-"+this.id+" "+ProducerConsumer.count);
				this.obj.notify();
			}
		}
	}
}
