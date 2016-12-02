package a;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EvenTree {
	
	//Tree Structure
	private static class Node<T> {
		private final List<Node<T>> childs = new ArrayList<>();
		
		private void addChildNode(Node<T> node) {
			this.childs.add(node);
		}
	}
	
	
	private static int[] decompose(Node<Integer> node) {
		
		int count = 0, edgesToRemove = 0;
		for(Node<Integer> childNode : node.childs) {
			// For each child node
			// calls current method recursively
			final int[] tmp = decompose(childNode);
			
			edgesToRemove += tmp[1];
			increments edgesToRemove by 1 
			
			if(tmp[0] % 2 == 0) {
				edgesToRemove++;
			} else {
				count += tmp[0];
			}
		}
				count++;
				return new int[]{count, edgesToRemove};
	}
	
	public static void main(String[] args) {
		final Scanner in = new Scanner(System.in);

System.out.println(“Enter the Number of nodes followed By The the number of edges and press Enter ”);
		

		final int N = in.nextInt();
		final int M = in.nextInt();
		
		
		final Node<Integer>[] treeNodes = (Node<Integer>[]) new Node[N];
System.out.println(“lets make the edges Now ”);

		for(int i = 0; i < M; i++) {
			
System.out.println(“enter the 2 vertices which will make the edge”+(i+1)+” and press enter ”);

			final int node1 = in.nextInt() - 1;
			// Gets second node of vertex
			final int node2 = in.nextInt() - 1;
			
						treeNodes[node1] = (treeNodes[node1] == null ? new Node<Integer>() : treeNodes[node1]);
			treeNodes[node2] = (treeNodes[node2] == null ? new Node<Integer>() : treeNodes[node2]);
			
			
			// add bigger node to smaller nodes
			if(node1 < node2) {
				treeNodes[node1].addChildNode(treeNodes[node2]);
			} else {
				treeNodes[node2].addChildNode(treeNodes[node1]);
			}
		}
		
  final int[] metadata = decompose(treeNodes[0]);
		
				System.out.println(“number of edges to remove to make it a even tree is ”+metadata[1]);
		
		in.close();
	}
}

