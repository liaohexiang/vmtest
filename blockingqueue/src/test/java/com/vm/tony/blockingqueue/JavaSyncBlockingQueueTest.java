package com.vm.tony.blockingqueue;

import java.util.concurrent.atomic.AtomicInteger;

public class JavaSyncBlockingQueueTest {

	
	public static void main(String[] args) {
		JavaSyncBlockingQueue<String> queue = new JavaSyncBlockingQueue<String>(2000);
		Putter putter1 = new Putter("putter1", queue);
		Putter putter2 = new Putter("putter2", queue);
		Putter putter3 = new Putter("putter3", queue);
		
		Taker taker1 = new Taker("taker1", queue);
		Taker taker2 = new Taker("taker2", queue);
		Taker taker3 = new Taker("taker3", queue);
		
		Thread p1 = new Thread(putter1);
		Thread p2 = new Thread(putter2);
		Thread p3 = new Thread(putter3);
		Thread t1 = new Thread(taker1);
		Thread t2 = new Thread(taker2);
		Thread t3 = new Thread(taker3);
		p1.start();
		t1.start();
		t2.start();
		p2.start();
		p3.start();
		t3.start();
	}

	public static class Putter implements Runnable {

		private static final AtomicInteger counter = new AtomicInteger(0);
		private String name;
		private JavaSyncBlockingQueue<String> queue;

		public Putter(String name, final JavaSyncBlockingQueue<String> queue) {
			this.name = name;
			this.queue = queue;
		}

		public void run() {
			while (counter.get() < 200) {
				int i = counter.incrementAndGet();
				try {
					System.out.println(name + " put: " + i);
					this.queue.put(String.valueOf(i));
				} catch (InterruptedException e) {

				}
			}
		}

	}

	public static class Taker implements Runnable {
		private static final AtomicInteger counter = new AtomicInteger(0);
		private String name;
		private JavaSyncBlockingQueue<String> queue;

		public Taker(String name, final JavaSyncBlockingQueue<String> queue) {
			this.name = name;
			this.queue = queue;
		}

		public void run() {
			int i = 0;
			while (i < 200) {
				i = counter.incrementAndGet();
				try {
					String e = this.queue.take();
					System.out.println(name +" take: " + e);
				} catch (InterruptedException e) {

				}
			}
		}

	}
}
