package com.greatlearning.longestpathdriver;

import java.util.ArrayList;

public class Main {

	static class Node {
		   Node leftNode;
		   Node rightNode;
		   int nodeData;
		   
		   static Node NewNode(int data){
			   Node temp = new Node();
			   temp.nodeData = data;
			   temp.leftNode = null;
			   temp.rightNode = null;
			   
			   return temp;
		   }
	}
	
	public static void main(String[] args) {
		
		Node root =  Node.NewNode(100);
		root.leftNode = Node.NewNode(20);
		root.rightNode = Node.NewNode(130);
		root.leftNode.leftNode = Node.NewNode(10);
		root.leftNode.rightNode = Node.NewNode(50);
		root.rightNode.leftNode = Node.NewNode(110);
		root.rightNode.rightNode = Node.NewNode(140);
		root.leftNode.leftNode.leftNode = Node.NewNode(5);
		
		ArrayList<Integer> lognestPath = FindTheLongestPath(root);
		int size = lognestPath.size();
		
		//print the longest path
		System.out.print(lognestPath.get(size-1));
		for(int i = size-2; i>= 0; i--) {
			System.out.print(" -> "+lognestPath.get(i));
		}
	}

	
	//Function to find the LongestPath in the binary tree
	static ArrayList<Integer> FindTheLongestPath(Node root){
		
		//if root is null means there is no binary tree so return empty arraylist
		if(root == null) {
			return new ArrayList<>();
		}
		
		//Recursive call for traversing the right subtree
		ArrayList<Integer> rightArr = FindTheLongestPath(root.rightNode);
		
		//Recursive call for traversing the left subtree
		ArrayList<Integer> leftArr = FindTheLongestPath(root.leftNode);
		
		//Compare the size of two array and add current node data accordingly
		
		if(rightArr.size() < leftArr.size()) {
			leftArr.add(root.nodeData);
		}
		else {
			rightArr.add(root.nodeData);
		}
		
		//return the longest array list
		return ((leftArr.size() >= rightArr.size())? leftArr : rightArr);
	}
}
