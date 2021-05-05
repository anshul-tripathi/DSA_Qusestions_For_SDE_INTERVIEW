package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class SolutionSortArray012
{

	private static void swap(int[] inputArray, int i, int j)
	{
		int temp = inputArray[i];
		inputArray[i] = inputArray[j];
		inputArray[j] = temp;
	}

	public static void sort012(int inputArray[], int n)
	{
		// code here
		int low = 0;
		int mid = 0;
		//and high to last index
		int high = inputArray.length-1;
		//Until mid doesn't cross high

		while (mid <= high)
		{
			//If an element is 0, bring it to the beginning
			if (inputArray[mid] == 0)
			{
				swap(inputArray, low, mid);
				low++;
				mid++;
			}

			//If an element is 2, send it to the end

			else if (inputArray[mid] == 2)
			{
				swap(inputArray, mid, high);
				high--;
			}

			else
			{
				mid++;
			}

		}

	}
}
public class SortArray012 {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
			int n = Integer.parseInt(br.readLine().trim());
			int arr[] = new int[n];
			String inputLine[] = br.readLine().trim().split(" ");
			for(int i=0; i<n; i++){
				arr[i] = Integer.parseInt(inputLine[i]);
			}
			SolutionSortArray012 ob=new SolutionSortArray012();
			ob.sort012(arr, n);
			StringBuffer str = new StringBuffer();
			for(int i=0; i<n; i++){
				str.append(arr[i]+" ");
			}
			System.out.println(str);
		}
	}
}
