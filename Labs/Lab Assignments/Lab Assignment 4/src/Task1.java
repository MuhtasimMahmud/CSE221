import java.io.File;

import java.io.FileNotFoundException;
import java.util.*;

public class Task1 
{
    public static void main(String[] args) throws FileNotFoundException 
    {
    	File file = new File("inputs1.txt");
        Scanner sc = new Scanner(file);

        String s1=sc.nextLine();
        s1 = s1.replaceAll(" ", "");
        s1=s1.stripTrailing();
        String s2=sc.nextLine();
        s2 = s2.replaceAll(" ", "");
        char [] c1=s1.toCharArray();
        char [] c2=s2.toCharArray();
        LCS l1=new LCS(c1,c2,c1.length,c2.length);
        int length=l1.lcs_length();

        char [] lcs=l1.lcs_string();


        for(int i=0;i<lcs.length;i++){
            System.out.print(lcs[i]);
        }
        System.out.println();
        int x=length*100/c1.length;

        System.out.println(x+"% PASSED ");
    }
}
