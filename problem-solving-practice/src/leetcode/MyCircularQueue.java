package leetcode;

import java.util.Arrays;

public class MyCircularQueue
{
	public static void main(String[] args)
	{
		MyCircularQueue m = new MyCircularQueue(2);
		m.enQueue(4);
		m.Rear();
		m.enQueue(9);
		m.deQueue();
		m.Front();
	}

	private int[] arr;
	private int front;
	private int rear;
	private int size;

	/**
	 * Initialize your data structure here. Set the size of the queue to be k.
	 */
	public MyCircularQueue(int k)
	{
		arr = new int[k];
		Arrays.fill(arr, -1);
		front = 0;
		rear = -1;
		size = 0;
	}

	/**
	 * Insert an element into the circular queue. Return true if the operation is successful.
	 */
	public boolean enQueue(int value)
	{
		if (size == arr.length)
		{
			return false;
		}
		size++;
		if (rear + 1 == arr.length)
		{
			rear = 0;
		}
		else
		{
			rear++;
		}
		arr[rear] = value;
		if (arr[front] == -1)
		{
			front = rear;
		}
		return true;
	}

	/**
	 * Delete an element from the circular queue. Return true if the operation is successful.
	 */
	public boolean deQueue()
	{
		if (size == 0)
		{
			return false;
		}
		arr[front] = -1;
		size--;
		front++;
		if (front == arr.length)
		{
			front = 0;
		}
		return true;
	}

	/**
	 * Get the front item from the queue.
	 */
	public int Front()
	{
		return arr[front];
	}

	/**
	 * Get the last item from the queue.
	 */
	public int Rear()
	{
		return arr[rear];
	}

	/**
	 * Checks whether the circular queue is empty or not.
	 */
	public boolean isEmpty()
	{
		return size == 0;
	}

	/**
	 * Checks whether the circular queue is full or not.
	 */
	public boolean isFull()
	{
		return size == arr.length;
	}
}

/**
 * Your MyCircularQueue object will be instantiated and called as such: MyCircularQueue obj = new MyCircularQueue(k); boolean param_1 =
 * obj.enQueue(value); boolean param_2 = obj.deQueue(); int param_3 = obj.Front(); int param_4 = obj.Rear(); boolean param_5 = obj.isEmpty(); boolean
 * param_6 = obj.isFull();
 */