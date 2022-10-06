import java.io.File;
import java.util.Scanner;

public class main 
{
	public static void main(String[]args)throws Exception
	{
		
		File file = new File("abc.txt");
		
		Scanner sc = new Scanner(file);
		
		while(sc.hasNext())
			System.out.println(sc.nextLine());

	}
}
