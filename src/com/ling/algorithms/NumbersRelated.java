package com.ling.algorithms;

import java.math.BigDecimal;

public class NumbersRelated {
	public static void main(String[] args) {
		int[] a = {2,3};
//		System.out.println(longestIncrease(a));
//		System.out.println(getCatalan(2));
//		System.out.println(getCatalan(3));
//		System.out.println(getCatalan(60));
//		findNumbers(15);
		
//		System.out.println(getLargestSubSum(a));
//		System.out.println(count1(1000));
		telphone(a);
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
	
	
	public static void telphone(int[] nums) {
		String[] c = {  
			" ",      //0  
		     " ",      //1  
		     "ABC",   //2  
		     "DEF",   //3  
		     "GHI",   //4  
		     "JKL",   //5  
		     "MNO",   //6  
		     "PQRS",  //7  
		     "TUV",   //8  
		     "WXYZ",  //9  
		};  
		  
		//如果number[0] = 4, answer[0] = 2   
		//c[number[0]][answer[0]] = c[4][2] = 'I';  
		int total[] = {0,0,3,3,3,3,3,4,3,4};  
		
		int n = nums.length;
		int[] result = new int[n];
		
		while(true) {			
			for(int i = 0; i < n; i ++) {
				System.out.print(""+c[nums[i]].charAt(result[i]));
			}
			System.out.println();		
			
			int k = 0;
			while(k<n) {
				if(result[k]<total[nums[k]]-1) {
					result[k] +=1;
					break;
				} else {					
					result[k]=0;
					k++;
				}
			}
			if (k==n) {
				break;
			}
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
	
	//最大字数组和
	public static int getLargestSubSum(int[] arr) {
		int sum = 0;
		int large = Integer.MIN_VALUE;
		
		for(int i=0; i < arr.length; i ++ ) {
			sum += arr[i];
			if(sum > large) {				
				large = sum;
			}
			if(sum<0) {
				sum = 0;
			}
		}
		return large ;
	}
	
	public static int count1(int n) {
		int[] prefix = new int[10];
		int[] suffix = new int[10];
		int[] digit = new int[10];
		int base = 1;
		for(int i = 0; base <= n ; base *=10,i++) {
			suffix[i] = n%base;
			digit[i] = n % (base*10)/base;
			prefix[i] = n/(base*10);
		}
		
		int count = 0;
		base = 1;
		
		for(int i = 0; base<=n ; base *=10,i++) {
			int val = digit[i];
			if(val<1) {
				count += prefix[i];
			}else if(val ==1) {
				count += prefix[i]+ 1 + suffix[i];
			} else {
				count += prefix[i]+base ;
			}				
		}		
		return count;
	}
}
