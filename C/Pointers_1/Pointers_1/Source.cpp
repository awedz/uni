#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <conio.h>

#define size 3

void InitArr(int(*arr)[size]);
void PrintArr(int(*arr)[size]);
void SortArr(int(*arr)[size]);
int GetRandNum();

void main()
{
	srand(time(NULL));
	int arr[size][size];
	InitArr(arr);
	printf("pre sort\n");
	PrintArr(arr);
	SortArr(arr);
	printf("post sort\n");
	PrintArr(arr);
	_getch();
}
void InitArr(int(*arr)[size])
{
	for (int i = 0; i < size; i++)
		for (int j = 0; j < size; j++)
			*(*(arr + i) + j) = GetRandNum();
}
int GetRandNum()
{
	return rand() % 10;
}
void PrintArr(int(*arr)[size])
{
	for (int i = 0; i < size; i++)
	{
		for (int j = 0; j < size; j++)
			printf("%d", *(*(arr + i) + j));
		printf("\n");
	}
}
void SortArr(int(*arr)[size])
{
	int temp;
	for (int x = 0; x < size * size; x++)
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				if (*(*(arr + i)+j+1) > *(*(arr + i) + j))//arr[i][j+1] > arr[i][j]
				{
					temp = *(*(arr + i) + j);
					*(*(arr + i) + j) = *(*(arr + i) + j + 1);
					*(*(arr + i) + j + 1) = temp;
				}

}