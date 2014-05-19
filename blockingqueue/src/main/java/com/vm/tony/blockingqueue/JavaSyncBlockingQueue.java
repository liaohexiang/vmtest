package com.vm.tony.blockingqueue;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class JavaSyncBlockingQueue<T> {
	private final LinkedList<T> queue = new LinkedList<T>();
	private final int maxLength;
	private final AtomicInteger count = new AtomicInteger(0);
	private final Object takeLock = new Object();
	private final Object putLock = new Object();

	public JavaSyncBlockingQueue() {
		this(Integer.MAX_VALUE);
	}

	public JavaSyncBlockingQueue(int maxLen) {
		this.maxLength = maxLen;
	}

	public void put(T t) throws InterruptedException {
		int c = -1;
		synchronized (this.putLock) {
			while (count.get() == maxLength) {
				this.putLock.wait();
			}
			this.queue.addLast(t);
			c = count.getAndIncrement();
			if (c + 1 < maxLength)
				this.putLock.notifyAll();
			if (c == 0)
				signalNotEmpty();
		}
		
	}

	private void signalNotEmpty() {
		synchronized (this.takeLock) {
			this.takeLock.notifyAll();
		}
	}

	public T take() throws InterruptedException {
		T e;
		int c = -1;
		synchronized (this.takeLock) {
			while (count.get() == 0) {
				this.takeLock.wait();
			}
			e = this.queue.removeFirst();
			c = count.getAndDecrement();
			if (c > 1)
				this.takeLock.notifyAll();
			if (c == this.maxLength)
				signalNotFull();
		}
		return e;
	}

	private void signalNotFull() {
		synchronized (this.putLock) {
			this.putLock.notifyAll();
		}
	}
}
