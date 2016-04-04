package stack;
public class StackClient {

	public static void main(String[] args) {
		//Stack<Integer> stack = new BoundedStack<Integer>(10);
		System.out.println("ref: https://en.wikipedia.org/wiki/Stack_(abstract_data_type)");
                System.out.println("reversing a stack: http://stackoverflow.com/questions/21023348/fast-algorithm-in-java-to-reverse-an-array");
                System.out.println("http://www.geeksforgeeks.org/write-a-function-to-reverse-the-nodes-of-a-linked-list/");
		Stack<Integer> stack = new LinkedListStack<Integer>();
		stack.push(1);
		stack.push(3);
		stack.push(2);
		stack.push(5);
		System.out.println(stack);
		stack.reverse();
		System.out.println("reversed : " + stack);
		stack.reverse();
		System.out.println("reversed again: " + stack);
		
		System.out.println("peek :"+ stack.peek());	
		System.out.println("pop :" + stack.pop());	
		System.out.println("pop :" + stack.pop());	
		System.out.println("pop :" + stack.pop());	
		stack.push(7);
		System.out.println("adding " + stack);
		System.out.println("pop :" + stack.pop());	
		System.out.println("pop :" + stack.pop());	
		System.out.println("pop :" + stack.pop());	
		
	}

}
