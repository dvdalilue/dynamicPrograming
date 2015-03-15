// CI-5651
// David Lilue, 09-10444

#include <iostream>
#include <fstream>
#include <sstream>
#include <math.h>
#include <algorithm>

using namespace std;

int bow(int lb, int lw, int p, int l, int * a)
{
    bool inB = false,
         inW = false;

    if (p < l)
    {
        if (a[lb] < a[p])
        {
            cout << "entro ";
            inB = true;
        } 
        if (a[lw] > a[p])
        {
            cout << ". tambien ";
            inW = true;
        }

        if (inB && inW) {
            cout << ". ambos\n";
            return std::min(bow(p, lw, p+1, l, a), bow(lb, p, p+1, l, a));
        }
        else if (inB)
        {
            cout << ". negro\n";
            return bow(p, lw, p+1, l, a);
        }
        else if (inW)
        {
            cout << ". blanco\n";
            return bow(lb, p, p+1, l, a);
        }
        else
        {
            cout << ". scolor\n";
            return 1 + bow(lb, lw, p+1, l, a);
        }
    }
    return 0;
}

int main(int argc, char const *argv[])
{
    string input_line;
    int i = 0,
        t = 0,
        mx = 0,
        b  = 0,
        w  = 0;
    int *** dp;
    int * matrix;

    //  Don't sync C++ and C I/O
    ios_base::sync_with_stdio(false);

    if(cin) {
        getline(cin, input_line);
        std::istringstream(input_line) >> t;
    }

    while (t != -1) {

        matrix = new int[t+1];

        for(i = 1; i < t; i++)
        {
            getline(cin, input_line, ' ');
            std::istringstream(input_line) >> matrix[i];
            mx = std::max(mx, matrix[i]);
        }

        mx++;
        getline(cin, input_line, '\n');
        std::istringstream(input_line) >> matrix[i];

        matrix[0] = mx;
        b = bow(1, 0, 2, t+1, matrix); //black
        matrix[0] = 0;
        w = bow(0, 1, 2, t+1, matrix); //white

        cout << std::min(b,w) << "\n";

        getline(cin, input_line);
        std::istringstream(input_line) >> t;   
    }
    return 0;
}
