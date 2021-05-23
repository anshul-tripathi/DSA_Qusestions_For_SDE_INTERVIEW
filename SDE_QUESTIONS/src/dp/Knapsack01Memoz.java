package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1#

public class Knapsack01Memoz {

	public static void main(String args[])throws IOException
	{
		//reading input using BufferedReader class
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

		//reading total testcases
		int t = Integer.parseInt(read.readLine());

		while(t-- > 0)
		{
			//reading number of elements and weight
			int n = Integer.parseInt(read.readLine());
			int w = Integer.parseInt(read.readLine());

			int val[] = new int[n];
			int wt[] = new int[n];

			String st[] = read.readLine().trim().split("\\s+");

			//inserting the values
			for(int i = 0; i < n; i++)
				val[i] = Integer.parseInt(st[i]);

			String s[] = read.readLine().trim().split("\\s+");

			//inserting the weigths
			for(int i = 0; i < n; i++)
				wt[i] = Integer.parseInt(s[i]);

			//calling method knapSack() of class Knapsack
			System.out.println(new SolutionKnapsack01Memoz().knapSack(w, wt, val, n));
		}
	}
}

class SolutionKnapsack01Memoz
{
	static int knapSack(int W, int wt[], int val[], int n , int t[][])
	{
		// your code here
		if(n==0 || W==0)
			return 0;

		if(t[n][W] != -1)
			return t[n][W];

		if(wt[n-1] > W){
			t[n][W] = knapSack ( W ,  wt ,  val , n-1,t);
			return t[n][W];
		}

		else{

			int pickItem = val[n-1]+ knapSack (W-wt[n-1] ,  wt , val , n-1 ,t);
			int notItem = knapSack (W , wt ,  val , n-1,t);

			t[n][W] = Math.max(pickItem,notItem);

			return t[n][W];
		}
	}

	static int knapSack(int W, int wt[], int val[], int n) {

		int t[][] = new int[1002][1002];
		for(int i=0 ; i<1002 ; i++){
			for(int j=0 ; j<1002 ; j++){
				t[i][j] = -1;
			}
		}
		return  knapSack(W,wt,val,n,t);

	}

}



