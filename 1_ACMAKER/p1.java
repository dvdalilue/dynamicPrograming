/**
 * ACMAKER
 * @author David Lilue, 09-10444
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p1
{

	public static String convertStreamToString(java.io.InputStream is)
	{
    	java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
    	return s.hasNext() ? s.next() : "";
	}

	public static void main (String[] args)
	{
		// String to be scanned to find the pattern.
	    String file = convertStreamToString(System.in);
	    
	    String pattern = "(\\A\\d+\\s*)";

	    // Create a Pattern object
	    Pattern r = Pattern.compile(pattern);

	    // Now create matcher object.
	    Matcher m = r.matcher(file);

	    String value = "";

	    while (m.find())
	    {
	    	value = m.group(0);

	        System.out.println("Found value: " + value);

	        file = file.substring(value.length(), file.length());

	        m = r.matcher(file);
	    }
	}
}

