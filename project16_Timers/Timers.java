package project10;
import java.util.*;
import java.util.concurrent.*;

public class Timers implements Runnable{
private static int timers=0;
private static int tasks=0;
	
	public void run() {
	try {
		while(timers<5000) {
			++timers;
			Timer t=new Timer();
			t.schedule(new TimerTask() {
				public void run() {
					++tasks;
					if(timers%100==0)
						System.out.println("Timers: "+timers+"\n"+"Tasks: "+tasks);
				}
			}, 0);
		}try {
			TimeUnit.SECONDS.sleep(3);
		}catch(InterruptedException e) {
			System.out.println("Opps... Sleep");
		}
	}finally {
		System.out.println("Done."+timers+"Timers done "+" Tasks "+tasks);
	}
	}
public static void main(String[] args) {
	ExecutorService ex=Executors.newCachedThreadPool();
	ex.execute(new Timers());
	ex.shutdown();
}
}
