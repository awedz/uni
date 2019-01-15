#include <stdio.h>
#include <string.h>

void PrintByChar(char str[], char printBy);
int main()
{
    char str[] = "cat Dragon horse tiger dog dolphin dinosaur dildo";
    char print = 'd';
    PrintByChar(str, print);
    fgetchar();
    return 0;
}

void PrintByChar(char str[], char printBy)
{
    int i, isPrint = 0;
    for (i = 0; i < strlen(str); i++)
    {
        if (str[i] == printBy)
        {
            isPrint = !isPrint;
            printf("\n");
        }
        while (isPrint && str[i] != ' ' && str[i])
        {
            printf("%c", str[i]);
            i++;
        }
        if (isPrint)
        {
            isPrint = !isPrint;
        }
    }
}