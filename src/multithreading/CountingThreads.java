package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountingThreads {

	static class Counter {
		private int counter = 0;

		public Counter(int c) {
			this.counter = c;
		}

		public synchronized void increment() {
			counter++;
		}

		public synchronized void decrement() {
			counter--;
		}

		public synchronized int value() {
			return counter;
		}
	}

	static class CounterThread extends Thread {		

		private Counter counter;
		private int limit;

		public CounterThread(int initial, int limit) {
			this.counter = new Counter(initial);
			this.limit = limit;
		}

		public CounterThread(Counter counter, int limit) {
			this.counter = counter;
			this.limit = limit;
		}

		public void run() 
		{
			try {
				while(counter.value() <= limit) {
					System.out.println("i: " + counter.value());
					counter.increment(); 
					sleep(500);
				}
				while(counter.value() >= limit) {
					System.out.println("d: " + counter.value());
					counter.decrement();
					sleep(500);
				}
			}
			catch (InterruptedException e) {
			}
		}
	}

	public static void main(String[] args) 
	{
		// Not shared counter
//		CounterThread inc = new CounterThread(0, 100);
//		CounterThread dec = new CounterThread(100, 0);
//
//		inc.start();
//		dec.start();
		
		// Shared counter
//		Counter count = new Counter(50);
//		CounterThread inc = new CounterThread(count, 100);
//		CounterThread dec = new CounterThread(count, 0);
//
//		inc.setPriority(8);
//		dec.setPriority(2);
//		inc.start();
//		dec.start();
		
		//ThreadPool
		Counter count = new Counter(50);
		CounterThread inc = new CounterThread(count, 100);
		CounterThread dec = new CounterThread(count, 0);
		
		ExecutorService exse = Executors.newFixedThreadPool(1);
		exse.submit(inc);
		exse.submit(dec);
		
		exse.shutdown();
		
		System.out.println("All finished");
				
	}





}
