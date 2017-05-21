/**
 * This class provides the implementation of a Queue with add, remove, peek, isEmpty methods.
 */

package StackAndQueue;

import java.util.NoSuchElementException;

/**
 * Created by Tushar.
 */

public class QueueImpl<T> {
	
	public static class QueueNode<T> {
		private T data;
		private QueueNode<T> next;
		
		public QueueNode(T data) {
			this.data = data;
		}
	}
	
	private QueueNode<T> first;
	private QueueNode<T> last;
	
	public void add(T data){
		
		QueueNode<T> t = new QueueNode<T>(data);
		if(last != null){
			last.next = t;
		}
		last = t;
		
		if(first == null){
			first = last;
		}
	}
	
	public T remove(){
		if(first == null)throw new NoSuchElementException();
		
		T item = first.data;
		first = first.next;
		if(first == null){
			last = null;
		}
		return item;
	}
	
	public T peek(){
		if(first == null) throw new NoSuchElementException();
		
		T item = first.data;
		return item;
	}
	
	public boolean isEmpty() {
		return first == null;
	}

	public static void main(String[] args) {
		QueueImpl<Integer> obj = new QueueImpl<Integer>();
		obj.add(10);
		obj.add(20);
		obj.add(30);
		obj.add(40);
		obj.add(50);
		
		System.out.println(obj.remove());
		System.out.println(obj.remove());
		System.out.println(obj.remove());
		System.out.println(obj.peek());
		System.out.println(obj.isEmpty());
		System.out.println(obj.remove());
		System.out.println(obj.remove());
	}
}
