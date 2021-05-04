package arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Given an array arr of N integers. Find the contiguous sub-array with maximum sum.
// Expected Time Complexity: O(N)
//Expected Auxiliary Space: O(1)

public class KadaneAlgorithm  {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
			//size of array
			int n = Integer.parseInt(br.readLine().trim());
			int arr[] = new int[n];
			String inputLine[] = br.readLine().trim().split(" ");


			for(int i=0; i<n; i++){
				arr[i] = Integer.parseInt(inputLine[i]);
			}

			MaxSumContigousArray obj = new MaxSumContigousArray();

			//calling maxSubarraySum() function
			System.out.println(obj.maxSubarraySum(arr, n));
		}
	}
}

class MaxSumContigousArray{

	int maxSubarraySum(int arr[], int n){

		int localMax = 0;
		int globalMax = Integer.MIN_VALUE;

		for(int i=0 ; i<n ; i++){

			localMax = Math.max(arr[i] , arr[i] + localMax);  // local max can be arr[i] or arr[i] + localmax of arr[i-1]
			if(localMax > globalMax){
				globalMax = localMax;
			}
		}

		return globalMax;

	}

}


// https://medium.com/@rsinghal757/kadanes-algorithm-dynamic-programming-how-and-why-does-it-work-3fd8849ed73d

