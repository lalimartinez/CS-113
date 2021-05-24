package edu.miracosta.cs113;

import java.io.Serializable;
import java.util.Scanner;

public class BinaryTree<E> implements Serializable{
	protected Node<E> mRoot;
	
	public BinaryTree() {
		mRoot = null;
	}
	
	protected BinaryTree(Node<E> root) {
		mRoot = root;
	}
	
	public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
		mRoot = new Node<E>(data);
		if(leftTree != null) 
			mRoot.mLeft = leftTree.mRoot;
		else
			mRoot.mLeft = null;
		
		if(rightTree != null)
			mRoot.mRight = rightTree.mRoot;
		else
			mRoot.mRight = null;
	}
	
	public BinaryTree<E> getLeftSubtree() {
		if(mRoot != null && mRoot.mLeft != null)
			return new BinaryTree<E>(mRoot.mLeft);
		else
			return null;
	}
	
	public BinaryTree<E> getRightSubtree() {
		if(mRoot != null && mRoot.mRight != null) 
			return new BinaryTree<E>(mRoot.mRight);
		else
			return null;
	}
	
	public E getData() {
		return mRoot.mData;
	}
	
	public boolean isLeaf() {
		return mRoot.mLeft == null && mRoot.mRight == null;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		preOrderTraverse(mRoot, 1, sb);
		return sb.toString();
	}
	
	private void preOrderTraverse(Node<E> node, int depth, StringBuilder sb) {
		for(int i = 1; i < depth; i++)
			sb.append(" ");
		
		if(node == null)
			sb.append("null\n");
		else {
			sb.append(node.toString());
			sb.append("\n");
			preOrderTraverse(node.mLeft, depth + 1, sb);
			preOrderTraverse(node.mRight, depth + 1, sb);
		}
	}
	
	public static BinaryTree<String> readBinaryTree(Scanner scan) {
		String data = scan.next();
		if(data.equals("null"))
			return null;
		else {
			BinaryTree<String> leftTree = readBinaryTree(scan);
			BinaryTree<String> rightTree = readBinaryTree(scan);
			return new BinaryTree<String>(data, leftTree, rightTree);
		}
	}
	
	
	protected static class Node<E> implements Serializable {
		protected E mData;
		protected Node<E> mLeft;
		protected Node<E> mRight;
		
		public Node(E data) {
			mData = data;
			mLeft = null;
			mRight = null;
		}
		
		public Node(E data, Node<E> left, Node<E> right) {
			mData = data;
			mLeft = left;
			mRight = right;
		}
		
		public String toString() {
			return mData.toString();
		}
	}

}
