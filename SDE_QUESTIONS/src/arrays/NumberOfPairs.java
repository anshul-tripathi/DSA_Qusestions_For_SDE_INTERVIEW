package arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NumberOfPairs
{
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int g = 0;g < t;g++)
		{
			String[] str = (br.readLine()).trim().split(" ");
			int M = Integer.parseInt(str[0]);
			int N = Integer.parseInt(str[1]);

			int[] x = new int[M];
			str = (br.readLine()).trim().split(" ");
			for(int i = 0;i< M;i++)
				x[i] = Integer.parseInt(str[i]);

			str = (br.readLine()).trim().split(" ");
			int[] y = new int[N];
			for(int i = 0;i< N;i++)
			{
				y[i] = Integer.parseInt(str[i]);

			}
			System.out.println(new SolutionNumberOfPairs().countPairs(x, y, M, N));

		}
	}
}

class SolutionNumberOfPairs
{

	// x[], y[]: input array elements
	// M, N: size of arrays x[] and y[] respectively
	//Function to count number of pairs such that x^y is greater than y^x.

	static int getIndex(int arr[] , int n , int x){

		int front = 0 , back = n-1 , ans=-1 ;

		while(front<=back){
			int mid = (front+back)/2;

			if(arr[mid] > x){
				ans = mid;
				back = mid-1;
			}
			else{
				front= mid+1;
			}
		}
		return ans;

	}

	static long countPairs(int x[], int y[], int m, int n)
	{

		// Brute Force Approach
		//     long count = 0;
		//     for(int i=0 ; i<m ; i++){
		//       for(int j=0 ; j<n ; j++){

		//           if(Math.pow(x[i] , y[j]) > Math.pow(y[j] , x[i]))
		//               count++;
		//       }
		//   }
		//   return count;

		int countZero=0 , countOne=0 , countTwo=0 , countThree=0 , countFour=0;
		long ans =0;
		Arrays.sort(x);
		Arrays.sort(y);

		for(int i=0 ; i<n ; i++){
			if(y[i]==0) countZero++;
			else if(y[i]==1) countOne++;
			else if(y[i]==2) countTwo++;
			else if(y[i]==3) countThree++;
			else if(y[i]==4)countFour++;
		}

		for(int i=0 ; i<m ; i++){

			int curr = x[i];

			if(curr == 0) continue;
			if(curr == 1) ans+=countZero;

			else if(curr==2){
				int index = getIndex(y,n,2);
				if(index != -1){
					ans += n-index;
				}

				ans-=countThree;
				ans-=countFour;
				ans+=countOne + countZero;
			}

			else{
				int index = getIndex(y , n , x[i]);
				if(index!=-1){
					ans+=n-index;
				}
				ans += countOne +countZero;
				if(x[i]==3){
					ans+=countTwo;
				}
			}

		}

		return ans;

	}
}
