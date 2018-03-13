package multithreading;

public class PingPong {
	
	private static int DIM = 9;

	class Ball implements Runnable {
		
		volatile int direction = 0;
		volatile int position = 0;
		volatile boolean gone = false;
		
		public synchronized int hit() {
			if(direction == 0) {
				direction = 1;
			}
			else {
				direction *= -1;
			}
			return direction;
		}
		
		
		private synchronized int move() {
			position += direction;
			return position;
		}
		
		
		private synchronized void printBall(int current) {
			//System.out.println("position: " + current);
			System.out.print("|");
			for(int i = 0; i < current; i++) {
				System.out.print(" ");
			}
			System.out.print("o");
			for(int i = current; i < DIM; i++) {
				System.out.print(" ");
			}
			System.out.print("|");
			System.out.println();
		}

		
		@Override
		public void run() {
			do {
				printBall(move());
				try {
					Thread.sleep(100);
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			while(position <= DIM && position >= 0);
			
			if(position > DIM) {
				System.out.println("Player B did not hit: " + position );
			}
			if(position < 0) {
				System.out.println("Player A did not hit: " + position);
				
			}
			System.out.println("Loser!");
			
			direction = 0;
			gone = true;
		}

	}

	class Player extends Thread {
		
		// Player position
		int position;
		Ball ball;
		String id;
		Object lock;
		
		public Player(int position, Ball ball, Object lock) {
			this.position = position;
			this.ball = ball;
			this.lock = lock;

			if(this.position == 0) {
				id = "A";
			}
			else if(this.position == DIM) {
				id = "B";
			}
		}
		
		public void playBall() {
			
			synchronized (lock) {
			
				if(ball.position == this.position) {
						ball.hit();
						System.out.print(" " + id + " hit! ");
		
						try {
							lock.notify();
							System.out.print(" " + id + " is going to sleep... ");
							lock.wait();
							System.out.println(" "+ id + " is up...");
						} 
						catch (InterruptedException e) {
							e.printStackTrace();
						}
	//				try {
	//					Thread.sleep(2000);
	//				} 
	//				catch (InterruptedException e) {
	//					e.printStackTrace();
	//				}
				}
			}
		}
		
		@Override
		public void run() {
			while(!ball.gone) {
				playBall();
			}
			synchronized (lock) {
				lock.notifyAll();
			}
			System.out.println("\n" + id + " says bye. ");
		}
	}
	
	public void runGame() {
		Ball ball = new Ball();
		Object lock = new Object();
		Player playerA = new Player(0, ball, lock);
		Player playerB = new Player(DIM, ball, lock);

		Thread ballThread = new Thread(ball);
		ballThread.start();
		playerA.start();
		playerB.start();	
	}
	
	
	public static void main(String[] args) {
		
		PingPong pingpong = new PingPong();
		pingpong.runGame();		
	}

}
