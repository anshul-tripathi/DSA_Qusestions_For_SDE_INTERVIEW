package stack;

import java.util.Stack;
// Breakdown problem into the one we know 2d Matrix ---> Histogram approach
public class MaxRectangleIn2DMatrix {

	public int maxArea1D(int hist[], int n)
	{
		int left[] = nsl(hist,n);
		int right[] = nsr(hist,n);

		int max = Integer.MIN_VALUE;

		for(int i=0 ; i<n ; i++){
			int area = (right[i] - left[i] - 1) * hist[i];
			if(area > max)
				max = area;
		}
		return max;
	}


	public int[] nsl(int arr[] , int n){

		Stack<Pair> st = new Stack<Pair>();
		int ans[] = new int[arr.length];
		int sudoIndex = -1;

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

	public int[] nsr(int arr[] , int n){

		Stack<Pair> st = new Stack<Pair>();
		int ans[] = new int[arr.length];
		int sudoIndex = n;

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

	public int maxArea(int M[][], int n, int m) {   // New Addition to max area histogram
		// add code here.
		int arr[] = new int[m];

		for(int j=0 ; j<m ; j++){
			arr[j] = M[0][j];
		}

		int ans = maxArea1D(arr,m);

		for(int i=1 ; i<n ; i++){
			for(int j=0 ; j<m ; j++){

				if(M[i][j] == 0)
					arr[j] = 0;         // if lower value 0 then base of histogram is 0 hence building not possible

				else{
					arr[j] += M[i][j];
				}
			}

			ans = Math.max(ans,maxArea1D(arr,m));  // break 2d matrix to 1 d array just like histogram
		}

		return ans;
	}
}


