import java.util.Scanner;

public class Task2 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int adjMat[][] = new int[n][n];
        String b[] = new String[n];
        for (int i = 0; i < m; i++) 
        {
            int j = sc.nextInt();
            int k = sc.nextInt();
            int w = sc.nextInt();
            adjMat[j][k] = w;
        }
        int s=sc.nextInt();
        int d=sc.nextInt();
        int b1=sc.nextInt();
        int b2=sc.nextInt();
        int b3=sc.nextInt();
        int b4=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            if(i==b1||i==b2||i==b3||i==b4)
            {
                b[i]="Yellow";
            }
        }
        String [] nodeName={"Mouchak","Panthapath","Rampura","Shahbagh","Dhanmondi","Lalmatia","Badda","Hatirjheel","Nilkhet","TSC","Dhaka University","BUET"};
        Dijkstra dj=new Dijkstra(n,adjMat,b);
        dj.dijkstra_path(s,d);
        int k=d;
        int count=0;
        while (dj.parent[k]!=0)
        {
            count++;
            k=dj.parent[k];
        }
        String [] arr=new String [count+2];
        arr[0]=nodeName[d];
        arr[arr.length-1]=nodeName[s];
        k=d;
        for(int i=1;i<arr.length-1;i++)
        {
            k=dj.parent[k];
            arr[i]=nodeName[k];
        }
        for(int i=arr.length-1;i>0;i--)
        {
            System.out.print(arr[i]+ "-->");
        }
        System.out.println(arr[0]);
        System.out.println("Path Cost : "+dj.dis[d]);
    }
}
