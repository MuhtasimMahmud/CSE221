import java.util.Scanner;

public class Task1 
{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m= sc.nextInt();
        int h=sc.nextInt();
        int num= sc.nextInt();
        int [] [] adjMat=new int [n] [n];
        for(int i=0;i<m;i++)
        {
            int x=sc.nextInt();
            int y= sc.nextInt();
            int c= sc.nextInt();
            adjMat[x-1][y-1]=c;
        }
        int [] sol=new int[num];
        for(int i=0;i<num;i++)
        {
            Dijkstra dijk= new Dijkstra(n,adjMat);
            int s=sc.nextInt();
            int e= sc.nextInt();
            sol[i]= dijk.dijkstra(s-1, h-1)+ dijk.dijkstra(h-1, e-1);
        }
        for(int i=0; i<num;i++)
        {
            if(sol[i]== Integer.MAX_VALUE)
                System.out.println("Be seeing ya, John");
            else
                System.out.println("Case "+(i+1)+" : "+sol[i]);
        }
    }
}