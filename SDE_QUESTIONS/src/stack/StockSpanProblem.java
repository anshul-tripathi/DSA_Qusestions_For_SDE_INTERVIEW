package stack;

import java.util.Scanner;
import java.util.Stack;


/*The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate the span of stock’s price for all n days.
The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day, for which the price of the stock on the current day is less than or equal to its price on the given day.
For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}. */


// Similar to left greatest element problem - aditya verma stack playlist

public class StockSpanProblem {

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while(t-- > 0)
		{
			int n =sc.nextInt();
			int a[] = new int[n];

			int i = 0;
			for(i = 0; i < n; i++)
				a[i] = sc.nextInt();

			Solution sol = new Solution();
			int[] s = sol.calculateSpan(a, n);

			for(i = 0; i < n; i++)
			{
				System.out.print(s[i] + " ");
			}

			System.out.println();
		}
	}
}

class Solution
{
	//Function to calculate the span of stockâ€™s price for all n days.
	public int[] calculateSpan(int price[], int n)
	{
		// Your code here
		Stack<Integer> st = new Stack<>();
		int ans[] = new int[n];

		for(int i=0 ; i<n ; i++){

			if(st.isEmpty())
				ans[i] = 1;

			else if(price[i] < price[st.peek()])
				ans[i] = i-st.peek();

			else if(price[i] >= price[st.peek()]){

				while(!st.isEmpty() && price[i] >= price[st.peek()]){
					st.pop();
				}

				if(st.isEmpty())
					ans[i] = i+1;

				else if(price[i] < price[st.peek()])
					ans[i] = i - st.peek();

			}
			st.push(i);
		}

		return ans;
	}
}