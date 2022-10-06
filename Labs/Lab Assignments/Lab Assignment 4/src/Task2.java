import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Task2 
{
    public static void main(String[] args) throws FileNotFoundException 
    {
    	File file = new File("inputs2.txt");
        Scanner sc = new Scanner(file);
    	
        String s1 = sc.nextLine();
        s1 = s1.toLowerCase();
        s1 = s1.replaceAll(" ", "");
        String s2 = sc.nextLine();
        s2 = s2.toLowerCase();
        s2 = s2.replaceAll(" ", "");
        s1 = s1.stripTrailing();
        s2 = s2.stripTrailing();

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        LCS l1 = new LCS(c1, c2, c1.length, c2.length);
        String[] a = {"monkeys", "wearing", "coats", "are", "doctors", "because", "of", "evolution", "results", "eruption"};
        System.out.println(l1.lcs_length());
        char[] str = l1.lcs_string();

        for (int i = 0; i < str.length; i++) {
            int count = 0;
            while (count < a.length) {
                if (str[i] == a[count].charAt(0))
                    System.out.print(a[count] + " ");
                count++;
            }
        }
    }
}
