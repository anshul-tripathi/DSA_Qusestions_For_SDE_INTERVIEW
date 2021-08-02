package stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class MaximumRectangularAreaHistogram  {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
			long n = Long.parseLong(br.readLine().trim());
			String inputLine[] = br.readLine().trim().split(" ");
			long[] arr = new long[(int)n];
			for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
			MaximumRectangularAreaHistogramSolution obj = new MaximumRectangularAreaHistogramSolution();
			System.out.println(obj.getMaxArea(arr, n));
		}
	}
}

class Pair{

	public int index;
	public long value;

}

class MaximumRectangularAreaHistogramSolution // aditya verma stack
{
	//Function to find largest rectangular area possible in a given histogram.
	public static long getMaxArea(long hist[], long n)
	{
		long left[] = nsl(hist,n);
		long right[] = nsr(hist,n);

		long max = Long.MIN_VALUE;

		// for(int i=0 ; i<n ; i++){
		//   System.out.print(left[i] + " ");
		// }

		// System.out.println();

		// for(int i=0 ; i<n ; i++){
		//   System.out.print(right[i] + " ");
		// }

		for(int i=0 ; i<n ; i++){
			long area = (right[i] - left[i] - 1) * hist[i];  // right - left - 1 = width && hist [i] height
			if(area > max)
				max = area;
		}

		return max;
	}


	public static long[] nsl(long arr[] , long n){

		Stack<Pair> st = new Stack<Pair>();
		long ans[] = new long[arr.length];
		long sudoIndex = -1;

		for(int i=0 ; i<n ; i++){

			if(st.size() == 0)
				ans[i] = sudoIndex;

			else if(st.peek().value < arr[i])
				ans[i] = st.peek().index;

			else if(st.peek().value >= arr[i]){
				while(st.size() != 0 && st.peek().value >= arr[i]){
					st.pop();
				}

				if(st.size() == 0)
					ans[i] = sudoIndex;

				else if(st.peek().value < arr[i])
					ans[i] = st.peek().index;

			}

			Pair pair = new Pair();
			pair.index = i;
			pair.value = arr[i];
			st.push(pair);

		}

		return ans;
	}

	public static long[] nsr(long arr[] , long n){

		Stack<Pair> st = new Stack<Pair>();
		long ans[] = new long[arr.length];
		long sudoIndex = n;   // remeber to give sudo index as size of array

		for(int i=arr.length-1 ; i>=0 ; i--){

			if(st.size() == 0)
				ans[i] = sudoIndex;

			else if(st.peek().value < arr[i])
				ans[i] = st.peek().index;

			else if(st.peek().value >= arr[i]){
				while(st.size() != 0 && st.peek().value >= arr[i]){
					st.pop();
				}

				if(st.size() == 0)
					ans[i] = sudoIndex;

				else if(st.peek().value < arr[i])
					ans[i] = st.peek().index;

			}

			Pair pair = new Pair();
			pair.index = i;
			pair.value = arr[i];
			st.push(pair);
		}

		return ans;
	}
}




