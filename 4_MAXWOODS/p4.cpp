// CI-5651
// David Lilue, 09-10444

#include <iostream>
#include <vector>
#include <fstream>
#include <sstream>
#include <iterator>
#include <math.h>
#include <algorithm>

using namespace std;

int main(int argc, char const *argv[])
{
    string input_line;
    int t = 0,
        i = 0,
        j = 0,
        k = 0;

    const int m = 0,
              n = 0;
    char c;
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
                        cout << "Algun elemento de la matrix es invalido\n";
                        exit(1);
                        break;
                }
            }
            cout << input_line << "\n"; // c = infix[i]; //this is your character
        }
        for (j = 0; j < m; ++j)
        	delete [] matrix[j];
        delete [] matrix;
        i++;
    }
    return 0;
}
