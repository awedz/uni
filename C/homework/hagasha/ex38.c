#include <stdio.h>
#include <string.h>
void CountABC(char str[]);
int main()
{
    char str[] = "ayccybaxyc";
    CountABC(str);
    fgetchar();
    return 1;
}

void CountABC(char str[])
{
    const char a = 'a', b = 'b', c = 'c';
    int i, A = 0, B = 0, C = 0;
    for (i = 0; i < strlen(str); i++)
    {
        switch (str[i])
        {
        case 'a':
            A++;
            break;
        case 'b':
            B++;
            break;
        case 'c':
            C++;
            break;
        default:
            break;
        }
    }
    printf("%c:%d %c:%d %c:%d", a, A, b, B, c, C);
}