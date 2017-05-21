/**
 * This class provides the implementation of a Stack with push, pop, peek, isEmpty methods.
 */



package StackAndQueue;

import java.util.EmptyStackException;

/**
 * Created by Tushar.
 */

public class StackImplementation<T> {
	
	private StackNode<T> top;
	
	public static class StackNode<T>{
		
		private T data;
		private StackNode<T> next;
		
		public StackNode(T data) {
			this.data = data;
		}
	}

	//This method will remove & return the top value from the stack
	public T pop(){
		if(top == null){
			throw new EmptyStackException();
		}
		
		T item = top.data;
		top = top.next;
		return item;
	}

	//This method will push a value to the top of the stack
	public void push(T data){
		StackNode<T> t = new StackNode<>(data);
		t.next = top;
		top = t;
	}

	//This method will return the top value of the stack
	public T peek(){
		if(top == null) throw new EmptyStackException();
		return top.data;
	}

	//This method will tell if the stack is empty or not
	public boolean isEmpty() {
		return top == null;
	}

	public static void main(String[] args) {
		
		StackImplementation<Integer> obj = new StackImplementation<Integer>();
		
		obj.push(20);
		obj.push(60);
		obj.push(30);
		obj.push(40);

		System.out.println(obj.peek());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
	}
}
