#include <stdio.h>
#include <string.h>
#define n 10

int func(int mat[], int num, int size);
void fix_str(char *s);
void PrintTriangle(int size);
int NumSum(int num);                   //1-
void PrintArrRec(int arr[], int size); //2-
int DigitSum(int n1);                  //3
int BiggestRec(int arr[], int size);   //4-
char *ReverseStr(char str1S[]);        //5
int DecToBin(int num);                 //6-
int main()
{
    int mat[n] = {1, 2, 4, 13, 5, 7, 9, 4, 9, 2};
    int res;
    res = func(mat, 0, n);
    //printf("\n%d\n", res);
    res = DigitSum(17);
    //printf("\n%d\n", res);
    //1
    res = NumSum(5);
    //printf("\n%d\n", res);
    //4
    res = BiggestRec(mat, n);
    //printf("\n%d\n", res);
    res = DecToBin(4);
    printf("\n%d\n", res);
    char s1[30] = "question number 5 in c exam";
    //fix_str(s1);
    //printf("%s", s1);
    fgetchar();
    return 0;
}
void fix_str(char *s)
{
    int i;
    for (i = 0; i < strlen(s); i++)
    {
        if (s[i] == ' ')
        {
            s[i] = '\0';
            fix_str(s + i + 1);
            strcat(s, s + i + 1);
        }
    }
}
int DecToBin(int num)
{
    int res = num % 2 == 0 ? 0 : 1;
    return num > 0 ? res += (10 * DecToBin(num / 2)) : 0;
}

int BiggestRec(int arr[], int size)
{
    static int biggest = 0;
    int num;
    if (size > 0)
    {
        num = BiggestRec(arr, size - 1);
        if (arr[size] > biggest)
        {
            biggest = arr[size];
        }
    }
    return biggest;
}
// int BiggestRec(int arr[], int size)
// {
//     static int biggest = 0;
//     int num;
//     if (size > 0)
//     {
//         num = BiggestRec(arr, size - 1);
//         if (arr[size] > biggest)
//         {
//             biggest = arr[size];
//         }
//     }
//     return biggest;
// }
void PrintArrRec(int arr[], int size)
{
    if (size > 0)
    {
        PrintArrRec(arr, size - 1);
        printf("%d ", arr[size - 1]);
    }
}
int NumSum(int num)
{
    return num > 0 ? num + NumSum(num - 1) : num;
}

int func(int mat[], int num, int size)
{
    int a;
    if (num >= size)
    {
        return 1;
    }
    if ((mat[num] % 2) == 0)
    {
        a = mat[num];
    }
    else
    {
        a = 1;
    }
    return (a * func(mat, num + 1, size));
}
int DigitSum(int n1)
{
    if (n1 == 0)
    {
        return 0;
    }
    return ((n1 % 10) + (DigitSum(n1 / 10)));
}
char *ReverseStr(char str1[])
{
    static int i = 0;
    static char revstr[7];
    if (*str1)
    {
        ReverseStr(str1 + 1);
        revstr[i++] = *str1;
    }
    return revstr;
}
