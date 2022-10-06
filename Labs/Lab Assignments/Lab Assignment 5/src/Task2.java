import java.util.*;

import java.io.*;
public class Task2 {
    static String [] names;

    public static float printknapsack(int w, int n, int[] weight, float[] price) {
        float k[][] = new float[n + 1][w + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (weight[i - 1] <= j)
                    k[i][j] = Math.max(k[i - 1][j], price[i - 1] + k[i - 1][j - weight[i - 1]]);
                else
                    k[i][j] = k[i - 1][j];
            }
        }
        float r=k[n][w];
        int w_=w,m=0;
        String [] tr = new String [n];
        for(int i=n; i>0 && r>1; i--){
            if(r==k[i-1][w_]){}
            else {
                tr[m] = names[i - 1];
                m++;
                r -= price[i-1];
                w_ -= weight[i-1];
            }
        }
        System.out.println("Name of the clubs whose trophies were sold:");
        for(int i=n-1;i>0;i--){
            if(tr[i] != null){
                System.out.print(tr[i]+" -> ");
            }
        }
        System.out.println(tr[0]);

        return k[n][w];
    }


    public static void main(String[] args) {
    	File file = new File("Task2.csv");
        try{
        Scanner sc = new Scanner(file);
        int capacity = Integer.parseInt(sc.nextLine());
        int n = Integer.parseInt(sc.nextLine());
        int[] weight = new int[n];
        float[] price = new float[n];
        String tr[] = new String[n];
        names = new String[n];
        for (int i = 0; i < n; i++) {
            String input=sc.nextLine();
            String [] splitInput=input.split(",");
            names[i] = splitInput[0];
            weight[i] = Integer.parseInt(splitInput[1]);
            price[i] = Float.parseFloat(splitInput[2]);
            tr[i] = splitInput[3];
        }
        float profit = printknapsack(capacity, n, weight, price);
        System.out.println("Maximum money he earned: "+profit+" million");
        }catch(Exception e){
            System.out.println(e);
        }
    }
}