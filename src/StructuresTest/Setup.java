package StructuresTest;

public class Setup {

	public static void main(String[] args) {
		System.out.println("Test");
		System.out.println();
		
		
		BasicStack stack = new BasicStack();
		
		stack.push("b");
		stack.push("e");
		stack.push("c");
		stack.push("a");
		stack.push("u");
		stack.push("s");
		stack.push("e");
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		ArrayStack arrayStack = new ArrayStack();
		
		arrayStack.push("b");
		arrayStack.push("e");
		arrayStack.push("c");
		arrayStack.push("a");
		arrayStack.push("u");
		arrayStack.push("s");
		arrayStack.push("e");
		
		arrayStack.push("b");
		arrayStack.push("e");
		arrayStack.push("c");
		arrayStack.push("a");
		arrayStack.push("u");
		arrayStack.push("s");
		arrayStack.push("e");
		
		System.out.println(arrayStack.pop());
		System.out.println(arrayStack.pop());
		System.out.println(arrayStack.pop());
		System.out.println(arrayStack.pop());
		System.out.println(arrayStack.pop());
		System.out.println(arrayStack.pop());
		System.out.println(arrayStack.pop());
		
	}

}
