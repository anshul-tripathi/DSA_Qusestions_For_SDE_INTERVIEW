package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RearrangeArrayAlternatively {
	public static void main (String[] args)throws IOException
	{

		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(read.readLine());

		while(t-- >0)
		{
			int n = Integer.parseInt(read.readLine());
			int[] temp= new int[n];

			String str[] = read.readLine().trim().split(" ");
			for(int i=0;i<n;i++)
				temp[i] = Integer.parseInt(str[i]);

			SolutionRearrangeArrayAlternatively ob = new SolutionRearrangeArrayAlternatively();
			ob.rearrange(temp, n);
			StringBuffer sb = new StringBuffer();
			for(int i =0; i < n; i++)
				sb.append(temp[i] + " ");
			System.out.println(sb);
		}
	}
}



//} Driver Code Ends


/*

Given a sorted array of positive integers.
Your task is to rearrange  the array elements alternatively
i.e first element should be max value, second should be min value,
third should be second max, fourth should be second min and so on.

Input : 1,2,3,4,5,6
Output : 6 1 5 2 4 3
 */

class SolutionRearrangeArrayAlternatively{

	public static void rearrange(int arr[], int n){

		// Space Complexity O(n) Approach using extra array

		// int result[] = new int[n];
		// for(int i=0,j = n-1,k=0 ; i<=j ; k++){

		//     if(k%2 == 0){
		//         result[k] = arr[j];
		//         j--;
		//     }

		//     else if(k%2 != 0){
		//         result[k] = arr[i];
		//         i++;
		//     }
		// }
		// for(int i=0 ; i<n ; i++){
		//     arr[i] = result[i];
		// }


		// Space Complexity O(1) Approach - Storing two values at sane pos using divsior quotient remainder formula

		int maxValue = arr[n-1] + 1;
		int maxIndex = n-1;
		int minIndex = 0;

		for(int i=0 ; i<n ; i++){

			if(i%2 == 0){
				arr[i] = arr[i] + ((arr[maxIndex] % maxValue)*maxValue);
				maxIndex--;
			}

			else if(i%2 != 0){
				arr[i] = arr[i] + ((arr[minIndex] % maxValue) * maxValue);
				minIndex++;
			}
		}

		for(int i=0 ; i<n ; i++){
			arr[i] = arr[i] / maxValue;
		}

	}

}

/*
 * Refrence Links:
 *
 * https://www.youtube.com/watch?v=ZRoVWxBngX0
 * https://www.youtube.com/watch?v=kQrezgskpho
 *
 */

