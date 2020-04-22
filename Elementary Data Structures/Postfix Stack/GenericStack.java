
public class GenericStack {
	private node top;

	public GenericStack() {
		top = null;
	}

	public boolean isEmpty(){
		return (top ==null);
	}

	public void push(Object newItem){
		top = new node(newItem, top);
	} 

	public Object pop(){
		if (isEmpty()){
			System.out.println(
					"Trying to pop when stack is empty");
			return null;
		}else{
			node temp = top;
			top = top.next;
			return temp.info;
		}
	} 

	void popAll(){
		top = null;
	}
	
	public Object peek(){
		if (isEmpty()){
			System.out.println("Stack is empty");
			return null;
		}else{
			return top.info;
		}
	} 
}
