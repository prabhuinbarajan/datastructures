package stack;
public class LinkedListStack<E> implements Stack<E> {
	int stackptr = 0;
	
	class StackItem {
		E item;
		StackItem next;
	}
	StackItem head;
	public LinkedListStack() {
	}
	

	public void push(E item) {
		StackItem current = new  StackItem();
		current.item = item;
		current.next = head;
		head = current;
		stackptr++;
	}
	public E pop() {
		if(stackptr == 0) {
			throw new RuntimeException ("already at the bottom of the stack : " + stackptr);
		}
		E item = head.item;
		head = head.next;		
		stackptr--;
		return item;
	}
	public E peek() {
		if(stackptr == 0)  {
			throw new RuntimeException("already at the bottom of the stack :" + stackptr);
		}
		return head.item;
	}
	public boolean isEmpty() {
		return stackptr == 0;
	}
	public int size() {
		return stackptr;
	}

	public void reverse() {
		if(isEmpty()) {
			return;
		}
		StackItem current = head;
		StackItem prev = null;
		while(current!= null) {
			StackItem next  = current.next;
			current.next = prev;
			prev = current;
			current = next; 
		}
		head = prev;
	}

        public String toString() {
                String result = "stack size : " + size();
                if(!isEmpty()) {
			StackItem ptr = head;
			while(ptr != null) {
                                result += " " + ptr.item;
				ptr = ptr.next;
                        }
                }
                return result;
        }

}
