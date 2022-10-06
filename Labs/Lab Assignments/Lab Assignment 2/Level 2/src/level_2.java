import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class level_2
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
		int position_of_Nora = sc.nextInt();
		int position_of_Lara = sc.nextInt(); 
		
		/*
		 *  we will assume Lina's position as the starting position
		 *  then we'll store the distances in the distance array
		 *  then we'll check Nora and Lara's distance from the distance array by giving their position as the index of distance array
		 */
		
		int distance[] = number_of_steps_needed(adj, positon_of_Lina, total_vertex);
		
		
		String winner = min(distance[position_of_Nora], distance[position_of_Lara]);
		
		System.out.println(winner);
	}
	
	
	private static String min(int x, int y) 
	{
		// who reached by less step is the winner
		// x -> nora
		// y -> lina
		
		if(x < y)
			return "Nora";
		else if(y < x)
			return "Lara";
		else
			return "Nora and Lara both";		
	}


	static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) 
	{
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
	
	
	/*
	 * here "position_of_Lina" is the starting position 
	 * we'll find the distance of all vertex from lina's position and then we'll compare the distance of Lara and Nora from lina's position
	 */
	
	static int[] number_of_steps_needed(ArrayList<ArrayList<Integer>> adj, int position_of_Lina, int total_vertex)               
	{
		int distance[] = new int[total_vertex];
		Arrays.fill(distance, -1);
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(position_of_Lina);
		distance[position_of_Lina] = 0;
		
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
			}
		}
		
		return distance;  
	}
}

//inputs :

//9
//12
//0 1
//0 2
//0 3
//1 3
//1 4
//2 3
//3 5
//4 8
//4 7
//5 6
//6 7
//7 8
//7
//5
//3


