package geometricApplications;

import java.util.Random;
import java.util.Stack;

public class TreeTesting {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(null,null,1);
		
		//Tree 1
		/*
		root.left = new TreeNode(null,null,2);
		root.left.left = new TreeNode(null,null,4);
		root.left.right = new TreeNode(null,null,5);
		
		root.right = new TreeNode(null,null,3);
		root.right.right = new TreeNode(null,null,6);
		root.right.right.left = new TreeNode(null,null,7);
		*/
		
		//Tree 2
		/*
		root  = new TreeNode(null,null,50);
		root.left =  new TreeNode(null,null,4);
		root.left.right = new TreeNode(null,null,40);
		root.left.right.left = new TreeNode(null,null,5);
		root.left.right.right = new TreeNode(null,null,46);
		
		root.right  = new TreeNode(null,null,91);
		root.right.left  = new TreeNode(null,null,81);
		root.right.left.right  = new TreeNode(null,null,86);
		root.right.left.right.left  = new TreeNode(null,null,84);
		*/
		
		//Tree 3
		/*
		root = new TreeNode(null,null,15);
		root.left = new TreeNode(null,null,6);
		root.left.right = new TreeNode(null,null,7); 
		root.left.left = new TreeNode(null,null,4); 
		root.left.left.right = new TreeNode(null,null,5);
		
		root.right = new TreeNode(null,null,50);
		root.right.left = new TreeNode(null,null,23);
		root.right.right = new TreeNode(null,null,71);
		*/
		
		
		//Tree 4
		/*
		root = new TreeNode(null,null,47);
		
		root.left = new TreeNode(null,null,17);
		root.left.right = new TreeNode(null,null,39);
		
		root.right = new TreeNode(null,null,87);
		root.right.left = new TreeNode(null,null,62);
		root.right.right = new TreeNode(null,null,95);
		*/
		
		
		//Tree 5
		/*
		root = new TreeNode(null,null,15);
		
		root.left = new TreeNode(null,null,6);
		root.left.right = new TreeNode(null,null,7);
		root.left.left = new TreeNode(null,null,4);
		root.left.left.right = new TreeNode(null,null,5);
		
		root.right = new TreeNode(null,null,23);
		root.right.right = new TreeNode(null,null,71);
		root.right.right.left = new TreeNode(null,null,50);
		*/
		
		
		
		//Tree 6
		/*
		root = new TreeNode(null,null,84);
		root.left = new TreeNode(null,null,34);
		root.left.right = new TreeNode(null,null,59);
		root.left.right.left = new TreeNode(null,null,54);
		root.left.left = new TreeNode(null,null,11);
		
		root.right = new TreeNode(null,null,96);
		root.right.left = new TreeNode(null,null,88);
		*/
		
		
		//Tree 7
		/*
		root = new TreeNode(null,null,85);
		root.left = new TreeNode(null,null,13);
		root.left.left = new TreeNode(null,null,1);
		root.left.right = new TreeNode(null,null,23);
		root.left.right.right = new TreeNode(null,null,64);
		root.left.right.right.right = new TreeNode(null,null,82);
		root.left.right.right.right.left = new TreeNode(null,null,67);
		root.left.right.left = new TreeNode(null,null,17);
		root.left.right.right.left = new TreeNode(null,null,40);
		root.left.right.right.left.right = new TreeNode(null,null,46);

		root.right = new TreeNode(null,null,86);
		*/
		
		//Tree 8
		
		/*
		root = new TreeNode(null,null,50);
		root.left = new TreeNode(null,null,29);
		root.left.left = new TreeNode(null,null,27);
		root.left.left.left = new TreeNode(null,null,1);
		root.left.right = new TreeNode(null,null,42);
		root.left.right.left = new TreeNode(null,null,38);
		root.left.right.right = new TreeNode(null,null,44);
		
		root.right = new TreeNode(null,null,66);
		root.right.left = new TreeNode(null,null,63);
		*/
		
		
		
