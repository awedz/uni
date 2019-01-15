#include <stdio.h>
#include <conio.h>
#include <time.h>
#include "stdlib.h"

#define n 20

void RandomArr(int arr[], int size);
void PrintArr(int arr[], int size);
void MoveNum(int arr[], int size, int num);
int main()
{
    const int size = n;
    int arr[n], input = 3;
    srand(time(NULL));

    RandomArr(arr, size);
    PrintArr(arr, size);
    MoveNum(arr, size, input);
    PrintArr(arr, size);

    fgetchar();
    return 0;
}

void MoveNum(int arr[], int size, int num)
{
    int i, j, temp;
    for (i = 0; i < size - 1; i++)
    {
        if (arr[i] == num)
        {
            for (j = i; j < size - 1; j++)
            {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}

void RandomArr(int arr[], int size)
{
    int i;
    for (i = 0; i < size; i++)
    {
        arr[i] = rand() % 10;
    }
}
void PrintArr(int arr[], int size)
{
    int i;
    for (i = 0; i < size; i++)
    {
        printf("%d ", arr[i]);
    }
    printf("\n");
}