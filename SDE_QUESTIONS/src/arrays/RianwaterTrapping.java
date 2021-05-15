package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Given an array arr[] of N non-negative integers representing the height of blocks. If width of each block is 1, compute how much water can be trapped between the blocks during the rainy season.
// https://www.youtube.com/watch?v=m18Hntz4go8
public class RianwaterTrapping {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){

			int n = Integer.parseInt(br.readLine().trim());
			int arr[] = new int[n];
			String inputLine[] = br.readLine().trim().split(" ");

			for(int i=0; i<n; i++){
				arr[i] = Integer.parseInt(inputLine[i]);
			}

			SolutionRianwaterTrapping  obj = new SolutionRianwaterTrapping ();

			System.out.println(obj.trappingWater(arr, n));
		}
	}
}

class SolutionRianwaterTrapping {

	// arr: input array
	// n: size of array
	// Function to find the trapped water between the blocks.
	static int trappingWater(int arr[], int n) {

		// Your code here
		int leftMax = 0 , rightMax = 0;
		int l = 0 , r = n-1;
		int ans = 0;

		while(l<r){

			if(arr[l] <= arr[r]){ // we want which one right or left pillar is the smaller one

				if(arr[l] >= leftMax)
					leftMax = arr[l];

				else
					ans += leftMax - arr[l];

				l++;
			}

			else{

				if(arr[r] >= rightMax)
					rightMax = arr[r];

				else
					ans += rightMax - arr[r];

				r--;
			}

		}

		return ans;
	}
}


