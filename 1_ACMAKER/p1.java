/**
 * ACMAKER
 * @author David Lilue, 09-10444
 */
import java.util.ArrayList;

public class p1
{
	public static Integer subStrOcr(String ss, String cs)
	{
		Integer c0 = ss.length(),
				c1 = cs.length() - c0,
				i  = 0,
				r  = 0;

		while (i <= c1)
		{
			if (ss.equals(cs.substring(i, i+c0))) {	r++; }
			i++;
		}
		return r;
	}

	public static Integer fsubStrOcr(String ss, String cs, Integer p)
	{
		Integer c0 = ss.length(),
				c1 = cs.length() - c0,
				i  = p,
				r  = 0;

		while (i <= c1)
		{
			if (ss.equals(cs.substring(i, i+c0))) {	return i + c0; }
			i++;
		}
		return -1;
	}

	public static void acmaker(
		String acm,
		Integer l,
		Integer p,
		ArrayList<String> phrase,
		Integer[] matrix,
		Integer olen,
		Integer maxK,
		Integer occurrence)
	{
		Integer c0 = 1,
				v0 = 0,
				v1 = 0,
				v2 = 0;
		String tmp = null,
			   nSt = null;

		if (p == maxK)
		{
			c0 = 0;
			if (l == 0) { matrix[matrix.length-1] += 1; }
		}

		if ((l != 0) && (c0 == 1))
		{
			tmp = acm.substring(0, 1);
			v2 = fsubStrOcr(tmp, phrase.get(p),occurrence);
			while (v2 != -1)
			{
				nSt = acm.substring(1);
				//System.out.println("$~>" + nSt + " -- " + p + " -- " + l + " -- " + v2);
				acmaker(nSt, l-1, p, phrase, matrix, olen, maxK, v2);
				//System.out.println("&~>" + nSt + " -- " + (p+1) + " -- " + l + " -- " + 0);
				acmaker(nSt, l-1, p+1, phrase, matrix, olen, maxK, 0);
				v2 = fsubStrOcr(tmp, phrase.get(p),v2);
			}
		}
	}

	public static ArrayList<String> ordenedCombinations(String ac, Integer l)
	{
		Integer c0 = l-1,
				c1 = ac.length(),
				v0 = c1,
				v1 = 0,
				v2 = 0;

		String aux = null;
		ArrayList<String> res = null;

		while (v0 > c0)
		{	
			v1 += v0;
			v0--;
		}

		res = new ArrayList<String>(v1);

		v0 = c1;
		v1 = 1;

		while (v0 > c0)
		{
			for (v2 = 0; (v2 + v1) <= c1 ; v2++)
			{
				aux = ac.substring(v2, v2+v1);
				if (!res.contains(aux))
					{
						res.add(aux.toLowerCase());
					}
			}
			v1++;
			v0--;
		}

		return res;
	}

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

    public static void printArray(Integer[] arg)
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

        String[] splitArray = file.split("\n+");
        String[] acronimo   = null;

        ArrayList<String> insignif = null;
        ArrayList<String> words    = null;
        ArrayList<String> phrase   = null;

        Integer[] matrix = null;

        String s = null;
        String a = null;

        int insg = Integer.parseInt(splitArray[0]),
            p    = 1,
            i    = 0,
            l    = 0;

        while (insg != 0)
        {
            insignif = new ArrayList<String>(insg);
            i        = 0;

            while (i < insg)
            {
                insignif.add(splitArray[p++]);
                i++;
            }

            s = splitArray[p++];

            while (!s.equals("LAST CASE"))
            {
                acronimo = s.split(" ");
                a = acronimo[0];
                l = acronimo.length;
                insg = 0;
                phrase = new ArrayList<String>(l);

                for (i = 1; i < l; i++)
                {
                	if (!insignif.contains(acronimo[i]))
                	{
                		insg = Math.max(insg, acronimo[i].length());
           				phrase.add(acronimo[i].toLowerCase());
                	}
                }

                l = phrase.size();
                i = a.length();
                matrix = new Integer[i*l*insg];
                matrix[(i*l*insg)-1] = 0;
                acmaker(a.toLowerCase(), i, 0, phrase, matrix, i-1, l, 0);

                i = matrix[(i*l*insg)-1];
                if (i != 0) {
                	System.out.println(a + " can be formed in " + i + " ways");
				} else {
                	System.out.println(a + " is not a valid abbreviation");
				}
                s = splitArray[p++];
            }
            insg = Integer.parseInt(splitArray[p++]);
        }
    }
}