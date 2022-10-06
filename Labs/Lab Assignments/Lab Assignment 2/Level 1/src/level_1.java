import java.io.File;

import java.io.FileNotFoundException;
import java.util.*;

public class level_1
{
	public static void main(String [] args) throws FileNotFoundException
	{
		File file = new File("inputs.txt");
		
		Scanner sc = new Scanner(file);
		
		int total_vertex = sc.nextInt();
		int number_of_connections = sc.nextInt();
		
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(total_vertex);
		
		for(int i=0; i<total_vertex; i++) 
		{
			adj.add(new ArrayList<Integer>());
		}
		
				
		while(number_of_connections > 0) 
		{
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			addEdge(adj, u, v);
			
			number_of_connections--;
		}
		
		int positon_of_Lina = sc.nextInt();
		
		int position_of_nora = 0;
		
		int steps = number_of_steps_needed(adj, position_of_nora, positon_of_Lina, total_vertex);
		
		System.out.println(steps);
		
	}
	
	
	static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) 
	{
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
	
	
	// here "position_of_nora" is the starting position 
	// and  "position_of_Lina" is the ending position
	
	static int number_of_steps_needed(ArrayList<ArrayList<Integer>> adj, int position_of_nora, int position_of_Lina, int total_vertex)               
	{
		
		int distance[] = new int[total_vertex];
		Arrays.fill(distance, -1);

		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(position_of_nora);
		distance[position_of_nora] = 0;
		
		
		while(!queue.isEmpty()) 
		{
			int x = queue.poll();
			
			for(int i =0; i<adj.get(x).size(); i++) 
			{
				int a = adj.get(x).get(i);
				
				if(distance[a] == -1) 
				{
					queue.add(a);
					distance[a] = distance[x]+1;
				}
				
				if(a == position_of_Lina)
					return distance[position_of_Lina];
			}
		}
		return -1;  
	}
}


// inputs :

//9
//13
//0 1
//0 2
//0 3
//1 3
//1 4
//2 3
//3 5
//3 6
//4 8
//4 7
//5 6
//6 7
//7 8
//6












