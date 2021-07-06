package linkedlist;
public class DetectAndRemoveLoop {

	public static void removeLoop(Node head){

		Node slow = head, fast = head;
		boolean loopAtHead = false;
		while(slow!=null && fast!=null && fast.next!=null){

			slow = slow.next;
			fast = fast.next.next;

			if(slow==fast){   //  Identifies one of the element in the loop
				break;
			}
		}

		if(slow == head ){ // Exception case when starting point of the list is head itself
			while(fast.next != slow){
				fast = fast.next;
			}

			fast.next = null;
		}

		else if(slow==fast){ // other conditon when we have found one of the element of loop

			slow = head;
			while(slow.next != fast.next){  // move with same pace
				slow = slow.next;
				fast = fast.next;
			}

			fast.next = null;
		}


		// https://www.youtube.com/watch?v=aIR0s1tY2Vk
	}
}
