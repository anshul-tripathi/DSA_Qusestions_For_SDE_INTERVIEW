package arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Given an array of size N-1 such that it only contains distinct integers in the range of 1 to N. Find the missing element.
// Expected Time Complexity: O(N)
//Expected Auxiliary Space: O(1)

public class missingNumberInArray{
	public static void main(String[] args) throws IOException {
		BufferedReader br =
				new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine().trim());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine().trim());
			String[] str = br.readLine().trim().split(" ");
			int[] array = new int[n - 1];
			for (int i = 0; i < n - 1; i++) {
				array[i] = Integer.parseInt(str[i]);
			}
			MissNum sln = new MissNum ();
			System.out.println(sln.missingNumber(array, n));
		}
	}
}// } Driver Code Ends

class MissNum {
	int missingNumber(int array[], int n) {

		// My first approach with complexity o(nlogn)
		// Arrays.sort(array);
		// int expectedNum = 1 , i=0;
		// while(i<array.length){

		//     if(array[i] == expectedNum){
		//         i++;
		//         expectedNum++;
		//     }

		//     else if(array[i] != expectedNum){
		//         return expectedNum;
		//     }

		// }
		// return expectedNum;

		// Better approach with complexity o(n) by using sum of natural numbers

		int totalSum = n*(n+1) / 2;
		for(int i=0 ; i<n-1 ; i++){
			totalSum-=array[i];
		}

		return totalSum;
	}
}
