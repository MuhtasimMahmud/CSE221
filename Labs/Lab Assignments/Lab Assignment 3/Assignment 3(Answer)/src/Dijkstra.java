import java.util.Comparator;

import java.util.PriorityQueue;

class Node implements Comparator<Node> 
{
    int node;
    int distance;

    public Node(int n, int d) 
    {
        node = n;
        distance = d;
    }

    public Node() 
    {
    	
    }

    public int compare(Node n1, Node n2) 
    {
        if (n1.distance < n2.distance) return -1;
        else if (n1.distance > n2.distance) return 1;
        return 0;
    }
}

public class Dijkstra 
{
    int n;
    int adjMat[][];
    int dis[];
    int parent[];
    String b[];
    PriorityQueue<Node> pq;
    public Dijkstra(int e, int a[][]) 
    {
        n = e;
        adjMat = a;
        dis = new int[n];
        parent = new int[n];
        for (int i = 0; i < n; i++) 
        {
            dis[i] = Integer.MAX_VALUE;
            parent[i] = 0;
        }
        pq = new PriorityQueue<Node>(n, new Node());
    }

    public Dijkstra(int e, int a[][], String c[]) 
    {
        n = e;
        adjMat = a;
        b=c;
        dis = new int[n];
        parent = new int[n];
        for (int i = 0; i < n; i++) 
        {
            dis[i] = Integer.MAX_VALUE;
            parent[i] = 0;
        }
        pq = new PriorityQueue<Node>(n, new Node());
    }


    public int dijkstra(int s, int d)
    {
        dis[s] = 0;
        pq.add(new Node(s, dis[s]));
        while (pq.isEmpty() != true) 
        {
            int u = pq.remove().node;
            for (int v = 0; v < n; v++) 
            {
                if (adjMat[u][v] > 0 && dis[v] > adjMat[u][v] + dis[u])
                {
                    dis[v] = adjMat[u][v] + dis[u];
                    parent[v] = u;
                    pq.add(new Node(v, dis[v]));
                }
            }
        }
        return dis[d];
    }

    public void dijkstra_path(int s, int d) 
    {
        dis[s] = 0;
        pq.add(new Node(s, dis[s]));
        while (pq.isEmpty() != true)
        {
            int u = pq.remove().node;
            if (b[u] == "Yellow") 
            {
            }
            else 
            {
                for (int v = 0; v < n; v++) 
                {
                    if (adjMat[u][v] > 0 && dis[v] > adjMat[u][v] + dis[u]) 
                    {
                        dis[v] = adjMat[u][v] + dis[u];
                        parent[v] = u;
                        pq.add(new Node(v, dis[v]));
                    }
                }
            }
        }
    }
}
