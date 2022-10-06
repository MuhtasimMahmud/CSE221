
import java.util.Scanner;

public class main 
{
	public static void main(String [] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		int a,n,sum,r = 0;
		
		n = sc.nextInt();
		a = n;
		sum = 0;
		
		
		while(n>0) 
		{
			r = n%10;
			sum = sum + (r*r*r);
			n = n/10;
		}
		
		if(a == sum)
			System.out.println("Armstrong Number");
		else
			System.out.println("Not an Armstrong Number");
		
	}
}




