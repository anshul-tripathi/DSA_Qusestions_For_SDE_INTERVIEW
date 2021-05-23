package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class KnapSackTopDown {

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
			System.out.println(new SolutionKnapSackTopDown().knapSack(w, wt, val, n));
		}
	}
}

class SolutionKnapSackTopDown
{
	//Function to return max value that can be put in knapsack of capacity W.

	static int knapSack(int W, int wt[], int val[], int n) {

		int t[][] = new int[n+1][W+1];

		for(int i=0 ; i<=n ; i++){
			t[i][0] = 0;
		}

		for(int j=0 ; j<=W ; j++){
			t[0][j] = 0;
		}

		for(int i=1 ; i<=n ; i++){
			for(int j=1 ; j<=W ; j++){   // remeber to run till n,w not only n-1,w-1

				if(wt[i-1] <= j){
					t[i][j] = Math.max(   (val[i-1] + t[i-1][j-wt[i-1]]) , (t[i-1][j])    );   // add val , sub wt from j
				}

				else{
					t[i][j] = t[i-1][j];
				}

			}
		}

		return t[n][W];
	}

}



