import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import com.sun.jdi.connect.spi.Connection;

public class level_4
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
		
		int mother = find_mother(adj, total_vertex);
		System.out.println("suitable first position for nora is : "+ mother);
		
	}
	
	
	static void DFS(ArrayList<ArrayList<Integer>>adj, int starting_travers_from, boolean visited[]) 
	{
		visited[starting_travers_from] = true;
		
		for(int i=0; i<adj.get(starting_travers_from).size(); i++) 
		{
			int x = adj.get(starting_travers_from).get(i);
			if(!visited[x]) 
			{
				DFS(adj,x,visited);
			}
		}
	}
	
	static int  find_mother(ArrayList<ArrayList<Integer>> adj, int total_vertex) 
	{
		boolean []visited = new boolean[total_vertex];
		
		int mother = -1;

		for(int i=0; i<total_vertex; i++) 
		{
			if(!visited[i]) 
			{
				DFS(adj,i,visited);
				mother = i;
			}
		}
		
		boolean check [] = new boolean[total_vertex];
		DFS(adj,mother,check);
		
		for(int i=0; i<check.length; i++) 
		{
			if(!check[i])
				return -1;
		}
		return mother;
	}  
	
	
	static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) 
	{
		adj.get(u).add(v);
	}
}


//inputs :

//7
//8
//0 6
//1 2
//1 5
//2 0
//2 5
//3 4
//4 2
//3 1
