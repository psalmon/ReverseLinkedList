package reverseList;

public class node {
	
	private Object data; //what we are storing. We could use a generic implementation here instead of Object type.
	private node next; //ptr to next note
	
	static node firstNode = null;
	static node lastNode = null;
	
	public node(){	//default constructor
		this.data = null;
		this.next = null;
	}
	
	public node(Object data){
		this.data = data;
		this.next = null;
	}
	
	public Object getNode(){
		return data;
	}
	
	public void setNode(Object data){
		this.data = data;
	}
	
	public node nextNode(){
		return next;
	}
	
	public void setNext(node next){
		this.next = next;
	}
	
	public void add(Object data){
		node n = new node(data);
		
		if (firstNode == null){
			firstNode = n;
			lastNode = n;
		}else{
			lastNode.setNext(n);
			lastNode = n;
		}
	}
	
	public void add(Object [] data){
		for (int i = 0; i < data.length; i++){
			add(data[i]);
		}
	}
	
	public void remove(Object data){
		node curr = firstNode;
		
		if (curr == null){
			return;
		}
		
		//single node in list condition!
		if (data.equals(curr.getNode())){
			if (curr.nextNode() == null){
				firstNode.setNode(null);//clear the data out just to be safe (and probably aid with garbage collection?)
				firstNode = new node();//new pointer to blank node
				lastNode = firstNode;//again.
				return;
			}
			//it's the first node, but it's more than one element
			curr.setNode(null);
			curr = curr.nextNode();
			firstNode = curr;
			return;
		}
		
		//not the first node. Let's loop!
		
		while(true){
			if(curr == null){//at end of list.
				break;
			}
			
			node next = curr.nextNode();
			
			if(next != null){
				if(data.equals(next.getNode())){
					//found it!
					node nextNext = next.nextNode();
					curr.setNext(nextNext);
					
					next = null;
					break;
				}
			}
			curr = curr.nextNode();
		}//end while
	}
	
	public void remove(Object [] data){
		for(int i = 0; i < data.length; i++){
			remove(data[i]);
		}
	}
	
	public void printList(){
		node curr = firstNode;
		while (curr.nextNode() != null){
			System.out.println(curr.getNode());
			curr = curr.nextNode();
		}
		System.out.println(curr.getNode());//print last element
	}
	
	public node getHead(){
		return firstNode;
	}

}
