package arrays;
import java.util.Scanner;

/*Given a String S, reverse the string without reversing its individual words. Words are separated by dots.
 * Input:
S = i.like.this.program.very.much
Output: much.very.program.this.like.i
Explanation: After reversing the whole
string(not individual words), the input
string becomes
much.very.program.this.like.i
 */

public class RverseByWord {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			String s = sc.next();
			SolutionRverseByWord obj = new SolutionRverseByWord();
			System.out.println(obj.reverseWords(s));
			t--;
		}
	}
}
//} Driver Code Ends

class SolutionRverseByWord
{
	//Function to reverse words in a given string.
	String reverseWords(String S)
	{
		// code here
		int i=S.length()-1 ;  // traverse from behind as first words need to be last one
		int end = S.length() ; // mainatin end so that you can store where was the last dote
		String result = "";

		while(i>=0){

			if(S.charAt(i) == '.'){
				result = result + S.substring(i+1,end) + ".";
				end = i; // update end after each word addition
			}

			i--;
		}

		result = result + S.substring(0,end);
		// if you don'nt write this first word of orignal string wom'nt be added as it does not have dot before it satisfy if condition in the loop

		return result;

	}
}