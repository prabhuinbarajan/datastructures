
public class BoundedStack<E> implements Stack<E> {
	private E[] arr;
	private int stackptr;
	public BoundedStack(int size) {
		arr= (E[]) new Object[size];
		stackptr = -1;
	}
	public void push(E item) {
		if(stackptr < arr.length -1 ) {
			arr[++stackptr] = item;
		} else {
			throw new RuntimeException("Stack Index size exceeded " + stackptr + ":" + arr.length);
		}
	}
	public E pop() {
		if(stackptr <  0) {
			throw new RuntimeException("stack already at the bottom " + stackptr + ":" + arr.length);
		}
		return arr[stackptr--];
	}
	public E peek() {
                if(stackptr <  0) {
                        throw new RuntimeException("stack already at the bottom " + stackptr + ":" + arr.length);
                }
		return arr[stackptr];
	}
	public int size() {
		return stackptr+1;
	}
	public boolean isEmpty() {
		return stackptr < 0;
	}
	public void reverse() {
		if(isEmpty()) {
			return;
		}
		reverseStack(0, stackptr);	
	}
	private void reverseStack(int start, int end) {
		if(start >=end)  {
			return;
		}
		E tmp = arr[start];
		arr[start] = arr[end];
		arr[end] = tmp;
		reverseStack(start+1 , end-1);
	}
        public String toString() {
                String result = "stack size : " + size();
		
                if(!isEmpty()) {
                        for(int i = stackptr; i>=0 ; i--) {
                                result += " " + arr[i];
                        }
                }
                return result;
        }
}
