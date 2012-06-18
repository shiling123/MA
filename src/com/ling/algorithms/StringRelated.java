package com.ling.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StringRelated {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lcs("abcab","bcaef"));
		System.out.println(lcs("a","bcaef"));
		System.out.println(lcs("abcab","b"));
		System.out.println(lcs("abcab","ef"));
		System.out.println(lcs("abcab","ab"));
		System.out.println(lcs("ab","eabcf"));	
		
		System.out.println("-------------");
		System.out.println(lccs("abcab","bcaef"));
		System.out.println(lccs("a","bcaef"));
		System.out.println(lccs("abcab","b"));
		System.out.println(lccs("abcab","ef"));
		System.out.println(lccs("abcab","ab"));
		System.out.println(lccs("ab","eabcf"));	
	}

	//最长公共连续字串
	private static String lcs(String a, String b) {
		int len1 = a.length();
		int len2 = b.length();
		
		List<Integer> prev = null;
		
		int pos = 0;
		int maxLength=0;
		
		for(int i = 0; i < len2 ; i ++  ) {
			List<Integer> current = new ArrayList<Integer>(len2);	
			for(int j=0; j < len1 ; j ++ ) {
				if(a.charAt(j) == b.charAt(i)) {
					if(j==0) {
						current.add(j, 1 );
					} else if(prev != null && prev.get(j-1)>0) {
						current.add(j, prev.get(j-1) +1 );
					} else {
						current.add(j, 1 );
					}
					
				} else {
					current.add(j, 0);
				}
				
				if(current.get(j)>maxLength) {
					pos = j;
					maxLength = current.get(j);
				}

			}
			prev = current;
		}
				
		return a.substring(pos - maxLength +1,pos +1);
	}
	
	//最长公共非连续字串
	private static String lccs(String s1, String s2) {
		int[][] num = new int[s1.length() + 1][s2.length() + 1];
		
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					num[i][j] = num[i - 1][j - 1] + 1;
				} else {
					num[i][j] = Math.max(num[i - 1][j], num[i][j - 1]);
				}
			}
		}

		int s1position = s1.length(), s2position = s2.length();
		StringBuffer result = new StringBuffer();
		while (s1position != 0 && s2position != 0) {
			if (s1.charAt(s1position - 1) == s2.charAt(s2position - 1)) {
				result.insert(0, s1.charAt(s1position - 1));
				s1position--;
				s2position--;
			} else if (num[s1position][s2position - 1] >= num[s1position - 1][s2position]) {
				s2position--;
			} else {
				s1position--;
			}
		}
		return result.toString();		
	}

}
