#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void RemoveChars(char str[]);
void PrintArr(char str[]);
int main()
{

    char str[100];
    printf("input string\n");
    gets(str);
    PrintArr(str);
    RemoveChars(str);
    PrintArr(str);
    fgetchar();
    return 0;
}
void RemoveChars(char str[])
{
    int i, j, x, z = 0, next, cnt, tCnt = 0, curr;
    char temp;

    for (i = 0; i < strlen(str); str[curr] != str[curr + 1] ? i++ : i--)
    {
        curr = i;
        next = i + 1;
        cnt = 0;
        if (str[curr] == str[next])
        {
            while (str[curr] == str[next++])
            {
                cnt++;
            }
            for (j = 0; j <= cnt; j++)
            {
                for (x = curr; x < strlen(str); x++)
                {
                    temp = str[x];
                    str[x] = str[x + 1];
                    str[x + 1] = temp;
                }
            }
            tCnt += cnt;
            cnt = 0;
        }
    }
}
void PrintArr(char str[])
{
    int i;
    for (i = 0; i < strlen(str); i++)
    {
        printf("%c", str[i]);
    }
    printf("\n");
}