		// Tree 9
		/*
		root = new TreeNode(null,null,1);
		
		root.right = new TreeNode(null,null,58);
		root.right.right = new TreeNode(null,null,94);
		root.right.left = new TreeNode(null,null,41);
		root.right.left.left = new TreeNode(null,null,25);
		root.right.left.right = new TreeNode(null,null,54);
		root.right.right.left = new TreeNode(null,null,71);
		*/
		
		//Tree 10
		
		root = new TreeNode(null,null,36);
		root.left = new TreeNode(null,null,19);
		root.left.left = new TreeNode(null,null,17);
		root.left.left.left = new TreeNode(null,null,8);
		
		root.right = new TreeNode(null,null,83);
		root.right.left = new TreeNode(null,null,82);
		root.right.right = new TreeNode(null,null,1);
		
		
		//travel(root);
		
		/*
		 * Balanced Binary Tree Input:
		 * [1,2,5,3,null,null,null,4,null]
		   [1,2,7,null,null,null,4,null,5]

		 * 
		 */
		
		//[[1],[2],[3,4],[5],[5],[]]
		
		
		
		
		System.out.println("Pre Order Traversal");
		preOrderTraversal(root);
		System.out.println();
		System.out.println("In Order Traversal");
		inOrderTraversal(root);
		System.out.println();
		System.out.println("Post Order Traversal");
		postOrderTraversal(root);
		
//		System.out.println();
//		System.out.println();
//		iterativeInOrderTraversal(root);
		
//		System.out.println();
//		System.out.println();
//		randomWalk(root);
		
//		int [] test = new int[] {1,2,3,4,5,6,7,8,9,10};
//		recursionExample(test, 0);
	}
	
	public static void travel(TreeNode node) {
		
		if(node == null || node.right == null || node.left == null) {
			System.out.println("END: "+ node.value);
			return;
		}
		
		
		System.out.println(node.value);
		
		if(node.right.value < node.left.value) {
			travel(node.right);
		}else {
			travel(node.left);
		}
		
	}
	
	public static void preOrderTraversal(TreeNode node) {
		
		if(node == null) {
			return;
		}
		
		if(node.right == null && node.left == null) {
			System.out.println(node.value);
			return;
		}
		
		
		
		System.out.println(node.value);
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
		
	}
	
	
	public static void inOrderTraversal(TreeNode node) {
		
//		for (StackTraceElement ste : Thread.currentThread().getStackTrace()) {
//			System.out.println(ste.getFileName());
//			System.out.println(ste.getMethodName());
//		    System.out.println(ste.getLineNumber());
//		}
		
		if(node == null) {
			return;
		}
		
		if(node.right == null && node.left == null) {
			System.out.println(node.value);
			return;
		}
		
		inOrderTraversal(node.left);
		System.out.println(node.value);
		inOrderTraversal(node.right);
		
	}
	
	public static void postOrderTraversal(TreeNode node) {
		
		if(node == null) {
			return;
		}
		
		if(node.right == null && node.left == null) {
			System.out.println(node.value);
			return;
		}
		
		postOrderTraversal(node.left);		
		postOrderTraversal(node.right);
		System.out.println(node.value);
		
	}
	
	public static void iterativeInOrderTraversal(TreeNode node) {
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		while(node != null) {
			stack.push(node);
			node = node.left;
		}
		
		while(!stack.isEmpty()) {
			TreeNode n = stack.pop();
			System.out.println(n.value);
			
			
		}

		
		
	}
	
	
	public static void recursionExample(int [] test,int indx) {
		if(indx == test.length - 1) {
			System.out.println(test[indx]);
			return;
		}
		test[indx] = test[indx] * 2;
		System.out.println(test[indx]);
		
		recursionExample(test, indx + 1);
	}
	
	public static void randomWalk(TreeNode node) {
		
		if(node == null) {
			return;
		}
		
		System.out.println(node.value);
		
		Random rand = new Random();
		int r = rand.nextInt((10 - 1) + 1) + 1;
		if(r % 2 == 0) {
			randomWalk(node.left);
		}else {
			randomWalk(node.right);
		}
		
	}

}
