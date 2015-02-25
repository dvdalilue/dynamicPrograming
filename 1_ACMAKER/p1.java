/**
 * ACMAKER
 * @author David Lilue, 09-10444
 */

public class p1
{
    public static String convertStreamToString(java.io.InputStream is)
    {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    public static void main (String[] args)
    {
        // String of the input.
        String file = convertStreamToString(System.in);
        // int    len  = file.length();

        String[] splitArray = file.split("\n+");

        String s = "";
        int insg = Integer.parseInt(splitArray[0]),
            p    = 1,
            i    = 0;

        while (insg != 0)
        {
            System.out.println("Palabras insignificantes:");

            while (i < insg)
            {
                System.out.println("--> " + splitArray[p++]);
                i++;
            }

            i = 0;
            s = splitArray[p++];

            while (!s.equals("LAST CASE"))
            {
                System.out.println("Acronino: " + s);

                s = splitArray[p++];
            }

            insg = Integer.parseInt(splitArray[p++]);
        }
    }
}

