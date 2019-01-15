#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <conio.h>
#include <ctype.h>
#include <string.h>

#define S 20
void Ex35(int arr[], int size, int X);
void FillRandomArr(int arr[], int size);
void main()
{

    //global stuff
    srand(time(NULL));
    //ex 35
    int arr[S] = {0}, X = 0;
    FillRandomArr(arr, S);
    X = rand() % 10;
    Ex35(arr, S, X);
}

void Ex35(int arr[], int size, int X)
{
    int startPrint = -1, endPrint = 0;
    for (size_t i = 0; i < size; i++)
        printf("%d ", arr[i]);

    for (size_t i = 0; i < size; i++)
        if (arr[i] == X)
            if (startPrint == -1)
                startPrint = i;
            else
                endPrint = i;

    printf("\nnum is: %d\n", X);

    for (size_t i = 0; i < size; i++)
        if (endPrint > 0)
        {
            if (i >= startPrint && i <= endPrint)
                printf("%d ", arr[i]);
        }
}

void FillRandomArr(int arr[], int size)
{
    for (size_t i = 0; i < size; i++)
    {
        arr[i] = rand() % 10;
    }
}