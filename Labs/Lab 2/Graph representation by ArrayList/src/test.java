import java.util.*;

/// graph representation by adjacency list

public class test 
{
	public static void main(String[]args) 
	{
		
		int v = 5;        // node/vertex size
		
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(v);
		
		for(int i=0; i<v; i++) 
		{
			adj.add(new ArrayList<Integer>());
		}
		
		addEdge(adj, 0, 1);
		addEdge(adj, 0, 4);
		addEdge(adj, 1, 2);
		addEdge(adj, 1, 3);
		addEdge(adj, 1, 4);
		addEdge(adj, 2, 3);
		addEdge(adj, 3, 4);
		
		printArrayList(adj);
		
	}
	
	public static void addEdge(ArrayList<ArrayList<Integer>>adj, int u, int v) 
	{
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
	
	public static void printArrayList(ArrayList<ArrayList<Integer>>adj) 
	{
		for(int i=0; i<adj.size(); i++) 
		{
			System.out.print("Printing the elements connected with node "+ i +" : ");
			for(int j=0; j<adj.get(i).size(); j++) 
			{
				System.out.print(adj.get(i).get(j));
				if(j< (adj.get(i).size())-1) 
				{
					System.out.print(" -> ");
				}
			}
			System.out.println();
		}
	}
	
}
