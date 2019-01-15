#include <stdio.h>
#include <string.h>
#include <conio.h>
#include <ctype.h>
#include <stdlib.h>
#include <time.h>

int **InitMatSnake(int size);
void PrintMat(int **mat, int size);
void BiggestNum(int **mat,int size,int *cnt);
void SmallestNum(int **mat,int size,int *cnt);
void CalcMainDiagona(int **mat,int size,int cnt);
void CalcScondDiagonal(int **mat,int size, int *cnt);
void CalcUpperMainDiagonalTri(int **mat,int size,int *cnt);
void CalcLowerMainDiagonalTri(int **mat,int size,int *cnt);
void CalcUpperSecDiagonalTri(int **mat, int size,int *cnt);
void CalcLowerSecDiagonalTri(int **mat, int size,int *cnt);
void SortMat(int **mat, int size);



void main()
{
	srand(time(NULL));
	int size = 5;
	int **mat = InitMatSnake(size);
	PrintMat(mat, size);
	_getch();
}
int **InitMatSnake(int size)
{
	int **mat = (int**)malloc(size * sizeof(int*));
	for (int i = 0; i < size; i++)
		*(mat + i) = (int*)malloc(size * sizeof(int));
	int i, j, cnt = 0;
	for (j = size; j > 0; j--)
	{
		for (j % 2 != 0 ? i = 1 : i = size; i > 0 && i <= size; j % 2 != 0 ? i++ : i--)
		{
			*(*(mat + i - 1) + j - 1) = cnt++;
		}
	}
	return mat;
}
void BiggestNum(int **mat, int size, int *cnt)
{
	*cnt = 0;
	for ( i = 0; i < length; i++)
	{

	}
}
void SmallestNum(int **mat, int size, int *cnt)
{

}


void PrintMat(int **mat, int size)
{
	for (int i = 0; i < size; i++)
	{
		for (int j = 0; j < size; j++)
			printf("%2d ", *(*(mat + i) + j));
		printf("\n");
	}
}