import java.util.*;

public class test 
{
	public static void main(String[]args) 
	{
		
		int v = 6;        // node/vertex size
		
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(v);
		
		for(int i=0; i<v; i++) 
		{
			adj.add(new ArrayList<Integer>());
		}
		
		// making the graph
		
		
        addEdge(adj,0, 1);
        addEdge(adj,1, 2);
        addEdge(adj,1, 4);
        addEdge(adj,4, 3);
        addEdge(adj,2, 5); 
        addEdge(adj,5, 3);
        addEdge(adj,2, 4);
        
//		printArrayList(adj);
		
		DFS(4,v,adj);
	}
	
	public static void addEdge(ArrayList<ArrayList<Integer>>adj, int u, int v) 
	{
		adj.get(u).add(v);
		adj.get(v).add(u);                           // jodi undirected graph thake tokhon sudhu ei line ta use korbo because undirected graph holo bydirectional 
	}
	
	
	public static void DFS(int starting_Node, int total_Node, ArrayList<ArrayList<Integer>> adj)
	{
		boolean visited[] = new boolean[total_Node];            // java te kuno boolean array er initial value false thake ... so visited array er shob gula te akhon false ase

		Stack<Integer> stack = new Stack<>();
		
		stack.push(starting_Node);
		
		while(!stack.isEmpty()) 
		{
			int x = stack.peek();
			stack.pop();
			
			
			if(visited[x] == false) 
			{
				System.out.print(x+" ");
				visited[x] = true;
			}
			
			
			for(int i=0; i<adj.get(x).size(); i++) 
			{
				int a = adj.get(x).get(i);
				if(!visited[a]) 
				{
					stack.push(a);
				}
			}
		}
	}
}






