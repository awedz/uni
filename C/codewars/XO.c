// XO("ooxx") => true
// XO("xooxx") => false
// XO("ooxXm") => true
// XO("zpzpzpp") => true // when no 'x' and 'o' is present should return true
// XO("zzoo") => false
#include <stdbool.h>
#include <string.h>
#include <stdio.h>

bool xo (const char* str)
{
    int x = 0, o = 0;
    size_t len = strlen(str);
    size_t i;
    char c;
    for (i=0;i<len;i++)
    {
        c = tolower(str[i]);
        switch(c)
        {
            case 'o':
                o++;
                break;
            case 'x':
                x++;
                break;
            default:
                break;
        }
    }
    return o==x;
}