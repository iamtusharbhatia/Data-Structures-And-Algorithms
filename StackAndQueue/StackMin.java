/**
 * This class provides the implementation of a Stack with push, pop, peek, isEmpty methods and a special method
 * to return minimum value of stack at any point of time.
 */

package StackAndQueue;

import java.util.EmptyStackException;

/**
 * Created by Tushar.
 */

public class StackMin<T extends Comparable<T>> {

	private StackNode<T> top;

	public static class StackNode<T extends Comparable<T>> {

		private T data;
		private T min;
		private StackNode<T> next;

		public StackNode(T data) {
			this.data = data;
			min = data;
		}
	}
	
	public T pop(){
		if(top == null){
			throw new EmptyStackException();
		}
		
		T item = top.data;
		top = top.next;
		return item;
	}
	
	public void push(T data){
		StackNode<T> t = new StackNode<>(data);
		if(top != null){ 
			t.next = top;
			int cmp = t.min.compareTo(top.min);
			if(cmp > 0){
				t.min = top.min;
			}
		}
		top = t;
	}
	
	public T peek(){
		if(top == null) throw new EmptyStackException();
		return top.data;
	}
	
	public T minimum(){
		if(top == null) throw new EmptyStackException();
		return top.min;
	}
	
	public boolean isEmpty(){
		return top == null;
	}

	public static void main(String[] args) {
		
		StackMin<Integer> obj = new StackMin<Integer>();
		
		obj.push(100);
		obj.push(20);
		obj.push(60);
		obj.push(30);
		obj.push(40);
		
		System.out.println("Min: "+ obj.minimum());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println("Min: "+ obj.minimum());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println("Min: "+ obj.minimum());
		System.out.println(obj.pop());
		
	}
}

