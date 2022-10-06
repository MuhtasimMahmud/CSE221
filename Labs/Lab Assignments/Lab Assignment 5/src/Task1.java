import java.util.Scanner;

import java.io.*;
public class Task1 {
    static String [] names;

    public static int printknapsack(int w, int n, int[] weight, int[] price) {
        int k[][] = new int[n + 1][w + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (weight[i - 1] <= j)
                    k[i][j] = Math.max(k[i - 1][j], price[i - 1] + k[i - 1][j - weight[i - 1]]);
                else
                    k[i][j] = k[i - 1][j];
            }
        }
        int r=k[n][w];
        int w_=w,m=0;
        String [] tr = new String [n];
        for(int i=n; i>0 && r>0; i--){
            if(r==k[i-1][w_]){}
            else {
                tr[m] = names[i - 1];
                m++;
                r -= price[i-1];
                w_ -= weight[i-1];
            }
        }
        System.out.println("Bought Players:");
        for(int i=n-1;i>0;i--){
            if(tr[i] != null){
                 
                System.out.print(tr[i]+" -> ");
            }
        }
        System.out.println(tr[0]);

        return k[n][w];
    }


    public static void main(String[] args) 
    {
    	File file = new File("Task01.csv");
        try{
        Scanner sc=new Scanner(file);
        int w = Integer.parseInt(sc.nextLine());
        int p = Integer.parseInt(sc.nextLine());
        names= new String[p];
        int [] wt = new int [p];
        int [] val = new int [p];
        String pos[] = new String[p];

        for(int i=0;i<p;i++){
            String input=sc.nextLine();
            String [] splitInput=input.split(",");
            names[i] = splitInput[0];
            wt[i] = Integer.parseInt(splitInput[1]);
            val[i] = Integer.parseInt(splitInput[2]);
            pos[i] = splitInput[3];
            
        }
        System.out.println("Maximum Summation of form : "+printknapsack(w,p,wt,val));
        }catch(Exception e){
              
            System.out.println(e);
        }

    }
}