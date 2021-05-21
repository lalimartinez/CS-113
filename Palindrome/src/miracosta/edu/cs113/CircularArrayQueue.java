package miracosta.edu.cs113;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class CircularArrayQueue<E> extends AbstractQueue<E> implements Queue<E> {
	private int mFront;
	private int mRear;
	private int mSize;
	private int mCapacity;
	private E[] mData;
	
	@SuppressWarnings("unchecked")
	public CircularArrayQueue() {
		mCapacity = 10;
		mSize = 0;
		mFront = 0;
		mRear = 9;
		mData = (E[]) new Object[10];
	}
	
	@SuppressWarnings("unchecked")
	public CircularArrayQueue(int capacity) {
		mCapacity = capacity;
		mData = (E[]) new Object[capacity];
		mSize = 0;
		mFront = 0;
		mRear = capacity - 1;
	}
	
	
	@Override
	public boolean offer(E e) {
		if(mCapacity == mSize)
			reaollocate();
		mRear = (mRear + 1) % mCapacity;
		mData[mRear] = e;
		mSize++;
		return true;
	}
	
	public boolean add(E e) {
		if(mCapacity == mSize)
			throw new IllegalStateException();
		return offer(e);
	}

	private void reaollocate() {
		int capacity = mCapacity * 2;
		@SuppressWarnings("unchecked")
		E[] data = (E[]) new Object[capacity];
		int j = mFront;
		for(int i = 0; i < mSize; i++) {
			data[i] = mData[j];
			j = (j + 1) % mCapacity;
		}
		mFront = 0;
		mRear = mSize - 1;
		mCapacity = capacity;
		mData = data;
		
	}

	@Override
	public E poll() {
		if(mSize == 0)
			return null;
		E temp = mData[mFront];
		mFront = (mFront + 1) % mCapacity;
		mSize--;
		return temp;
	}
	
	public E remove() {
		if(mSize == 0)
			throw new NoSuchElementException();
		return poll();
	}

	@Override
	public E peek() {
		if(mSize == 0)
			return null;
		return mData[mFront];
	}
	
	public E element() {
		if(mSize == 0)
			throw new NoSuchElementException();
		return peek();
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return mSize;
	}

}
