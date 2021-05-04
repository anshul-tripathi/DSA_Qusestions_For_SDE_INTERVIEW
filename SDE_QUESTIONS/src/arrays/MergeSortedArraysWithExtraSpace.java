package arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class SolutionMergeSortedArraysWithExtraSpace{

	public static int[] merge(int arr1[], int arr2[]){

		int size=arr1.length+arr2.length;
		int arr[] = new int[size];


		int i=0; // count for arr 1
		int j=0; // count for arr2
		int k=0;

		for(k=0 ; i<arr1.length && j<arr2.length ; k++)
		{
			if(arr1[i]<=arr2[j]){
				arr[k]=arr1[i];
				i++;
			}

			else if(arr1[i]>arr2[j]){
				arr[k]=arr2[j];
				j++;
			}
		}

		while(i<arr1.length)
		{
			arr[k]=arr1[i];
			i++;
			k++;
		}


		while(j<arr2.length)
		{
			arr[k]=arr2[j];
			j++;
			k++;
		}

		return arr;
	}

}


public class  MergeSortedArraysWithExtraSpace {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static int[] takeInput() throws IOException {
		int size = Integer.parseInt(br.readLine().trim());
		int[] input = new int[size];

		if (size == 0) {
			return input;
		}

		String[] strNums;
		strNums = br.readLine().split("\\s");


		for (int i = 0; i < size; ++i) {
			input[i] = Integer.parseInt(strNums[i]);
		}

		return input;
	}

	public static void printArray(int[] arr) {
		for (int element : arr) {
			System.out.print(element + " ");
		}

		System.out.println();
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		int t = Integer.parseInt(br.readLine().trim());

		while(t > 0) {

			int[] input1 = takeInput();
			int[] input2 = takeInput();
			int[] ans = SolutionMergeSortedArraysWithExtraSpace.merge(input1, input2);
			printArray(ans);

			t -= 1;
		}
	}
}