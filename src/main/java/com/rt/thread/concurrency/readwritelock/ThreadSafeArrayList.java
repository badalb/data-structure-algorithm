package com.rt.thread.concurrency.readwritelock;

/**
 * ReadWriteLock is implemented by ReentrantReadWriteLock Class in
 * java.util.concurrent.locks package.Multiple Threads can acquire multiple read
 * Locks, but only a single Thread can acquire mutually-exclusive write Lock
 * .Other threads requesting readLocks have to wait till the write Lock is
 * released. A thread is allowed to degrade from write lock to read lock but not
 * vice-versa. Allowing a read thread to upgrade would lead to a deadlock as
 * more than one thread can try to upgrade its lock. The ReentrantReadWriteLock
 * also supports all the features of the Reentrant lock like providing fair
 * mechanism ,reentrantLocks, Condition Support (on a write Lock only), allowing
 * interruption on read as well as write Locks.
 * 
 * @author badalb
 *
 */
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadSafeArrayList<E> {
	private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

	private final Lock readLock = readWriteLock.readLock();

	private final Lock writeLock = readWriteLock.writeLock();

	private final List<E> list = new ArrayList<>();

	public void set(E o) {
		writeLock.lock();
		try {
			list.add(o);
			System.out.println("Adding element by thread" + Thread.currentThread().getName());
		} finally {
			writeLock.unlock();
		}
	}

	public E get(int i) {
		readLock.lock();
		try {
			System.out.println("Printing elements by thread" + Thread.currentThread().getName());
			return list.get(i);
		} finally {
			readLock.unlock();
		}
	}

	public static void main(String[] args) {
		ThreadSafeArrayList<String> threadSafeArrayList = new ThreadSafeArrayList<>();
		threadSafeArrayList.set("1");
		threadSafeArrayList.set("2");
		threadSafeArrayList.set("3");

		System.out.println("Printing the First Element : " + threadSafeArrayList.get(1));
	}
}
