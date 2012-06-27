package com.ling.algorithms;

import java.util.Stack;

public class StackRelated {

	/**
	 *设计包含min 函数的栈。 
    定义栈的数据结构，要求添加一个min 函数，能够得到栈的最小元素。 
    要求函数min、push 以及pop 的时间复杂度都是O(1)。 
	 */
	public static void main(String[] args) {
//		MinStack<Float> a = new MinStack<Float>();
//		a.push(1.0f);		System.out.println("min(): " + a.min()); 
//		a.push(2.0f);		System.out.println("min(): " + a.min()); 
//		a.push(4.2f);		System.out.println("min(): " + a.min()); 
//		a.push(0.5f);		System.out.println("min(): " + a.min()); 		
//		
//		MinStack<Integer> b = new MinStack<Integer>();
//		b.push(1);		System.out.println("min(): " + b.min()); 
//		b.push(2);		System.out.println("min(): " + b.min()); 
//		b.push(4);		System.out.println("min(): " + b.min()); 
//		b.push(0);		System.out.println("min(): " + b.min()); 
		int[] a = {1,2,3,4};
		int[] b= {1,3,2,4};
		System.out.println(checkOrder(a,b));
	}
	
	
	public static class MinStack<E extends Comparable< ? super E>> {
		private Stack<E> items = new Stack<E>();
		private Stack<E> mins = new Stack<E>();

		public void push (E i) {
			if(items.size() == 0) {
				mins.push(i);
			} else {				
				E m = mins.peek();
				E min =i.compareTo(m)> 0? m:i;
				mins.push(min);
			}
			items.push(i);
		}

		public E pop() {
			mins.pop();
			return items.pop();
		}
		
		public E min() {
			return mins.peek();			
		}
	}
	
	public static class TwoStackQueue<E> {
		private Stack<E> a = new Stack<E>();
		private Stack<E> b = new Stack<E>();
		
		public void inQueue(E e) {
			a.push(e);
		}
		
		public E outQueue() {
			if(b.size()==0) {
				while(!a.isEmpty()) {
					b.push(a.pop());
				}
			}
			return b.pop();
		}
	}	
	
	public static boolean checkOrder(int[] push,int [] pop) {
		if(push.length != pop.length) {
			return false;
		}		
		int len = push.length;
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		int j = 0;
		while(i<len) {
			int ori = pop[i];
			while(stack.isEmpty()||stack.peek()!=ori) {
				if(j<len) {
					stack.push(push[j]);
					j++;
				} else {
					return false;
				}
			}
			while(!stack.isEmpty()&&stack.peek()==ori){
				stack.pop();
				i ++;
			}		
		}		
		return true;
	}
}
