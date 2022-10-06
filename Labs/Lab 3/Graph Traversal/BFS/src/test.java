import java.util.*;

public class test 
{
	public static void main(String[]args) 
	{
		
		int v = 4;        // node/vertex size
		
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(v);
		
		for(int i=0; i<v; i++) 
		{
			adj.add(new ArrayList<Integer>());
		}
		
		// making the graph
		
		addEdge(adj, 0, 1);
		addEdge(adj, 0, 2);
		addEdge(adj, 2, 0);
		addEdge(adj, 1, 2);
		addEdge(adj, 2, 3);
		addEdge(adj, 3, 3);
		
//		printArrayList(adj);
		
		
		BFS(2,v,adj);
	}
	
	public static void addEdge(ArrayList<ArrayList<Integer>>adj, int u, int v) 
	{
		adj.get(u).add(v);
//		adj.get(v).add(u);                   // jodi undirected graph thake tokhon sudhu ei line ta use korbo because undirected graph holo bydirectional
	}
	
	public static void BFS(int starting_Node,int total_Nodes, ArrayList<ArrayList<Integer>>adj) 
	{
		boolean visited[] = new boolean [total_Nodes];     // java te kuno boolean array er initial value false thake ... so visited array er shob gula te akhon false ase
		
		// taking the queue to traverse the graph
		Queue<Integer> queue = new LinkedList<Integer>();
		
		// making the starting node as visited by giving true in the index of that node int  array
		visited[starting_Node] = true;
		queue.add(starting_Node);
		
		while(!queue.isEmpty()) 
		{
			int x = queue.poll();
			System.out.print(x+" ");
			
			
			for(int i=0; i< adj.get(x).size(); i++) 
			{
				int a = adj.get(x).get(i);
				
				if(!visited[a]) 
				{
					queue.add(a);
					visited[a] = true;
				}
			}
		}
	}
	
}






