package stack;
import java.util.Stack;

public class NextGreaterElement {

	// aditya verma stack - https://practice.geeksforgeeks.org/problems/next-larger-element-1587115620/1

	//Function to find the next greater element for each element of the array.
	public static long[] nextLargerElement(long[] arr, int n)
	{
		if(n==0)
			return arr;

		long[] ans = new long[n];

		Stack<Long> st = new Stack<>();
		for(int i=n-1 , j=n-1 ; i>=0 ; i-- , j--)
		{
			if(st.size() == 0)
				ans[j] = -1;

			else if(st.size() != 0 && st.peek()>arr[i])
				ans[j] = st.peek();

			else if(st.size() !=0 && st.peek()<arr[i]){

				while(st.size() != 0 && st.peek() < arr[i]){
					st.pop();
				}

				if(st.size() == 0)
					ans[j] = -1;

				else if(st.peek() > arr[i])
					ans[j] = st.peek();
			}

			st.push(arr[i]);
		}

		return ans;
	}

}
