package com.ling.basic;

public class AnExtendIssue {
	
	
	static class A {
		String name = "This is A";
		
		public String getName() {
			return name;
		}
	}
	
	static class B extends A{
		String name = "This is B";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Should print This is A
		System.out.println(new B().getName());

	}

}
