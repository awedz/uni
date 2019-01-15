#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#define n 10

void MakeRandom(int arr[]);
void CheckArr(int arr[]);

int main()
{
    srand(time(NULL));
    int arr[10] = {0};
    MakeRandom(arr);
    CheckArr(arr);
    fgetchar();
    return 0;
}

void CheckArr(int arr[])
{
    int even[n] = {0}, odd[n] = {0}, i, oddCounter = 0, evenCounert = 0;
    for (i = 0; i < n; i++)
    {
        if (arr[i] % 2 == 0)
        {
            even[evenCounert] = arr[i];
            evenCounert++;
        }
        else
        {
            odd[oddCounter] = arr[i];
            oddCounter++;
        }
    }
    printf("The new array of even numbers has %d numbers: ", evenCounert);
    for (i = 0; i < evenCounert; i++)
    {
        printf("%d ", even[i]);
    }
    printf("\n");
    printf("The new array of odd numbers has %d numbers: ", oddCounter);
    for (i = 0; i < oddCounter; i++)
    {
        printf("%d ", odd[i]);
    }
}

void MakeRandom(int arr[])
{
    int i;

    for (i = 0; i < n; i++)
    {
        arr[i] = rand() % 100;
    }
}