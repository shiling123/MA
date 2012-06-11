package com.ling.algorithms;

import java.util.Collections;

public class BinSearch {
	public static void main(String[] a) {
		int [] arr = {1,2,3,4,5};

		System.out.println(find(arr,2));
		System.out.println(find2(arr,1));

		int [] arr1 = {4,5,6,7,1,2,3};
		System.out.println(findCircle(arr,2));
		System.out.println(findCircle(arr1,2));

	}
	
	public static int find(int [] array, int key) {
		int left=0;
		int right = array.length-1;
		
		while(left<=right) {
//			may change to: 
//				left + (right-left)/2
//				(left+right)<<<2
			int mid = (left+right)/2;
			int compareTo = key - array[mid];
			if(compareTo==0 ) {
				return mid;
			} else if( compareTo > 0) {//key > mid, need check in right
				left = mid +1;
			} else {
				right = mid -1;
			}
		}
		return -1;
	}
	
	public static int find2(int[] array, int key) {
		int left=0;
		int right = array.length-1;		
		return find_r(array,key,left,right);
	}

	private static int find_r(int[] array, int key, int left, int right) {
		if(left>right) { 
			return -1;
		} 
		int mid = (left+right)/2;
		int compareTo = key - array[mid];
		if(compareTo==0 ) {
			return mid;
		} else if( compareTo > 0) {//key > mid, need check in right
			left = mid +1;
			return find_r(array,key,left,right);
		} else {
			right = mid -1;
			return find_r(array,key,left,right);
		}		
	}
	
	//find a value in circle ordered array
	public static int findCircle(int [] array, int key) {
		int left=0;
		int right = array.length-1;
		
		while(left<=right) {
			int mid = (left+right)/2;
			int compareTo = key - array[mid];			
			
			if(compareTo==0 ) {
				return mid;
			}
			
			if(array[mid]<array[right]) {
				if( compareTo < 0) {
					right = mid -1;
				} else {			//key > mid, need check in right	
					if(array[right]<key) {//should in the left
						right = mid -1;
					} else {
						left = mid + 1;
					}
				}
			} else {
				if( compareTo < 0) { //key < mid,key can be in left or right					
					if(array[left]<key) {//should in the left
						right = mid +1;
					} else {
						left = mid - 1;
					}
				} else {			//key > mid, need check in right	
					left = mid + 1;
				}
			}
		}
		return -1;
	}
}
