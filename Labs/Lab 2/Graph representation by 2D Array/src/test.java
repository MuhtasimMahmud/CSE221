import java.util.*;

/// graph representation by adjacency matrix

public class test 
{
	public static void main(String [] args) 
	{
		int v = 5;
		int arr[][] = new int[v][v];
		
		addEdge(arr,0,1);
		addEdge(arr,0,4);
		addEdge(arr,1,2);
		addEdge(arr,1,3);
		addEdge(arr,1,4);
		addEdge(arr,2,3);
		addEdge(arr,3,4);
		
		printMatrix(arr);
	}
	
	
	
	public static void addEdge(int a[][], int u, int v) 
	{
		a[u][v] = 1;
		a[v][u] = 1;
	}
	
	public static void printMatrix(int a[][]) 
	{
		for(int i=0; i<a.length; i++) 
		{
			for(int j=0; j<a[i].length; j++) 
			{
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
}
