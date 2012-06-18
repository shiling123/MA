package com.ling.algorithms;

import java.math.BigDecimal;

public class NumbersRelated {
	public static void main(String[] args) {
//		int[] a = {1,4,5,2,3,2,4};
//		System.out.println(longestIncrease(a));
//		System.out.println(getCatalan(2));
//		System.out.println(getCatalan(3));
//		System.out.println(getCatalan(60));
		findNumbers(15);
	}
	
	public static int longestIncrease(int[]arr) {
		int[] s = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			s[i]=1;
			for(int j=0; j<i ; j++) {
				if(arr[i]>arr[j] && (s[j]+1) > s[i]) {
					s[i] = s[j]+1;
				}
			}
		}
		
		int max=1;
		for(int i : s) {
			if(i>max) {
				max=i;
			}
		}
	
		return max;
	}
	
	public static BigDecimal getCatalan(int n ) {
		BigDecimal catalan = new BigDecimal(1);
		for(int i = 1; i <= n ; i++) {
			catalan = catalan.multiply(new BigDecimal(2 * ( 2 * i -1 ))).divide(new BigDecimal(i+1),1,BigDecimal.ROUND_HALF_EVEN);
		}
		return catalan;
	}
	
	
	public void telphone(String nums) {
		int n = nums.length();
		
		while(n>0) {
			
		}
	}
	
	//输入一个正数n，输出所有和为n连续正数序列。
	public static void findNumbers(int n) {
		int small=1;
		int big = 2;		
		int sum = 3;
		
		while(small<n/2+1) {						
			while(sum > n){
				sum -= small;
				small ++;	
				if(sum==n) {
					printNumbersBetween(small,big);
				} 
			}  
			big++;
			sum +=  big;
			if(sum==n) {
				printNumbersBetween(small,big);
			} 
		}
	}

	private static void printNumbersBetween(int small, int big) {
		for(int i = small; i< big ; i ++) {
			System.out.print(i+",");
		}	
		System.out.println(big);

	}
}
