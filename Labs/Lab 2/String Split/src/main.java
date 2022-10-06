import java.util.*;

public class main 
{
	public static void main(String [] args) 
	{
		String a = "My name is Muhtasim Mahmud";
		
		String [] result = a.split("[ ]",0);    // etar mane hocche a stirng tar moddhe jekhane space pabe tar pore theke notun line create kore dibe
		
		for(String x: result ) 
		{
			System.out.println(x);
		}
	}
}
