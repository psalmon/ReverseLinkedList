package reverseList;

public class reverseList {
	
	static node ll = new node();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Integer[] elements = {1, 5, 3, 2, 7, 5, 9};

			ll.add(elements);
			System.out.println("List before reverse: "); ll.printList();
			System.out.println("---------------------------");
			
			reverse(ll.getHead());
			
			System.out.println("List after reverse: "); ll.printList();
	}
	
	public static void reverse(node head){
		node curr = head;
		node second = curr.nextNode();
		node third = second.nextNode();//need a temp holder so we dont lose seconds next pointer.
		curr.nextNode().setNext(curr);//initial 2nd element needs to point to prior element. so 2->1
		curr.setNext(null);//head is last element, so set null. So 1->null
		ll.lastNode = curr;
		
		curr = third;
		
		node prior = second;
		
		while(curr != null){
			node next = curr.nextNode();
			curr.setNext(prior);
			
			prior = curr;
			curr = next;	
		}
		ll.firstNode = prior;
	}

}
