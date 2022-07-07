package org.swea.eclipse;

import java.util.*;

public class Solution {

	public static final int N=9;
	
	public static boolean check_row (int[][] A) {
		
		for (int i=0; i<N; i++) {
			int check[]=new int[N+1]; 
			boolean flag=true;
			for (int j=0; j<N; j++) {
				int num=A[i][j];
				if (check[num]==1) {
					flag=false;
					break;
				}
				else check[num]++;
			}
			if (!flag) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean check_square (int y, int x, int arr[][]) {
		int check[]=new int[N+1]; 
		boolean flag=true;
		
		for (int i=y; i<y+3; i++) {
			for (int j=x; j<x+3; j++){
				int num=arr[i][j];
				if (check[num]==1) {
					flag=false;
					break;
				}
				else check[num]++;
			}
			if (!flag) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean tFlag=true;
		
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		
		for (int tc=1; tc<=T; tc++) {
			int arr[][]=new int[N][N];
			int arr2[][]=new int[N][N];
			
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					arr[i][j]=sc.nextInt();
					arr2[N-j-1][i]=arr[i][j];
				}
			}
			
			if (!check_row(arr)) {
				System.out.printf("#%d 0\n", tc);
				continue;
			}
			if (!check_row(arr2)) {
				System.out.printf("#%d 0\n", tc);
				continue;
			}
			
			for (int i=0; i<N; i+=3) {
				boolean flag=true;
				for (int j=0; j<N; j+=3) {
					if (!check_square(i,j,arr)) {
						flag=false;
						break;
					}
				}
				if (!flag) {
					System.out.printf("#%d 0\n", tc);
					tFlag=false;
					break;
				}
			}
			
			if (tFlag) {System.out.printf("#%d 1\n", tc);	}
		}
	}

}
