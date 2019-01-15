#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <conio.h>
#include <ctype.h>
#include <string.h>

int Ex34(char str[]);
void Ex35(int arr[], int size, int X);
void FillRandomArr(int arr[], int size);

void main()
{

    //global stuff
    srand(time(NULL));
    //ex 34
    char str[] = "asDFasDFa asd ASDAsd aSSSSsd aSsd asd";
    int wordcount = Ex34(str);
    printf("%d\n", wordcount);

    _getch();
}

int Ex34(char str[])
{
    int c = 0, capitalCount = 0, normalCount = 0, wordCount = 0;
    while (str[c])
    {
        if (islower(str[c]) || isupper(str[c]))
        {
            if (islower(str[c]))
            {
                normalCount++;
            }
            else
            {
                capitalCount++;
            }
        }
        else
        {
            if (capitalCount > normalCount)
            {
                wordCount++;
            }
            capitalCount = 0;
            normalCount = 0;
        }
        c++;
    }
    return wordCount;
}

void FillRandomArr(int arr[], int size)
{
    for (size_t i = 0; i < size; i++)
    {
        arr[i] = rand() % 10;
    }
}