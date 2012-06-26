package com.ling.algorithms;

import java.util.Collections;

public class DuplicateNumbers {

	/**
	 * find duplicate number N+M , number range in (1,2,...,N)
	 * time: O(N), space 0(1)
	 */
	public static void main(String[] args) {
		int[] a = {1,2,3,5,1,2,3,4,5,6};
		find(a,6);
	}
		
	public static void find(int[] array, int n) {
		if(array.length<2) {
			return;
		}
		
		int tail = array.length-1;
		int lastPos = n - 1;
		
		for(int i = 0; i < lastPos; ){
			//take one 
			int value = array[i];
			//continue if value equals
			if(value == i + 1) {
				i ++;
				continue;
			} else {
				//try move value to array[value], e.g. 3 to a[2]
				//need use the last M space to store the conflict numbers
				
				//conflict situation, can't put the value to 
				if(array[value -1 ] == value) {					
					if(tail > lastPos) {    //has enough extra space
						//swap with the tail one, and move tail pos 
						array[i] =array[tail];
						array[tail] = value;
						tail --;
						continue;
					} else{					//has no enough extra space
						//do nothing,and next i
						i++;
					}
				}
				// non conflict situation, just swap
				else {
					array[i] = array[value-1];
					array[value -1 ] = value;					
				}
			}
		}
		
		for(int i = 0; i < array.length; i++) {
			if(i+1!=array[i]) {
				System.out.print(array[i]);
			}
		}
	}
}
