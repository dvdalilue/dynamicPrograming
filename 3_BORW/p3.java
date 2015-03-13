/**
 * ACMAKER
 * @author David Lilue, 09-10444
 */
import java.util.ArrayList;

public class p3
{
	public static String convertStreamToString(java.io.InputStream is)
    {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    public static void printArray(ArrayList<String> arg)
    {
    	Integer t = 0;

    	System.out.println("palabras: ");

    	while (t < arg.size())
    	{
    		System.out.println(arg.get(t));
    		t++;
    	}
    }

    public static void printArray(String[] arg)
    {
    	Integer t = 0;

    	System.out.println("palabras: ");

    	while (t < arg.length)
    	{
    		System.out.println(arg[t]);
    		t++;
    	}
    }

	public static void main (String[] args)
	{
        // String of the input.
		String file = convertStreamToString(System.in);

		String[] splitArray = file.split("\n+"),
				 splitLine  = null;

		Integer[] dp = null,
				  nm = null;

		String s = null;

		Integer l = Integer.parseInt(splitArray[0]),
				i = 1;

		while (l != -1)
		{
			splitLine = splitArray[i++].split(" ");
			printArray(splitLine);
			l = Integer.parseInt(splitArray[i++]);
		}
	}
}