package com.ling.algorithms;

public class SimilarString {

	private static int distance(String a, int ab, String b, int bb) {
		if(ab>a.length()-1 ) {
			if(bb>b.length()-1) {
				return 0;	
			} else {
				return b.length()-bb;
			}
		}
		
		if(bb>b.length()-1 ) {
			if(ab>a.length()-1) {
				return 0;	
			} else {
				return a.length()-ab;
			}
		}
		
		if(a.charAt(ab)==b.charAt(bb)) {
			return distance(a,ab+1,b,bb+1);
		} else {
			int dis1 = distance(a,ab,b,bb+1);
			int dis2 = distance(a,ab+1,b,bb+1);
			int dis3 = distance(a,ab+1,b,bb);
			
			return min(min(dis1,dis2),dis3) + 1;
		}
	}
	
	private static int min(int i, int j) {
		return i<j?i:j;
	}

	public static int distance(String a, String b) {
		return distance(a,0,b,0);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(distance("abc","ab"));
		System.out.println(distance("ab","abc"));
		System.out.println(distance("abc","abd"));
	}

}
