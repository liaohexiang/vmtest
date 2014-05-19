package com.vm.tony.blockingqueue;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<T> {

	private final LinkedList<T> queue = new LinkedList<T>();
	private final int maxLength;
	private final AtomicInteger count = new AtomicInteger(0);
	private final ReentrantLock takeLock = new ReentrantLock();
	private final Condition notEmpty = takeLock.newCondition();
	private final ReentrantLock putLock = new ReentrantLock();
	private final Condition notFull = putLock.newCondition();

	public BlockingQueue() {
		this(Integer.MAX_VALUE);
	}

	public BlockingQueue(int maxLen) {
		this.maxLength = maxLen;
	}

	public void put(T t) throws InterruptedException {
		int c = -1;
		this.putLock.lockInterruptibly();
		try {
			while (count.get() == maxLength) {
				notFull.await();
			}
			this.queue.addLast(t);
			c = count.getAndIncrement();
			if (c + 1 < maxLength)
				notFull.signal();
		} finally {
			putLock.unlock();
		}
		if (c == 0)
			signalNotEmpty();
	}

	private void signalNotEmpty() {
		final ReentrantLock takeLock = this.takeLock;
		takeLock.lock();
		try {
			notEmpty.signal();
		} finally {
			takeLock.unlock();
		}
	}

	public T take() throws InterruptedException {
		T e;
		int c = -1;
		takeLock.lockInterruptibly();
		try {
			while (count.get() == 0) {
				notEmpty.await();
			}
			e = this.queue.getFirst();
			c = count.getAndDecrement();
			if (c > 1)
				notEmpty.signal();
		} finally {
			takeLock.unlock();
		}
		if (c == this.maxLength)
			signalNotFull();
		return e;
	}

	private void signalNotFull() {
		final ReentrantLock putLock = this.putLock;
		putLock.lock();
		try {
			notFull.signal();
		} finally {
			putLock.unlock();
		}
	}
}
