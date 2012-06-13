package com.ling.algorithms;

public class XiaoJiChiMi {

	/**
	 * 给一个n行m列的矩形框，每个格点都放着若干大米，小鸡从左下角点出发，只能往右或者往上走，问小鸡最多能吃掉多少大米。 
	 */
	public static void main(String[] args) {
		int[][] a = {{5,4},{1,3}};
		System.out.println(eat(a));
	}
	
	public static int eat(int[][] array) {
		int xlen = array.length;
		if(xlen==0) return -1;
		int ylen = array[0].length;		
		if(ylen==0) return -1;
		int[][] s = new int[xlen][ylen];
		
		for(int i = 0; i < xlen;i++) {
			for(int j = 0; j < ylen;j++) {
				//s[i][j] = max{ s[i][j-1] , s[j][i-1]]} + s[i][j]
				if(i==0 && j==0) {
					s[0][0] = array[0][0];
				} else 	if(i==0) {
					s[i][j] = s[i][j-1] + array[i][j];
				} else 	if(j==0) {
					s[i][j] = s[i-1][j] + array[i][j];
				} else {
					s[i][j] = (s[i][j-1] >  s[i-1][j] ? s[i][j-1] : s[i-1][j]) + array[i][j];
				}				
			}
		}
		for(int i = 0; i < xlen;i++) {
			for(int j = 0; j < ylen;j++) {
				System.out.println("i:" + i + " j:" + j + " " + s[i][j]);
			}
		}

		return s[xlen-1][ylen-1];
	}

}
