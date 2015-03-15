// CI-5651
// David Lilue, 09-10444

#include <iostream>
#include <fstream>
#include <sstream>
#include <math.h>
#include <algorithm>

using namespace std;

int maxwoods(int pm, int pn, int m, int n, int dir, int ** matrix, int * mdp)
{
	int r = 0,
		d = 0,
		l = 0;
	
	if (matrix[pm][pn] != 1)
	{
		if (matrix[pm][pn] == 2)
			r = 1;

		if ((pm + 1) < m)
		{
			d = maxwoods(pm+1, pn, m, n, dir*-1, matrix, mdp);
		}
		if ((0 <= (pn + dir)) && ((pn + dir) < n))
		{
			l = maxwoods(pm, pn+dir, m, n, dir, matrix, mdp);
		}
		return r + std::max(l,d);
	}
	return r;
}

int main(int argc, char const *argv[])
{
    string input_line;
    int t = 0,
        i = 0,
        j = 0,
        k = 0,
        m = 0,
        n = 0,
        d = 1;
    char c;
    int * dp;
    int ** matrix;

    //  Don't sync C++ and C I/O
    ios_base::sync_with_stdio(false);

    if(cin) {
        getline(cin, input_line);
        std::istringstream(input_line) >> t;
    }

    while(i < t) {
        getline(cin, input_line, ' ');
        std::istringstream(input_line) >> m;
        getline(cin, input_line, '\n');
        std::istringstream(input_line) >> n;

        matrix = new int*[m];
        for (j = 0; j < m; ++j)
        	matrix[j] = new int[n];

        for(j = 0; j<m; j++)
        {
            getline(cin, input_line);
            for (k = 0; k < n; k++)
            {
                switch(input_line[k]) {
                    case 'T':
                        matrix[j][k] = 2;
                        break;
                    case '#':
                        matrix[j][k] = 1;
                        break;
                    case '0':
                        matrix[j][k] = 0;
                        break;
                    default:
                        exit(1);
                        break;
                }
            }
        }

        dp = new int[n];

        j = 0;
	    while (j < n) {
    		dp[j] = 0;
    		j++;
	    }

        cout << maxwoods(0, 0, m, n, 1, matrix, dp) << "\n";

        for (j = 0; j < m; ++j)
        	delete [] matrix[j];
        delete [] matrix;
        i++;
    }
    return 0;
}
