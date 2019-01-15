#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <conio.h>
#include <math.h>

int **InitMath(int m);
void FillMat(int **mat,int m);
void DoMath(int **mat,int m);
void PrintMat(int **mat,int m);
void main()
{
	int m = 3;
	srand(time(NULL));
	int **newArr = InitMath(m);
	FillMat(newArr,m);
	PrintMat(newArr, m);
	printf("\n");
	DoMath(newArr,m);
	PrintMat(newArr, m);
	_getch();
}

void DoMath(int **mat,int m)
{
	int lead;
	for (int i = 0; i < m-1; i++)
	{
		for (int j = 1; j < m-1; j++)
		{
			lead = *(*(mat + i) + i);
			 *(*(mat + i) + j) = (lead * *(*(mat + i)+j)) - (*(*(mat + i) + i) * *(*(mat + i + 1) + j));
		}
	}
}
int **InitMath(int m)
{
	int **arr = (int**)malloc(m * sizeof(int*));
	for (int i = 0; i < m; i++)
			*(arr+i) = (int*)malloc(m * sizeof(int));
	return arr;
}
void FillMat(int **mat,int m)
{
	for (int i = 0; i < m; i++)
		for (int j = 0; j < m; j++)
			*(*(mat + i) + j) = rand() % 2 > 0 ? *(*(mat + i) + j) = rand() % 10 : (*(*(mat + i) + j) = rand() % 10)*(1);
}
void PrintMat(int **mat, int m)
{
	for (int i = 0; i < m; i++)
	{
		for (int j = 0; j < m; j++)
		{
			printf("%d,", *(*(mat + i) + j));
		}
		printf("\n");
	}
}